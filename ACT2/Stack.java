package ACT2;

/**
 * Implementación de una pila (LIFO) para gestionar el historial de comandos
 */
public class Stack {
    private LinkedList lista;
    
    public Stack(String tipoLista) {
        lista = new LinkedList(tipoLista);
    }
    
    // Agregar un comando a la pila (push)
    public void push(String comando) {
        // Crear un string con formato para almacenar comando y timestamp
        String comandoConTimestamp = "Comando: " + comando + " | Hora: " + java.time.LocalTime.now().toString();
        lista.insert(comandoConTimestamp);
    }
    
    // Eliminar y obtener el último comando (pop)
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        
        // Obtener el último comando (tope de la pila)
        String ultimo = (String) lista.getUltimo();
        // Crear un objeto temporal para eliminar
        String temp = new String(ultimo);
        lista.delete(temp);
        return ultimo;
    }
    
    // Ver el último comando sin eliminarlo (peek)
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return (String) lista.getUltimo();
    }
    
    // Verificar si la pila está vacía
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    // Mostrar todos los comandos en la pila
    public void mostrarComandos() {
        lista.display();
    }
}