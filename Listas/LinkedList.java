package Listas;

/**
 * Clase que implementa listas enlazadas para manejar contactos con operaciones CRUD
 * Soporta listas simplemente enlazadas, doblemente enlazadas y circulares.
 */
public class LinkedList {
    // Punter al inicio y fin de la lista
    private Node head; // Primer nodo de la lista
    private Node tail; // Último nodo de la lista
    private String listType; // Tipos de lista: "SIMPLE", "DOUBLE", "CIRCULAR"

    // Constructor para inicializar la lista según el tipo especificado
    // listType: Tipo de lista a crear ("SIMPLE", "DOUBLE", "CIRCULAR")
    public LinkedList(String listType) {
        this.head = null;
        this.tail = null;
        this.listType = listType;
    }

    // Insertar un nuevo contacto en la lista
    // contact: Objeto Contacto a insertar
    // Dependiendo del tipo de lista, se maneja la inserción de manera diferente
    // En listas simplemente enlazadas, se agrega al final
    // En listas dobles, se mantiene la referencia al nodo anterior
    // En listas circulares, se conecta el último nodo al primero
    public void insert(Contact contact) {
        Node newNode; // Nuevo nodo a insertar
        
        switch(listType) {
            case "SIMPLE": // Lista simplemente enlazada
                newNode = new Node(contact); // Crea nodo simple
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
                newNode = new Node(contact, tail);
                if (head == null) { // Si la lista está vacía
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode; // Conecta el último nodo al nuevo
                    tail = newNode; // Actualiza tail
                }
                break;
                
            case "CIRCULAR": // Lista circular
                newNode = new Node(contact); // Crea nodo circular
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

    // Eliminar un contacto
    // contact: Objeto Contacto a eliminar
    // Retorna true si se eliminó el contacto, false si no se encontró
    public boolean delete(Contact contact) {
        if (head == null) return false; // Lista vacía

        switch(listType) {
            case "SIMPLE": // Lista simple
                if (((Contact)head.data).equals(contact)) { // Si es el primer nodo
                    head = head.next; // Mueve head al siguiente
                    if (head == null) tail = null; // Si la lista queda vacía, tail también es null
                    return true;
                }
                
                Node current = head;
                // Busca el nodo anterior al que se quiere eliminar
                while (current.next != null && !((Contact)current.next.data).equals(contact)) {
                    current = current.next;
                }
                
                if (current.next != null) { // Si se encontró el contacto
                    if (current.next == tail) { // Si es el último nodo
                        tail = current; // Actualiza tail
                    }
                    current.next = current.next.next; // Elimina el contacto
                    return true;
                }
                break;
                
            case "DOUBLE": // Lista doble
                if (((Contact)head.data).equals(contact)) { // Si es el primer nodo
                    head = head.next;
                    if (head != null) {
                        head.prev = null; // Elimina referencia al nodo anterior
                    } else {
                        tail = null; // Si la lista queda vacía, tail también es null
                    }
                    return true;
                }
                
                current = head;
                // Busca el nodo que contiene el contacto
                while (current != null && !((Contact)current.data).equals(contact)) {
                    current = current.next;
                }
                
                if (current != null) { // Si se encontró el contacto
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
                if (((Contact)head.data).equals(contact)) { // Si es el primer nodo
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
                // Recorre la lista circular buscando el contacto 
                do {
                    if (((Contact)current.data).equals(contact)) { // Si se encuentra el contacto
                        prev.next = current.next; // Elimina el contacto
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
        return false; // No se encontró el contacto
    }

    // Buscar un contacto en la lista
    // contact: Objeto Contacto a buscar
    // Retorna true si se encuentra, false en caso contrario
    public boolean search(Contact contact) {
        if (head == null) return false; // Lista vacía

        Node current = head;
        // Recorre la lista buscando el contacto
        do {
            if (((Contact)current.data).equals(contact)) { // Si se encuentra el contacto
                return true;
            }
            current = current.next;
        } while (current != null && current != head); // Para listas lineales y circulares 

        return false; // No se encontró el contacto
    }

    // Mostrar todos los contactos de la lista
    // Imprime los contactos en la consola
    public void display() {
        if (head == null) { // Si la lista está vacía
            System.out.println("\nLa agenda de contactos está vacía");
            return;
        }
            // Encabezado de la lista
        System.out.println("\n=== LISTA DE CONTACTOS ===");
        System.out.println("Tipo de lista: " + listType);
        System.out.println("--------------------------");
        
        Node current = head;
        // Recorre la lista mostrando cada contacto
        do {
            System.out.println(current.data); // Usando toString() de Contact
            current = current.next;
        } while (current != null && current != head); // Para todos los tipos de lista
        
        System.out.println("--------------------------");
    }
}