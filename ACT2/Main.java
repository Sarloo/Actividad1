package ACT2;

import java.util.Scanner;

/**
 * Simulador de sistema operativo que gestiona comandos (pila) y procesos (cola)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear pila para comandos y cola para procesos
        Stack historialComandos = new Stack("SIMPLE");
        Queue colaProcesos = new Queue("SIMPLE");
        
        System.out.println("=== SIMULADOR DE SISTEMA OPERATIVO ===");
        
        // Menú principal
        while(true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ejecutar comando");
            System.out.println("2. Agregar proceso");
            System.out.println("3. Ver historial de comandos y cola de procesos");
            System.out.println("4. Procesar siguiente comando");
            System.out.println("5. Realizar siguiente proceso");
            System.out.println("6. Salir del simulador");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch(opcion) {
                case 1: // Ejecutar comando
                    boolean otroComando = true;
                    while (otroComando) {
                        System.out.println("\n--- EJECUTAR COMANDO ---");
                        System.out.print("Ingrese el comando a ejecutar: ");
                        String comando = scanner.nextLine();
                        
                        historialComandos.push(comando);
                        System.out.println("Comando ejecutado: " + comando);
                        
                        System.out.print("¿Desea ejecutar otro comando? (s/n): ");
                        String respuesta = scanner.nextLine();
                        otroComando = respuesta.equalsIgnoreCase("s");
                    }
                    break;
                    
                case 2: // Agregar proceso
                    boolean otroProceso = true;
                    while (otroProceso) {
                        System.out.println("\n--- AGREGAR PROCESO ---");
                        System.out.print("Ingrese el nombre del proceso: ");
                        String proceso = scanner.nextLine();
                        
                        colaProcesos.enqueue(proceso);
                        System.out.println("Proceso agregado: " + proceso);
                        
                        System.out.print("¿Desea agregar otro proceso? (s/n): ");
                        String respuesta = scanner.nextLine();
                        otroProceso = respuesta.equalsIgnoreCase("s");
                    }
                    break;
                    
                case 3: // Ver historial de comandos y cola de procesos
                    System.out.println("\n--- HISTORIAL DE COMANDOS ---");
                    if (historialComandos.isEmpty()) {
                        System.out.println("El historial de comandos está vacío.");
                    } else {
                        historialComandos.mostrarComandos();
                    }
                    
                    System.out.println("\n--- COLA DE PROCESOS ---");
                    if (colaProcesos.isEmpty()) {
                        System.out.println("La cola de procesos está vacía.");
                    } else {
                        colaProcesos.mostrarProcesos();
                    }
                    break;
                    
                case 4: // Procesar siguiente comando
                    boolean procesarOtroComando = true;
                    while (procesarOtroComando && !historialComandos.isEmpty()) {
                        System.out.println("\n--- PROCESANDO COMANDO ---");
                        String comando = historialComandos.pop();
                        System.out.println("Procesando: " + comando);
                        System.out.println("Comando ejecutado exitosamente.");
                        
                        if (!historialComandos.isEmpty()) {
                            System.out.print("¿Desea procesar otro comando? (s/n): ");
                            String respuesta = scanner.nextLine();
                            procesarOtroComando = respuesta.equalsIgnoreCase("s");
                        } else {
                            System.out.println("No hay más comandos en el historial.");
                            procesarOtroComando = false;
                        }
                    }
                    if (historialComandos.isEmpty()) {
                        System.out.println("El historial de comandos está vacío.");
                    }
                    break;
                    
                case 5: // Realizar siguiente proceso
                    boolean realizarOtroProceso = true;
                    while (realizarOtroProceso && !colaProcesos.isEmpty()) {
                        System.out.println("\n--- REALIZANDO PROCESO ---");
                        String proceso = colaProcesos.dequeue();
                        System.out.println("Ejecutando: " + proceso);
                        System.out.println("Proceso completado exitosamente.");
                        
                        if (!colaProcesos.isEmpty()) {
                            System.out.print("¿Desea ejecutar otro proceso? (s/n): ");
                            String respuesta = scanner.nextLine();
                            realizarOtroProceso = respuesta.equalsIgnoreCase("s");
                        } else {
                            System.out.println("No hay más procesos en la cola.");
                            realizarOtroProceso = false;
                        }
                    }
                    if (colaProcesos.isEmpty()) {
                        System.out.println("La cola de procesos está vacía.");
                    }
                    break;
                    
                case 6: // Salir del simulador
                    System.out.println("\nSaliendo del simulador. ¡Hasta pronto!");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        }
    }
}