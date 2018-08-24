
package co.edu.escuelaing.arem.designprimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static spark.Spark.*;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 *
 */
public class SparkWebApp {

    private static double pro;
    private static double deri;
    private static Linked lista = new Linked();

    public SparkWebApp() {
        this.lista = lista;
        this.pro = pro;
        this.deri = deri;
    }

    /**
     * Metodo media, calcula la media de una lista encadenada
     *
     * @return res media de la lista
     */
    public static double media() {
        double res;
        for (int i = 0; i < lista.getTamanio(); i++) {
            pro += lista.ver(i);
        }
        res = pro / lista.getTamanio();
        return res;
    }

    /**
     * Metodo derivadaParcial, calcula la derivada parcial de una lista
     * encadenada
     *
     * @return total derivada parcial de la lista
     */
    public static double derivadaParcial() {
        for (int i = 0; i < lista.getTamanio(); i++) {
            deri += lista.ver(i);
        }
        double p = deri / lista.getTamanio();
        double c = 0;

        for (int i = 0; i < lista.getTamanio(); i++) {
            c += Math.pow(lista.ver(i) - p, 2);
        }

        double total = Math.sqrt(c / (lista.getTamanio() - 1));

        return total;
    }
    
    /**
     * Metodo leerArchivo, lee los números de un archivo .txt y los almacena en una lista enlazada
     * @throws java.io.IOException IoException
     * @param archivo archivo
     */
 
    public static void leerArchivo(String archivo) throws IOException{
        
        BufferedReader in = new BufferedReader(new FileReader(archivo));
        String listado;
        while ((listado = in.readLine())!=null){
            double  nuevo = Double.parseDouble(listado);
            lista.agregar(nuevo);
        }
        in.close();
    }

    public static void main(String[] args) throws IOException {
        port(getPort());
        
        String lista;
        String c;
        c = "archivo.txt";
        leerArchivo(c);
       
        get("/hello", (req, res) -> ("<!DOCTYPE html>" + 
                                     "<html>"+
                                     "<head>"+
                                        "<title>Tarea 2 AREM</title>"+
                                        "</head>"+
                                        "<body>"+
                                            "<p>Media y Derivada parcial</p>"+
                                            "<p> * Ingrese los datos separados por comas : </p>"+
                                            "<input type='text' id='tnum' name='numero'>"+
                                            "<button id='boton' class='button'>calcular</button>"+
                                        "</body>"+
                                            "<body>"+
                                            "<p> * Media : </p>"+ media() +
                                            "<p> * Derivada Parcial : </p>"+ derivadaParcial() +
                                        "</body>"+
                                    "</html>"));
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
