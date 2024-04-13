package ar.edu.unju.fi.ejercicio8.main;

import java.util.Scanner;
import ar.edu.unju.fi.ejercicio8.mondel.CalculadoraEspecial;

public class Main {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		// Crear un objeto de la clase CalculadoraEspecial
		CalculadoraEspecial calculadora = new CalculadoraEspecial();
		
		// Solicitar al usuario que ingrese el valor de n
		System.out.println("Ingrese el valor del numero: ");
		int n = scanner.nextInt();
		
		calculadora.setN(n);// Establecer el valor de n usando el setter
		
		// Calcular la sumatoria y mostrar el resultado
		double resultadoSumatoria = calculadora.mostrarSumatoria();
		System.out.println("Sumatoria de "+n+": " + resultadoSumatoria);
        // Calcular la productoria y mostrar el resultado
        double resultadoProductoria = calculadora.mostrarProductoria();
        System.out.println("Productoria de "+n+": " + resultadoProductoria);
        
        
		scanner.close();
	}

}
