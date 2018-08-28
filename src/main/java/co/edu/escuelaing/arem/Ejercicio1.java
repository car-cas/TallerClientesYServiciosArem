package co.edu.escuelaing.arem;

import java.io.*;
import java.net.*;
/**
 *
 * @author Carlos Andrés Castaneda Lozano
 */
public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://campusvirtual.escuelaing.edu.co/moodle/course/view.php?id=892#13h52m32s");
        System.out.println("getProtocol :"+url.getProtocol());
        System.out.println("getAuthority :"+url.getAuthority());
        System.out.println("getHost :"+url.getHost());
        System.out.println("getPath :"+url.getPath());
        System.out.println("getQuery :"+url.getQuery());
        System.out.println("getFile :"+url.getFile());
        System.out.println("getRef :"+url.getRef());
    }
    
}
