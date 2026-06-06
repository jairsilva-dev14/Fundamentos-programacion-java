
package sesion9;

import java.util.Scanner;

public class DescuentoTiendaRopa {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Variables de entrada
        float monto;

        // Variables de proceso
        float descuento, montoDescuento;

        // Variable de salida
        float montoFinal;
        
        // Leer entradas
        System.out.println("Ingrese el monto total de la compra: ");
        monto = teclado.nextFloat();

        // Proceso
        if (monto >= 200) {
            descuento = 0.15f;
        } else if (monto >= 100) {
            descuento = 0.10f;
        } else {
            descuento = 0.00f;
        }
        
        montoDescuento = monto * descuento;
        montoFinal = monto - montoDescuento;
        
        // Salida
        System.out.println("Monto original: S/ " + monto);
        System.out.println("Descuento aplicado: " + (descuento * 100));
        System.out.println("Monto de descuento: S/ " + montoDescuento);
        System.out.println("Monto final a pagar: S/ " + montoFinal);
        
    }
    
}
