package PCT;

import java.util.ArrayList;

public class Conector {

	public static ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
	
	public static String setText() {
		return Telefono.setText();
	}
	
	public static String getTitle(int i) {
		switch(i) {
		case 0:return "Gestor de Telefonos";
		case 1:return "Agregar Telefono";
		case 2:return "Consultar Telefono";
		case 3:return "Actualizar Telefono";
		}
		return"";
	}
	
	public static boolean add(Telefono tel) {
		telefonos.add(tel);
		revision();
		return true;
	}
	
	public static void revision() {
		for(int i=1; i<Telefono.totalTelefonos.length;i++) {
			Telefono.totalTelefonos[i]=0;
		}
		Telefono.totalTelefonos[0]=telefonos.size();
		Object[] tel = telefonos.toArray();
		for(int i=0; i<tel.length;i++) {
			Telefono t = (Telefono)tel[i];
			Telefono.totalTelefonos[t.estado+1]++;
		}
	}
	
	public static String[] getTelefonos(){
		Object[] tel = telefonos.toArray();
		String[] t = new String[tel.length];
		for(int i=0; i<tel.length;i++) {
			t[i]=((Telefono)tel[i]).numero;
		}
		return t;
	}
	
	public static void agregar(String dueño, String modelo, String contraseña, String comentarios, String numero) {
		add(new Telefono(dueño,modelo,contraseña,comentarios,numero));
	}

	public static String detalles(int index, boolean b) {
		Telefono aux = telefonos.get(index);
		return aux.toString(b);
	}

	public static void eliminar(int index) {
		telefonos.remove(index);
	}

	public static String[] getContenido(int index) {
		Telefono t = (Telefono)telefonos.get(index);
		return t.getDatos();
	}

	public static void actualizarDatos(int index, String[] datos) {
		Telefono t = (Telefono)telefonos.get(index);
		t.setDatos(datos);
	}
	public static void incrementar(int index) {
		Telefono t = (Telefono)telefonos.get(index);
		t.incrementarEstado();
	}
	public static String getEstadoActual(int index) {
		Telefono t = (Telefono)telefonos.get(index);
		return Telefono.estados[t.estado];
	}
	
	public static void setValor(int index, String valor) {
		Telefono t = (Telefono)telefonos.get(index);
		t.valorArreglo = valor;
	}
}
