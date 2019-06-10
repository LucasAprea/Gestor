package Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import PCT.*;

public class Log {
	static File log = new File("Log.txt");
	static FileWriter f; 
	static PrintWriter printLog; 
	static Date today = new Date();
	
	public static void generarLog() {
		
		if(log.exists()) {
			log.delete();
		}
		try {
			log.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		write("Programa propiedad de TecnoNation Solutions");
		write("Version: " + Main.version);
		//TODO write("Estado de la licencia: " + Licence.State);
		//TODO write("Clave de la aplicacion: " + Licence.KEY");
		//TODO write("Fecha inicio de Licencia: " + Licence.licenceStart);
		//TODO write("Fecha de expiracion: "+ Licence.licenceOut);
		CambiarNivel();
	}
	private static void write(String texto) {
		try {
			f=new FileWriter(log,true);
			printLog = new PrintWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		texto = texto + "\n";
		printLog.println(texto);
		printLog.close();
	}
	public static void WriteLog(String texto) {
		try {
			f=new FileWriter(log,true);
			printLog = new PrintWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		texto = today.toString() + ": " + texto + "\n";
		printLog.println(texto);
		printLog.close();
	}
	public static void WarningLog(String texto) {
		try {
			f=new FileWriter(log,true);
			printLog = new PrintWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		texto = today.toString() + ": WARNING: " + texto + "\n";
		printLog.println(texto);
		printLog.close();
	}
	public static void CambiarNivel() {
		write("\n");
		write("-------------------------------------------------------------------------------------------------");
		write("\n");
	}
}
