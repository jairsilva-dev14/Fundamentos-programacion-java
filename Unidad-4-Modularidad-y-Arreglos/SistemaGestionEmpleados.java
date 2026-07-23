package silva_rodriguez_wilson_jair;

import java.util.Scanner;

public class SistemaGestionEmpleados {

    public static final int maxEmpleados = 20;
    public static int contadorEmpleados = 0;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String[] nombreE = new String[maxEmpleados];
        byte[] añoServicio = new byte[maxEmpleados];

        String contraseñaSistema;
        String contraseñaIngresada;
        String usuarioCreado;
        byte intentos = 0;
        byte opcion;

        do {
            System.out.print("Crea tu usuario: ");
            usuarioCreado = teclado.nextLine();
            System.out.print("Crea tu contraseña: ");
            contraseñaSistema = teclado.nextLine();
            System.out.println("SE HA REGISTRADO CORECTAMENTE TUS DATOS");

            do {
                System.out.println("INICIA SESION");
                System.out.print("Ingresa tu usuario: ");
                usuarioCreado = teclado.nextLine();
                System.out.print("Ingresa tu contraseña: ");
                contraseñaIngresada = teclado.nextLine();

                if (contraseñaSistema.equalsIgnoreCase(contraseñaIngresada)) {
                    System.out.println("BIENVENIDO AL SISTEMA");
                    do {
                        System.out.println("MENU DE EMPLEADOS");
                        System.out.println("1) Registrar Empleado");
                        System.out.println("2) Mostrar lista de Empleados");
                        System.out.println("3) Buscar Empleado con mas años de servicio");
                        System.out.println("4) Ingresar numero que represente los años de servicio");
                        System.out.println("5) Salir");
                        System.out.print("Elige una opcion(1-5): ");
                        opcion = teclado.nextByte();

                        switch (opcion) {
                            case 1:
                                registrarEmpleado(nombreE, añoServicio, teclado);
                                break;
                            case 2:
                                listaEmpleados(nombreE, añoServicio, teclado);
                                break;
                            case 3:
                                mayorAñoServicio(nombreE, añoServicio, teclado);
                                break;
                            case 4:
                                numeroAñoServicio(nombreE, añoServicio, teclado);
                                break;
                            case 5:
                                System.out.println("Saliendo del Sistema...  ¡Hasta Luego!");
                                break;
                            default:
                                System.out.println("Error: Opcion ingresada no valida");
                        }
                    } while (opcion != 5);

                } else {
                    System.out.println("Contraseña Ingresada incorrecta");
                    intentos++;
                }
            } while (intentos != 3);
            System.out.println("Se terminaron tus limites de intento");
            break;
        } while (intentos > 0);

    }

    public static void registrarEmpleado(String[] nombreE, byte[] añoServicio, Scanner teclado) {
        if (SistemaGestionEmpleados.contadorEmpleados >= SistemaGestionEmpleados.maxEmpleados) {
            System.out.println("Error: El registro de emplezados esta lleno");
            return;
        }
        System.out.println("REGISTRAR EMPLEADOS");
        teclado.nextLine();
        System.out.print("Ingrese el nombre del Empleado: ");
        nombreE[contadorEmpleados] = teclado.nextLine();
        System.out.print("Ingrese los años de servicio del Empleado: ");
        añoServicio[contadorEmpleados] = teclado.nextByte();

        contadorEmpleados++;
        System.out.println("Se ha registrado correctamente los datos del empleado");
    }

    public static void listaEmpleados(String[] nombreE, byte[] añoServicio, Scanner teclado) {
        System.out.println("LISTA DE EMPLEADOS REGISTRADOS");
        teclado.nextLine();

        if (contadorEmpleados == 0) {
            System.out.println("El registro de empleados esta vacio");
            return;
        }

        for (int i = 0; i < contadorEmpleados; i++) {
            System.out.println("Nombre Empleado: " + nombreE[i] + " |" + "Años de Servicio: " + añoServicio[i]);
        }
    }

    public static void mayorAñoServicio(String[] nombreE, byte[] añoServicio, Scanner teclado) {
        System.out.println("EMPLEADOS CON MAYOR AÑOS DE SERVICIO");
        teclado.nextLine();
        byte añoMayor;
        if (contadorEmpleados == 0) {
            System.out.println("El registro de empleados esta vacio");
            return;
        }

    }

    public static void numeroAñoServicio(String[] nombreE, byte[] añoServicio, Scanner teclado) {
        teclado.nextLine();
        byte añoEmpleado;
        System.out.print("Ingrese el numero de años de servicios de algun empleado: ");
        añoEmpleado = teclado.nextByte();

        if (contadorEmpleados == 0) {
            System.out.println("El resgitro esta vacio ");
            return;
        }
        byte añoJubilacion = 30;
        if (añoEmpleado >= 30) {
            System.out.println("Año de servicio mayor, debe jubilarse");
        } else {
            añoServicio[contadorEmpleados] = (byte) (añoJubilacion - añoEmpleado);
            System.out.println("Le quedan " + añoServicio[contadorEmpleados] + " años de servicio para jubilarse");
        }

    }

}
