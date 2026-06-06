
package sesion9;

import java.util.Scanner;


public class PromedioNotas {

    public static void main(String[] args) {
        //Definir scanner
        Scanner teclado = new Scanner(System.in);
        
        //Variables de entrada
        double num1, num2, num3, num4, num5;
        
        //Variables de Salida
        double promedioNotas;
        
        //Leer entradas
        System.out.println("Ingrese Nota 1: ");
        num1 = teclado.nextDouble();
        System.out.println("Ingese Nota 2: ");
        num2 = teclado.nextDouble();
        System.out.println("Ingrese Nota 3: ");
        num3 = teclado.nextDouble();
        System.out.println("Ingrese Nota 4: ");
        num4 = teclado.nextDouble();
        System.out.println("Ingrese Nota 5: ");
        num5 = teclado.nextDouble();
        
        //Desarrollo de Proceso
        promedioNotas = (num1+num2+num3+num4+num5)/5;
                
        //Mostrar Salidas
        System.out.println("El Promedio Total de Notas es de:" + promedioNotas);
    }
    
}
