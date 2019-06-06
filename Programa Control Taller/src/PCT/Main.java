package PCT;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Main {

	private JFrame frame;
	JTextPane infoPanel = new JTextPane();
	//Control 
		private int[] totalTelefonos = {0,0,0,0,0,0};
	//Telefonos:
	ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
	//Botones: 
	JButton btnAgregar;
	JButton btnConsultar; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					window.frame.setTitle("Gestor de Telefonos");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnAgregar = new JButton("Agregar Telefono");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Agregar(Main.this);

			}
		});
		btnAgregar.setBounds(10, 10, 215, 30);
		panel.add(btnAgregar);
		
		btnConsultar = new JButton("Consultar Telefono");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Consultar(telefonos, Main.this);
			}
		});
		btnConsultar.setBounds(10, 50, 215, 30);
		panel.add(btnConsultar);
		infoPanel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		infoPanel.setBounds(10, 93, 440, 447);
		panel.add(infoPanel);
		this.setText(totalTelefonos);
	}
	public void setText(int[]estados) {
		String L1 = "Telefonos totales: " + estados[0];
		String L2 = "Telefonos En Revision: " + estados[1];
		String L3 = "Telefonos Esperando Repuestos: " + estados[2];
		String L4 = "Telefonos Esperando Reparacion: " + estados[3];
		String L5 = "Telefonos En Reparacion: " + estados[4];
		String L6 = "Telefonos Esperando Retirarse: " + estados[5];
		String Texto = L1 + "\n" + L2 + "\n" + L3 + "\n" + L4 + "\n" + L5 + "\n" + L6;
		infoPanel.setText(Texto);
	}

	public void CargarTelefono(Telefono tel) {
		telefonos.add(tel);
		this.Revision();
		this.setText(totalTelefonos);
		
	}
	
	public void Revision() {
		for(int i=1; i<totalTelefonos.length;i++) {
			totalTelefonos[i]=0;
		}
		totalTelefonos[0]=telefonos.size();
		Object[] tel = telefonos.toArray();
		for(int i=0; i<tel.length;i++) {
			Telefono t = (Telefono)tel[i];
			totalTelefonos[t.estado+1]++;
		}
		setText(totalTelefonos);
	}
}
