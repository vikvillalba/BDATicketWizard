package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevoDepositoDTO;
import itson.ticketwizard.entidades.Deposito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author victoria
 */
public class DepositosDAO {
     private final ManejadorConexiones manejadorConexiones;

    public DepositosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
     
    public Deposito realizarDeposito(NuevoDepositoDTO nuevoDepositoDTO, int codigoUsuario) throws SQLException{
        String codigoSQL="""
                         INSET INTO DEPOSITOS(CODIGOUSUARIO, MONTO, FECHAHORA)
                         VALUES(?,?,?);
                         """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, codigoUsuario);
            
            comando.setFloat(2,nuevoDepositoDTO.getSaldo());
            
            Timestamp fechaHora = new Timestamp(System.currentTimeMillis());
            comando.setTimestamp(3, fechaHora);
           
         int filasAfectadas = comando.executeUpdate();
            
            if (filasAfectadas > 0) {
                try (ResultSet generatedKeys = comando.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int codigoDeposito = generatedKeys.getInt(1);
                        
                        return new Deposito(codigoDeposito, codigoUsuario, nuevoDepositoDTO.getSaldo(), fechaHora.toLocalDateTime());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar el depósito: " + e.getMessage());
            throw e;
        }
        return null;
    }
     
}
