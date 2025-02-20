package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victoria
 */
public class BoletosDAO {
    
    private final ManejadorConexiones manejadorConexiones;

    public BoletosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
    
        public List<BoletoDTO> buscarPaginadoAlumnosTabla(int limit, int offset) throws PersistenciaException {
        try {
            List<BoletoDTO> listaBoletos = null;

            Connection conexion = this.manejadorConexiones.crearConexion();
            String codigoSQL = "SELECT e.nombre, e.fecha, e.recinto, b.fila, b.asiento, e.ciudad, e.estado, b.precio "
                    + "FROM boletos b INNER JOIN eventos e ON b.codigoEvento = e.codigoEvento"
                    + "LIMIT " + limit + " OFFSET " + offset + ";";
            Statement comandoSQL = conexion.createStatement();
            ResultSet resultado = comandoSQL.executeQuery(codigoSQL);
            while (resultado.next()) {
                if (listaBoletos == null) {
                    listaBoletos = new ArrayList<>();
                }
                BoletoDTO alumno = this.boletoTablaDTO(resultado);
                listaBoletos.add(alumno);
            }
            conexion.close();
            return listaBoletos;
        } catch (SQLException ex) {
            // hacer uso de Logger
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }
        private BoletoDTO boletoTablaDTO(ResultSet resultado) throws SQLException {
        
        String nombre = resultado.getString("nombre");
        Timestamp fecha = resultado.getTimestamp("fecha");
        LocalDateTime fechaHora = fecha.toLocalDateTime();
        String recinto = resultado.getString("recinto");
        String asiento = resultado.getString("asiento");
        String fila = resultado.getString("fila");
        String ciudad = resultado.getString("ciudad");
        String estado = resultado.getString("estado");
        BigDecimal precio = resultado.getBigDecimal("precio");
        
        return new BoletoDTO(nombre, fechaHora, recinto, fila, asiento, ciudad, estado, precio);
    }
    
}
