
package Silva_Rodriguez_Wilson_Jair;

import java.util.Scanner;

public class BusquedaNombre {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nombreIngresado;
        boolean encontrado = false;
        String nombre[];
        nombre = new String[8];

        nombre[0] = "Jair";
        nombre[1] = "Carlos";
        nombre[2] = "Fernando";
        nombre[3] = "Pedro";
        nombre[4] = "Laura";
        nombre[5] = "Angel";
        nombre[6] = "Anghelo";
        nombre[7] = "Gustavo";

        System.out.println("Ingresa nombre a buscar: ");
        nombreIngresado = teclado.next().trim();

        for (int i = 0; i < nombre.length; i++) {
            if (nombre[i].equalsIgnoreCase(nombreIngresado)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("El nombre " + nombreIngresado + " si se encuentra en la lista");
        } else {
             System.out.println("El nombre " + nombreIngresado + " no se encuentra en la lista");
        }

    }
    
}
