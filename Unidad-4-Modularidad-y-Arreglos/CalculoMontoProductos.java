package Silva_Rodriguez_Wilson_Jair;

import java.util.Scanner;

public class CalculoMontoProductos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in, "utf-8");
        float total = 0;

        String productos[][] = new String[5][2];
        byte opcion;

        System.out.println("Ingresar datos (1) o cargar datos (2)");
        opcion = teclado.nextByte();

        if (opcion == 1) {
            for (int i = 0; i < productos.length; i++) {
                System.out.println("Ingrese el nombre del producto: " + (i + 1));
                productos[i][0] = teclado.nextLine();
                teclado.nextLine();
                System.out.println("Ingrese el precio del producto: " + (i + 1));
                productos[i][1] = teclado.nextLine();
            }
        } else {
            productos = cargarDatos();
        }

        //Total venta
        for (int i = 0; i < productos.length; i++) {
            total += Float.parseFloat(productos[i][1]);
        }
        System.out.println("El total de venta es: " + total);

        //Muestra el precio de un producto
        String nomProducto;
        float precio = -1;
        teclado.nextLine(); //Para generar consumo de salto de linea
        System.out.println("Ingresa el nombre del producto: ");
        nomProducto = teclado.nextLine().trim();

        for (int i = 0; i < productos.length; i++) {
            if (nomProducto.equalsIgnoreCase(productos[i][0])) {
                precio = Float.parseFloat(productos[i][1]);
                break;
            }
        }
        if (precio == -1) {
            System.out.println("Producto no disponible");
        } else {
            System.out.println("El precio del producto " + nomProducto + " es: " + precio);
        }

        //Muestra los productos que tengan precios mayores a 11 soles
        System.out.println("Productos con precios mayores a 11 soles");
        for (int i = 0; i < productos.length; i++) {
            if (Float.parseFloat(productos[i][1]) > 11) {
                System.out.println(productos[i][1]);
            }

        }

    }

    //Mis funciones
    static String[][] cargarDatos() {
        String datos[][] = {{"kolynos", "7.00"}, {"Papel Higienico", "12"}, {"Atun", "15"},
        {"Papel Toalla", "10.5"}, {"Detergente", "45"}};
        return datos;
    }

}
