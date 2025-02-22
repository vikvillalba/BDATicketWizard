package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevoDepositoDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.Deposito;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
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
     
//    public Deposito realizarDeposito(NuevoDepositoDTO nuevoDepositoDTO, UsuarioRegistradoDTO usuarioRegistradoDTO) throws SQLException, PersistenciaException{
//        try(Connection conexion = manejadorConexiones.crearConexion();
//            CallableStatement comando = conexion.prepareCall("{CALL GESTIONAR_TRANSACCION(?,?,?,?,?,?)}")){
//            //se usa CallableStatement para procedimientos almacenados
//            comando.setString(1, "DEPOSITO");
//            comando.setInt(2, usuarioRegistradoDTO.getCodigoUsuario());
//            comando.setNull(3, Types.VARCHAR);
//            comando.setBigDecimal(4, nuevoDepositoDTO.getSaldo());
//            comando.setNull(5, Types.INTEGER);
//            comando.setNull(6, Types.TIMESTAMP);
//            // para mandar los valores null se utiliza el setNull, se le manda el lugar y el tipo de dato que es
//            
//            int filasAfectadas = comando.executeUpdate();
//            System.out.println("Filas afectadas: " + filasAfectadas);
//
//            return new Deposito(usuarioRegistradoDTO.getCodigoUsuario(), nuevoDepositoDTO.getSaldo(), LocalDateTime.now());
//
//        }catch(SQLException e){
//            System.err.println("ERROR SQL:" + e.getMessage());
//            throw new PersistenciaException("ERROR: ERROR AL REALIZAR LA TRANSACCION");
//        }
     
//}
}
