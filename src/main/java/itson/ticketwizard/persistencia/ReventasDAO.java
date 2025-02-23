package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.NuevaReventaDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.TransaccionReventa;
import itson.ticketwizard.enums.TipoCompra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victoria
 */
public class ReventasDAO {

    private ManejadorConexiones manejadorConexiones;

    public ReventasDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

    public boolean registrarReventa(NuevaReventaDTO reventaDTO, BoletoDTO boletoDTO) throws PersistenciaException {
        String codigoSQLReventa = """
                       {CALL SP_revenderBoleto(?, ?, ?, ?, ?, ?)}
                       """;

        String codigoSQLEstadoBoleto = """
                                   UPDATE BOLETOS 
                                   SET ESTADO = 1, REVENTA = 1, PRECIO = ?
                                   WHERE CODIGOBOLETO = ?;
                                   """;

        try (Connection conexion = manejadorConexiones.crearConexion(); CallableStatement comandoReventa = conexion.prepareCall(codigoSQLReventa); PreparedStatement comandoEstado = conexion.prepareStatement(codigoSQLEstadoBoleto)) {

            // Ejecutar procedimiento almacenado para la reventa
            comandoReventa.setInt(1, reventaDTO.getCodigoUsuario());
            comandoReventa.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            comandoReventa.setInt(3, boletoDTO.getCodigoBoleto());
            comandoReventa.setTimestamp(4, Timestamp.valueOf(reventaDTO.getFechaLimite()));
            comandoReventa.setBigDecimal(5, reventaDTO.getPrecioVenta());
            comandoReventa.setBigDecimal(6, boletoDTO.getPrecio());
            comandoReventa.executeUpdate();

            // Actualizar estado del boleto
            comandoEstado.setBigDecimal(1, reventaDTO.getPrecioVenta());
            comandoEstado.setInt(2, boletoDTO.getCodigoBoleto());
            comandoEstado.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Error al realizar la reventa");
        }
    }


}

