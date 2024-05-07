package Servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Dtos.CitasDto;

/**
 * Clase que contiene todos los metodos con la funcionalidad de los ficheros.
 * <author>dmp - 07-05-2024</author>
 */
public class FicherosImplementacion implements FicherosInterfaz {

	Scanner sc = new Scanner(System.in);
	DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Override
	public void mostrarCita(List<CitasDto> listaCitas) {
		
		String mensaje = "Ha entrado en la funcionalidad mostrar cita";
		escribirFicheroLog(mensaje);
		
		System.out.println("Introduzca la fecha que desee consultar (dd-MM-yyyy)");
		String fechaUsu = sc.next();
		
		String ruta = "informe" + "-" + fechaUsu.replace("-", "");
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(ruta);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for (CitasDto citasDto : listaCitas) {
				
				if(fechaUsu.equals(citasDto.getFechaCita().format(formato1))) {
					
					String mensajeC = citasDto.getDni() + ";" + citasDto.getApellidos() + "," + citasDto.getNombre() + ";" + citasDto.getEspecialidad() + ";";
					
					printWriter.write(mensajeC + "\n");
					
					System.out.println("Se ha imprimido correctamente");
					
				}else {
					System.out.println("No hay informacion que mostrar");
				}
				
				
			}
			fileWriter.close();
			
		} catch (IOException e) {
		
			String mensajeE = e.getMessage();
			System.out.println("Se ha producido un error, vuelvelo a intentar de nuevo en 10 minutos");
			escribirFicheroLog(mensajeE); 
			
		}
	
		
	}

	@Override
	public void escribirFicheroLog(String mensaje) {
		
		LocalDate localDate = LocalDate.now();
		
		String ruta = "log" + "-" + localDate.format(formato1);
		
		try {
			FileWriter fileWriter = new FileWriter(ruta, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.write(mensaje + "\n");
			
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Se ha producido un error, vuelvelo a intentar de nuevo en 10 minutos");
			e.printStackTrace();
		}
		
		
	}

}
