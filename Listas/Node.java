package Listas;

public class Node {
    Object data;
    Node next;
    Node prev;

    // Constructor para lista simplemente enlazada
    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Constructor para lista doblemente enlazada
    public Node(Object data, Node prev) {
        this.data = data;
        this.next = null;
        this.prev = prev;
    }
}