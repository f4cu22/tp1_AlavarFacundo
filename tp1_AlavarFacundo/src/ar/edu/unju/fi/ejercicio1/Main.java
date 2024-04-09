package ar.edu.unju.fi.ejercicio1;

public class Main {

	public static void main(String[] args) {
		//Ejercicio 1 - Calcular el promedio y guarde el resultado en otra variable
		int num1;
		int num2;
		int num3;
		int num4;
		int num5;
		num1=8;
		num2=5;
		num3=1;
		num4=20;
		num5=9;
		float suma = (num1+num2+num3+num4+num5);
		float promedio= (float) suma/5 ;
		System.out.println("Los numeros a promediar son: "+num1+", "+num2+", "+num3+", "+num4+", "+num5+".");
		System.out.println("El promedio es: "+promedio+" ");
		
	}

}
