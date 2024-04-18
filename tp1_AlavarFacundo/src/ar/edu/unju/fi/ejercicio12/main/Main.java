package ar.edu.unju.fi.ejercicio12.main;


import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre de la persona:");
		String nombre = scanner.nextLine();

		System.out.println("Ingrese la fecha de nacimiento (formato dd/mm/yyyy):");
	    String fechaNacimientoStr = scanner.nextLine();
	    String[] partesFecha = fechaNacimientoStr.split("/");
	    int dia = Integer.parseInt(partesFecha[0]);
	    int mes = Integer.parseInt(partesFecha[1]) - 1; // Restamos 1 porque en Calendar enero es 0
	    int anio = Integer.parseInt(partesFecha[2]);

	    Calendar fechaNacimiento = Calendar.getInstance();
	    fechaNacimiento.set(anio, mes, dia);

	    Persona persona = new Persona(nombre, fechaNacimiento);

	    System.out.println("\nDatos de la persona: ");
	    System.out.println(persona);

	    System.out.println("Edad: " + persona.calcularEdad() + " años");
	    System.out.println("Signo del zodiaco: " + persona.obtenerSignoZodiaco());
	    System.out.println("Estación: " + persona.obtenerEstacion());

	    scanner.close();

	}

}
