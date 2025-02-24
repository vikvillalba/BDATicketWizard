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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victoria
 */
public class DepositosDAO {
     private final ManejadorConexiones manejadorConexiones;

    public DepositosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
     
    public Deposito realizarDeposito(NuevoDepositoDTO nuevoDepositoDTO) throws SQLException, PersistenciaException{
        
        try(Connection conexion = manejadorConexiones.crearConexion();
            CallableStatement comando = conexion.prepareCall("{CALL SP_Deposito(?,?)}")){
            //se usa CallableStatement para procedimientos almacenados
 
            comando.setInt(1, nuevoDepositoDTO.getCodigoUsuario());
            comando.setBigDecimal(2, nuevoDepositoDTO.getSaldo());
            
            int filasAfectadas = comando.executeUpdate();

            return new Deposito(nuevoDepositoDTO.getCodigoUsuario(), nuevoDepositoDTO.getSaldo(), LocalDateTime.now());

        }catch(SQLException e){
            System.err.println("ERROR SQL:" + e.getMessage());
            throw new PersistenciaException("ERROR: ERROR AL REALIZAR LA TRANSACCION");
        }
     
}
    
    public List<Deposito> obtenerDepositosUsuario(UsuarioRegistradoDTO usuarioRegistradoDTO) throws PersistenciaException {
        List<Deposito> depositosRealizados = new ArrayList<>();

        String codigoSQL = """
                           SELECT CODIGODEPOSITO, MONTO, FECHAHORA
                           FROM DEPOSITOS
                           WHERE CODIGOUSUARIO = ?;
                           """;

        try {
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, usuarioRegistradoDTO.getCodigoUsuario());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer codigoDeposito = resultado.getInt("CODIGODEPOSITO");
                BigDecimal monto = resultado.getBigDecimal("MONTO");
                Timestamp fecha = resultado.getTimestamp("FECHAHORA");
                LocalDateTime fechaHora = fecha.toLocalDateTime();

                Deposito deposito = new Deposito(codigoDeposito, monto, fechaHora);
                depositosRealizados.add(deposito);
            }

            conexion.close();
            return depositosRealizados;
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw new PersistenciaException("Error al recuperar los boletos.");
        }
    }
}
