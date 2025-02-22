package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevaCompraDTO;
import itson.ticketwizard.dtos.NuevoDomicilioUsuarioDTO;
import itson.ticketwizard.dtos.NuevoUsuarioDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.Usuario;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public Usuario registrarUsuario(NuevoUsuarioDTO nuevoUsuarioDTO, NuevoDomicilioUsuarioDTO nuevoDomicilioDTO) {
    String codigoSQL = "{CALL SP_crearCuenta(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 


    try {
        Connection conexion = manejadorConexiones.crearConexion();
        CallableStatement comando = conexion.prepareCall(codigoSQL);

        comando.setString(1, nuevoUsuarioDTO.getNombres());
        comando.setString(2, nuevoUsuarioDTO.getApellidoPaterno());
        comando.setString(3, nuevoUsuarioDTO.getApellidoMaterno());
        comando.setDate(4, new java.sql.Date(nuevoUsuarioDTO.getFechaNacimiento().getTime()));
        comando.setString(5, nuevoUsuarioDTO.getNombreUsuario());
        String contraseniaEncriptada = BCrypt.hashpw(nuevoUsuarioDTO.getContrasenia(), BCrypt.gensalt());
        comando.setString(6, contraseniaEncriptada);

        comando.setString(7, nuevoUsuarioDTO.getCorreoElectronico());
        comando.setString(8, nuevoDomicilioDTO.getCalle());
        comando.setString(9, nuevoDomicilioDTO.getNumero());
        comando.setString(10, nuevoDomicilioDTO.getColonia());
        comando.setString(11, nuevoDomicilioDTO.getCiudad());
        comando.setString(12, nuevoDomicilioDTO.getEstado());
        comando.setInt(13, nuevoDomicilioDTO.getCodigoPostal());

        comando.registerOutParameter(14, java.sql.Types.INTEGER);
        comando.execute();

        // Obtener el ID generado
        int idGenerado = comando.getInt(14);

        if (idGenerado > 0) {

            return new Usuario(idGenerado,
                    nuevoUsuarioDTO.getNombres(), nuevoUsuarioDTO.getApellidoPaterno(), nuevoUsuarioDTO.getApellidoMaterno(),
                    nuevoUsuarioDTO.getFechaNacimiento(), 0.0f, nuevoUsuarioDTO.getNombreUsuario(),
                    contraseniaEncriptada, nuevoUsuarioDTO.getCorreoElectronico());
        }

    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return null;
}

    // obtener usuarios existentes en la bd
    public List<UsuarioRegistradoDTO> ObtenerCuentasExistentes() {
        List<UsuarioRegistradoDTO> cuentasExistentes = new LinkedList<>();

        String codigoSQL = """
                           SELECT CODIGOUSUARIO, NOMBREUSUARIO, CONTRASENA
                           FROM USUARIOS;
                           """;

        try {

            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            ResultSet resultadosConsulta = comando.executeQuery();
            
            
            while (resultadosConsulta.next()) {
                Integer codigoUsuario = resultadosConsulta.getInt("CODIGOUSUARIO");
                String nombreUsuario = resultadosConsulta.getString("NOMBREUSUARIO");
                String contrasena = resultadosConsulta.getString("CONTRASENA");

                UsuarioRegistradoDTO usuarioRegistrado = new UsuarioRegistradoDTO(codigoUsuario, nombreUsuario, contrasena);
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
        comando.setDate(4, new Date(usuarioActualizado.getFechaNacimiento().getTime()));
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
