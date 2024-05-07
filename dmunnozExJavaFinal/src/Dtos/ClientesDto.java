package Dtos;

import java.time.LocalDateTime;
/**
 * Clase que contiene todo lo relacionado con los clientes, esta compuesto por atributos, getter y setters y constructores
 * <author>dmp - 07-05-2024</author>
 */
public class ClientesDto {

	long id;
	String dni = "aaaaa";
	String nombre = "aaaaa";
	String apellidos = "aaaaa";
	String nombreCompleto  = "aaaaa";
	LocalDateTime fechaAlta = LocalDateTime.now();
	
	
	boolean validado = false;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isValidado() {
		return validado;
	}
	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public ClientesDto() {
		super();
	}
	public ClientesDto(long id, String dni, String nombre, String apellidos, String nombreCompleto,
			LocalDateTime fechaAlta, boolean validado) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreCompleto = nombreCompleto;
		this.fechaAlta = fechaAlta;
		this.validado = validado;
	}
	
	
	
}
