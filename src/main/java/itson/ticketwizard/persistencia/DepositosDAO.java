package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevoDepositoDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.Deposito;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author victoria
 */
public class DepositosDAO {
     private final ManejadorConexiones manejadorConexiones;

    public DepositosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
     
    public Deposito realizarDeposito(NuevoDepositoDTO nuevoDepositoDTO, UsuarioRegistradoDTO usuarioRegistradoDTO) throws SQLException, PersistenciaException{
        String codigoSQL="""
                         CALL GESTIONAR_TRANSACCION(?,?,?,?,?,?);
                         """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setString(1, "DEPOSITO");
            comando.setInt(2, usuarioRegistradoDTO.getCodigoUsuario());
            comando.setString(3, null);
            comando.setBigDecimal(4, nuevoDepositoDTO.getSaldo());
            comando.setInt(5, 0);
            comando.setDate(6, null);
            System.out.println(comando.executeUpdate() > 0);
            return new Deposito(usuarioRegistradoDTO.getCodigoUsuario(), nuevoDepositoDTO.getSaldo(), LocalDateTime.now());

        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new PersistenciaException("ERROR: ERROR AL REALIZAR LA TRANSACCION");
        }
     
}
}
