
package sesion9;

import java.util.Scanner;

public class JuegoDadoApuestas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variables de entrada
        float montoApuesta;
        byte numObtenido;
        
        //Variable de proceso
        String mensaje = null;
        
        //Variable de salida
        double resultado = 0;
        
        //Leer entradas
        System.out.println("Ingresa el numero obtenido: ");
        numObtenido = teclado.nextByte();
        System.out.println("Ingrese el monto de apuesta: ");
        montoApuesta = teclado.nextFloat();
        
        //Proceso
        switch (numObtenido) {
            case 1:
            case 6: {
                mensaje = "Pierde";
                resultado = 0;
                break;
            }
            case 2:
            case 5: {
                mensaje = "Precio Consuelo";
                resultado = montoApuesta;
                break;
            }
            case 3:
            case 4: {
                mensaje = "Gana";
                resultado = montoApuesta * 2;
                break;
            }
            default: {
            } break;
        }
        System.out.println("USTED: " + mensaje);
        System.out.println("SU MONTO ES DE: " + resultado);
    }
    
}
