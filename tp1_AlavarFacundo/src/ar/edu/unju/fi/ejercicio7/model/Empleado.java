package ar.edu.unju.fi.ejercicio7.model;

public class Empleado {
	//atributos
	private String nombre;
	private int legajo;
	private double salario;
	
	
	//constantes
	private static final double SALARIO_MINIMO = 21000.00;
	private static final double AUMENTO_POR_MERITOS = 20000.00;
	
	//constructor parametrizado
	public Empleado(String nombre, int legajo, double salario) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		if(salario >= SALARIO_MINIMO) {
			this.salario= salario;
		}
		else {
			this.salario = SALARIO_MINIMO;
		}
			
		
	}
	
	//metodo para mostrar los datos del empleado
	public void mostrarDatos() {
		System.out.println("Nombre del empleado: "+nombre);
		System.out.println("Legajo: "+legajo);
		System.out.println("Salario : $"+salario);
	}
	
	//metodo para dar aumento al salario del empleado
	public void darAumento() {
		this.salario += AUMENTO_POR_MERITOS;
		System.out.println("Se ha aplicado el aumento por meritos. ");
		System.out.println("Nuevo salario: $"+salario);
		
	}
	

	
	//getters and setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public static double getSalarioMinimo() {
		return SALARIO_MINIMO;
	}


	public static double getAumentoPorMeritos() {
		return AUMENTO_POR_MERITOS;
	}
	
	

}
