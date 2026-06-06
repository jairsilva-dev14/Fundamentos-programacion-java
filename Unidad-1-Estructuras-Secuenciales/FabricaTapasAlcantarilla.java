
package sesion9;

import java.util.Scanner;

public class FabricaTapasAlcantarilla {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Variables de entrada
        float radio;

        //Variables de salida(tambien de proceso)
        float perimetro, area;

        //Leer datos
        System.out.println("Ingrese el radio de la tapa:");
        radio = teclado.nextFloat();

        //Proceso
        perimetro = (float) Math.PI * 2 * radio;
        area = (float) (Math.PI * Math.pow(radio, 2));

        //Mostrar salida
        System.out.println("El perimetro es de: " + perimetro);
        System.out.println("El area es de: " + area);
    }
    
}
