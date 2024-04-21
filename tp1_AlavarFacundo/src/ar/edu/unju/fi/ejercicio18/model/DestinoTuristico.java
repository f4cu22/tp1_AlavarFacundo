package ar.edu.unju.fi.ejercicio18.model;

/**
*Clase que representa a un Destino Turistico
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/

public class DestinoTuristico {
	/*
	*----------------------------
	*--------atributos--------
	*----------------------------
	*/
	private String codigo;
	private String nombre;
	private double precio;
	private Pais pais;
	private int cantidadDias;
	
	/*
	*----------------------------
	*--------constructores--------
	*----------------------------
	*/
	
	/**
	*Constructor parametrizado
	*@param codigo valor del codigo del destino turistuco
	*@param nombre valor del nombre del destino turistico
	*@param precio valor del precio del destino turistico
	*@param pais valor del pais del destino turistico
	*@param cantidadDias valor del las cantidad de dias del destino turistico
	*/
	public DestinoTuristico(String codigo, String nombre, double precio, Pais pais, int cantidadDias) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.pais = pais;
		this.cantidadDias = cantidadDias;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais poais) {
		this.pais = poais;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}
	

}
