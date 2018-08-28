package co.edu.escuelaing.arem;

import java.io.*;
import java.net.*;
/**
 *
 * @author Carlos Andrés Castaneda Lozano
 */
public class URLReader {

    public static void main(String[] args) throws Exception {
        URL google = new URL("http://www.google.com/");
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
