package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoApartadoDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.enums.TipoCompra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author victoria
 */
public class BoletosApartadosDAO {
   private final ManejadorConexiones manejadorConexiones;

    public BoletosApartadosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
   
    public boolean apartarBoleto(BoletoApartadoDTO boletoApartadoDTO, UsuarioRegistradoDTO usuarioRegistradoDTO) throws PersistenciaException {

        String codigoApartadoSQL = """
                                    INSERT INTO BOLETOSAPARTADOS (CODIGOUSUARIO, FECHAHORA, NUMEROSERIEBOLETO)
                                    VALUES (?, ?, ?);
                                    """;

        String codigoBoletoSQL = """
                                   UPDATE BOLETOS 
                                   SET APARTADO = 1
                                   WHERE CODIGOBOLETO = ?;
                                """;

        try (Connection conexion = manejadorConexiones.crearConexion()) {
            conexion.setAutoCommit(false);

            try (PreparedStatement comandoApartado = conexion.prepareStatement(codigoApartadoSQL); PreparedStatement comandoBoleto = conexion.prepareStatement(codigoBoletoSQL)) {

                comandoApartado.setInt(1, usuarioRegistradoDTO.getCodigoUsuario());
                comandoApartado.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                comandoApartado.setString(3, boletoApartadoDTO.getNumeroSerie());
                comandoApartado.executeUpdate();

                comandoBoleto.setInt(1, boletoApartadoDTO.getCodigoBoleto());
                comandoBoleto.executeUpdate();

                conexion.commit();
                return true;

            } catch (SQLException ex) {
                conexion.rollback();
                System.out.println("Error SQL: " + ex.getMessage());
                throw new PersistenciaException("Error al apartar el boleto.");
                
            } finally {
                conexion.setAutoCommit(true);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            throw new PersistenciaException("No se pudo conectar a la base de datos.");
        }
    }
}
