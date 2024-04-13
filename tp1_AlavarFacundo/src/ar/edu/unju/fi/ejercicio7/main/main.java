package ar.edu.unju.fi.ejercicio7.main;

import java.util.Scanner;
import ar.edu.unju.fi.ejercicio7.model.Empleado;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese nombre del empleado: ");
		String nombre = scanner.nextLine();
		
		System.out.println("Ingrese legajo del empleado: ");
		int legajo = scanner.nextInt();
		
		System.out.println("Ingrese salario del empleado: ");
		double salario = scanner.nextDouble();
		
		// Nuevo empleado utilizando el constructor parametrizado
        Empleado nuevoEmpleado = new Empleado(nombre, legajo, salario);
        
        System.out.println("/nDatos del nuevo empleado: ");
        nuevoEmpleado.mostrarDatos();
        
        nuevoEmpleado.darAumento();
        
        System.out.println("/nDatos del nuevo empleado: ");
        nuevoEmpleado.mostrarDatos();

        scanner.close();
	}

}
