package co.edu.escuelaing.arem.Ejercicio45;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos Andrés Castaneda Lozano
 */
public class Ejercicio451 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        while (true) {
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                try {
                    inputLine = inputLine.split(" ")[1];
                    if (inputLine.endsWith(".html")) {
                        File pagina = new File("./" + inputLine);
                        String resultado = "";
                        try {
                            FileReader fReader = new FileReader(pagina);
                            BufferedReader bReader = new BufferedReader(fReader);
                            String line;
                            while ((line = bReader.readLine()) != null) {
                                resultado += line + "\n";
                            }
                            bReader.close();
                        } catch (FileNotFoundException ex) {
                            System.err.println("El recurso solicitado " + "./" + inputLine + " no existe");
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            System.err.println("Error en la lectura del Buffer");
                            ex.printStackTrace();
                        }
                        if (!in.ready()) {
                            break;
                        }
                        outputLine = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "\r\n"
                                + resultado
                                + inputLine;
                        out.println(outputLine);
                    }

                }catch(java.lang.ArrayIndexOutOfBoundsException e){
                    
                }
            }
        }

    }
}
