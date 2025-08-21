package ACT2;

/**
 * Clase que implementa listas enlazadas para manejar objetos con operaciones CRUD
 * Soporta listas simplemente enlazadas, doblemente enlazadas y circulares.
 */
public class LinkedList {
    // Punteros al inicio y fin de la lista
    private Node head; // Primer nodo de la lista
    private Node tail; // Último nodo de la lista
    private String listType; // Tipos de lista: "SIMPLE", "DOUBLE", "CIRCULAR"

    // Constructor para inicializar la lista según el tipo especificado
    public LinkedList(String listType) {
        this.head = null;
        this.tail = null;
        this.listType = listType;
    }

    // Insertar un nuevo objeto en la lista
    public void insert(Object data) {
        Node newNode; // Nuevo nodo a insertar
        
        switch(listType) {
            case "SIMPLE": // Lista simplemente enlazada
                newNode = new Node(data); // Crea nodo simple
                if (head == null) { // Si la lista está vacía
                    head = newNode; // Head y tail apuntan al nuevo nodo
                    tail = newNode;
                } else {
                    tail.next = newNode; // Conecta el último nodo al nuevo
                    tail = newNode; // Actualiza tail 
                }
                break;
                
            case "DOUBLE": // Lista doblemente enlazada
                // Crea un nuevo nodo con referencia al nodo anterior (tail)
                newNode = new Node(data, tail);
                if (head == null) { // Si la lista está vacía
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode; // Conecta el último nodo al nuevo
                    tail = newNode; // Actualiza tail
                }
                break;
                
            case "CIRCULAR": // Lista circular
                newNode = new Node(data); // Crea nodo circular
                if (head == null) { // Si la lista está vacía
                    head = newNode;
                    head.next = head; // Se apunta a sí mismo
                    tail = head; // Tail es head en circulares
                } else {
                    tail.next = newNode; // Enlaza el último nodo al nuevo
                    newNode.next = head; // Hace circular el enlace
                    tail = newNode; // Actualiza tail al nuevo nodo
                }
                break;
        }
    }

    // Eliminar un objeto
    public boolean delete(Object data) {
        if (head == null) return false; // Lista vacía

        switch(listType) {
            case "SIMPLE": // Lista simple
                if (head.data.equals(data)) { // Si es el primer nodo
                    head = head.next; // Mueve head al siguiente
                    if (head == null) tail = null; // Si la lista queda vacía, tail también es null
                    return true;
                }
                
                Node current = head;
                // Busca el nodo anterior al que se quiere eliminar
                while (current.next != null && !current.next.data.equals(data)) {
                    current = current.next;
                }
                
                if (current.next != null) { // Si se encontró el objeto
                    if (current.next == tail) { // Si es el último nodo
                        tail = current; // Actualiza tail
                    }
                    current.next = current.next.next; // Elimina el objeto
                    return true;
                }
                break;
                
            case "DOUBLE": // Lista doble
                if (head.data.equals(data)) { // Si es el primer nodo
                    head = head.next;
                    if (head != null) {
                        head.prev = null; // Elimina referencia al nodo anterior
                    } else {
                        tail = null; // Si la lista queda vacía, tail también es null
                    }
                    return true;
                }
                
                current = head;
                // Busca el nodo que contiene el objeto
                while (current != null && !current.data.equals(data)) {
                    current = current.next;
                }
                
                if (current != null) { // Si se encontró el objeto
                    if (current.prev != null) {
                        current.prev.next = current.next; // Actualiza el nodo anterior
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev; // Actualiza el nodo siguiente
                    }
                    if (current == tail) { // Si es el último nodo
                        tail = current.prev; // Actualiza tail
                    }
                    return true;
                }
                break;
                
            case "CIRCULAR": // Lista circular
                if (head.data.equals(data)) { // Si es el primer nodo
                    if (head.next == head) { // Si solo hay un nodo
                        head = null;
                        tail = null;
                    } else {
                        tail.next = head.next; // Elimina referencia circular
                        head = head.next; // Nuevo head
                    }
                    return true;
                }
                
                Node prev = tail;
                current = head;
                // Recorre la lista circular buscando el objeto 
                do {
                    if (current.data.equals(data)) { // Si se encuentra el objeto
                        prev.next = current.next; // Elimina el objeto
                        if (current == tail) { // Si es el último nodo
                            tail = prev; // Actualiza tail
                        }
                        return true;
                    }
                    prev = current;
                    current = current.next;
                } while (current != head); // Hasta volver al inicio
                break;
        }
        return false; // No se encontró el objeto
    }

    // Buscar un objeto en la lista
    public boolean search(Object data) {
        if (head == null) return false; // Lista vacía

        Node current = head;
        // Recorre la lista buscando el objeto
        do {
            if (current.data.equals(data)) { // Si se encuentra el objeto
                return true;
            }
            current = current.next;
        } while (current != null && current != head); // Para listas lineales y circulares 

        return false; // No se encontró el objeto
    }

    // Mostrar todos los objetos de la lista
    public void display() {
        if (head == null) { // Si la lista está vacía
            System.out.println("\nLa lista está vacía");
            return;
        }
        
        System.out.println("\n=== LISTA ===");
        System.out.println("Tipo de lista: " + listType);
        System.out.println("--------------------------");
        
        Node current = head;
        // Recorre la lista mostrando cada objeto
        do {
            System.out.println(current.data.toString());
            current = current.next;
        } while (current != null && current != head); // Para todos los tipos de lista
        
        System.out.println("--------------------------");
    }

    // Obtener el primer elemento de la lista
    public Object getPrimero() {
        if (head == null) return null;
        return head.data;
    }

    // Obtener el último elemento de la lista
    public Object getUltimo() {
        if (tail == null) return null;
        return tail.data;
    }

    // Verificar si la lista está vacía
    public boolean isEmpty() {
        return head == null;
    }
}