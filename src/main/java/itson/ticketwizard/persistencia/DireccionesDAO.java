package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.NuevoDomicilioUsuarioDTO;
import itson.ticketwizard.entidades.DomicilioUsuario;
import itson.ticketwizard.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author victoria
 */
public class DireccionesDAO {
    
    private final ManejadorConexiones manejadorConexiones;

    public DireccionesDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

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
            System.out.println("se registró el domicilio");
            
        }catch(SQLException ex){
            
            System.err.println(ex.getMessage()); 
        }
        return null;
    }
}
