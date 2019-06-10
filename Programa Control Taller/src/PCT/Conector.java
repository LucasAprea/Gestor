package PCT;

import java.util.ArrayList;
import java.util.ListIterator;
import Log.Log;
import javax.swing.JTextPane;

public class Conector {

	public static ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
	private static JTextPane detalles;
	
	public static void iniciar(JTextPane datos) {
		detalles = datos;
		Log.generarLog();
		ManejoDeArchivos.cargarDatos();
		Log.WriteLog("Datos Cargados: "+ telefonos.size());
		actualizar();
	}
	
	private static void actualizar() {
		revision();
		detalles.setText(Telefono.setText());
	}
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
		actualizar();
		Log.WriteLog("Telefono Agregado Correctamente");
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
		Log.WriteLog("Telefono eliminado: "+telefonos.get(index).numero);
		telefonos.remove(index);
	}

	public static String[] getContenido(int index) {
		Telefono t = (Telefono)telefonos.get(index);
		return t.getDatos();
	}

	public static void actualizarDatos(int index, String[] datos) {
		Telefono t = (Telefono)telefonos.get(index);
		Log.WriteLog("Telefono Actualizado: " + t.numero);
		t.setDatos(datos);
		actualizar();
	}
	public static void incrementar(int index) {
		Telefono t = (Telefono)telefonos.get(index);
		t.incrementarEstado();
		actualizar();
	}
	public static String getEstadoActual(int index) {
		Telefono t = (Telefono)telefonos.get(index);
		return Telefono.estados[t.estado];
	}
	
	public static void setValor(int index, String valor) {
		Telefono t = (Telefono)telefonos.get(index);
		t.valorArreglo = valor;
		actualizar();
	}
	public static void agregarDesdeArchivo(String[] datos) {
		Telefono t = new Telefono(datos);
		add(t);
	}
	public static void guardar() {
		ManejoDeArchivos.borrar();
		Telefono t;
		ListIterator<Telefono> list = telefonos.listIterator();
		while(list.hasNext()) {
			t = list.next();
			ManejoDeArchivos.guardarDatos(t.guardarDatos());
		}
	}
	public static void actualizarLog(String texto) {
		Log.WriteLog(texto);
	}
	public static void warningLog(String texto) {
		Log.WarningLog(texto);
	}
}
