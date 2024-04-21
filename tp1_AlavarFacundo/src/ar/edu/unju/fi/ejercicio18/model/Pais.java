package ar.edu.unju.fi.ejercicio18.model;

/**
*Clase que representa a un Pais
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
public class Pais {
	/*
	*----------------------------
	*--------atributos--------
	*----------------------------
	*/
	private String codigo;
	private String nombre;
	
	/*
	*----------------------------
	*--------constructores--------
	*----------------------------
	*/
	
	/**
	*Constructor parametrizado
	*@param codigo valor del codigo del pais
	*@param nombre valor del nombre del pais
	*/
	public Pais(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/*
	*----------------------------------
	*--------metodos accesores--------
	*--------------------------------
	*/
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
