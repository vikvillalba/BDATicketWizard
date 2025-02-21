package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
        public List<BoletoDTO> buscarPaginadoAlumnosTabla(int limit, int offset, UsuarioRegistradoDTO usuarioRegistradoDTO) throws PersistenciaException {
        try {
            List<BoletoDTO> listaBoletos = null;

            Connection conexion = this.manejadorConexiones.crearConexion();
            String codigoSQL = """
                               SELECT e.NOMBRE, e.FECHA, e.RECINTO, b.FILA, b.ASIENTO, e.CIUDAD, e.ESTADO, b.PRECIO, b.NUMEROSERIE, b.CODIGOBOLETO
                               FROM BOLETOS b 
                               INNER JOIN EVENTOS e ON b.CODIGOEVENTO = e.CODIGOEVENTO
                               WHERE (b.codigoUsuario IS NULL OR b.codigoUsuario != ?)
                               LIMIT ? OFFSET ?;
                               """;

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, usuarioRegistradoDTO.getCodigoUsuario());
            comando.setInt(2, limit);
            comando.setInt(3, offset);
            
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {
                if (listaBoletos == null) {
                    listaBoletos = new ArrayList<>();
                }
                BoletoDTO boleto = this.boletoTablaDTO(resultado);
                listaBoletos.add(boleto);
            }
            conexion.close();
            return listaBoletos;
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Error al recuperar los boletos.");
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
        String numeroSerie = resultado.getString("numeroSerie");
        Integer codigoBoleto = resultado.getInt("codigoBoleto");
        
        return new BoletoDTO(nombre, fechaHora, recinto, fila, asiento, ciudad, estado, precio, numeroSerie, codigoBoleto);
    }
    
}
