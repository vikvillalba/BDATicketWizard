package itson.ticketwizard.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author victoria
 */
public class ManejadorConexiones {
    
    private final String cadenaConexion = "jdbc:mysql://localhost/ticketWizard_10am";
    private final String usuario = "root";
    private final String contrasena = "56945Apo";
    
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
        return conexion;
    }
}
