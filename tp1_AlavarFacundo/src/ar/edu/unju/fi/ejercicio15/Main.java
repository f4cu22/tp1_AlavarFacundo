package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int array;
		
		//ingreso de posicion
		do {
            System.out.print("Ingrese un número entero entre 5 y 10: ");
            array = scanner.nextInt();
        } while (array < 5 || array > 10);
	
		// array tipo String de tamaño 
		String[] nombre = new String[array];
		
		//ingreso de nombres
		for (int i = 0; i < nombre.length; i++) {
            System.out.print("Ingrese el nombre de la persona para la posición " + i + ": ");
            nombre[i] = scanner.next();
        }
		
		 // Mostrar desde el primer índice hasta el último
        System.out.println("\nContenido del array (de primera a última posición):");
        for (int i = 0; i < nombre.length; i++) {
            System.out.println("Posición " + i + ": " + nombre[i]);
        }

        // Mostrar desde el último índice hasta el primero
        System.out.println("\nContenido del array (de última a primera posición):");
        for (int i = nombre.length - 1; i >= 0; i--) {
            System.out.println("Posición " + i + ": " + nombre[i]);
        }
		
		scanner.close();
	}

}
