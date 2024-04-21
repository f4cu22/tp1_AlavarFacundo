package ar.edu.unju.fi.ejercicio18.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

public class Main {
	
	private static Scanner sc;
    private static List<Pais> paises;
    private static List<DestinoTuristico> destinosTuristicos;

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		destinosTuristicos = new ArrayList<>();
		paises = new ArrayList<>();
		
		int opcion = 0;
		cargarPaises();
		do {
			try {
				opcion=menu();
				scanner.nextLine(); // Consumir el salto de línea después del número
				
				switch (opcion) {
				case 1:{ altaDestinoTuristico(); break; }
                case 2:{ mostrarDestinosTuristicos(); break; }
                case 3:{ modificarPaisDestinosTuristicos(); break; }
                case 4:{ limpiarDestinosTuristicos(); break; }
                case 5:{ eliminarDestinoTuristico(); break; }
                case 6:{ mostrarDestinosOrdenadosNombre(); break; }
                case 7:{ mostrarPaises(); break; }
                case 8:{ mostrarDestinosDePais(); break; }
				case 9:{ System.out.println("Saliendo del programa..."); break;}
		        default:
		            System.out.println("Opción no válida. Intente de nuevo.");
				}
				} catch (InputMismatchException e) {
	                System.out.println("Error: Ingrese una opción válida.");
	                scanner.nextLine(); // Limpiar el buffer de entrada
	            } catch (Exception e) {
	                System.out.println("Error: " + e.getMessage());
	                scanner.nextLine(); // Limpiar el buffer de entrada
	            }
				}while(opcion != 9);
			scanner.close();
			}
	/**
	 * Metodo para cargar paises
	 */
		public static void cargarPaises() {
			paises.add(new Pais("ESP", "España"));
			paises.add(new Pais("ARG", "Argentina"));
			paises.add(new Pais("PRU", "Peru"));
			paises.add(new Pais("BRA", "Brasil"));
			paises.add(new Pais("ITA", "Italia"));
		}
	/**
	 * Metodo menu y el ingreso de opcion
	 * @return 
	 * @return opcion
	 */
		public static int menu() {
		System.out.println("Menu de opciones: ");
		System.out.println("1 - Alta de destino turístico");
		System.out.println("2 - Mostrar todos los destinos turísticos");
		System.out.println("3 - Modificar el país de un destino turístico");
		System.out.println("4 - Limpiar el ArrayList de destino turísticos");
		System.out.println("5 - Eliminar un destino turístico");
		System.out.println("6 - Mostrar los destinos turísticos ordenados por nombre");
		System.out.println("7 - Mostrar todos los países");
		System.out.println("8 - Mostrar los destinos turísticos que pertenecen a un país");
		System.out.println("9 - Salir");
		System.out.println("Ingrese opcion: ");
		return sc.nextInt();
		}
		
		/**
		 * metodo de alta para destino turistico
		 */
		public static void altaDestinoTuristico() {
		//Alta de destino turístico (para asociar el país se ingresa el código de páis)
		System.out.println("Ingrese el código del destino turístico:");
        String codigo = sc.nextLine();
        System.out.println("Ingrese el nombre del destino turístico:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el precio del destino turístico:");
        double precio = sc.nextDouble();
        sc.nextLine(); // Consumir el salto de línea después del número
        System.out.println("Lista de países disponibles:");
        for (Pais pais : paises) {
            System.out.println(pais.getCodigo() + " - " + pais.getNombre());
        }
        System.out.println("Ingrese el código del país asociado al destino turístico:");
        String codigoPais = sc.nextLine();

        // Buscar el país por código
        Pais paisAsociado = null;
        for (Pais pais : paises) {
            if (pais.getCodigo().equals(codigoPais)) {
                paisAsociado = pais;
            }
            if (paisAsociado != null) {
                DestinoTuristico nuevoDestino = new DestinoTuristico(codigo, nombre, precio, paisAsociado, 0);
                destinosTuristicos.add(nuevoDestino);
                System.out.println("Destino turístico agregado correctamente.");
            } else {
                System.out.println("Código de país no válido. No se pudo asociar el destino turístico.");
            	}
        	}
		}
		
		
		/**
		 * 
		 */
		public static void mostrarDestinosTuristicos() {
			// Mostrar todos los destinos turísticos
            System.out.println("Lista de destinos turísticos:");
            for (DestinoTuristico destino : destinosTuristicos) {
                System.out.println(destino.getCodigo() + " - " + destino.getNombre());
            }
		}
		
		
		/**
		 * metodo para modificar el país de un destino turístico
		 */
		public static void modificarPaisDestinosTuristicos() {
			// Modificar el país de un destino turístico
		    if (destinosTuristicos.isEmpty()) {
		        System.out.println("No hay destinos turísticos para modificar.");
		    } else {
		        System.out.println("Lista de destinos turísticos:");
		        for (DestinoTuristico destino : destinosTuristicos) {
		            System.out.println(destino.getCodigo() + " - " + destino.getNombre());
		        }
		        System.out.println("Ingrese el código del destino turístico a modificar:");
		        String codigoDestinoModificar = sc.nextLine();

		        // Buscar el destino turístico por código
		        DestinoTuristico destinoModificar = null;
		        for (DestinoTuristico destino : destinosTuristicos) {
		            if (destino.getCodigo().equals(codigoDestinoModificar)) {
		                destinoModificar = destino;
		                break;
		            }
		        }

		        if (destinoModificar != null) {
		            System.out.println("Destino turístico encontrado: " + destinoModificar.getNombre());
		            System.out.println("Lista de países disponibles:");
		            for (Pais pais : paises) {
		                System.out.println(pais.getCodigo() + " - " + pais.getNombre());
		            }
		            System.out.println("Ingrese el nuevo código del país para este destino turístico:");
		            String nuevoCodigoPais = sc.nextLine();

		            // Buscar el país por código
		            Pais nuevoPaisAsociado = null;
		            for (Pais pais : paises) {
		                if (pais.getCodigo().equals(nuevoCodigoPais)) {
		                    nuevoPaisAsociado = pais;
		                    break;
		                }
		            }

		            if (nuevoPaisAsociado != null) {
		                destinoModificar.setPais(nuevoPaisAsociado);
		                System.out.println("País asociado al destino turístico modificado correctamente.");
		            } else {
		                System.out.println("Código de país no válido. No se pudo modificar el país asociado al destino turístico.");
		            }
		        } else {
		            System.out.println("No se encontró ningún destino turístico con ese código.");
		        }
		    }
		}
		
		
		/**
		 * metodo para limpiar destinos uristicos
		 */
		public static void limpiarDestinosTuristicos() {
			// Limpiar el ArrayList de destinos turísticos
		    if (destinosTuristicos.isEmpty()) {
		        System.out.println("La lista de destinos turísticos ya está vacía.");
		    } else {
		        destinosTuristicos.clear(); // Limpiar la lista de destinos turísticos
		        System.out.println("Se ha limpiado la lista de destinos turísticos correctamente.");
		    }
		}
		
		
		/**
		 * metodo para eliminar un destino turistico
		 */
		public static void eliminarDestinoTuristico() {
			// Eliminar un destino turístico
		    if (destinosTuristicos.isEmpty()) {
		        System.out.println("No hay destinos turísticos para eliminar.");
		    } else {
		        System.out.println("Lista de destinos turísticos:");
		        for (DestinoTuristico destino : destinosTuristicos) {
		            System.out.println(destino.getCodigo() + " - " + destino.getNombre());
		        }
		        System.out.println("Ingrese el código del destino turístico a eliminar:");
		        String codigoDestinoEliminar = sc.nextLine();

		        Iterator<DestinoTuristico> iterator = destinosTuristicos.iterator();
		        boolean encontrado = false;

		        while (iterator.hasNext()) {
		            DestinoTuristico destino = iterator.next();
		            if (destino.getCodigo().equals(codigoDestinoEliminar)) {
		                iterator.remove(); // Eliminar el destino turístico encontrado
		                System.out.println("Destino turístico eliminado correctamente.");
		                encontrado = true;
		                break;
		            }
		        }

		        if (!encontrado) {
		            System.out.println("No se encontró ningún destino turístico con ese código.");
		        }
		    }
		}
		
		
		/**
		 * metodo para mostrar destinos ordenados
		 */
		public static void mostrarDestinosOrdenadosNombre() {
			// Mostrar los destinos turísticos ordenados por nombre
		    if (destinosTuristicos.isEmpty()) {
		        System.out.println("No hay destinos turísticos para mostrar.");
		    } else {
		        // Ordenar la lista de destinos turísticos por nombre
		        Collections.sort(destinosTuristicos, Comparator.comparing(DestinoTuristico::getNombre));

		        System.out.println("Lista de destinos turísticos ordenados por nombre:");
		        for (DestinoTuristico destino : destinosTuristicos) {
		            System.out.println(destino.getCodigo() + " - " + destino.getNombre());
		        }
		    }
		}
		
		
		/**
		 * metodo para mostrar paises
		 */
		public static void mostrarPaises() {
			// Mostrar todos los países
		    if (paises.isEmpty()) {
		        System.out.println("No hay países para mostrar.");
		    } else {
		        System.out.println("Lista de países:");
		        for (Pais pais : paises) {
		            System.out.println("Código: " + pais.getCodigo() + ", Nombre: " + pais.getNombre());
		        }
		    }
		}
		
		
		/**
		 * metodo para mostrar destinos de pais
		 */
		public static void mostrarDestinosDePais() {
			// Mostrar los destinos turísticos que pertenecen a un país
		    if (destinosTuristicos.isEmpty()) {
		        System.out.println("No hay destinos turísticos para mostrar.");
		    } else {
		        System.out.println("Ingrese el código del país para mostrar sus destinos turísticos:");
		        String codigoPaisBusqueda = sc.nextLine();

		        boolean encontrados = false;

		        System.out.println("Destinos turísticos del país con código " + codigoPaisBusqueda + ":");
		        for (DestinoTuristico destino : destinosTuristicos) {
		            if (destino.getPais().getCodigo().equals(codigoPaisBusqueda)) {
		                System.out.println(destino.getCodigo() + " - " + destino.getNombre());
		                encontrados = true;
		            }
		        }

		        if (!encontrados) {
		            System.out.println("No se encontraron destinos turísticos para el país con código " + codigoPaisBusqueda);
		        }
		    }
		}
	}
