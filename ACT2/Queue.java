package ACT2;

/**
 * Implementación de una cola (FIFO) para gestionar procesos en ejecución
 */
public class Queue {
    private LinkedList lista;
    
    public Queue(String tipoLista) {
        lista = new LinkedList(tipoLista);
    }
    
    // Agregar un proceso a la cola (enqueue)
    public void enqueue(String proceso) {
        // Crear un string con formato para almacenar proceso y timestamp
        String procesoConInfo = "Proceso: " + proceso + " | Hora: " + java.time.LocalTime.now().toString();
        lista.insert(procesoConInfo);
    }
    
    // Eliminar y obtener el primer proceso (dequeue)
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        // Obtener el primer proceso
        String primero = (String) lista.getPrimero();
        // Crear un objeto temporal para eliminar
        String temp = new String(primero);
        lista.delete(temp);
        return primero;
    }
    
    // Ver el primer proceso sin eliminarlo (peek)
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return (String) lista.getPrimero();
    }
    
    // Verificar si la cola está vacía
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    // Mostrar todos los procesos en la cola
    public void mostrarProcesos() {
        lista.display();
    }
}