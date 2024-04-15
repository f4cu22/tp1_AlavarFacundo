package ar.edu.unju.fi.ejercicio9.model;

public class Producto {
	private String nombre;
	private String codigo;
	private double precio;
	private byte descuento;
	

	public String getNombre() {
		return nombre;
	}

	//getters y setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public byte getDescuento() {
		return descuento;
	}

	public void setDescuento(byte descuento) {
		this.descuento = descuento;
	}
	//constructor por defecto.
	public Producto() {
	}
	
	//metodo para calcular descuento
	public double calcularDescuento() {
		return precio = precio - (precio * descuento/100);
	}
}
