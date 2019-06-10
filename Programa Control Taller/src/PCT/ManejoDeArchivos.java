package PCT;

import java.io.*;
import java.util.Iterator;

public class ManejoDeArchivos {
	
	public static void cargarDatos() {
		Iterator<String> texto;
		String linea;
		String[] datos;
		try {
			File file = new File("Datos.priv");
			FileReader fr = new FileReader(file);
			BufferedReader archivo = new BufferedReader(fr);
				texto = archivo.lines().iterator();
				while(texto.hasNext()) {
					linea = texto.next();
					datos = linea.split("\\/");
					Conector.agregarDesdeArchivo(datos);
				}
			archivo.close();
		} catch (IOException e) {
			if(e != null) {
				Conector.warningLog(e.toString());
			}e.printStackTrace();
		}
	}
	public static void guardarDatos(String[] datos) {
		String linea = "";
		for(int i=0; i<datos.length;i++) {
			linea += datos[i]+"/";
		}
		File archivo = new File("Datos.priv");
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
				FileWriter f = new FileWriter(archivo, true);
				PrintWriter print = new PrintWriter(f);
				print.println(linea);
				print.close();
				f.close();
			} catch (IOException e) {
				if(e != null) {
					Conector.warningLog(e.toString());
				}e.printStackTrace();
			}
		}else {
			FileWriter f;
			try {
				f = new FileWriter(archivo, true);
				PrintWriter print = new PrintWriter(f);
				print.println(linea);
				print.close();
				f.close();
			} catch (IOException e) {
				if(e != null) {
					Conector.warningLog(e.toString());
				}e.printStackTrace();
			}
		}
	}
	public static void borrar() {
		File archivo = new File("Datos.priv");
		//if(archivo.exists())
			archivo.delete();
	}
	
	
}
