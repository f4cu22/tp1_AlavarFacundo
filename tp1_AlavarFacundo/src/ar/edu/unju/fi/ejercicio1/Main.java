package ar.edu.unju.fi.ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Ejercicio 1 - Calcular el promedio y guarde el resultado en otra variable.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese 5 numeros enteros a promediar: ");
		Integer num1 =scanner.nextInt();
		Integer num2 =scanner.nextInt();
		Integer num3 =scanner.nextInt();
		Integer num4 =scanner.nextInt();
		Integer num5 =scanner.nextInt();
		float promedio=(num1+num2+num3+num4+num5)/5;
		System.out.println("Los numeros a promediar son: "+num1+", "+num2+", "+num3+", "+num4+", "+num5+".");
		System.out.println("El promedio es: "+promedio);
		scanner.close();

	}

}
