
package sesion9;

import java.util.Scanner;

public class TermometroGrillo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variables de entrada
        byte numSonido;
        String estacion;
        
        //Variable de proceso
        double constante = 0;
        
        //Variable de salida
        double temperatura;
        
        //Leer entradas
        System.out.println("Ingrese el número de sonidos emitidos por un grillo en un minuto: ");
        numSonido = teclado.nextByte();
        System.out.println("Ingresa el estacion: ");
        estacion = teclado.next();
        
        //Proceso
        if (estacion.equalsIgnoreCase("invierno") || estacion.equalsIgnoreCase("otoño")) {
            constante = (0.1 * 40) + 40;
        } else if (estacion.equalsIgnoreCase("verano") || estacion.equalsIgnoreCase("primavera")) {
            constante = 40 - (0.1 * 40);
        } else {
            System.out.println("Estación no identificada, la estacion base se usara de 40");
        }
        temperatura = (numSonido / 4) + constante;
        
        //Mostrar salidas
        System.out.println("La temperatura calculada es: " + temperatura + " °F");
          
    }
    
}
