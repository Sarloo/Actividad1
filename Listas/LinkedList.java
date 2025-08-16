package Listas;

public class LinkedList {
    private Node head;
    private Node tail;
    private String listType; // "SIMPLE", "DOUBLE", "CIRCULAR"

    public LinkedList(String listType) {
        this.head = null;
        this.tail = null;
        this.listType = listType;
    }

    // Insertar elementos
    public void insert(Object data) {
        Node newNode;
        
        switch(listType) {
            case "SIMPLE":
                newNode = new Node(data);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
                break;
                
            case "DOUBLE":
                newNode = new Node(data, tail);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
                break;
                
            case "CIRCULAR":
                newNode = new Node(data);
                if (head == null) {
                    head = newNode;
                    head.next = head;
                    tail = head;
                } else {
                    tail.next = newNode;
                    newNode.next = head;
                    tail = newNode;
                }
                break;
        }
    }

    // Eliminar elementos
    public boolean delete(Object data) {
        if (head == null) return false;

        switch(listType) {
            case "SIMPLE":
                if (head.data.equals(data)) {
                    head = head.next;
                    if (head == null) tail = null;
                    return true;
                }
                
                Node current = head;
                while (current.next != null && !current.next.data.equals(data)) {
                    current = current.next;
                }
                
                if (current.next != null) {
                    if (current.next == tail) {
                        tail = current;
                    }
                    current.next = current.next.next;
                    return true;
                }
                break;
                
            case "DOUBLE":
                if (head.data.equals(data)) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                    return true;
                }
                
                current = head;
                while (current != null && !current.data.equals(data)) {
                    current = current.next;
                }
                
                if (current != null) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    if (current == tail) {
                        tail = current.prev;
                    }
                    return true;
                }
                break;
                
            case "CIRCULAR":
                if (head.data.equals(data)) {
                    if (head.next == head) {
                        head = null;
                        tail = null;
                    } else {
                        tail.next = head.next;
                        head = head.next;
                    }
                    return true;
                }
                
                Node prev = tail;
                current = head;
                do {
                    if (current.data.equals(data)) {
                        prev.next = current.next;
                        if (current == tail) {
                            tail = prev;
                        }
                        return true;
                    }
                    prev = current;
                    current = current.next;
                } while (current != head);
                break;
        }
        return false;
    }

    // Buscar elementos
    public boolean search(Object data) {
        if (head == null) return false;

        Node current = head;
        do {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        } while (current != null && current != head);

        return false;
    }

    // Mostrar elementos
    public void display() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }

        System.out.println("\nContenido de la lista " + listType + ":");
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != null && current != head);
        
        if (listType.equals("CIRCULAR")) {
            System.out.println("(vuelve al inicio)");
        } else {
            System.out.println("null");
        }
        System.out.println();
    }
}