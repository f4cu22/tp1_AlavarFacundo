package ar.edu.unju.fi.ejercicio8.mondel;

public class CalculadoraEspecial {
	private int n;
	
	
	//constructor por defecto.
	public CalculadoraEspecial() {
		// No es necesario inicializar n en el constructor por defecto
	}

	//getters y setters
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
	//metodo para la sumatoria
	//Formula  [(k * (k + 1)) / 2]^2 + ... + [((k+n) * ((k+n) + 1)) /2]^2
	public double mostrarSumatoria() {
		int sumatoria = 0;
		for(int i=1;i<=n;i++) {
			 int operacion = ( (i * (i + 1)) / 2) * ( (i * (i + 1)) / 2);
	         sumatoria = sumatoria + operacion;
		}
		return sumatoria;
	}
	
	//metodo para la productoria
	public double mostrarProductoria() {
		int productoria = 1;
		for(int i=1;i<=n;i++) {
			productoria = productoria * (i * (i + 4));
		}
		return productoria;
	}


}
