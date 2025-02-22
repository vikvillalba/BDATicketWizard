package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.NuevaCompraDTO;
import itson.ticketwizard.entidades.TransaccionCompra;
import itson.ticketwizard.enums.TipoCompra;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author victoria
 */
public class ComprasDAO {

    private ManejadorConexiones manejadorConexiones;

    public ComprasDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

    public boolean registrarCompra(NuevaCompraDTO compraDTO, BoletoDTO boletoDTO) throws PersistenciaException {
        String codigoSQLCompra = """
                                {CALL SP_registrarCompra(?, ?, ?, ?, ?)}
                               """;

        // Usar una sola conexión para todas las operaciones
        try (Connection conexion = manejadorConexiones.crearConexion()) {

            try (CallableStatement comandoCompra = conexion.prepareCall(codigoSQLCompra)) {
                comandoCompra.setInt(1, compraDTO.getCodigoUsuario());
                comandoCompra.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                comandoCompra.setBigDecimal(3, compraDTO.getPrecioBoleto());
                comandoCompra.setInt(4, boletoDTO.getCodigoBoleto());
                comandoCompra.setString(5, TipoCompra.REVENTA.name());

                comandoCompra.executeUpdate();
            }

            String codigoSQLPago = """
                                {CALL SP_realizarPago(?, ?, ?)}
                               """;
            try (CallableStatement comandoPago = conexion.prepareCall(codigoSQLPago)) {
                comandoPago.setBigDecimal(1, compraDTO.getPrecioBoleto());
                comandoPago.setInt(2, compraDTO.getCodigoUsuario());
                comandoPago.setInt(3, boletoDTO.getCodigoUsuarioDuenio());

                comandoPago.executeUpdate();
            }

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Error al realizar la compra o el pago.");
        }
    }

    public boolean actualizarDuenioBoleto(NuevaCompraDTO compraDTO, BoletoDTO boletoDTO) throws PersistenciaException {
        String codigoSQL = """
                           UPDATE BOLETOS
                           SET NUMEROSERIE = ?, CODIGOUSUARIO = ?
                           WHERE CODIGOBOLETO = ?;
                           """;

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            comando.setString(1, this.generarNumeroSerie());
            comando.setInt(2, compraDTO.getCodigoUsuario());
            comando.setInt(3, boletoDTO.getCodigoBoleto());

            return comando.executeUpdate() > 0;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw new PersistenciaException("Error al recuperar los datos.");
        }
    }

    private String generarNumeroSerie() {
        String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        //genera 4 letras aleatorias
        for (int i = 0; i < 4; i++) {
            codigo.append(LETRAS.charAt(random.nextInt(LETRAS.length())));
        }

        // genera 4 numeros aleatorios
        int numero = random.nextInt(10000); // Número entre 0000 y 9999
        codigo.append(String.format("%04d", numero));

        return codigo.toString();

    }
}
