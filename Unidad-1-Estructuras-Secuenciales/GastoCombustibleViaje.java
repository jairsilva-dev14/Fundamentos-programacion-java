
package sesion9;

import java.util.Scanner;

public class GastoCombustibleViaje {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variables de entrada
        float distancia, rendimiento, precioCombustible;
        
        //Variables de proceso
        float gastoCombustible;
        
        //Variables de salida
        float costoTotal;
        
        //Leer entradas
        System.out.println("Ingrese la distancia de viaje en km: ");
        distancia = teclado.nextFloat();
        System.out.println("Ingrese el rendimiento del vehiculo en km por litro: ");
        rendimiento = teclado.nextFloat();
        System.out.println("Ingrese el precio actual de combustible por litro: ");
        precioCombustible = teclado.nextFloat();
        
        //Proceso
        gastoCombustible = distancia / rendimiento;
        costoTotal = gastoCombustible * precioCombustible;
        
        //Mostrar salidas
        System.out.println("El costo total de combustible es de: " + costoTotal);
        
    }
    
}
