package ar.edu.unju.fi.ejercicio11;
/**
*Clase main que representa el calculo de una secuencia numerica
*mediante la estructura for
*80 117 152 185 216 245 272 297 320 341 360 377 392 405 416 425 432 437 440 441 440 
*437 432 425 416 405 392 377 360 341 320 297 272 245 216 185 152 117 80 41
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
public class Main {

	public static void main(String[] args) {
        int i = 2;
        int j = 40;
        int a = j;
        /*
         * Calculos:
         * i=2
         * j=40
         * a=40
         * despues se usa la formula j = j + a - [(i * k) - 1] en la estructura for
         * se le asigna a m=j+1 para que de el resultado
         */
        
        for (int k = 1; k >= 0; k++) {
        	j = j + a - ((i * k)-1);
        	int m=j+1;
            if(j <=0){break;}
            System.out.print(m +" ");
             }
         }
        
    }