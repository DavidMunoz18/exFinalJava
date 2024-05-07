package Servicios;

import java.util.List;

import Dtos.CitasDto;

/**
 * Clase que contiene los metodos relacionados con los ficheros.
 * <author>dmp - 07-05-2024</author>
 */
public interface FicherosInterfaz {

	/**
	 * Metodo que se usa para imprimir las citas medicas para un dia especifico
	 * <author>dmp - 07-05-2024</author>
	 * @param listaCitas
	 */
	public void mostrarCita(List<CitasDto> listaCitas);
	
	/**
	 * Metodo que se usa para escribir todo lo que pasa en la aplicación en un fichero log
	 * <author>dmp - 07-05-2024</author>
	 * @param mensaje
	 */
	public void escribirFicheroLog(String mensaje);
}
