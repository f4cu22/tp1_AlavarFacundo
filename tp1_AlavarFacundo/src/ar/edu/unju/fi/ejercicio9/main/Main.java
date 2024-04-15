package ar.edu.unju.fi.ejercicio9.main;

import ar.edu.unju.fi.ejercicio9.model.Producto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear 3 objetos de la clase Producto
        for (int i = 1; i <= 3; i++) {
            Producto producto = new Producto();

            System.out.println("Ingrese los datos para el producto " + i + ":");
            System.out.print("Nombre: ");
            producto.setNombre(scanner.nextLine());

            System.out.print("Código: ");
            producto.setCodigo(scanner.nextLine());

            System.out.print("Precio: ");
            producto.setPrecio(Double.parseDouble(scanner.nextLine()));

            System.out.print("Descuento (%): ");
            producto.setDescuento(Byte.parseByte(scanner.nextLine()));

            // Mostrar datos ingresados y precio con descuento
            System.out.println("Datos ingresados para el producto " + i + ":");
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Precio con descuento: $" + producto.calcularDescuento());
            System.out.println();
        }

        scanner.close();
    }
}