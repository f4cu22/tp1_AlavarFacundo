package ar.edu.unju.fi.ejercicio12.model;

import java.util.Calendar;

public class Persona {
	private String nombre;
	private Calendar fechaNacimiento;
	
	public Persona(String nombre, Calendar fechaNacimiento) {
	    this.nombre = nombre;
	    this.fechaNacimiento = fechaNacimiento;
	}
	public int calcularEdad() {
	    Calendar ahora = Calendar.getInstance();
	    int edad = ahora.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
	    if (ahora.get(Calendar.DAY_OF_YEAR) < fechaNacimiento.get(Calendar.DAY_OF_YEAR)) {
	    edad--;
	}
	    return edad;
	    
	}
	
	
    @Override
	public String toString() {
		return "Persona Nombre: " + nombre + "\nFechaNacimiento: " + fechaNacimiento.get(Calendar.DAY_OF_MONTH) 
		+"/"+ (fechaNacimiento.get(Calendar.MONTH) + 1) + "/" + fechaNacimiento.get(Calendar.YEAR) + "\n";
	}
    
	public String obtenerSignoZodiaco() {
        int mes = fechaNacimiento.get(Calendar.MONTH) + 1; // Se suma 1 porque en Calendar enero es 0
        int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);

        // Determinar signo del zodiaco
        if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
            return "Aries";
        } else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
            return "Tauro";
        } else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
            return "Géminis";
        } else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
            return "Cáncer";
        } else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
            return "Leo";
        } else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
            return "Virgo";
        } else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
            return "Libra";
        } else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
            return "Escorpio";
        } else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
            return "Sagitario";
        } else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
            return "Capricornio";
        } else if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
            return "Acuario";
        } else 
        {
            return "Piscis";
        }
    }
    
    public String obtenerEstacion() {
        int mes = fechaNacimiento.get(Calendar.MONTH) + 1; // Se suma 1 porque en Calendar enero es 0
        
        if (mes >= 3 && mes <= 5) {
            return "Otoño";
        } else if (mes >= 6 && mes <= 8) {
            return "Invierno";
        } else if (mes >= 9 && mes <= 11) {
            return "Primavera";
        } else {
            return "Verano";
        }
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
    
}
