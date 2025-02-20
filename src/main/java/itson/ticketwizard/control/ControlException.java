/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package itson.ticketwizard.control;

/**
 *
 * @author victoria
 */
public class ControlException extends Exception{

    /**
     * Creates a new instance of <code>ControlException</code> without detail message.
     */
    public ControlException() {
    }

    /**
     * Constructs an instance of <code>ControlException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ControlException(String msg) {
        super(msg);
    }
}
