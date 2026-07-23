package silva_rodriguez_wilson_jair;

import java.util.Scanner;

public class CajeroAutomaticoMenu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Variables de entrada
        byte opcion;
        float agregarDinero;
        float retirarDinero;
        byte opcionServicios;
        float montoLuz;
        float montoAgua;

        //Variables de proceso
        float saldoCuenta;
        float descuentoLuz;

        //Inicializar variables
        saldoCuenta = 500;
        descuentoLuz = 0.15f;

        System.out.println("SIMULACION DE CAJERO AUTOMATICO");

        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("(1) Deposito");
            System.out.println("(2) Retiro");
            System.out.println("(3) Transferencia");
            System.out.println("(4) Pago de Servicios");
            System.out.println("(5) Recargas");
            System.out.println("(6) Consulta Saldo");
            System.out.println("(7) Salir");
            System.out.print("Ingrese la opcion: ");
            opcion = teclado.nextByte();

            switch (opcion) {
                case 1:
                    System.out.println("Deposito");
                    System.out.println("El saldo de tu tarjeta es de: " + saldoCuenta);
                    System.out.print("Ingresa el saldo para agregar a tu tarjeta: ");
                    agregarDinero = teclado.nextFloat();
                    saldoCuenta = saldoCuenta + agregarDinero;
                    System.out.println("El saldo de tu tarjeta ahora es de: " + saldoCuenta);
                    break;
                case 2:
                    System.out.println("Retiro");
                    System.out.println("El saldo de tu tarjeta es de: " + saldoCuenta);
                    System.out.print("Ingresa el monto a retirar de tu tarjeta: ");
                    retirarDinero = teclado.nextFloat();
                    if (retirarDinero <= saldoCuenta) {
                        saldoCuenta = saldoCuenta - retirarDinero;
                        System.out.println("El saldo de tu tarjeta ahora es de: " + saldoCuenta);
                    } else {
                        System.out.println("Monto por encima del saldo de tu tarjeta");
                    }

                    break;
                case 3:
                    System.out.println("Transferencia");
                    System.out.println("Servicio no Disponible");
                    break;
                case 4:
                    System.out.println("Pago de Servicios");
                    System.out.println("1) Pagar Luz");
                    System.out.println("2) Pagar Agua");
                    System.out.print("Ingrese la opcion para realizar el pago de servicios: ");
                    opcionServicios = teclado.nextByte();
                    switch (opcionServicios) {
                        case 1:
                            System.out.println("Pagar Luz");
                            System.out.println("Ingresa el monto de recibo de luz: ");
                            montoLuz = teclado.nextFloat();
                            saldoCuenta = saldoCuenta - saldoCuenta * descuentoLuz;
                            System.out.println("El saldo de tu tarjeta ahora es de: " + saldoCuenta);
                            System.out.println("Se ha realizado el pago de tu recibo de luz");
                            break;
                        case 2:
                            System.out.println("Pagar Agua");
                            System.out.println("Ingresa el monto de recibo de agua: ");
                            montoAgua = teclado.nextFloat();
                            saldoCuenta = saldoCuenta - montoAgua;
                            System.out.println("Se ha realizado el pago de tu recibo de agua");
                            System.out.println("El saldo de tu tarjeta ahora es de: " + saldoCuenta);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }

                    break;
                case 5:
                    System.out.println("Recargas");
                    System.out.println("Servicio no Disponible");
                    break;
                case 6:
                    System.out.println("Consulta Saldo");
                    System.out.println("El saldo de tu tarjeta es: " + saldoCuenta);
                    break;
                case 7:
                    System.out.println("Salir");
                    System.out.println("Saliste del sistema");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 7);
        System.out.println("El saldo de tu tarjeta es: " + saldoCuenta);

    }

}


/*SIMULACION DE CAJERO AUTOMATICO
MENU DE OPCIONES
(1) Deposito
(2) Retiro
(3) Transferencia
(4) Pago de Servicios
(5) Recargas
(6) Consulta Saldo
(7) Salir
Ingrese la opcion: 1
Deposito
El saldo de tu tarjeta es de: 500.0
Ingresa el saldo para agregar a tu tarjeta: 200
El saldo de tu tarjeta ahora es de: 700.0
MENU DE OPCIONES
(1) Deposito
(2) Retiro
(3) Transferencia
(4) Pago de Servicios
(5) Recargas
(6) Consulta Saldo
(7) Salir
Ingrese la opcion: 2
Retiro
El saldo de tu tarjeta es de: 700.0
Ingresa el monto a retirar de tu tarjeta: 75
El saldo de tu tarjeta ahora es de: 625.0
MENU DE OPCIONES
(1) Deposito
(2) Retiro
(3) Transferencia
(4) Pago de Servicios
(5) Recargas
(6) Consulta Saldo
(7) Salir
Ingrese la opcion: 4
Pago de Servicios
1) Pagar Luz
2) Pagar Agua
Ingrese la opcion para realizar el pago de servicios: 1
Pagar Luz
Ingresa el monto de recibo de luz: 
70
El saldo de tu tarjeta ahora es de: 531.25
Se ha realizado el pago de tu recibo de luz
MENU DE OPCIONES
(1) Deposito
(2) Retiro
(3) Transferencia
(4) Pago de Servicios
(5) Recargas
(6) Consulta Saldo
(7) Salir
Ingrese la opcion: 6
Consulta Saldo
El saldo de tu tarjeta es: 531.25
MENU DE OPCIONES
(1) Deposito
(2) Retiro
(3) Transferencia
(4) Pago de Servicios
(5) Recargas
(6) Consulta Saldo
(7) Salir
Ingrese la opcion: 7
Salir
Saliste del sistema
El saldo de tu tarjeta es: 531.25*/