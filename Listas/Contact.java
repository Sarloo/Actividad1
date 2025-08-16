package Listas;

/**
 * Esta clase representa un contacto en la agenda
 * Almacena su información básica: nombre, teléfono y dirección.
 */
public class Contact {
    // Campos privados para almacenar la información del contacto
    private String nombre;
    private String telefono;
    private String direccion;  

    // Constructor para crear un nuevo contacto
    public Contact(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    // Representación en cadena del contacto
    @Override
    public String toString() {
        // Usa String.format para aliear las columnas
        return String.format("Nombre: %-20s | Teléfono: %-15s | Dirección: %-20s", 
               nombre, telefono, direccion);
    }
        // Compara dos contactos por nombre y teléfono para ver si son iguales
        // Retorna true si son iguales, false en caso contrario
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica si son el mismo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica si el objeto es nulo o de una clase diferente
        Contact other = (Contact) obj;
        // Compaa nombre y telefono ignorando mayúsculas y minúsculas
        // Retorna true si ambos campos coinciden, false en caso contrario
        return nombre.equalsIgnoreCase(other.nombre) && 
               telefono.equals(other.telefono);
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
}