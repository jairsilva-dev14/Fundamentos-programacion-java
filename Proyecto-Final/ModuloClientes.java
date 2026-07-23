package GRUPO_2;

import java.util.Scanner;

public class ModuloClientes {

    public static void menuClientes(String[] dniCliente, String[] nombreCliente, int[] puntosCliente, Scanner teclado) {
        byte opcion;
        do {
            System.out.println("");
            System.out.println("---------------------------------");
            System.out.println("      GESTIÓN DE CLIENTES");
            System.out.println("---------------------------------");
            System.out.println("[1] Registrar cliente");
            System.out.println("[2] Listar clientes");
            System.out.println("[3] Buscar cliente por DNI");
            System.out.println("[4] Agregar puntos de fidelización");
            System.out.println("[5] Volver al menú principal");
            System.out.println("---------------------------------");
            System.out.print("Ingrese opción: ");
            opcion = teclado.nextByte();

            switch (opcion) {
                case 1:
                    registrarCliente(dniCliente, nombreCliente, puntosCliente, teclado);
                    break;
                case 2:
                    listarClientes(dniCliente, nombreCliente, puntosCliente);
                    break;
                case 3:
                    buscarClienteMenu(dniCliente, nombreCliente, puntosCliente, teclado);
                    break;
                case 4:
                    agregarPuntos(dniCliente, nombreCliente, puntosCliente, teclado);
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void registrarCliente(String[] dniCliente, String[] nombreCliente, int[] puntosCliente, Scanner teclado) {
        if (SistemaTienda.contadorClientes >= SistemaTienda.maxClientes) {
            System.out.println("No se pueden registrar más clientes, capacidad máxima alcanzada.");
            return;
        }

        String dni;
        boolean dniValido;
        teclado.nextLine();

        do {
            System.out.print("Ingrese DNI del cliente (8 dígitos): ");
            dni = teclado.nextLine();
            dniValido = esDniValido(dni);
            if (!dniValido) {
                System.out.println("Error: El DNI debe tener exactamente 8 dígitos numéricos.");
            }
        } while (!dniValido);

        System.out.print("Ingrese nombre del cliente: ");
        String nombre = teclado.nextLine();

        dniCliente[SistemaTienda.contadorClientes] = dni;
        nombreCliente[SistemaTienda.contadorClientes] = nombre;
        puntosCliente[SistemaTienda.contadorClientes] = 0;

        SistemaTienda.contadorClientes++;
        System.out.println("¡Cliente registrado correctamente!");
    }

    public static boolean esDniValido(String dni) {

        int totalCaracteres = dni.length();

        if (totalCaracteres != 8) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            char caracterActual = dni.charAt(i);

            boolean esUnNumero = Character.isDigit(caracterActual);

            if (esUnNumero == false) {
                return false;
            }
        }
        return true;
    }

    public static void listarClientes(String[] dniCliente, String[] nombreCliente, int[] puntosCliente) {
        if (SistemaTienda.contadorClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE CLIENTES REGISTRADOS ---");
        for (int i = 0; i < SistemaTienda.contadorClientes; i++) {
            String categoria = obtenerCategoriaCliente(puntosCliente[i]);
            System.out.println("DNI: " + dniCliente[i] + " | Cliente: " + nombreCliente[i] + " | Puntos: " + puntosCliente[i] + " | Categoría: " + categoria);
        }
    }

    public static int buscarClientePorDni(String[] dniCliente, String dni) {
        for (int i = 0; i < SistemaTienda.contadorClientes; i++) {
            if (dniCliente[i].equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    public static void buscarClienteMenu(String[] dniCliente, String[] nombreCliente, int[] puntosCliente, Scanner teclado) {
        teclado.nextLine();
        System.out.print("Ingrese DNI del cliente a buscar: ");
        String dni = teclado.nextLine();

        int indice = buscarClientePorDni(dniCliente, dni);

        if (indice == -1) {
            System.out.println("Cliente no encontrado.");
        } else {
            String categoria = obtenerCategoriaCliente(puntosCliente[indice]);
            System.out.println("\n>>> CLIENTE ENCONTRADO <<<");
            System.out.println("DNI: " + dniCliente[indice]);
            System.out.println("Nombre: " + nombreCliente[indice]);
            System.out.println("Puntos Acumulados: " + puntosCliente[indice]);
            System.out.println("Categoría: " + categoria);
        }
    }

    public static void agregarPuntos(String[] dniCliente, String[] nombreCliente, int[] puntosCliente, Scanner teclado) {
        teclado.nextLine();
        System.out.print("Ingrese DNI del cliente: ");
        String dni = teclado.nextLine();

        int indice = buscarClientePorDni(dniCliente, dni);

        if (indice == -1) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Cliente seleccionado: " + nombreCliente[indice]);
        System.out.print("Ingrese puntos manuales a agregar: ");
        int puntos = teclado.nextInt();

        if (puntos < 0) {
            System.out.println("Error: No se pueden añadir puntos negativos.");
        } else {
            puntosCliente[indice] = puntosCliente[indice] + puntos;
            System.out.println("¡Puntos actualizados! Total actual: " + puntosCliente[indice] + " puntos.");
        }
    }

    public static String obtenerCategoriaCliente(int puntos) {
        if (puntos >= 300) {
            return "Oro";
        } else if (puntos >= 100) {
            return "Plata";
        } else {
            return "Bronce";
        }
    }
}
