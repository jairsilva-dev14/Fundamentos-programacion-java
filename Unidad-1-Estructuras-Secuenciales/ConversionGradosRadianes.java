
package sesion9;

import java.util.Scanner;

public class ConversionGradosRadianes {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variables de entrada
        int anguloGrados;
        
        //Variables de salida(también de proceso)
        double radianes;
        
        //Leer entradas
        System.out.println("Ingrese el Angulo: ");
        anguloGrados = teclado.nextInt();
        
        //Proceso
        radianes = (anguloGrados * (Math.PI / 180));
        
        //Mostrar salidas
        System.out.println("El Angulo en radianes es: " + radianes);
        
    }
    
}
