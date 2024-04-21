package ar.edu.unju.fi.ejercicio17.model;

import java.time.LocalDate;
import java.time.Period;

/**
*Clase que representa a un Jugador
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
public class Jugador {
	/*
	*----------------------------
	*--------atributos--------
	*----------------------------
	*/
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private double estatura;
	private double peso;
	private String posicion;
	/*
	*----------------------------
	*--------constructores--------
	*----------------------------
	*/
	/**
	*Constructor parametrizado
	*@param nombre valor del jugador
	*@param apellido valor del jugador
	*@param fechaNacimiento valor del jugador
	*@param nacionalidad valor del jugador
	*@param estatura valor del jugador
	*@param peso valor del jugdor
	*@param posicion valor del jugador
	*/
	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, double estatura,
			double peso, String posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}
	/*
	*----------------------------------
	*--------metodos accesores--------
	*--------------------------------
	*/
	
	//metodo para calcular la edad
	public int calcularEdad() {
		LocalDate fechaActual = LocalDate.now();
    	Period periodo = Period.between(this.fechaNacimiento, fechaActual);
    	return periodo.getYears();
	}

	//getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public double getEstatura() {
		return estatura;
	}


	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	

}
