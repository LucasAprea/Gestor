package PCT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class Actualizar {

	private JFrame frmActualizar;
	private JTextPane control;
	private Consultar ct;
	
	//Cambiantes:
	private int index;
	
	private JTextField dueno;
	
	private JLabel lblContrasea;
	private JTextField contrasena;
	
	private JTextField numero;
	private JLabel lblNumero;
	
	private JLabel lblModelo;
	private JTextField modelo;
	
	private JLabel lblObservaciones;
	private JTextField observaciones;
	
	private JButton btnIncrementarEstado;
	
	private JButton btnActualizarPrecio;
	
	private JButton btnSave;

	
	public Actualizar(int i, Consultar tel) {
		initialize();
		ct = tel;
		this.index = i;
		colocarContenido();
		frmActualizar.setVisible(true);
	}
	private void colocarContenido() {
		String[]datos = Conector.getContenido(index);
		dueno.setText(datos[0]);
		contrasena.setText(datos[1]);
		modelo.setText(datos[2]);
		numero.setText(datos[3]);
	}
	private void GuardarDatos() {
		String[] datos = new String[5];
		datos[0] = dueno.getText();
		datos[1] = contrasena.getText();
		datos[2] = modelo.getText();
		datos[3] = numero.getText();
		datos[4] = observaciones.getText();
		Conector.actualizarDatos(index,datos);
		ct.getDatos();
		frmActualizar.dispose();
	}
	private void incrementarEstado() {
		Conector.incrementar(index);
		control.setText("Se Incremento el Estado \nValor Actual: " + Conector.getEstadoActual(index));
	}
	private void initialize() {
		Math.abs(5);
		frmActualizar = new JFrame();
		frmActualizar.setTitle("Actualizar Telefono");
		frmActualizar.setBounds(100, 100, 598, 298);
		frmActualizar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmActualizar.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		dueno = new JTextField();
		dueno.setBounds(86, 13, 157, 22);
		panel.add(dueno);
		dueno.setColumns(10);
		
		contrasena = new JTextField();
		contrasena.setBounds(86, 48, 157, 22);
		panel.add(contrasena);
		contrasena.setColumns(10);
		
		numero = new JTextField();
		numero.setBounds(86, 83, 157, 22);
		panel.add(numero);
		numero.setColumns(10);
		
		JLabel lblDueo = new JLabel("Due\u00F1o");
		lblDueo.setBounds(12, 16, 43, 16);
		panel.add(lblDueo);
		
		modelo = new JTextField();
		modelo.setColumns(10);
		modelo.setBounds(86, 118, 157, 22);
		panel.add(modelo);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(12, 51, 75, 16);
		panel.add(lblContrasea);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(12, 86, 56, 16);
		panel.add(lblNumero);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 121, 56, 16);
		panel.add(lblModelo);
		
		observaciones = new JTextField();
		observaciones.setBounds(346, 16, 222, 124);
		panel.add(observaciones);
		observaciones.setColumns(10);
		
		lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(255, 16, 88, 16);
		panel.add(lblObservaciones);
		
		btnIncrementarEstado = new JButton("Incrementar Estado");
		btnIncrementarEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				incrementarEstado();
				Conector.revision();
				ct.getDatos();
			}
		});
		btnIncrementarEstado.setBounds(12, 205, 157, 25);
		panel.add(btnIncrementarEstado);
		
		btnActualizarPrecio = new JButton("Actualizar Precio");
		btnActualizarPrecio.setBounds(181, 205, 157, 25);
		btnActualizarPrecio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ActualizarPrecio(index);
			}
		});
		panel.add(btnActualizarPrecio);
		
		btnSave = new JButton("Guardar");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Actualizar.this.GuardarDatos();
				Conector.revision();
			}
		});
		btnSave.setBounds(12, 167, 157, 25);
		panel.add(btnSave);
		
		control = new JTextPane();
		control.setBounds(346, 153, 222, 85);
		panel.add(control);
	}
}

