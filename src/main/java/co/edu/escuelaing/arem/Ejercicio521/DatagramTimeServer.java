
package co.edu.escuelaing.arem.Ejercicio521;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class DatagramTimeServer {

    DatagramSocket socket;

    public DatagramTimeServer() throws SocketException {
        
        socket = new DatagramSocket(4445);
    }

    public void startServer() {
        byte[] buf = new byte[256];
        try {
            while(true) {
                DatagramPacket datagrama = new DatagramPacket(buf, buf.length);
                socket.receive(datagrama);
                String dString = new Date().toString();
                buf = dString.getBytes();
                InetAddress address = datagrama.getAddress();
                int port = datagrama.getPort();
                datagrama = new DatagramPacket(buf, buf.length, address, port);
                socket.send(datagrama);
            }
        } catch (IOException ex) {
            Logger.getLogger(DatagramTimeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        socket.close();
    }

    public static void main(String[] args) throws SocketException{
        DatagramTimeServer ds = new DatagramTimeServer();
        ds.startServer();
    }
}
