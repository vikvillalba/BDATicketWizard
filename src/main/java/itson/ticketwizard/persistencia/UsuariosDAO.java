package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevoUsuarioDTO;
import itson.ticketwizard.entidades.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author victoria
 */
public class UsuariosDAO { // almacena usuarios en la bd

    private final ManejadorConexiones manejadorConexiones;

    public UsuariosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

    public Usuario registrarUsuario(NuevoUsuarioDTO nuevoUsuarioDTO) {
        String codigoSQL = """
                           INSERT INTO USUARIOS (NOMBRES, APELLIDOPATERNO, APELLIDOMATERNO, FECHANACIMIENTO, 
                           NOMBREUSUARIO, CONTRASENA, CORREOELECTRONICO)
                           VALUES (?, ?, ?, ?, ?, ?, ?);
                           """;

        try {
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, nuevoUsuarioDTO.getNombres());
            comando.setString(2, nuevoUsuarioDTO.getApellidoPaterno());
            comando.setString(3, nuevoUsuarioDTO.getApellidoMaterno());
            comando.setDate(4, new java.sql.Date(nuevoUsuarioDTO.getFechaNacimiento().getTime()));
            comando.setString(5, nuevoUsuarioDTO.getNombreUsuario());
            comando.setString(6, nuevoUsuarioDTO.getContrasenia());
            comando.setString(7, nuevoUsuarioDTO.getCorreoElectronico());

            int filasAfectadas = comando.executeUpdate();
            if (filasAfectadas > 0) {
                try (ResultSet generatedKeys = comando.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idGenerado = generatedKeys.getInt(1); // Obtener el ID generado por el sgbd

                        // Retornar el objeto Usuario con el ID asignado
                        return new Usuario(idGenerado,
                                nuevoUsuarioDTO.getNombres(), nuevoUsuarioDTO.getApellidoPaterno(), nuevoUsuarioDTO.getApellidoPaterno(),
                                nuevoUsuarioDTO.getFechaNacimiento(), 0.0f, nuevoUsuarioDTO.getNombreUsuario(),
                                nuevoUsuarioDTO.getContrasenia(), nuevoUsuarioDTO.getCorreoElectronico());
                    }
                }
            }
            System.out.println("se registró el usuario");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Actualiza la informacion de un usuario en la base de datos.
     * @param usuarioActualizado datos actualizados del usuario.
     * @return true si es exitosa, false si no.
     */
    
    public boolean actualizarUsuario(NuevoUsuarioDTO usuarioActualizado) throws SQLException{
        String sql = """
                     UPDATE USUARIOS
                     SET NOMBRES = ?, APELLIDOPATERNO= ?, APELLIDOMATERNO = ?,
                     FECHANACIMIENTO = ?, CONTRASENA = ?, CORREOELECTRONICO = ?
                     WHERE NOMBREUSUARIO = ?;
                     """;
        
        try(Connection conexion = manejadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(sql)){
            
            comando.setString(1, usuarioActualizado.getNombres());
            comando.setString(2, usuarioActualizado.getApellidoPaterno());
            comando.setString(3, usuarioActualizado.getApellidoMaterno());
            comando.setDate(4, new Date(usuarioActualizado.getFechaNacimiento().getTime()));
            comando.setString(5, usuarioActualizado.getContrasenia());
            comando.setString(6, usuarioActualizado.getCorreoElectronico());
            comando.setString(7, usuarioActualizado.getNombreUsuario());
            
            int filasActualizadas = comando.executeUpdate();
            //devuelve true si al menos 1 fila se actualizo
            return filasActualizadas > 0;
            
        } catch (SQLException ex){
            System.err.println("Error al actualizar usuario: " + ex.getMessage());
        }
        return false;
    }

}
