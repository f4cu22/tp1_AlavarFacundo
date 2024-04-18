package ar.edu.unju.fi.ejercicio10.main;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

import java.util.Scanner;

public class main {
    private static Scanner scanner;

    public static Pizza crearPizza(){
        Pizza pizza = new Pizza();

        while(true){
            System.out.println("Diametros disponibles: 20 - 30 - 40");
            System.out.print("Ingrese el diametro de la pizza: ");
            int diametro = scanner.nextInt();
            if(diametro == 20 || diametro == 30 || diametro == 40){
                pizza.setDiametro(diametro);
                break;
            }
            System.out.println("Ingrese un diametro válido.");
        }

        while(true){
            System.out.print("¿Agregar ingredientes especiales? s / n: ");
            char respuesta = scanner.next().charAt(0);
            if(respuesta == 's' || respuesta == 'S' ){
                pizza.setIngredientesEspeciales(true);
                break;
            } else if(respuesta == 'n' || respuesta == 'N'){
                pizza.setIngredientesEspeciales(false);
                break;
            } else {
                System.out.println("Ingrese una respuesta válida. s o n");
            }
        }

        return pizza;
    }

    public static void main(String[] args) {
        int cantidadPizzas = 3;
        scanner = new Scanner(System.in);

        for(int i = 0; i < cantidadPizzas; i++){
            Pizza pizza = crearPizza();
            pizza.calcularPrecio();
            pizza.calcularArea();

            System.out.println("** Pizza " + (i+1) + " **");
            System.out.println(pizza);
        }

        scanner.close();
    }
}