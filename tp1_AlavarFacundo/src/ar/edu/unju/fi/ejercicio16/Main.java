package ar.edu.unju.fi.ejercicio16;
/**
*Clase main que representa la definicion y creeacion de
* array para almacenar 5 elementos de tipo String
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// array de 5 elementos tipo String
        String[] nombres = new String[5];
        
        //ingreso de  nombres
        System.out.println("Ingrese 5 nombres de personas:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }
        
        //valores guardados en el array
        System.out.println("\nValores guardados en el array:");
        int e = 0;
        while (e < nombres.length) {
            System.out.println(e + ": " + nombres[e]);
            e++;
        }
        
        //tamaño del array
        System.out.println("\nTamaño del array: " + nombres.length);
        
        //ingreso de índice a eliminar
        byte eliminar;
        do {
            System.out.print("\nIngrese el índice (0 - " + (nombres.length - 1) + ") para eliminar un elemento: ");
            eliminar = scanner.nextByte();
        } while (eliminar < 0 || eliminar >= nombres.length);
        
        // Eliminar el elemento
        if (eliminar >= 0 && eliminar < nombres.length) {
            // Desplazar los elementos restantes
            for (int i = (int) eliminar; i < nombres.length - 1; i++) {
                nombres[i] = nombres[i + 1];
            }
            
        //espacio en blanco 
        nombres[nombres.length - 1] = "";
        
        }

        // Mostrar el arreglo actualizado después de eliminar el elemento
        System.out.println("\nArreglo después de eliminar el elemento en el índice " + eliminar + ":");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(i + ": " + nombres[i]);
        }
        scanner.close();
	}
	

}
