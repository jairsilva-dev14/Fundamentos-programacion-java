package GRUPO_2;

import java.util.Scanner;

public class SistemaTienda {

    public static final int maxProductos = 50;
    public static int contadorProductos = 0;

    public static final int maxClientes = 50;
    public static int contadorClientes = 0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String[] nombres = new String[maxProductos];
        double[] precios = new double[maxProductos];
        int[] stock = new int[maxProductos];

        String[] dniClientes = new String[maxClientes];
        String[] nombresClientes = new String[maxClientes];
        int[] puntosClientes = new int[maxClientes];

        byte opcion;

        do {
            System.out.println("\n=========================================");
            System.out.println("       SISTEMA DE GESTIÓN DE TIENDA      ");
            System.out.println("=========================================");
            System.out.println("1. Gestión de Ventas");
            System.out.println("2. Gestión de Clientes");
            System.out.println("3. Salir del Sistema");
            System.out.print("Elija una opción (1-3): ");
            opcion = teclado.nextByte();

            switch (opcion) {
                case 1:
                    ModuloVentas.menuVentas(nombres, precios, stock, dniClientes, nombresClientes, puntosClientes, teclado);
                    break;
                case 2:
                    ModuloClientes.menuClientes(dniClientes, nombresClientes, puntosClientes, teclado);
                    break;
                case 3:
                    System.out.println("\nSaliendo del sistema... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\nError: Opción inválida.");
            }
        } while (opcion != 3);

    }
}