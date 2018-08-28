package co.edu.escuelaing.arem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Carlos Andrés Castaneda Lozano
 */
public class Ejercicio2 {
     public static void main(String[] args) throws MalformedURLException {        
        Scanner scanner = new Scanner(System.in);
        System.out.println("URL: ");
        String n = scanner.nextLine();
        scanner.close(); 
        URL url = new URL(n);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine = null;
            PrintStream o = new PrintStream(new File("resultado.html"));
            System.setOut(o);
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }        
    }
}
