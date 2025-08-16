package Listas;

public class DataTypeExamples {
    // Tipos primitivos (usando wrappers)
    public static void primitiveTypesExample() {
        System.out.println("\n--- EJEMPLOS DE TIPOS PRIMITIVOS ---");
        Integer entero = 42;
        Double decimal = 3.1416;
        Character caracter = 'J';
        Boolean booleano = false;
        
        System.out.println("Entero (Integer): " + entero);
        System.out.println("Decimal (Double): " + decimal);
        System.out.println("Carácter (Character): " + caracter);
        System.out.println("Booleano (Boolean): " + booleano);
    }

    // Tipos complejos
    public static void complexTypesExample() {
        System.out.println("\n--- EJEMPLOS DE TIPOS COMPLEJOS ---");
        String texto = "Programación en Java";
        int[] numeros = {10, 20, 30, 40, 50};
        
        System.out.println("Cadena (String): " + texto);
        System.out.print("Arreglo (int[]): ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Creación de contactos
    public static Contacto createContact(String name, String address, String phone) {
        return new Contacto(name, address, phone);
    }
}