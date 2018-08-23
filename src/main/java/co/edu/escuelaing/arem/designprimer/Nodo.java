
package co.edu.escuelaing.arem.designprimer;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class Nodo {
    private Nodo next;
    private double dato;
    
    /**
     * Constructor Nodo
     * @param dato 
     */
    
    public Nodo(double dato){
        this.dato = dato;
        this.next = null;
    }
    
    /**
     * Metodo getNext, retorna el nodo
     * @return next Nodo
     */
    
    public Nodo getNext(){
        return this.next;
    }
    
    /**
     * Metodo agregar, agrega un nuevo nodo 
     * @param n Nodo
     */
    
    public void agregar(Nodo n){
        this.next = n;
    }
    
    /**
     * Metodo getDato, retorna el dato
     * @return dato double 
     */
    
    public double getDato(){
        return this.dato;
    }
    
}
