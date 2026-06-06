package sesion9;

import java.util.Scanner;

public class ClasificacionTriangulos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Variables de entrada
        int ladoA, ladoB, ladoC;

        //Variables de proceso
        int sumaAB, sumaBC, sumaCA;

        //Variables de proceso
        String mensaje;

        //Leer entradas
        System.out.println("Ingrese el Lado A: ");
        ladoA = teclado.nextInt();
        System.out.println("Ingrese el Lado B: ");
        ladoB = teclado.nextInt();
        System.out.println("Ingrese el Lado C: ");
        ladoC = teclado.nextInt();

        //Validacion de datos
        if (ladoA > 0 && ladoB > 0 && ladoC > 0) {
            sumaAB = ladoA + ladoB;
            sumaBC = ladoB + ladoC;
            sumaCA = ladoC + ladoA;

            if (sumaAB > ladoC && sumaBC > ladoA && sumaCA > ladoB) {
                if (ladoA == ladoB && ladoB == ladoC) {
                    mensaje = "Triangulo Equilatero";
                } else {
                    if (ladoA == ladoB || ladoB == ladoC || ladoA == ladoC) {
                        mensaje = "Triangulo Isosceles";
                    } else {
                        mensaje = "Triangulo Escaleno";
                    }
                }

            } else {
                mensaje = "No es un Triangulo, no cumple el Teorema de Desigualdad";
            }
        } else {
            mensaje = "Datos no validos";
        }
        System.out.println(mensaje);

    }

}
