package Controladores;

import java.util.ArrayList;
import java.util.List;

import Dtos.CitasDto;
import Dtos.ClientesDto;
import Servicios.FicherosImplementacion;
import Servicios.FicherosInterfaz;
import Servicios.MenuImplementacion;
import Servicios.MenuInterfaz;
import Servicios.OperativaImplementacion;
import Servicios.OperativaInterfaz;


/**
 * Clase principal de la aplicacion
 * <author>dmp - 07-05-2024</author>
 */
public class Inicio {
	
	/**
	 * Metodo de entrada y salida de la aplicacion
	 * <author>dmp - 07-05-2024</author>
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<ClientesDto> listaClientes = new ArrayList<ClientesDto>();
		List<CitasDto> listaCitas = new ArrayList<CitasDto>();
		MenuInterfaz mi = new MenuImplementacion();
		OperativaInterfaz oi = new OperativaImplementacion();
		FicherosInterfaz fi = new FicherosImplementacion();
		try {
			
			String mensaje1 = "Ha entrado en la apliacion";
			fi.escribirFicheroLog(mensaje1);
		
		boolean cerrarMenu = false;
		int opcion;
		while(!cerrarMenu) {
			
			opcion = mi.mostrarMenuYSeleccionPrincipal();
			switch (opcion) {
			case 0:
				String mensaje2 = "Ha cerrado la apliacion";
				fi.escribirFicheroLog(mensaje2);
				cerrarMenu = true;
				break;
			case 1:
				int opcionEmpleados = mi.mostrarMenuEmpleados();
				switch (opcionEmpleados) {
				case 0:
					break;
				case 1:
					oi.validarNuevoCliente(listaClientes);
					break;
				case 2:
					fi.mostrarCita(listaCitas);
					break;

				default:
					System.out.println("La opcion seleccionada no existe");
					break;
				}
				
				break;
			case 2:
				int opcionClientes = mi.mostrarMenuClientes();
				switch (opcionClientes) {
				case 0:
					break;
				case 1:
					oi.registroCliente(listaClientes);
					break;
				case 2:
					oi.solicitudCita(listaClientes, listaCitas);
					break;
				case 3:
					oi.consultaCitaIntervalo(listaCitas);
					break;

				default:
					System.out.println("La opcion seleccionada no existe");
					break;
				}
				
				break;

			default:
				System.out.println("La opcion seleccionada no existe");
				break;
			}
			
		 }
		}catch (Exception e) {
			System.out.println("Se ha producido un error, vuelvelo a intentar de nuevo en 10 minutos");
			
			String mensajeError = e.getMessage();
			
			
			fi.escribirFicheroLog(mensajeError);
		}
	}

}
