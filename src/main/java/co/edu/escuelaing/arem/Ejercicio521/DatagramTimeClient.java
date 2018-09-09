package co.edu.escuelaing.arem.Ejercicio521;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andrés Castaneda Lozano
 */
public class DatagramTimeClient {
    public static void main(String[] args) {
        byte[] sendBuf = new byte[256];
        try {
            while(true) {
                DatagramSocket socket = new DatagramSocket();
                byte[] buf = new byte[256];
                InetAddress address = InetAddress.getByName("127.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);

                socket.send(packet);
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Date: " + received);
                
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        } catch (SocketException e) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, e);
        } catch (UnknownHostException e) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
