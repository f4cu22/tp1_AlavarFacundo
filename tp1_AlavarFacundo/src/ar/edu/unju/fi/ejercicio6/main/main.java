package ar.edu.unju.fi.ejercicio6.main;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import ar.edu.unju.fi.ejercicio6.model.Persona;

public class main {
	
	private static Scanner sc = null;
	
	public static Persona crearPersonaDefecto(){
		
		Persona persona = new Persona();
		
		System.out.print("Ingresar DNI: ");
		String dni = sc.next();

		System.out.print("Ingresar su Nombre: ");
		String nombre = sc.next();
		sc.nextLine();
		System.out.println("Fecha Nacimiento en (DD/MM/YYYY): ");	
		String fechaNacString= sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacString,formatter);
		
		String fechaFinal = (formatter.format(fechaNac));
		
		
		System.out.print("Provincia: ");
		String provincia = sc.next();

		persona.setDni(dni);
		persona.setNombre(nombre);
		persona.setFechaFinal(fechaFinal);
		persona.setProvincia(provincia);

		return persona;
		
	}
	public static Persona crearPersonaParametrizado() {
		System.out.print("Ingresar DNI: ");
		String dni = sc.next();

		System.out.print("Ingresar su Nombre: ");
		String nombre = sc.next();

		sc.nextLine();
		System.out.println("Fecha Nacimiento en (DD/MM/YYYY): ");	
		String fechaNacString= sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacString,formatter);
		
		String fechaFinal = (formatter.format(fechaNac));

		System.out.print("Provincia: ");
		String provincia = sc.next();
		
		Persona persona = new Persona(dni, nombre, fechaFinal, provincia);
		return persona;
	}
	
	public static Persona crearPersonaSinProvincia() {
		
		Persona persona = new Persona();
		System.out.print("Ingresar DNI: ");
		String dni = sc.next();

		System.out.print("Ingresar su Nombre: ");
		String nombre = sc.next();

		sc.nextLine();
		System.out.println("Fecha Nacimiento en (DD/MM/YYYY): ");	
		String fechaNacString= sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacString,formatter);
		
		String fechaFinal = (formatter.format(fechaNac));
		
		persona.setDni(dni);
		persona.setNombre(nombre);
		persona.setFechaFinal(fechaFinal);
		
		return persona;
	}
	public static void main(String[] args) {

		sc = new Scanner(System.in);

		Persona persona1 = crearPersonaDefecto();
		Persona persona2 = crearPersonaParametrizado();
		Persona persona3 = crearPersonaSinProvincia();

		System.out.println(persona1);
		System.out.println(persona2);
		System.out.println(persona3);

		sc.close();
	}
}


