
package sesion9;

import java.util.Scanner;

public class VelocidadObjetoMovimiento {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variables de entrada
        double velocidad;
        double tiempo;
        
        //Variables de salida(también de proceso)
        double velocidadPromedio;
        double distanciaRecorrida;
        
        //Leer entradas
        System.out.println("Ingrese la velocidad: ");
        velocidad = teclado.nextDouble();
        System.out.println("Ingrese el tiempo: ");
        tiempo = teclado.nextDouble();
        
        //Proceso
        distanciaRecorrida = velocidad * tiempo;
        velocidadPromedio = distanciaRecorrida / tiempo;
        
        //Mostrar Salidas
        System.out.println("La Velocidad Promedio es: " + velocidadPromedio);                
        System.out.println("La Distancia Recorrida es: " + distanciaRecorrida);
        
                
    }
    
}
