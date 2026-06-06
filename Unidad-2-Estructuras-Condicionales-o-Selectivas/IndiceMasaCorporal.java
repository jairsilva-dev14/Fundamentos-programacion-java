
package sesion9;

import java.util.Scanner;

public class IndiceMasaCorporal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variable de entrada
        float peso, estatura;
        
        //Variable de proceso
        float IMC;
        
        //Variable de salida
        String mensaje = null;
        
        //Leer entradas
        System.out.println("Ingrese su Peso: ");
        peso = teclado.nextFloat();
        System.out.println("Ingrese su Estatura: ");
        estatura = teclado.nextFloat();
        
        //Proceso
        IMC = (float) ((peso)/(Math.pow(estatura, 2)));
        
        if (IMC < 18.5) {
            mensaje = "Bajo Peso";
        } else if (IMC < 25.0) {
            mensaje = "Peso Normal";
        } else if (IMC < 30.0) {
            mensaje = "Sobrepeso";
        } else if (IMC < 35.0) {
            mensaje = "Obesidad 1";
        } else if (IMC < 40.0) {
            mensaje = "Obesidad 2";
        } else {
            mensaje = "Obesidad 3"; 
        } System.out.println("Usted se encuentra en " + mensaje + " y su IMC es de: " + IMC);
        
    }
    
}
