package Listas;

import java.util.Scanner;

/**
 * Programa principal de gestión de contactos con diferentes tipos de listas enlazadas
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Esto es para leer la entrada del usuario
        LinkedList agenda = null; // Inicializa la agenda como null para luego asignarle un tipo de lista
        
        // Menú para seleccionar tipo de lista
        System.out.println("=== BIENVENIDO AL SISTEMA DE GESTIÓN DE CONTACTOS ===");
        System.out.println("\nSeleccione el tipo de lista para su agenda:");
        System.out.println("1. Lista simplemente enlazada");
        System.out.println("2. Lista doblemente enlazada");
        System.out.println("3. Lista circular");
        System.out.print("Opción: ");
        
        int tipoLista = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        // Crea la lista según la opción seleccionada
        switch(tipoLista) {
            case 1: agenda = new LinkedList("SIMPLE"); break;
            case 2: agenda = new LinkedList("DOUBLE"); break;
            case 3: agenda = new LinkedList("CIRCULAR"); break;
            default:
                System.out.println("Opción inválida. Usando lista simplemente enlazada por defecto.");
                agenda = new LinkedList("SIMPLE");
        }
        
        // Menú principal de operaciones
        while(true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar nuevo contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Mostrar ejemplos de tipos de datos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch(opcion) {
                case 1: // Agregar contacto
                    System.out.println("\n--- NUEVO CONTACTO ---");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    
                    Contact nuevo = new Contact(nombre, telefono, direccion);
                    agenda.insert(nuevo);
                    System.out.println("\nContacto agregado exitosamente!");
                    break;
                    
                case 2: // Eliminar contacto
                    System.out.println("\n--- ELIMINAR CONTACTO ---");
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telEliminar = scanner.nextLine();
                    
                    Contact eliminar = new Contact(nombreEliminar, telEliminar, "");
                    if(agenda.delete(eliminar)) {
                        System.out.println("\nContacto eliminado exitosamente!");
                    } else {
                        System.out.println("\nContacto no encontrado en la agenda.");
                    }
                    break;
                    
                case 3: // Buscar contacto
                    System.out.println("\n--- BUSCAR CONTACTO ---");
                    System.out.print("Nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telBuscar = scanner.nextLine();
                    
                    // Crar un contacto temporal para buscar
                    Contact buscar = new Contact(nombreBuscar, telBuscar, "");
                    if(agenda.search(buscar)) {
                        System.out.println("\nEl contacto SÍ está en la agenda.");
                    } else {
                        System.out.println("\nEl contacto NO está en la agenda.");
                    }
                    break;
                    
                case 4: // Mostrar todos los contactos
                    agenda.display();
                    break;
                    
                case 5: // Mostrar ejemplos de tipos de datos
                    DataTypeExamples.mostrarTodosEjemplos();
                    break;
                    
                case 6: // Salir
                    System.out.println("\nGracias por usar el sistema de gestión de contactos!");
                    scanner.close(); // Cierra el scanner
                    System.exit(0); // Sale del programa
                    
                default: // Opción inválida
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        }
    }
}