
package co.edu.escuelaing.arem.designprimer;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class Linked {
    private Nodo cabeza;
    private int tamanio; 
    
    /**
     * Constructor Linked
     */
    
    public Linked(){
        cabeza = null;
        tamanio = 0;
    }
    
    /**
     * Metodo agregar, agrega nuevos elementos a la lista encadenada
     * e incremennta el tamaño de la lista 
     * @param n double 
     */
    
    public void agregar(double n){
        if(cabeza==null){
            cabeza = new Nodo(n);
        }else{
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(n);
            nuevo.agregar(temp);
            cabeza = nuevo;
        }
        tamanio++;
    }
    
    /**
     * Metodo ver, muestra los elementos de la lista
     * @para indice int
     */
    
    public double ver(int indice){
        Nodo temp = cabeza;
        for(int i=0;i<indice;i++){
            temp = temp.getNext();
        }
        return temp.getDato();
    }
    
    /**
     * Metodo getTamanio, retorna el tamanio de la lista
     * @return tamanio int 
     */
    
    public int getTamanio(){
        return tamanio;
    }
}
