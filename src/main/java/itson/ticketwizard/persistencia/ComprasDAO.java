
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevaCompraDTO;
import itson.ticketwizard.entidades.Transaccion;
import itson.ticketwizard.entidades.TransaccionCompra;
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
public class ComprasDAO {
    private ManejadorConexiones manejadorConexiones;

    public ComprasDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
    
    public TransaccionCompra registrarCompra(NuevaCompraDTO compraDTO) throws PersistenciaException{
        String sqlTransaccion = """
                           INSERT INTO TRANSACCIONES(CODIGOUSUARIO, MONTO, NUMEROSERIEBOLETO, FECHAHORA)
                           VALUES(?, ?, ?, NOW());
                           """;
        
        try {
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comandoTransaccion = conexion.prepareStatement(sqlTransaccion, Statement.RETURN_GENERATED_KEYS);
            comandoTransaccion.setInt(1, compraDTO.getCodigoUsuario());
            comandoTransaccion.setBigDecimal(2, compraDTO.getPrecioBoleto());
            comandoTransaccion.setString(3, compraDTO.getNumeroSerieBoleto());

            LocalDateTime fechaHora = LocalDateTime.now();
            comandoTransaccion.setTimestamp(4, Timestamp.valueOf(fechaHora));

            comandoTransaccion.executeUpdate();

            ResultSet generatedKeys = comandoTransaccion.getGeneratedKeys();
            int idTransaccion = -1;
            if (generatedKeys.next()) {
                idTransaccion = generatedKeys.getInt(1);
            }

            String sqlCompra = """
                               INSERT INTO TRANSACCIONESCOMPRAS(CODIGOTRANSACCION)
                               VALUES(?);
                               """;
            
            PreparedStatement comandoCompra = conexion.prepareStatement(sqlCompra);
            comandoCompra.setInt(1, idTransaccion);
            comandoCompra.executeUpdate();
            
            return new TransaccionCompra(idTransaccion, compraDTO.getCodigoUsuario(), fechaHora, compraDTO.getPrecioBoleto(), compraDTO.getNumeroSerieBoleto());
 
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Error al realizar la compra.");
        }
    }
    
    
}
