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

	private JFrame frmActualizarTelefono;
	private JTextField dueno;
	private JTextField contrasena;
	private JTextField numero;
	private JTextField modelo;
	private JLabel lblContrasea;
	private JLabel lblNumero;
	private JLabel lblModelo;
	private JTextField observaciones;
	private JLabel lblObservaciones;
	private JButton btnIncrementarEstado;
	private JButton btnActualizarPrecio;
	private JButton btnNewButton;
	private Main main;
	private Telefono t;
	private JTextPane control;
	private Consultar ct;
	
	public Actualizar(Telefono t, Main m, Consultar tel) {
		initialize();
		this.t = t;
		main = m;
		ct = tel;
		colocarContenido(this.t);
		frmActualizarTelefono.setVisible(true);
	}
	private void colocarContenido(Telefono t) {
		dueno.setText(t.dueno);
		contrasena.setText(t.contrasena);
		numero.setText(t.numero);
		modelo.setText(t.modelo);
	}
	private void GuardarDatos() {
		t.dueno = dueno.getText();
		t.contrasena = contrasena.getText();
		t.modelo = modelo.getText();
		t.numero = numero.getText();
		t.setObeservaciones(observaciones.getText());
		ct.getDatos();
		frmActualizarTelefono.dispose();
	}
	private void incrementarEstado() {
		t.incrementarEstado();
		control.setText("Se Incremento el Estado \nValor Actual: " + Telefono.estados[t.estado]);
	}
	private void initialize() {
		Math.abs(5);
		frmActualizarTelefono = new JFrame();
		frmActualizarTelefono.setTitle("Actualizar Telefono");
		frmActualizarTelefono.setBounds(100, 100, 598, 298);
		frmActualizarTelefono.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmActualizarTelefono.getContentPane().add(panel, BorderLayout.CENTER);
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
				main.Revision();
				ct.getDatos();
			}
		});
		btnIncrementarEstado.setBounds(12, 205, 157, 25);
		panel.add(btnIncrementarEstado);
		
		btnActualizarPrecio = new JButton("Actualizar Precio");
		btnActualizarPrecio.setBounds(181, 205, 157, 25);
		panel.add(btnActualizarPrecio);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Actualizar.this.GuardarDatos();
				main.Revision();
			}
		});
		btnNewButton.setBounds(12, 167, 157, 25);
		panel.add(btnNewButton);
		
		control = new JTextPane();
		control.setBounds(346, 153, 222, 85);
		panel.add(control);
	}
}

