package Listas;

/**
 * Clase con ejemplos de diferentes tipos de datos
 */
public class DataTypeExamples {
    
    /**
     * Muestra ejemplos de tipos de datos primitivos (usando wrappers)
     */
    public static void mostrarPrimitivos() {
        System.out.println("\n=== EJEMPLOS DE TIPOS PRIMITIVOS ===");
        
        // Ejemplos usando wrappers
        Integer entero = 42;
        Double decimal = 3.1416;
        Character caracter = 'A';
        Boolean booleano = true;
        
        System.out.println("Entero (Integer): " + entero);
        System.out.println("Decimal (Double): " + decimal);
        System.out.println("Carácter (Character): " + caracter);
        System.out.println("Booleano (Boolean): " + booleano);
    }
    
    /**
     * Muestra ejemplos de tipos de datos complejos
     */
    public static void mostrarComplejos() {
        System.out.println("\n=== EJEMPLOS DE TIPOS COMPLEJOS ===");
        
        // Ejemplos de tipos complejos
        String texto = "Hola Mundo";
        int[] numeros = {1, 2, 3, 4, 5};
        Contact contactoEjemplo = new Contact("Ejemplo", "12345678", "Calle Ficticia 123");
        
        System.out.println("Cadena (String): " + texto);
        System.out.print("Arreglo (int[]): ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println("\nObjeto Contact: " + contactoEjemplo);
    }
    
    /**
     * Muestra todos los ejemplos
     */
    public static void mostrarTodosEjemplos() {
        mostrarPrimitivos();
        mostrarComplejos();
    }
}