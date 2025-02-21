package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevoDomicilioUsuarioDTO;
import itson.ticketwizard.dtos.NuevoUsuarioDTO;
import itson.ticketwizard.entidades.DomicilioUsuario;
import itson.ticketwizard.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author victoria
 */
/**
 * DAO para gestionar la persistencia de direcciones de usuarios.
 * Registra nuevos domicilios en la base de datos.
 * 
 * @author victoria
 */
public class DireccionesDAO {
    
    private final ManejadorConexiones manejadorConexiones;

    public DireccionesDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

    /**
     * Registra un domicilio asociado a un usuario en la base de datos
     * 
     * @param nuevoDomicilioDTO datos del domicilio
     * @param usuarioDTO datos del usuario
     * @return true si se registro correctamente, false si no
     * @throws SQLException Si hay error en la base de datos
     */
    public DomicilioUsuario registrarDireccion(NuevoDomicilioUsuarioDTO nuevoDomicilioDTO, Usuario usuario){
        String comandoSQL = """
                            INSERT INTO DOMICILIOSUSUARIOS (CODIGOUSUARIO, CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, CODIGOPOSTAL)
                            VALUES(?, ?, ?, ?, ?, ?, ?);
                            """;
        
        try {
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(comandoSQL);
            
            comando.setInt(1, usuario.getCodigoUsuario());
            comando.setString(2, nuevoDomicilioDTO.getCalle());
            comando.setString(3, nuevoDomicilioDTO.getNumero());
            comando.setString(4, nuevoDomicilioDTO.getColonia());
            comando.setString(5, nuevoDomicilioDTO.getCiudad());
            comando.setString(6, nuevoDomicilioDTO.getEstado());
            comando.setInt(7, nuevoDomicilioDTO.getCodigoPostal());
            
            int filasAfectadas = comando.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("Se registró el domicilio correctamente.");
            
            // Retornar el objeto con los datos insertados
            return new DomicilioUsuario(
                usuario.getCodigoUsuario(),
                nuevoDomicilioDTO.getCalle(),
                nuevoDomicilioDTO.getNumero(),
                nuevoDomicilioDTO.getColonia(),
                nuevoDomicilioDTO.getCiudad(),
                nuevoDomicilioDTO.getEstado(),
                nuevoDomicilioDTO.getCodigoPostal()
            );
        }
            
        }catch(SQLException ex){
            
            System.err.println(ex.getMessage()); 
        }
        return null;
    }
}

