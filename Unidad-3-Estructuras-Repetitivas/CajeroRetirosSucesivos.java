package Silva_Rodriguez_Wilson_Jair;

import java.util.Scanner;

public class CajeroRetirosSucesivos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Variables de entrada
        int montoRetiro;
        String respuestaUsuario;

        //Variables de proceso
        int saldoCajero;

        //Variables de salida
        String mensaje;

        //Inicializar variables
        saldoCajero = 1000;
        respuestaUsuario = "Si";

        do {
            System.out.println("Su saldo en el cajero es de: " + saldoCajero);
            System.out.println("Ingrese el monto a retirar: ");
            montoRetiro = teclado.nextInt();

            if (montoRetiro <= saldoCajero) {
                saldoCajero = saldoCajero - montoRetiro;
                System.out.println("Retiro exitoso, retire su dinero");
                System.out.println("Su saldo restante es de: " + saldoCajero);

                if (saldoCajero == 0) {
                    System.out.println("El cajero se ha quedado sin fondos");
                    break;
                } else {
                    System.out.println("¿Desea realizar otro retiro?(Si/No)");
                    respuestaUsuario = teclado.next();
                }

            } else {
                mensaje = "Saldo insuficiente en el cajero para realizar este retiro";
                System.out.println(mensaje);
            }

        } while (respuestaUsuario.equalsIgnoreCase("Si") && saldoCajero > 0);
        System.out.println("Operación finalizada");
        System.out.println("Saldo final del cajero: S/. " + saldoCajero);
    }

}
