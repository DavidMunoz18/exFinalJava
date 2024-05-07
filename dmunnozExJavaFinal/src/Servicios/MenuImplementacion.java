package Servicios;

import java.util.Scanner;
/**
 * Clase que contiene la funcionalidad de los metodos relacionados con el menu
 * <author>dmp - 07-05-2024</author>
 */
public class MenuImplementacion implements MenuInterfaz {

	Scanner sc = new Scanner(System.in);
	@Override
	public int mostrarMenuYSeleccionPrincipal() {
		
		int opcion;
		System.out.println("------------------------");
		System.out.println("0. Cerrar menu");
		System.out.println("1. Empleados");
		System.out.println("2. Clientes");
		System.out.println("------------------------");
		opcion = sc.nextInt();
		
		return opcion;
	}
	@Override
	public int mostrarMenuEmpleados() {
		
		int opcion;
		System.out.println("------------------------");
		System.out.println("0. Volver");
		System.out.println("1. Validar nuevo cliente");
		System.out.println("2. Imprimir citas medicas para un dia especifico");
		System.out.println("------------------------");
		opcion = sc.nextInt();
		
		return opcion;
	}
	@Override
	public int mostrarMenuClientes() {
		int opcion;
		System.out.println("------------------------");
		System.out.println("0. Volver");
		System.out.println("1. Registro de cliente");
		System.out.println("2. Solicitud de cita medica");
		System.out.println("3. Consultar citas medicas para un intervalo de tiempo (EXTRA)");
		System.out.println("------------------------");
		opcion = sc.nextInt();
		
		return opcion;
	}

}
