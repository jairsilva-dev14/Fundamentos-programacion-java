
package Silva_Rodriguez_Wilson_Jair;

import java.util.Scanner;

public class SeguridadBanco {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        //Variables de entrada
        String contraseñaIngresada;
        
        //Variables de proceso
        String contraseñaSistema;
        int intentos;
        
        //Variable de salida
        String mensaje;
        
        //Inicializar variables
        contraseñaSistema = "Seguro123";
        intentos = 0;
        
        //Proceso
        do {
            System.out.println("Ingresa la contraseña: ");
            contraseñaIngresada = teclado.next();
            intentos++;
            
            if (contraseñaSistema.equals(contraseñaIngresada)) {
                System.out.println("Bienvenido al Sistema");
                break;
            } else {
                mensaje = "Contraseña Incorrecta, vuelva a intentarlo";
                System.out.println(mensaje);
            }
        } while (intentos < 3);
        if (intentos == 3) {
            System.out.println("Llegaste al limite de intentos");
        }
        
    }
    
}
