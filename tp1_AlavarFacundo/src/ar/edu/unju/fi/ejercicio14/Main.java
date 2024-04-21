package ar.edu.unju.fi.ejercicio14;
/**
*Clase main que representa el ingreso por consola de un número entero,
* que se encuentre en el rango [3,10]
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int array;
		
		//ingreso de posicion
		do {
            System.out.print("Ingrese un número entero entre 3 y 10: ");
            array = scanner.nextInt();
        } while (array < 3 || array > 10);
		
		//crea array de tamaño
		int[] num = new int[array];
		
		//ingreso de numeros
		for (int i = 0; i < num.length; i++) {
            System.out.print("Ingrese un número entero para la posición " + i + ": ");
            num[i] = scanner.nextInt();
        }
		
		//muestra posicion del array
		System.out.println("Valores almacenados en el array:");
	    for (int i = 0; i < num.length; i++) {
	    	System.out.println("Posición " + i + ": " + num[i]);
	    }
	    
	    //se calcula la suma
	    int suma = 0;
        for (int numero : num) {
            suma += numero;
        }
        
        //se muestra la suma
        System.out.println("La suma de todos los valores en el array es: " + suma);
        
	scanner.close();
	}

}
