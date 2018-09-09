package co.edu.escuelaing.arem.Ejercicio641;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Carlos Andres Castaneda Lozano
 */
public interface EchoServer extends Remote {

    public String echo(String cadena) throws RemoteException;

}
