package ar.edu.unju.fi.ejercicio17.main;
/**
*Clase main que representa el menu para un jugador
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

public class Main {
	private static Scanner sc;
    private static List<Jugador> jugadores;
	public static void main(String[] args) {
		sc = new Scanner(System.in); 
		jugadores = new ArrayList<Jugador>();
        
		int opcion=0;
		//generarJugadores();
		do {opcion=menu();
			switch (opcion) {
			case 1:{ altaJugador(); break; }
            case 2:{ mostrarJugadorNyA(); break; }
            case 3:{ mostrarOrdenadosPorApellido(); break; }
            case 4:{ modificarJugador(); break; }
            case 5:{ eliminarJugador(); break; }
            case 6:{ mostrarJugadores(); break;}
            case 7:{ mostrarPorNacionalidad(); break; }
			case 8:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opcion invalida. Intente de nuevo.");
			}
		}while(opcion != 8);
		sc.close();
	}
	
		//metodo para buscar un jugador por nombre y apellido
		private static Jugador buscarJugador(String nombreBusqueda, String apellidoBusqueda, List<Jugador> jugadores) {
			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().equalsIgnoreCase(nombreBusqueda) && jugador.getApellido().equalsIgnoreCase(apellidoBusqueda)) {
                return jugador; // Retorna el jugador encontrado
            }
        }
        return null; // Retorna null si no se encuentra ningún jugador con el nombre y apellido especificados
    }
	
		/**
		 * Menu de opciones
		 * @return opcion
		 */
		private static int menu() {
			int opc;
			System.out.println("Menu de opciones: ");
			System.out.println("1 - Alta de jugador");
			System.out.println("2 - Mostrar los datos del jugador");
			System.out.println("3 - Mostrar todos los jugadores ordenados por apellido");
			System.out.println("4 - Modificar los datos de un jugador");
			System.out.println("5 - Eliminar jugador");
			System.out.println("6 - Mostrar la cantidad total de jugadores");
			System.out.println("7 - Mostrar la cantidad de jugadores de una nacionalidad");
			System.out.println("8 - Salir");
			System.out.println("Ingrese opcion: ");
			opc=sc.nextInt();
			return opc;
		}
		/**
		 * Metodo alta de jugador
		 */
		private static void altaJugador() {
			try {
				System.out.println("Ingrese los datos del jugador: ");
				System.out.println("Nombre: ");
				String nombre = sc.next();
				System.out.println("Apellido: ");
				String apellido = sc.next();
				
				sc.nextLine(); // Limpiar el buffe
				
				System.out.println("Fecha Nacimiento en (DD/MM/YYYY): ");	
				String fechaNacString= sc.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechaNacimiento = LocalDate.parse(fechaNacString,formatter);
				
				System.out.println("Nacionalidad: ");
				String nacionalidad = sc.next();
				System.out.println("Estatura: ");
				Double estatura = sc.nextDouble();
				System.out.println("Peso (kg): ");
				Double peso = sc.nextDouble();
				System.out.println("Posición (delantero, medio, defensa, arquero): ");
				String posicion = sc.next();
				
				Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
				jugadores.add(nuevoJugador);
				System.out.println("Jugador agregado correctamente");
				}catch(DateTimeParseException e){
					System.out.println("Error: Formato de fecha incorrecto. Use el formato YYYY-MM-DD");
				}catch (InputMismatchException e) {
			        System.out.println("Error: Tipo de dato incorrecto. Ingrese un número válido para estatura y peso.");
			        sc.next(); // Limpiar el buffer de entrada
			    }catch (Exception e) {
			        System.out.println("Error inesperado al registrar jugador: " + e.getMessage());
			    }
		}
			/**
			 * Metodo para mostrar los datos del jugador por nombre y apellido
			 */
			private static void mostrarJugadorNyA() {
			//mostrar los datos del jugador por nombre y apellido
			try {
			System.out.println("Ingrese el nombre del jugador: ");
			String nombreBusqueda =sc.next();
			System.out.println("Ingrese el apellido del jugador: ");
			String apellidoBusqueda =sc.next();
			
			Jugador jugadorEncontrado = buscarJugador(nombreBusqueda, apellidoBusqueda, jugadores);
							
			if (jugadorEncontrado != null) {
				System.out.println("Datos del jugador: ");
				System.out.println("Nombre: " + jugadorEncontrado.getNombre());
				System.out.println("Apellido: " + jugadorEncontrado.getApellido());
				System.out.println("Fecha de nacimiento: " + jugadorEncontrado.getFechaNacimiento());
				System.out.println("Nacionalidad: " + jugadorEncontrado.getNacionalidad());
				System.out.println("Estatura: " + jugadorEncontrado.getEstatura());
				System.out.println("Peso: " + jugadorEncontrado.getPeso());
				System.out.println("Posicion: " + jugadorEncontrado.getPosicion());
				}
			else {
				System.out.println("Jugador no encontrado.");
			}
			}
			catch(Exception e){
				System.out.println("Error inesperado al mostrar los datos del jugador: "+e.getMessage());
			}
		
		}
		
		/**
		 * metodo para mostrar todos los jugadores ordenados por apellido
		 */
		public static void mostrarOrdenadosPorApellido() {
			//Mostrar todos los jugadores ordenados por apellido
			try {
				if(jugadores.isEmpty()) {
					System.out.println("No hay jugadores registrados.");
				}
				else {
					//Define un Comparador
					Comparator<Jugador> comparadorApellido = Comparator.comparing(Jugador::getApellido);
					
					//Ordena la lista de jugadores utilizando el Comparador
					Collections.sort(jugadores, comparadorApellido);
					
					//Mostrar los jugadores ordenados por apellido
					System.out.println("Jugadores ordenados por apellido: ");
					for(Jugador jugador : jugadores) {
						System.out.println("Apellido y Nombre: "+jugador.getApellido()+", "+jugador.getNombre());
					}
				}
			} catch (Exception e) {
				System.out.println("Error inesperado al mostrar jugadores ordenados por apellido: " + e.getMessage());
			}
		}
		
		/**
		 * metodo para modificar datos del jugador
		 */
		public static void modificarJugador() {
			//modificar los datos de un jugador
			try {
			if(jugadores.isEmpty()) {
				System.out.println("Jugador no encontrado.");
			}
			else {
				System.out.println("Ingrese el nombre del jugador a modificar: ");
				String nombreModificar =sc.next();
				System.out.println("Ingrese el apellido del jugador a modificar: ");
				String apellidoModificar =sc.next();
				
				
				Jugador jugadorModificar = buscarJugador(nombreModificar,apellidoModificar,jugadores);
				if(jugadorModificar!=null) {
					//mostrar datos actuales del jugador
					System.out.println("Datos actuales del jugador: ");
					System.out.println("Nombre: " + jugadorModificar.getNombre());
					System.out.println("Apellido: " + jugadorModificar.getApellido());
					System.out.println("Fecha de nacimiento: " + jugadorModificar.getFechaNacimiento());
					System.out.println("Nacionalidad: " + jugadorModificar.getNacionalidad());
					System.out.println("Estatura: " + jugadorModificar.getEstatura());
					System.out.println("Peso: " + jugadorModificar.getPeso());
					System.out.println("Posicion: " + jugadorModificar.getPosicion());
					
					//solicitar nuevos datos
					System.out.println("Ingrese nuevos datos para modificar(o deje en blanco para mantener): ");
					System.out.println("Nuevo nombre: ");
					String nuevoNombre=sc.next();
					System.out.println("Nuevo apeliido: ");
					String nuevoApellido=sc.next();
					
					sc.nextLine(); // Limpiar el buffe
					
					System.out.println("Fecha Nacimiento en (DD/MM/YYYY): ");	
					String fechaNacString= sc.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate nuevaFechaNacimiento = LocalDate.parse(fechaNacString,formatter);
					System.out.println("Nueva nacionalidad: ");
					String nuevaNacionalidad=sc.next();
					System.out.println("Nueva estatura(m): ");
					Double nuevaEstatura=sc.nextDouble();
					System.out.println("Nuevo peso(kg): ");
					Double nuevoPeso=sc.nextDouble();
					System.out.println("Nueva posición (delantero, medio, defensa, arquero): ");
					String nuevaPosicion=sc.next();
					
					//actualizar los datos del jugador
					jugadorModificar.setNombre(!nuevoNombre.isEmpty() ? nuevoNombre : jugadorModificar.getNombre());
					jugadorModificar.setApellido(!nuevoApellido.isEmpty() ? nuevoApellido : jugadorModificar.getApellido());
		            jugadorModificar.setFechaNacimiento(nuevaFechaNacimiento);
		            jugadorModificar.setNacionalidad(!nuevaNacionalidad.isEmpty() ? nuevaNacionalidad : jugadorModificar.getNacionalidad());
		            jugadorModificar.setEstatura(nuevaEstatura);
		            jugadorModificar.setPeso(nuevoPeso);
		            jugadorModificar.setPosicion(!nuevaPosicion.isEmpty() ? nuevaPosicion : jugadorModificar.getPosicion());
		            
		            System.out.println("Datos modificados correctamente.");
				}
				else {
					System.out.println("Jugador no encontrado. ");
				}
			}
			} catch (DateTimeParseException e) {
		        System.out.println("Error: Formato de fecha incorrecto. Use el formato YYYY-MM-DD.");
		    } catch (InputMismatchException e) {
		        System.out.println("Error: Tipo de dato incorrecto. Ingrese un número válido para estatura y peso.");
		        sc.next(); // Limpiar el buffer de entrada
		    } catch (Exception e) {
		        System.out.println("Error inesperado al modificar los datos del jugador: " + e.getMessage());
		    }
			}
		/**
		 * metodo para eliminar jugador
		 */
		public static void eliminarJugador() {
			//eliminar jugador
			try {
			if(jugadores.isEmpty()) {
				System.out.println("Jugador no encontrado.");
			}
			else {
				System.out.println("Ingrese el nombre del jugador a eliminar: ");
				String nombreEliminar =sc.next();
				System.out.println("Ingrese el apellido del jugador a eliminar: ");
				String apellidoEliminar =sc.next();
				
				Iterator<Jugador> iterator = jugadores.iterator();
				boolean jugadorEncontrado1 = false;
				
				while(iterator.hasNext()) {
					Jugador jugador = iterator.next();
					if(jugador.getNombre().equals(nombreEliminar)&& jugador.getApellido().equalsIgnoreCase(apellidoEliminar)) {
						iterator.remove(); // Eliminar el jugador usando el Iterator
		                System.out.println("Jugador eliminado correctamente.");
		                jugadorEncontrado1 = true;
		                break; // Salir del bucle una vez que se elimina el jugador
					}
				}
				if(!jugadorEncontrado1) {
					System.out.println("Jugador no encontrado: ");
				}
			}
		} catch (Exception e) {
	        System.out.println("Error inesperado al eliminar el jugador: " + e.getMessage());
	    }
		}
		
		/**
		 * metodo para mostrar la cantidad total
		 */
		public static void mostrarJugadores() {
			// Mostrar la cantidad total de jugadores en el ArrayList
			try {
		    int cantidadJugadores = jugadores.size();
		    System.out.println("Cantidad total de jugadores: " + cantidadJugadores);
			} catch (Exception e) {
		        System.out.println("Error inesperado al mostrar la cantidad de jugadores: " + e.getMessage());
		    }
		}
		
		/**
		 * metodo para mostrar la cantidad de jugadores por nacionalidad
		 */
		public static void mostrarPorNacionalidad() {
			//Mostrar la cantidad de jugadores de una nacionalidad especifica
			try {
			if (jugadores.isEmpty()) {
				System.out.println("No hay jugadores registrados.");
			}
			else {
				System.out.println("Ingrese la nacionalidad para contar jugadores: ");
				String nacionalidadBuscar = sc.next();
				
				int cantidadJugadoresNacionalidad = 0;
				for (Jugador jugador : jugadores) {
					if(jugador.getNacionalidad().equals(nacionalidadBuscar)) {
						cantidadJugadoresNacionalidad++;
					}
				}
				System.out.println("Cantidad de jugadores de nacionalidad " + nacionalidadBuscar 
						+": " + cantidadJugadoresNacionalidad);
			}
			} catch (Exception e) {
		        System.out.println("Error inesperado al contar jugadores por nacionalidad: " + e.getMessage());
		    }
		}
}

	


