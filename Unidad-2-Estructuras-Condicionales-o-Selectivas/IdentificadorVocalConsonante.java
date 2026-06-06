
package sesion9;

import java.util.Scanner;

public class IdentificadorVocalConsonante {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variables de entrada
        char letra;
        
        //Variables de proceso(salida)
        String mensaje;
        
        //Leer entradas
        System.out.println("Ingrese una letra: ");
        letra = teclado.next().charAt(0);
        
        //Proceso
        if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U' || 
            letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            mensaje = "Es una Vocal";
        } else {
            mensaje = "Es una Consonante";
        } 
        System.out.println(mensaje);
    }
    
}
