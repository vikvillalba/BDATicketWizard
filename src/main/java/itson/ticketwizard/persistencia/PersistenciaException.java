
package itson.ticketwizard.persistencia;

/**
 *
 * @author victoria
 */
public class PersistenciaException extends Exception{

    /**
     * Creates a new instance of <code>PersistenciaException</code> without detail message.
     */
    public PersistenciaException() {
    }

    /**
     * Constructs an instance of <code>PersistenciaException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public PersistenciaException(String msg) {
        super(msg);
    }
}
