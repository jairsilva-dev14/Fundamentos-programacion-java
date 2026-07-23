package Silva_Rodriguez_Wilson_Jair;

import java.util.Scanner;

public class JuegoAdivinaNumero {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Variables de entrada
        byte numeroIngresado;

        //Variables de proceso
        byte numeroSecreto;
        int intentos;

        //Inicializar Variables
        intentos = 0;

        //Proceso
        numeroSecreto = (byte) (Math.random() * (10 - 1 + 1) + 1);
        System.out.println("Bienvenido al Juego de la Suerte");

        do {
            System.out.println("Intenta adivinar un numero del 1 al 10");
            System.out.println("Ingrese tu numero: ");
            numeroIngresado = teclado.nextByte();
            intentos++;

            if (numeroIngresado > numeroSecreto) {
                System.out.println("El número secreto es menor, vuelve a intentarlo");
            } else if (numeroIngresado < numeroSecreto) {
                System.out.println("El número secreto es mayor, vuelve a intentarlo");
            } else {
                System.out.println("Felicidades - Lograste adivinar el numero");
            }

        } while (numeroIngresado != numeroSecreto);
        System.out.println("Tus intentos realizados fueron: " + intentos);

    }

}
