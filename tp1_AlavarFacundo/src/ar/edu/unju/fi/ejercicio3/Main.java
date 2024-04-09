package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese numero entero");
		num = scanner.nextInt();
		
		if(num % 2 == 0) {
			num=num*3;
			System.out.println("El numeroes par.");
			System.out.println("Su triple es: "+num+".");
		}else {
			num=num*2;
			System.out.println("El numeroes par.");
			System.out.println("Su doble es: "+num+".");
			
		}
		
		scanner.close();

	}

}
