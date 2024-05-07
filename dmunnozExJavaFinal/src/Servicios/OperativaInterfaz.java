package Servicios;

import java.util.List;

import Dtos.CitasDto;
import Dtos.ClientesDto;

/**
 * Clase que contiene los metodos relacionados con la operativa de la aplicación
 * <author>dmp - 07-05-2024</author>
 */
public interface OperativaInterfaz {

	/**
	 * Metodo que se usa para dar de alta a un nuevo cliente
	 * <author>dmp - 07-05-2024</author>
	 * @param listaClientes
	 */
	public void registroCliente(List<ClientesDto> listaClientes);
	
	/**
	 * Metodo que se usa para crear una cita de la especialidad que se desee y la fecha que se desee.
	 * <author>dmp - 07-05-2024</author>
	 * @param listaClientes
	 * @param listaCitas
	 */
	public void solicitudCita(List<ClientesDto> listaClientes, List<CitasDto> listaCitas);
	
	/**
	 * Metodo que se usa para validar a un cliente
	 * <author>dmp - 07-05-2024</author>
	 * @param listaClientes
	 */
	public void validarNuevoCliente(List<ClientesDto> listaClientes);
	
	/**
	 * Metodo que se usa para mostrar citas en un intervalo de tiempo
	 * <author>dmp - 07-05-2024</author>
	 * @param listaCitas
	 */
	public void consultaCitaIntervalo(List<CitasDto> listaCitas);
	
}
