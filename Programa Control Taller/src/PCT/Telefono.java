package PCT;

public class Telefono {
			
	String due�o = "";
	String contrase�a = "";
	String[] comentarios = null;
	String modelo = "";
	int estado = 0;
	String[] observaciones = null;
	String numero = "";
	String valorArreglo = "";
	
	public static String[] estados = {"Revisando", "Esperando Repuestos", "Esperando Reparacion", "En Reparacion",  "Esperando Retirarse"};
	static int[] totalTelefonos = {0,0,0,0,0,0};
	
	public Telefono(String D,String m, String clave, String comentario, String numero) {
		due�o = D;
		modelo = m;
		contrase�a = clave;
		if(comentario != null && comentario != "") {
			comentarios = comentario.split(", ");
		}else {comentarios = null;}
		this.numero = numero;
		estado = 0;
		valorArreglo = "0";
	}
	public Telefono(String[] datos) {
		due�o = datos[0];
		contrase�a = datos[1];
		comentarios = datos[2].split("\\*");
		modelo = datos[3];
		estado = Integer.valueOf(datos[4]);
		observaciones = datos[5].split("\\*");
		numero = datos[6];
		valorArreglo = datos[7];
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
			texto = "Due�o: " + due�o + "\n" + "contrase�a: " + contrase�a + "\n" + "Modelo: " + modelo + "\n" + "Estado: " + Telefono.estados[estado] + " \n Numero: " + numero + "\n Valor Arreglo: $"+ valorArreglo + "\n Comentarios: \n";
		}else {
			texto = "Due�o: " + due�o + "\n" + "Modelo: " + modelo + "\n" + "Estado: " + Telefono.estados[estado] + " \nNumero: " + numero + "\nValor Arreglo: $"+ valorArreglo + "\nComentarios: \n";
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
		String L2 = " Telefonos En Revision: " + totalTelefonos[1];
		String L3 = " Telefonos Esperando Repuestos: " + totalTelefonos[2];
		String L4 = " Telefonos Esperando Reparacion: " + totalTelefonos[3];
		String L5 = " Telefonos En Reparacion: " + totalTelefonos[4];
		String L6 = " Telefonos Esperando Retirarse: " + totalTelefonos[5];
		String Texto = L1 + "\n" + L2 + "\n" + L3 + "\n" + L4 + "\n" + L5 + "\n" + L6;
		return Texto;
	}
	
	public String[] getDatos() {
		String[] datos = new String[4];
		datos[0]=this.due�o;
		datos[1]=this.contrase�a;
		datos[2]=this.modelo;
		datos[3]=this.numero;
		return datos;
	}

	public void setDatos(String[]datos) {
		due�o = datos[0];
		contrase�a = datos[1];
		modelo= datos[2];
		numero = datos[3];
		if(datos[4]!= null && datos[4] != "" )
			observaciones = datos[4].split(",");
		observaciones = null;
	}
	
	public String[] guardarDatos() {
		String[] datos = new String[8];
		datos[0] = due�o ;
		datos[1] = contrase�a;
		datos[2]= "";
		if(comentarios != null && comentarios.length>0 && comentarios[0] != ""){
			for(int i=0; i<comentarios.length;i++) {
				datos[2]+= comentarios[i] + "*";
			}
		}else {
			datos[2]="";
		}
		datos[3] = modelo;
		datos[4] = String.valueOf(estado);
		datos[5]= "";
		if(observaciones != null && observaciones.length>0 && observaciones[0] != "" ) {
			for(int i=0; i<observaciones.length;i++) {
				datos[5]+= observaciones[i] + "*";
			}
		}else {
			datos[5] ="";
		}
		datos[6] = numero;
		datos[7] = valorArreglo;
		return datos;
	}

}

