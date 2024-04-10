package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num;
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Ingrese numero entero y que este en el rango de 1 y 9");
		num = scanner.nextInt();
		
		if (num>=0 && num<=9)
		for(int i=0;i<=10;i++) {
			int resultado = num * i;
			System.out.println(num+" x "+i+" = "+resultado);
		}
		else
			System.out.println("Esta fuera de rango");
	}

}
