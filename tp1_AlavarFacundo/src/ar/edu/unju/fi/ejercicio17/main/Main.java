package ar.edu.unju.fi.ejercicio17.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Jugador> jugadores = new ArrayList<>();
        
		int opcion;
		
		do {
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
			opcion=scanner.nextInt();
			
			switch (opcion) {
			case 1:
				//Alata de jugador
				try {
				System.out.println("Ingrese los datos del jugador: ");
				System.out.println("Nombre: ");
				String nombre = scanner.next();
				System.out.println("Apellido: ");
				String apellido = scanner.next();
				
				scanner.nextLine(); // Limpiar el buffe
				
				System.out.println("Fecha Nacimiento en (DD/MM/YYYY): ");	
				String fechaNacString= scanner.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechaNacimiento = LocalDate.parse(fechaNacString,formatter);
				
				System.out.println("Nacionalidad: ");
				String nacionalidad = scanner.next();
				System.out.println("Estatura: ");
				Double estatura = scanner.nextDouble();
				System.out.println("Peso (kg): ");
				Double peso = scanner.nextDouble();
				System.out.println("Posición (delantero, medio, defensa, arquero): ");
				String posicion = scanner.next();
				
				Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
				jugadores.add(nuevoJugador);
				System.out.println("Jugador agregado correctamente");
				}catch(DateTimeParseException e){
					System.out.println("Error: Formato de fecha incorrecto. Use el formato YYYY-MM-DD");
				}catch (InputMismatchException e) {
			        System.out.println("Error: Tipo de dato incorrecto. Ingrese un número válido para estatura y peso.");
			        scanner.next(); // Limpiar el buffer de entrada
			    }catch (Exception e) {
			        System.out.println("Error inesperado al registrar jugador: " + e.getMessage());
			    }
				break;
				
			case 2:
				//mostrar los datos del jugador por nombre y apellido
				try {
				System.out.println("Ingrese el nombre del jugador: ");
				String nombreBusqueda =scanner.next();
				System.out.println("Ingrese el apellido del jugador: ");
				String apellidoBusqueda =scanner.next();
				
				Jugador jugadorEncontrado = buscarJugador(nombreBusqueda, apellidoBusqueda, jugadores);;
								
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
				break;
			case 3:
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
				break;
			case 4:
				//modificar los datos de un jugador
				try {
				if(jugadores.isEmpty()) {
					System.out.println("Jugador no encontrado.");
				}
				else {
					System.out.println("Ingrese el nombre del jugador a modificar: ");
					String nombreModificar =scanner.next();
					System.out.println("Ingrese el apellido del jugador a modificar: ");
					String apellidoModificar =scanner.next();
					
					
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
						String nuevoNombre=scanner.next();
						System.out.println("Nuevo apeliido: ");
						String nuevoApellido=scanner.next();
						
						scanner.nextLine(); // Limpiar el buffe
						
						System.out.println("Fecha Nacimiento en (DD/MM/YYYY): ");	
						String fechaNacString= scanner.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate nuevaFechaNacimiento = LocalDate.parse(fechaNacString,formatter);
						
						System.out.println("Nueva nacionalidad: ");
						String nuevaNacionalidad=scanner.next();
						System.out.println("Nueva estatura(m): ");
						Double nuevaEstatura=scanner.nextDouble();
						System.out.println("Nuevo peso(kg): ");
						Double nuevoPeso=scanner.nextDouble();
						System.out.println("Nueva posición (delantero, medio, defensa, arquero): ");
						String nuevaPosicion=scanner.next();
						
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
			        scanner.next(); // Limpiar el buffer de entrada
			    } catch (Exception e) {
			        System.out.println("Error inesperado al modificar los datos del jugador: " + e.getMessage());
			    }
				break;
			case 5:
				//eliminar jugador
				try {
				if(jugadores.isEmpty()) {
					System.out.println("Jugador no encontrado.");
				}
				else {
					System.out.println("Ingrese el nombre del jugador a eliminar: ");
					String nombreEliminar =scanner.next();
					System.out.println("Ingrese el apellido del jugador a eliminar: ");
					String apellidoEliminar =scanner.next();
					
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
			case 6:
				// Mostrar la cantidad total de jugadores en el ArrayList
				try {
			    int cantidadJugadores = jugadores.size();
			    System.out.println("Cantidad total de jugadores: " + cantidadJugadores);
				} catch (Exception e) {
			        System.out.println("Error inesperado al mostrar la cantidad de jugadores: " + e.getMessage());
			    }
			    break;
			case 7:
				//Mostrar la cantidad de jugadores de una nacionalidad especifica
				try {
				if (jugadores.isEmpty()) {
					System.out.println("No hay jugadores registrados.");
				}
				else {
					System.out.println("Ingrese la nacionalidad para contar jugadores: ");
					String nacionalidadBuscar = scanner.next();
					
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
				break;
			case 8:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opcion invalida. Intente de nuevo.");
			}
		}while(opcion != 8);
		scanner.close();
	}	
		//metodo para buscar un jugador por nombre y apellido
		private static Jugador buscarJugador(String nombre,String apellido,ArrayList<Jugador> jugadores) {
			for(Jugador jugador : jugadores){
				if(jugador.getNombre().equalsIgnoreCase(nombre)&& jugador.getApellido().equalsIgnoreCase(apellido)){
					return jugador;
				}
						
			}return null;
		}
		
		
	}
	


