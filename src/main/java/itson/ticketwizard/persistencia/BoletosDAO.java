package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoCompraDTO;
import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BusquedaBoletoFechasDTO;
import itson.ticketwizard.dtos.BusquedaBoletoNombreDTO;
import itson.ticketwizard.dtos.NuevaCompraDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.TransaccionCompra;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author victoria
 */
public class BoletosDAO {

    private final ManejadorConexiones manejadorConexiones;

    public BoletosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

    public List<BoletoDTO> buscarPaginadoBoletosTabla(int limit, int offset, UsuarioRegistradoDTO usuarioRegistradoDTO) throws PersistenciaException {
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
  
        public List<BoletoDTO> buscarPaginadoBoletosTablaNombreEvento(int limit, int offset, UsuarioRegistradoDTO usuarioRegistradoDTO, BusquedaBoletoNombreDTO busquedaBoletoNombreDTO) throws PersistenciaException {
        try {
            List<BoletoDTO> listaBoletos = null;

            Connection conexion = this.manejadorConexiones.crearConexion();
            String codigoSQL = """
                               SELECT e.NOMBRE, e.FECHA, e.RECINTO, b.FILA, b.ASIENTO, e.CIUDAD, e.ESTADO, b.PRECIO, b.NUMEROSERIE, b.CODIGOBOLETO
                               FROM BOLETOS b 
                               INNER JOIN EVENTOS e ON b.CODIGOEVENTO = e.CODIGOEVENTO
                               WHERE (b.codigoUsuario IS NULL OR b.codigoUsuario != ?)
                               AND e.NOMBRE LIKE ?
                               LIMIT ? OFFSET ?;
                               """;

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, usuarioRegistradoDTO.getCodigoUsuario());
            comando.setString(2, "%" + busquedaBoletoNombreDTO.getNombreEvento() + "%");
            comando.setInt(3, limit);
            comando.setInt(4, offset);
            
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
        
        
        public List<BoletoDTO> buscarPaginadoBoletosTablaRangoFechas(int limit, int offset, UsuarioRegistradoDTO usuarioRegistradoDTO, BusquedaBoletoFechasDTO busquedaBoletoFechasDTO) throws PersistenciaException {
        try {
            List<BoletoDTO> listaBoletos = null;

            Connection conexion = this.manejadorConexiones.crearConexion();
            String codigoSQL = """
                               SELECT e.NOMBRE, e.FECHA, e.RECINTO, b.FILA, b.ASIENTO, e.CIUDAD, e.ESTADO, b.PRECIO, b.NUMEROSERIE, b.CODIGOBOLETO
                               FROM BOLETOS b 
                               INNER JOIN EVENTOS e ON b.CODIGOEVENTO = e.CODIGOEVENTO
                               WHERE (b.codigoUsuario IS NULL OR b.codigoUsuario != ?)
                               AND e.FECHA BETWEEN ? AND ?
                               LIMIT ? OFFSET ?;
                               """;

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, usuarioRegistradoDTO.getCodigoUsuario());
            comando.setDate(2, Date.valueOf(busquedaBoletoFechasDTO.getFechaInicio().toLocalDate()));
            comando.setDate(3, Date.valueOf(busquedaBoletoFechasDTO.getFechaFin().toLocalDate()));
            comando.setInt(4, limit);
            comando.setInt(5, offset);
            
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
        
    public BoletoDTO obtenerBoletoCompra(BoletoCompraDTO boletoCompraDTO) throws PersistenciaException {
        String codigoSQL = """
                           SELECT e.NOMBRE, e.FECHA, e.RECINTO, b.FILA, b.ASIENTO, e.CIUDAD, e.ESTADO, b.PRECIO, b.NUMEROSERIE, b.CODIGOBOLETO, b.CODIGOUSUARIO
                           FROM BOLETOS b 
                           INNER JOIN EVENTOS e ON b.CODIGOEVENTO = e.CODIGOEVENTO
                           WHERE b.NUMEROSERIE = ?;
                           """;

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setString(1, boletoCompraDTO.getNumeroSerie());

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                return new BoletoDTO(resultado.getString("NOMBRE"), resultado.getTimestamp("FECHA").toLocalDateTime(),
                        resultado.getString("RECINTO"), resultado.getString("FILA"), resultado.getString("ASIENTO"),
                        resultado.getString("CIUDAD"), resultado.getString("ESTADO"), resultado.getBigDecimal("PRECIO"),
                        resultado.getString("NUMEROSERIE"), resultado.getInt("CODIGOBOLETO"), resultado.getInt("CODIGOUSUARIO"));

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw new PersistenciaException("Error al recuperar los datos.");
        }

        return null;
    }

}
