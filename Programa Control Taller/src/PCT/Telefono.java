package PCT;

public class Telefono {
	String dueno;
	String contrasena;
	String[] comentarios;
	String modelo;
	int estado;
	String[] observaciones;
	String numero;
	double valorArreglo;
	
	public static String[] estados = {"Revisando", "Esperando Repuestos", "Esperando Reparacion", "En Reparacion",  "Esperando Retirarse"};
	
	public Telefono(String D,String m, String clave, String Comentario, String numero) {
		dueno = D;
		modelo = m;
		contrasena = clave;
		comentarios = Comentario.split(", ");
		this.numero = numero;
		estado = 0;
		valorArreglo = 0;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setObeservaciones(String observaciones) {
		this.observaciones = observaciones.split(",");
	}
	
	public String toString(boolean opcion) {
		String texto;
		if(opcion) {
			texto = "Dueño: " + dueno + "\n" + "contraseña: " + contrasena + "\n" + "Modelo: " + modelo + "\n" + "Estado: " + Telefono.estados[estado] + " \n Numero: " + numero + "\n Valor Arreglo: $"+ valorArreglo + "\n Comentarios: \n";
		}else {
			texto = "Dueño: " + dueno + "\n" + "Modelo: " + modelo + "\n" + "Estado: " + Telefono.estados[estado] + " \nNumero: " + numero + "\nValor Arreglo: $"+ valorArreglo + "\nComentarios: \n";
		}
		for(int i=0; i<comentarios.length;i++) {
			if(comentarios[i] != "") {
				texto += "-" + comentarios[i] + "\n";
			}
		}
		texto += "Observaciones: \n";
		if(observaciones != null) {
			for(int i=0; i<observaciones.length;i++) {
				if(observaciones[i] != "") {
					texto += "-" + observaciones[i] + "\n";
				}
			}
		}
		return texto;
	}

	public void incrementarEstado() {
		if(estado<Telefono.estados.length-1) {
			estado++;
		}
	}

}

