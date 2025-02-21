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
    public boolean registrarDireccion(NuevoDomicilioUsuarioDTO nuevoDomicilioDTO, NuevoUsuarioDTO usuarioDTO) throws SQLException {
        String comandoSQL = """
            INSERT INTO DOMICILIOSUSUARIOS (CODIGOUSUARIO, CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, CODIGOPOSTAL)
            VALUES((SELECT CODIGOUSUARIO FROM USUARIOS WHERE CORREOELECTRONICO = ?), ?, ?, ?, ?, ?, ?);
        """;

        try (
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(comandoSQL)
        ) {
            comando.setString(1, usuarioDTO.getCorreoElectronico());
            comando.setString(2, nuevoDomicilioDTO.getCalle());
            comando.setString(3, nuevoDomicilioDTO.getNumero());
            comando.setString(4, nuevoDomicilioDTO.getColonia());
            comando.setString(5, nuevoDomicilioDTO.getCiudad());
            comando.setString(6, nuevoDomicilioDTO.getEstado());
            comando.setInt(7, nuevoDomicilioDTO.getCodigoPostal());

            return comando.executeUpdate() > 0; // devuelve true si la insercion si se pudo hacer
        }
    }
}

