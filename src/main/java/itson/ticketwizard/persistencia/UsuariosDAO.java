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

}
