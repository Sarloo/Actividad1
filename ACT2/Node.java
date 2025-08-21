package ACT2;

/**
 * Clase que representa un nodo para listas enlazadas
 * Cada nodo almacena un dato (en este caso, un String)
 */
public class Node {
    Object data;    // Dato almacenado en el nodo (en este caso será un String)
    Node next;      // Referencia al siguiente nodo
    Node prev;      // Referencia al nodo anterior (para listas dobles)

    // Constructor para listas simples
    public Node(Object data) {
        this.data = data; // Almacena el dato en el nodo
        this.next = null; // Inicializa el siguiente nodo como null
        this.prev = null; // Inicializa el nodo anterior como null
    }

    // Constructor para listas dobles
    // data: Dato a almacenar
    // prev: Referencia al nodo anterior
    public Node(Object data, Node prev) {
        this.data = data; // Almacena el dato en el nodo
        this.next = null; // Inicializa el siguiente nodo como null
        this.prev = prev; // Establece el nodo anterior
    }
}