package GRUPO_2;

import java.util.Scanner;

public class ModuloVentas {

    public static void menuVentas(String[] nombres, double[] precios, int[] stock, String[] dniCliente, String[] nombreCliente, int[] puntosCliente, Scanner teclado) {
        byte opcion;
        do {
            System.out.println("\n-----------------------------------------");
            System.out.println("   GESTIÓN DE VENTAS ");
            System.out.println("-----------------------------------------");
            System.out.println("1. Registrar Nuevo Producto");
            System.out.println("2. Mostrar Productos Registrados");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Realizar Venta");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Elija una opción (1-5): ");
            opcion = teclado.nextByte();

            switch (opcion) {
                case 1:
                    registrarProducto(nombres, precios, stock, teclado);
                    break;
                case 2:
                    mostrarInventario(nombres, precios, stock);
                    break;
                case 3:
                    buscarProducto(nombres, precios, stock, teclado);
                    break;
                case 4:
                    realizarVenta(nombres, precios, stock, dniCliente, nombreCliente, puntosCliente, teclado);
                    break;
                case 5:
                    System.out.println("\nRegresando al menú principal...");
                    break;
                default:
                    System.out.println("\nError: Opción inválida.");
            }
        } while (opcion != 5);
    }

    public static void registrarProducto(String[] nombres, double[] precios, int[] stock, Scanner teclado) {
        if (SistemaTienda.contadorProductos >= SistemaTienda.maxProductos) {
            System.out.println("Error: El inventario está lleno.");
            return;
        }

        System.out.println("\n--- NUEVO REGISTRO ---");
        teclado.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        nombres[SistemaTienda.contadorProductos] = teclado.nextLine();

        double precioIngresado;
        do {
            System.out.print("Ingrese el precio unitario (S/.): ");
            precioIngresado = teclado.nextDouble();
            if (precioIngresado < 0) {
                System.out.println("Error: El precio no puede ser negativo.");
            }
        } while (precioIngresado < 0);
        precios[SistemaTienda.contadorProductos] = precioIngresado;

        int stockIngresado;
        do {
            System.out.print("Ingrese la cantidad en stock: ");
            stockIngresado = teclado.nextInt();
            if (stockIngresado < 0) {
                System.out.println("Error: El stock no puede ser menor a cero.");
            }
        } while (stockIngresado < 0);
        stock[SistemaTienda.contadorProductos] = stockIngresado;

        SistemaTienda.contadorProductos++;
        System.out.println("¡Producto registrado correctamente!");
    }

    public static void mostrarInventario(String[] nombres, double[] precios, int[] stock) {
        System.out.println("\n--- REPORTE DE PRODUCTOS REGISTRADOS ACTUAL ---");
        if (SistemaTienda.contadorProductos == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (int i = 0; i < SistemaTienda.contadorProductos; i++) {
            System.out.println("ID: [" + i + "] | Producto: " + nombres[i] + " | Precio: S/. " + precios[i] + " | Stock: " + stock[i] + " unid.");
        }
    }

    public static int buscarProducto(String[] nombres, double[] precios, int[] stock, Scanner teclado) {
        if (SistemaTienda.contadorProductos == 0) {
            System.out.println("El Registro de Productos está vacío.");
            return -1;
        }

        teclado.nextLine();
        System.out.print("\nIngrese el nombre del producto a buscar: ");
        String textoBusqueda = teclado.nextLine();

        for (int i = 0; i < SistemaTienda.contadorProductos; i++) {
            if (nombres[i].equalsIgnoreCase(textoBusqueda)) {
                System.out.println("\n--- PRODUCTO ENCONTRADO ---");
                System.out.println("ID: [" + i + "] | " + nombres[i] + " | S/. " + precios[i] + " | Stock: " + stock[i]);
                return i;
            }
        }
        System.out.println("No se encontró el producto.");
        return -1;
    }

    public static double calcularDescuento(String categoria, double subtotal) {
        if (categoria.equals("Oro")) {
            return subtotal * 0.15;
        } else if (categoria.equals("Plata")) {
            return subtotal * 0.05;
        }
        return 0.0;
    }

    public static void realizarVenta(String[] nombres, double[] precios, int[] stock, String[] dniCliente, String[] nombreCliente, int[] puntosCliente, Scanner teclado) {
        if (SistemaTienda.contadorProductos == 0) {
            System.out.println("No se pueden realizar ventas. El inventario está vacío.");
            return;
        }

        System.out.println("\n--- MÓDULO DE VENTAS ---");
        System.out.print("Ingrese el ID del producto a vender: ");
        int id = teclado.nextInt();

        if (id >= 0 && id < SistemaTienda.contadorProductos) {
            System.out.print("¿Cuántas unidades de '" + nombres[id] + "' desea vender?: ");
            int cantidad = teclado.nextInt();

            if (cantidad <= 0) {
                System.out.println("Error: La cantidad debe ser mayor a cero.");
                return;
            }
            if (cantidad > stock[id]) {
                System.out.println("Error: Stock insuficiente. Solo dispone de " + stock[id] + " unidades.");
                return;
            }

            double subtotal = cantidad * precios[id];
            teclado.nextLine();

            System.out.print("Ingrese el DNI del cliente (O presione Enter para Público General): ");
            String dniBusqueda = teclado.nextLine();

            double montoDescuento = 0;
            int indiceCliente = -1;
            String categoria = "Ninguna (Público General)";

            if (!dniBusqueda.isEmpty()) {

                indiceCliente = ModuloClientes.buscarClientePorDni(dniCliente, dniBusqueda);

                if (indiceCliente != -1) {
                    categoria = ModuloClientes.obtenerCategoriaCliente(puntosCliente[indiceCliente]);

                    montoDescuento = calcularDescuento(categoria, subtotal);
                } else {
                    System.out.println("DNI no registrado. Se procesará como Público General.");
                }
            }

            double totalPagar = subtotal - montoDescuento;
            stock[id] = stock[id] - cantidad;

            System.out.println("\n>>> TRANSACCIÓN EXITOSA <<<");
            System.out.println("Producto: " + nombres[id] + " x " + cantidad + " unidades.");
            System.out.println("Subtotal: S/. " + subtotal);

            if (indiceCliente != -1) {
                System.out.println("Cliente: " + nombreCliente[indiceCliente] + " | Categoría: " + categoria);
                System.out.println("Descuento aplicado: S/. " + montoDescuento);

                int puntosGanados = (int) (totalPagar / 10);
                puntosCliente[indiceCliente] = puntosCliente[indiceCliente] + puntosGanados;

                System.out.println("¡Puntos ganados!: +" + puntosGanados + " pts.");
                System.out.println("Total acumulado de puntos: " + puntosCliente[indiceCliente] + " pts.");
            }

            System.out.println("TOTAL NETO A PAGAR: S/. " + totalPagar);
            System.out.println("Stock actual de " + nombres[id] + ": " + stock[id] + " unidades.");

        } else {
            System.out.println("Error: ID de producto inválido.");
        }
    }
}
