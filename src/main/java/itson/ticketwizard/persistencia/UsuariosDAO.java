package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevoUsuarioDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

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
            String contraseniaEncriptada = BCrypt.hashpw(nuevoUsuarioDTO.getContrasenia(), BCrypt.gensalt());
            comando.setString(6, contraseniaEncriptada);

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
                                contraseniaEncriptada, nuevoUsuarioDTO.getCorreoElectronico());
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

    // obtener usuarios existentes en la bd
    public List<UsuarioRegistradoDTO> ObtenerCuentasExistentes() {
        List<UsuarioRegistradoDTO> cuentasExistentes = new LinkedList<>();

        String codigoSQL = """
                           SELECT NOMBREUSUARIO, CONTRASENA
                           FROM USUARIOS;
                           """;

        try {

            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            ResultSet resultadosConsulta = comando.executeQuery();

            // aquí es donde hay que hacer eso de desencriptar la contraseña para agregarla al dto
            
            
            while (resultadosConsulta.next()) {
                String nombreUsuario = resultadosConsulta.getString("NOMBREUSUARIO");
                String contrasena = resultadosConsulta.getString("CONTRASENA");

                UsuarioRegistradoDTO usuarioRegistrado = new UsuarioRegistradoDTO(nombreUsuario, contrasena);
                cuentasExistentes.add(usuarioRegistrado);
            }

        } catch (SQLException ex) {
            System.err.println("Error al obtener las cuentas existentes." + ex.getMessage());
        }
        return cuentasExistentes;
    }
    
    public UsuarioRegistradoDTO obtenerUsuario(UsuarioRegistradoDTO usuarioRegistradoDTO) throws PersistenciaException {
        String codigoSQL = """
                            SELECT CODIGOUSUARIO, NOMBREUSUARIO, SALDODISPONIBLE
                            FROM USUARIOS
                            WHERE CODIGOUSUARIO = ?
                            """;

        try {

            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, usuarioRegistradoDTO.getCodigoUsuario());

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                return new UsuarioRegistradoDTO(resultado.getInt("CODIGOUSUARIO"), resultado.getString("NOMBREUSUARIO"), resultado.getBigDecimal("SALDODISPONIBLE"));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw new PersistenciaException("Error al recuperar los datos.");
        }

        return null;
    }
    
    
    //actualiza los datos del usuario
    public boolean actualizarUsuario(NuevoUsuarioDTO usuarioActualizado) {
    String sql = """
                 UPDATE USUARIOS
                 SET NOMBRES = ?, APELLIDOPATERNO = ?, APELLIDOMATERNO = ?,
                 FECHANACIMIENTO = ?, CONTRASENA = ?, CORREOELECTRONICO = ?
                 WHERE NOMBREUSUARIO = ?;
                 """;

    try (Connection conexion = manejadorConexiones.crearConexion();
         PreparedStatement comando = conexion.prepareStatement(sql)) {

        comando.setString(1, usuarioActualizado.getNombres());
        comando.setString(2, usuarioActualizado.getApellidoPaterno());
        comando.setString(3, usuarioActualizado.getApellidoMaterno());
        comando.setDate(4, (java.sql.Date) new Date(usuarioActualizado.getFechaNacimiento().getTime()));
        //encripta la nueva contrasena
        String contraseniaEncriptada = BCrypt.hashpw(usuarioActualizado.getContrasenia(), BCrypt.gensalt());
        comando.setString(5, contraseniaEncriptada);
        comando.setString(6, usuarioActualizado.getCorreoElectronico());
        comando.setString(7, usuarioActualizado.getNombreUsuario());
        //devuelve true si al menos 1 fila fue actualizada
        return comando.executeUpdate() > 0;

    } catch (SQLException ex) {
        System.err.println("Error al actualizar usuario: " + ex.getMessage());
        return false;
    }
}

}
