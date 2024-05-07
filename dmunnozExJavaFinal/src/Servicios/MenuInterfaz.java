package Servicios;

/**
 * Clase que contiene todos los metodos relacionados con el menu
 * <author>dmp - 07-05-2024</author>
 */
public interface MenuInterfaz {

	/**
	 * Metodo que se usa para mostrar el menu y poder seleccionar una opcion
	 * <author>dmp - 07-05-2024</author>
	 * @return
	 */
	public int mostrarMenuYSeleccionPrincipal();
	
	/**
	 * Metodo que se usa para mostrar el menu de los empleados
	 * <author>dmp - 07-05-2024</author>
	 * @return
	 */
	public int mostrarMenuEmpleados();
	
	/**
	 * Metodo que se usa para mostrar el menu de los clientes
	 * <author>dmp - 07-05-2024</author>
	 * @return
	 */
	public int mostrarMenuClientes();
}
