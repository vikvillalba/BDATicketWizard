package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.UsuarioDTO;
import itson.ticketwizard.dtos.UsuarioRegistradoDTO;
import itson.ticketwizard.entidades.Usuario;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public Usuario registrarUsuario(UsuarioDTO nuevoUsuarioDTO) {
        String codigoSQL = "{CALL SP_crearCuenta(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try {
            Connection conexion = manejadorConexiones.crearConexion();
            CallableStatement comando = conexion.prepareCall(codigoSQL);

            comando.setString(1, nuevoUsuarioDTO.getNombres());
            comando.setString(2, nuevoUsuarioDTO.getApellidoPaterno());
            comando.setString(3, nuevoUsuarioDTO.getApellidoMaterno());
            comando.setDate(4, java.sql.Date.valueOf(nuevoUsuarioDTO.getFechaNacimiento()));

            comando.setString(5, nuevoUsuarioDTO.getNombreUsuario());
            String contraseniaEncriptada = BCrypt.hashpw(nuevoUsuarioDTO.getContrasenia(), BCrypt.gensalt());
            comando.setString(6, contraseniaEncriptada);

            comando.setString(7, nuevoUsuarioDTO.getCorreoElectronico());
            comando.setString(8, nuevoUsuarioDTO.getCalle());
            comando.setString(9, nuevoUsuarioDTO.getNumero());
            comando.setString(10, nuevoUsuarioDTO.getColonia());
            comando.setString(11, nuevoUsuarioDTO.getCiudad());
            comando.setString(12, nuevoUsuarioDTO.getEstado());
            comando.setInt(13, nuevoUsuarioDTO.getCodigoPostal());

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
                           SELECT CODIGOUSUARIO, NOMBREUSUARIO, CONTRASENA, SALDODISPONIBLE
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
                BigDecimal saldo = resultadosConsulta.getBigDecimal("SALDODISPONIBLE");

                UsuarioRegistradoDTO usuarioRegistrado = new UsuarioRegistradoDTO(codigoUsuario, nombreUsuario, contrasena, saldo);
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
    public boolean actualizarUsuario(UsuarioDTO usuarioActualizado, UsuarioRegistradoDTO usuarioRegistradoDTO) {
        String usuariosSQL = """
                        UPDATE USUARIOS
                        SET NOMBRES = ?, APELLIDOPATERNO = ?, APELLIDOMATERNO = ?,
                        FECHANACIMIENTO = ?, NOMBREUSUARIO = ?, CONTRASENA = ?, CORREOELECTRONICO = ?
                        WHERE CODIGOUSUARIO = ?;
                        """;

        String domiciliosSQL = """
                        UPDATE DOMICILIOSUSUARIOS
                        SET CALLE = ?, NUMERO = ?, COLONIA = ?, CIUDAD = ?,
                        ESTADO = ?, CODIGOPOSTAL = ?
                        WHERE CODIGOUSUARIO = ?;
                        """;

        Connection conexion = null;

        try {
            conexion = manejadorConexiones.crearConexion();
            conexion.setAutoCommit(false);

            try (PreparedStatement comandoUsuario = conexion.prepareStatement(usuariosSQL)) {
                comandoUsuario.setString(1, usuarioActualizado.getNombres());
                comandoUsuario.setString(2, usuarioActualizado.getApellidoPaterno());
                comandoUsuario.setString(3, usuarioActualizado.getApellidoMaterno());
                comandoUsuario.setDate(4, java.sql.Date.valueOf(usuarioActualizado.getFechaNacimiento()));
                comandoUsuario.setString(5, usuarioActualizado.getNombreUsuario());
                comandoUsuario.setString(6, usuarioActualizado.getContrasenia());
                comandoUsuario.setString(7, usuarioActualizado.getCorreoElectronico());
                comandoUsuario.setInt(8, usuarioRegistradoDTO.getCodigoUsuario());

                int filasUsuario = comandoUsuario.executeUpdate();
                if (filasUsuario == 0) {
                    throw new SQLException("No se encontró el usuario para actualizar.");
                }
            }

            try (PreparedStatement comandoDomicilio = conexion.prepareStatement(domiciliosSQL)) {
                comandoDomicilio.setString(1, usuarioActualizado.getCalle());
                comandoDomicilio.setString(2, usuarioActualizado.getNumero());
                comandoDomicilio.setString(3, usuarioActualizado.getColonia());
                comandoDomicilio.setString(4, usuarioActualizado.getCiudad());
                comandoDomicilio.setString(5, usuarioActualizado.getEstado());
                comandoDomicilio.setInt(6, usuarioActualizado.getCodigoPostal());
                comandoDomicilio.setInt(7, usuarioRegistradoDTO.getCodigoUsuario());

                int filasDomicilio = comandoDomicilio.executeUpdate();
                if (filasDomicilio == 0) {
                    throw new SQLException("No se encontró el domicilio para actualizar.");
                }
            }

            conexion.commit();
            return true;

        } catch (SQLException ex) {
            System.err.println("Error al actualizar usuario y/o domicilio: " + ex.getMessage());
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException rollbackEx) {
                    System.err.println("Error al hacer rollback: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error al cerrar conexión: " + closeEx.getMessage());
                }
            }
        }
        return false;
    }



    public UsuarioDTO obtenerUsuarioDTO(UsuarioRegistradoDTO usuarioRegistradoDTO) throws PersistenciaException {
        
        String codigoSQL = """
                           SELECT u.NOMBRES, u.APELLIDOPATERNO, u.APELLIDOMATERNO, u.FECHANACIMIENTO, 
                           u.SALDODISPONIBLE, u.NOMBREUSUARIO, u.CONTRASENA, u.CORREOELECTRONICO, 
                           d.CALLE, d.NUMERO, d.COLONIA, d.CIUDAD, d.ESTADO, d.CODIGOPOSTAL
                           FROM USUARIOS u
                           INNER JOIN DOMICILIOSUSUARIOS d ON d.CODIGOUSUARIO = u.CODIGOUSUARIO
                           WHERE u.CODIGOUSUARIO = ?
                           """;
        
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, usuarioRegistradoDTO.getCodigoUsuario());
            
             ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {

                String nombre = resultado.getString("nombres");
                String apellidoPat = resultado.getString("apellidopaterno");
                String apellidoMat = resultado.getString("apellidomaterno");
                Date fechaSQL = resultado.getDate("fechanacimiento"); // Obtener como java.sql.Date
                LocalDate fechaNacimiento = fechaSQL.toLocalDate();
                BigDecimal saldo = resultado.getBigDecimal("saldodisponible");
                String nombreUsuario = resultado.getString("nombreusuario");
                String contrasena = resultado.getString("contrasena");
                String correo = resultado.getString("correoelectronico");
                String calle = resultado.getString("calle");
                String numero = resultado.getString("numero");
                String colonia = resultado.getString("colonia");
                String ciudad = resultado.getString("ciudad");
                String estado = resultado.getString("estado");
                Integer codigoPostal = resultado.getInt("codigopostal");

                return new UsuarioDTO(nombre, apellidoPat, apellidoMat,
                        fechaNacimiento, nombreUsuario, contrasena, correo, calle, numero,
                        colonia, ciudad, estado, codigoPostal);

            }
        
        } catch (SQLException ex) {
            System.err.println("Error al recuperar al usuario: " + ex.getMessage());
            throw new PersistenciaException("Error al recuperar al usuario.");
            
        }

        return null;
    }

    public void ejecutarEventoBoletosApartados(BoletoDTO boletoDTO) {
        String query = "UPDATE CONFIGURACIONEVENTO SET CODIGOBOLETO = ? WHERE id = 1";

        try (Connection conexion = manejadorConexiones.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, boletoDTO.getNumeroSerie());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el código del boleto: " + e.getMessage());
        }
    }

}
