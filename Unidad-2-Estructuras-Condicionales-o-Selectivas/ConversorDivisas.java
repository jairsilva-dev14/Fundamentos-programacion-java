
package sesion9;

import java.util.Scanner;

public class ConversorDivisas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Variables de entrada
        float monto;
        String monedaOrigen, monedaDestino;

        // Variables de proceso
        float montoEnSoles, resultado;

        // Variable de salida
        String mensaje = null;

        //Inicializar variables
        float valorUSD = 3.47f;
        float valorEUR = 4.07f;
        float valorJPY = 0.02f;
        float valorGBP = 4.67f;
        float valorPEN = 1.00f;

        // Leer entradas
        System.out.println("Ingrese el monto a convertir: ");
        monto = teclado.nextFloat();
        System.out.println("Ingrese la moneda de origen (USD/EUR/JPY/GBP/PEN): ");
        monedaOrigen = teclado.next().toUpperCase();
        System.out.println("Ingrese la moneda de destino (USD/EUR/JPY/GBP/PEN): ");
        monedaDestino = teclado.next().toUpperCase();

        // Proceso
        if (monedaOrigen.equals("USD")) {
            montoEnSoles = monto * valorUSD;
        } else if (monedaOrigen.equals("EUR")) {
            montoEnSoles = monto * valorEUR;
        } else if (monedaOrigen.equals("JPY")) {
            montoEnSoles = monto * valorJPY;
        } else if (monedaOrigen.equals("GBP")) {
            montoEnSoles = monto * valorGBP;
        } else {
            montoEnSoles = monto * valorPEN;
        }

        if (monedaDestino.equals("USD")) {
            resultado = montoEnSoles / valorUSD;
        } else if (monedaDestino.equals("EUR")) {
            resultado = montoEnSoles / valorEUR;
        } else if (monedaDestino.equals("JPY")) {
            resultado = montoEnSoles / valorJPY;
        } else if (monedaDestino.equals("GBP")) {
            resultado = montoEnSoles / valorGBP;
        } else {
            resultado = montoEnSoles / valorPEN;
        }

        mensaje = monedaDestino;

        // Salida
        System.out.println(monto + " " + monedaOrigen + " equivale a: " + resultado + " " + mensaje);
        

    }
    
}
