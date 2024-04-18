package ar.edu.unju.fi.ejercicio11;

public class Main {

	public static void main(String[] args) {
        int i = 2;
        int j = 40;
        for (int num = 1; num >= 0; num++) {
        	 if(num == 1){
                 j = j * i;
                 System.out.print(j +" ");
             } else {
                 //Segundo paso
                 j = j + num - ((i * num) - 1);
                 if(j <=0){break;}
                 System.out.print(j +" ");
             }
            }
        
    }
}