package PCT;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	public final static String version = "B.1.000.000.EE";
	
	private JFrame frame;
	
	JButton btnAgregar;
	JButton btnConsultar;
	JTextPane detalles;
	private JMenuItem mntmGuardar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					window.frame.setTitle(Conector.getTitle(0));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
		Conector.iniciar(detalles);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conector.guardar();
				JOptionPane.showMessageDialog(null, "Archivo Guardado", "Guardar", 1);
			}
		});
		mnArchivo.add(mntmGuardar);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Agregar();

			}
		});
		btnAgregar.setBounds(10, 10, 215, 30);
		panel.add(btnAgregar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Consultar();
			}
		});
		btnConsultar.setBounds(10, 50, 215, 30);
		panel.add(btnConsultar);
		
		detalles = new JTextPane();
		detalles.setBounds(10, 93, 440, 343);
		detalles.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(detalles);
		
		
	}
}
