package Listas;

public class Contacto {
    private String name;
    private String address;
    private String phone;

    public Contacto(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %-15s | Dirección: %-20s | Teléfono: %-10s", 
               name, address, phone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto other = (Contacto) obj;
        return name.equalsIgnoreCase(other.name) && 
               phone.equals(other.phone);
    }
}