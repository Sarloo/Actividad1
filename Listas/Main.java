package Listas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = null;
        
        while (true) {
            printMainMenu();
            int option = getIntInput(scanner, "Seleccione una opción: ");
            
            switch (option) {
                case 1: list = createList(scanner); break;
                case 2: insertElement(scanner, list); break;
                case 3: deleteElement(scanner, list); break;
                case 4: searchElement(scanner, list); break;
                case 5: displayList(list); break;
                case 6: showDataExamples(); break;
                case 7: manageContacts(scanner); break;
                case 8: exitProgram(scanner);
                default: System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private static void printMainMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Crear nueva lista");
        System.out.println("2. Insertar elemento");
        System.out.println("3. Eliminar elemento");
        System.out.println("4. Buscar elemento");
        System.out.println("5. Mostrar lista");
        System.out.println("6. Ejemplos de tipos de datos");
        System.out.println("7. Gestión de contactos");
        System.out.println("8. Salir");
    }
    
    private static LinkedList createList(Scanner scanner) {
        System.out.println("\n--- CREAR NUEVA LISTA ---");
        System.out.println("1. Simplemente enlazada");
        System.out.println("2. Doblemente enlazada");
        System.out.println("3. Circular");
        int type = getIntInput(scanner, "Seleccione tipo de lista: ");
        
        switch (type) {
            case 1: return new LinkedList("SIMPLE");
            case 2: return new LinkedList("DOUBLE");
            case 3: return new LinkedList("CIRCULAR");
            default:
                System.out.println("Opción no válida. Se creará lista simplemente enlazada.");
                return new LinkedList("SIMPLE");
        }
    }
    
    private static void insertElement(Scanner scanner, LinkedList list) {
        if (list == null) {
            System.out.println("Primero debe crear una lista (Opción 1)");
            return;
        }
        
        System.out.print("\nIngrese el dato a insertar: ");
        String data = scanner.nextLine();
        list.insert(data);
        System.out.println("Elemento insertado correctamente.");
    }
    
    private static void deleteElement(Scanner scanner, LinkedList list) {
        if (list == null) {
            System.out.println("Primero debe crear una lista (Opción 1)");
            return;
        }
        
        System.out.print("\nIngrese el dato a eliminar: ");
        String data = scanner.nextLine();
        if (list.delete(data)) {
            System.out.println("Elemento eliminado correctamente.");
        } else {
            System.out.println("Elemento no encontrado en la lista.");
        }
    }
    
    private static void searchElement(Scanner scanner, LinkedList list) {
        if (list == null) {
            System.out.println("Primero debe crear una lista (Opción 1)");
            return;
        }
        
        System.out.print("\nIngrese el dato a buscar: ");
        String data = scanner.nextLine();
        if (list.search(data)) {
            System.out.println("Elemento encontrado en la lista.");
        } else {
            System.out.println("Elemento no encontrado en la lista.");
        }
    }
    
    private static void displayList(LinkedList list) {
        if (list == null) {
            System.out.println("Primero debe crear una lista (Opción 1)");
            return;
        }
        list.display();
    }
    
    private static void showDataExamples() {
        DataTypeExamples.primitiveTypesExample();
        DataTypeExamples.complexTypesExample();
    }
    
    private static void manageContacts(Scanner scanner) {
        LinkedList contactList = new LinkedList("SIMPLE");
        
        while (true) {
            System.out.println("\n=== GESTIÓN DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Mostrar contactos");
            System.out.println("5. Volver al menú principal");
            
            int option = getIntInput(scanner, "Seleccione una opción: ");
            
            switch (option) {
                case 1: addContact(scanner, contactList); break;
                case 2: removeContact(scanner, contactList); break;
                case 3: findContact(scanner, contactList); break;
                case 4: contactList.display(); break;
                case 5: return;
                default: System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private static void addContact(Scanner scanner, LinkedList list) {
        System.out.println("\n--- AGREGAR CONTACTO ---");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Dirección: ");
        String address = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();
        
        Contacto newContact = DataTypeExamples.createContact(name, address, phone);
        list.insert(newContact);
        System.out.println("Contacto agregado correctamente.");
    }
    
    private static void removeContact(Scanner scanner, LinkedList list) {
        System.out.println("\n--- ELIMINAR CONTACTO ---");
        System.out.print("Nombre del contacto: ");
        String name = scanner.nextLine();
        System.out.print("Teléfono del contacto: ");
        String phone = scanner.nextLine();
        
        Contacto tempContact = new Contacto(name, "", phone);
        if (list.delete(tempContact)) {
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
    
    private static void findContact(Scanner scanner, LinkedList list) {
        System.out.println("\n--- BUSCAR CONTACTO ---");
        System.out.print("Nombre del contacto: ");
        String name = scanner.nextLine();
        System.out.print("Teléfono del contacto: ");
        String phone = scanner.nextLine();
        
        Contacto tempContact = new Contacto(name, "", phone);
        if (list.search(tempContact)) {
            System.out.println("Contacto encontrado en la lista.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
    
    private static void exitProgram(Scanner scanner) {
        System.out.println("\nSaliendo del programa...");
        scanner.close();
        System.exit(0);
    }
    
    private static int getIntInput(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. " + message);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return input;
    }
}