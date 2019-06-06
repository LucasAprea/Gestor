package PCT;

public class Telefono {
			
	String dueño;
	String contraseña;
	String[] comentarios;
	String modelo;
	int estado;
	String[] observaciones;
	String numero;
	String valorArreglo;
	
	public static String[] estados = {"Revisando", "Esperando Repuestos", "Esperando Reparacion", "En Reparacion",  "Esperando Retirarse"};
	static int[] totalTelefonos = {0,0,0,0,0,0};
	
	public Telefono(String D,String m, String clave, String Comentario, String numero) {
		dueño = D;
		modelo = m;
		contraseña = clave;
		comentarios = Comentario.split(", ");
		this.numero = numero;
		estado = 0;
		valorArreglo = "0";
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
			texto = "Dueño: " + dueño + "\n" + "contraseña: " + contraseña + "\n" + "Modelo: " + modelo + "\n" + "Estado: " + Telefono.estados[estado] + " \n Numero: " + numero + "\n Valor Arreglo: $"+ valorArreglo + "\n Comentarios: \n";
		}else {
			texto = "Dueño: " + dueño + "\n" + "Modelo: " + modelo + "\n" + "Estado: " + Telefono.estados[estado] + " \nNumero: " + numero + "\nValor Arreglo: $"+ valorArreglo + "\nComentarios: \n";
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
	
	public static String setText() {
		String L1 = "Telefonos totales: " + totalTelefonos[0];
		String L2 = "Telefonos En Revision: " + totalTelefonos[1];
		String L3 = "Telefonos Esperando Repuestos: " + totalTelefonos[2];
		String L4 = "Telefonos Esperando Reparacion: " + totalTelefonos[3];
		String L5 = "Telefonos En Reparacion: " + totalTelefonos[4];
		String L6 = "Telefonos Esperando Retirarse: " + totalTelefonos[5];
		String Texto = L1 + "\n" + L2 + "\n" + L3 + "\n" + L4 + "\n" + L5 + "\n" + L6;
		return Texto;
	}
	
	public String[] getDatos() {
		String[] datos = new String[4];
		datos[0]=this.dueño;
		datos[1]=this.contraseña;
		datos[2]=this.modelo;
		datos[3]=this.numero;
		return datos;
	}

	public void setDatos(String[]datos) {
		dueño = datos[0];
		contraseña = datos[1];
		modelo= datos[2];
		numero = datos[3];
		observaciones = datos[4].split(",");
	}

}

