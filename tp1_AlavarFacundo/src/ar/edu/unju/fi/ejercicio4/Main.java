package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		float num;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese numero entero y que este en el rango de 1 y 10");
		num = scanner.nextInt();
		
		if (num>0&&num<=10){
			float i=num;
			System.out.println("el numero que eligio: "+num);
			while(i!=1) {
				num=num*(i-1);
				i--;
		}
			System.out.println("El factorial es: "+num);
		}
		else{
			System.out.println("El numero ingresado esta fuera de rango");
		}

		scanner.close();
	}

}
