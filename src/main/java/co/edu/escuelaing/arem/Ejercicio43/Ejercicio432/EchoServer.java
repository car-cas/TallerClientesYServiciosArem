package co.edu.escuelaing.arem.Ejercicio43.Ejercicio432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos Andrés Castaneda Lozano
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine = null,operador = "cos";
        double input = 0;
        double calculo = 0;
       
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje:" + inputLine);
            try{
                input = Double.parseDouble(inputLine);
                switch (operador) {
                    case "sin":
                        calculo = Math.sin(input);
                        break;
                    case "cos":
                        calculo = Math.cos(input);
                        break;
                    case "tan":
                        calculo = Math.tan(input);
                        break;
                }
                outputLine = "Calculo : " + calculo;
                out.println(outputLine);
            }catch(NumberFormatException e){
                if(inputLine.startsWith("fun:")) {
                    if(inputLine.substring(4).equals("sin") || inputLine.substring(4).equals("cos") || inputLine.substring(4).equals("tan")) {
                        operador = inputLine.substring(4);
                        out.println("Operador : " + operador);
                    }else{
                        out.println("Operador invalido");
                    }
                }else{
                    if (outputLine.equals("Respuesta: Bye.")) {
                        break;
                    }
                }
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
