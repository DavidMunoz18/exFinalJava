package Servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Dtos.CitasDto;
import Dtos.ClientesDto;

/**
 * Clase que contiene toda la funcionalidad de los metodos relacionados con la operativa de la aplicación
 * <author>dmp - 07-05-2024</author>
 */
public class OperativaImplementacion implements OperativaInterfaz {

	Scanner sc = new Scanner(System.in);
	FicherosInterfaz fi = new FicherosImplementacion();
	@Override
	public void registroCliente(List<ClientesDto> listaClientes) {
		
		try {
			
		
		String mensaje = "Ha entrado en la funcionalidad registro cliente";
		fi.escribirFicheroLog(mensaje);
		
		ClientesDto cliente = crearNuevoCliente(listaClientes);
		
		listaClientes.add(cliente);
		}catch (Exception e) {
			String mensajeError = e.getMessage();
			fi.escribirFicheroLog(mensajeError);
			System.out.println("Se ha producido un error, vuelvelo a intentar en 10 minutos");
		}
		
	}
	/**
	 * Metodo que se usa para crear un nuevo cliente
	 * <author>dmp - 07-05-2024</author>
	 * @param listaClientes
	 * @return
	 */
	private ClientesDto crearNuevoCliente(List<ClientesDto> listaClientes) {
		
		ClientesDto cliente = new ClientesDto();
		
		cliente.setId(idAutogenerado(listaClientes));
		
		System.out.println("ID: " + cliente.getId());
		
		System.out.println("Introduce el dni");
		cliente.setDni(sc.next());
		
		System.out.println("Introduce el nombre");
		cliente.setNombre(sc.next());

		System.out.println("Introduce los apellidos");
		cliente.setApellidos(sc.next());
		
		
		LocalDateTime instante = LocalDateTime.now();
		cliente.setFechaAlta(instante);
		System.out.println("Fecha de alta: " + cliente.getFechaAlta());
		
		cliente.setNombreCompleto(cliente.getNombre() + "," + cliente.getApellidos());
		
		
		
		return cliente;
		
	}
	/**
	 * Metodo que se usa para generar un id para el cliente
	 * <author>dmp - 07-05-2024</author>
	 * @param listaClientes
	 * @return
	 */
	private long idAutogenerado(List<ClientesDto> listaClientes) {
		
		int tamanioLista = listaClientes.size();
		
		long id;
		
		if(tamanioLista == 0) {
			id = 1;
		}
		else {
			id = listaClientes.get(tamanioLista -1).getId() + 1;
		}
		return id;
		
	}
	@Override
	public void solicitudCita(List<ClientesDto> listaClientes, List<CitasDto> listaCitas) {
		
		try {
		String mensaje = "Ha entrado en la funcionalidad mostrar solicitud cita";
		fi.escribirFicheroLog(mensaje);
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		System.out.println("Introduzca su dni");
		String dniUsu = sc.next();
		
		for (ClientesDto clientesDto : listaClientes) {
			
			if(dniUsu.equals(clientesDto.getDni()) && clientesDto.isValidado() == true) {
				
				
				
				
				
				int opcionMenu = mostrarEspecialidades();
				switch (opcionMenu) {
				case 1:
					
					
					Long id = idAutoGeneradoCita(listaCitas);
					
					String dni = clientesDto.getDni();
					
					String nombre = clientesDto.getNombre();
					
					String apellidos = clientesDto.getApellidos();
					
		
					String especialidad = "Psicologia";
					
					System.out.println("Introduzca la fecha de cita y la hora que desee (yyyy-MM-dd)");
					LocalDate fechaCita = LocalDate.parse(sc.next(), dateTimeFormatter);
					
					System.out.println("Se ha seleccionado la fecha correctamente");
					
					CitasDto citasDto = new CitasDto(id, dni, nombre, apellidos, especialidad, fechaCita);
					
					listaCitas.add(citasDto);
					
					break;
				case 2:
					Long id2 = idAutoGeneradoCita(listaCitas);
					
					String dni2 = clientesDto.getDni();
					
					String nombre2 = clientesDto.getNombre();
					
					String apellidos2 = clientesDto.getApellidos();
					
		
					String especialidad2 = "Traumatologia";
					
					System.out.println("Introduzca la fecha de cita y la hora que desee (yyyy-MM-dd)");
					LocalDate fechaCita2 = LocalDate.parse(sc.next(), dateTimeFormatter);
					
					System.out.println("Se ha seleccionado la fecha correctamente");
					
					CitasDto citasDto2 = new CitasDto(id2, dni2, nombre2, apellidos2, especialidad2, fechaCita2);
					
					listaCitas.add(citasDto2);
					break;
				case 3:
					Long id3 = idAutoGeneradoCita(listaCitas);
					
					String dni3 = clientesDto.getDni();
					
					String nombre3 = clientesDto.getNombre();
					
					String apellidos3 = clientesDto.getApellidos();
					
		
					String especialidad3 = "Fisioterapia";
					
					System.out.println("Introduzca la fecha de cita y la hora que desee (yyyy-MM-dd)");
					LocalDate fechaCita3 = LocalDate.parse(sc.next(), dateTimeFormatter);
					
					System.out.println("Se ha seleccionado la fecha correctamente");
					
					CitasDto citasDto3 = new CitasDto(id3, dni3, nombre3, apellidos3, especialidad3, fechaCita3);
					
					listaCitas.add(citasDto3);
					break;

				default:
					System.out.println("La opcion seleccionada no existe");
					break;
				}
			}
			
		}
		}catch (Exception e) {
			String mensajeError = e.getMessage();
			fi.escribirFicheroLog(mensajeError);
			System.out.println("Se ha producido un error, vuelvelo a intentar en 10 minutos");
		}
		
	}
	/**
	 * Metodo que se usa para mostrar el tipo de especialidades que se desee escoger
	 * <author>dmp - 07-05-2024</author>
	 * @return
	 */
	private int mostrarEspecialidades() {
		int opcion;
		
		System.out.println("1. Psicologia");
		System.out.println("2. Traumatologia");
		System.out.println("3. Fisioterapia");
		
		opcion = sc.nextInt();
		
		return opcion;
		
	}
	
	/**
	 * Metodo que se usa para generar un id de cada cita
	 * <author>dmp - 07-05-2024</author>
	 * @param listaCitas
	 * @return
	 */
	private long idAutoGeneradoCita(List<CitasDto> listaCitas) {
		

		int tamanioLista = listaCitas.size();
		
		long id;
		
		if(tamanioLista == 0) {
			id = 1;
		}
		else {
			id = listaCitas.get(tamanioLista -1).getId() + 1;
		}
		return id;
		
	}
	@Override
	public void validarNuevoCliente(List<ClientesDto> listaClientes) {
		
		try {
			
		
		String mensaje = "Ha entrado en la funcionalidad validar cliente";
		fi.escribirFicheroLog(mensaje);
		
		for (ClientesDto clientesDto : listaClientes) {
			
			if (clientesDto.isValidado() == false) {
				
				String mensajeCliente = clientesDto.getDni() + " - " + clientesDto.getApellidos() + "," + clientesDto.getNombre();
				
				System.out.println(mensajeCliente);
				
				System.out.println("Introduzca un dni");
				String dniValidado = sc.next();
				
				if(dniValidado.equals(clientesDto.getDni()) && clientesDto.isValidado() == false) {
					
					System.out.println("El cliente ha sido validado correctamente");
					clientesDto.setValidado(true);
					
				}else {
					System.out.println("El cliente seleccionado no existe");
				}
				
			}else {
				System.out.println("No hay clientes sin validar");
			}
			
		}	
		}catch (Exception e) {
			String mensajeError = e.getMessage();				
			fi.escribirFicheroLog(mensajeError);
			System.out.println("Se ha producido un error, vuelvelo a intentar en 10 minutos");
		}
		
	}
	@Override
	public void consultaCitaIntervalo(List<CitasDto> listaCitas) {
		
		try {
			
		
		DateTimeFormatter formatoIntervalo = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		System.out.println("Introduce tu dni");
		String dni = sc.next();
		
		System.out.println("Introduce una fecha de inicio de intervalo (dd-MM-yyyy)");
		String fechaUsu1 = sc.next();
		
		System.out.println("Introduce una fecha de fin de intervalo (dd-MM-yyyy)");
		String fechaUsu2 = sc.next();
		
	
		
		for (CitasDto citasDto : listaCitas) {
			
			if(citasDto.getFechaCita().format(formatoIntervalo).equals(fechaUsu1) || citasDto.getFechaCita().format(formatoIntervalo).equals(fechaUsu2) || fechaUsu1.equals(fechaUsu2)) {
				
				System.out.println(citasDto.getDni() + citasDto.getFechaCita());
				
			}
			
		}
		}catch (Exception e) {
			String mensajeError = e.getMessage();				
			fi.escribirFicheroLog(mensajeError);
			System.out.println("Se ha producido un error, vuelvelo a intentar en 10 minutos");
		}
	}

	
	
	
	

}
