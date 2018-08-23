
package co.edu.escuelaing.arem.designprimer;

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
    
    public static void agregarDatos(double Dato ){
        
    }

    public static void main(String[] args) {
        port(getPort());
      
        get("/hello", (req, res) -> ("<!DOCTYPE html>" + 
                                     "<html>"+
                                     "<head>"+
                                            "<title>Media y Derivada parcial</title>"+
                                        "</head>"+
                                        "<body>"+
                                            "<input type='text' id='tnum' name='numero'>"+
                                        "</body>"+
                                    "</html>"));
                                            
        
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
