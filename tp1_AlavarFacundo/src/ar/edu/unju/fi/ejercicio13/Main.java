package ar.edu.unju.fi.ejercicio13;
/**
*Clase main que representa la creacion de un array de 8 elementos, 
*que permita almacenar números enteros
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//array de 8 enteros
        int[] miArray = new int[8];
        
        // Pedir al usuario que ingrese 8 números enteros
        for (int i = 0; i < miArray.length; i++) {
            System.out.print("Ingresa un número entero para la posición " + i + ": ");
            miArray[i] = scanner.nextInt();
        }

        // índice y el valor 
        System.out.println("Índice\tValor");
        for (int i = 0; i < miArray.length; i++) {
            System.out.println(i + "\t" + miArray[i]);
        }
        scanner.close();
	}

}
