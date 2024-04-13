package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Persona {
	private String dni;
	private String nombre;
	private String fechaFinal;
	private String provincia;
	
	public Persona() {}
	
	public Persona(String dni, String nombre, String nacimiento, String provincia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaFinal = nacimiento;
		this.provincia = provincia;
	}
	public Persona(String dni, String nombre, String fechaFinal) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaFinal = fechaFinal;
		this.provincia = "Jujuy";
	}

	@Override
	public String toString() {
		return "Nombre: "+nombre+". "+
				"DNI: "+dni+". "+
				"Fecha de nacimiento: "+fechaFinal+
				". "+"Provincia: "+provincia+". "+
				"edad: "+getEdad()+
				(Mayor() ? " es mayor de edad."  : " es menor de edad.");
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

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public int getEdad() {

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate fechaNacimiento = LocalDate.parse(this.fechaFinal, formatter);
	        LocalDate hoy = LocalDate.now();
	        int edad = Period.between(fechaNacimiento, hoy).getYears();
	        return edad;
	    }

	public Boolean Mayor() {
		return getEdad() >= 18 ? true : false ;
	}
	
	
	
}