package PCT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Agregar {

	private JFrame frmAgregar;
	private JTextField dueno;
	private JTextField contrasena;
	private JTextField comentarios;
	private JTextField numero;
	private JTextField modelo;
	
	public Agregar() {
			initialize();
		}
	
	private void initialize() {
		frmAgregar = new JFrame();
		frmAgregar.setTitle(Conector.getTitle(1));
		frmAgregar.setBounds(100, 100, 450, 383);
		frmAgregar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {	
			frmAgregar.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		frmAgregar.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		dueno = new JTextField();
		dueno.setBounds(100, 31, 116, 22);
		panel.add(dueno);
		dueno.setColumns(10);
		
		contrasena = new JTextField();
		contrasena.setBounds(100, 66, 116, 22);
		panel.add(contrasena);
		contrasena.setColumns(10);
		
		comentarios = new JTextField();
		comentarios.setBounds(100, 143, 300, 100);
		panel.add(comentarios);
		comentarios.setColumns(10);
		
		numero = new JTextField();
		numero.setBounds(100, 256, 116, 22);
		panel.add(numero);
		numero.setColumns(10);
		
		JLabel lblDueo = new JLabel("Dueño");
		lblDueo.setBounds(12, 34, 56, 16);
		panel.add(lblDueo);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setBounds(12, 69, 76, 16);
		panel.add(lblNewLabel);
		
		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setBounds(12, 140, 76, 16);
		panel.add(lblComentarios);
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setBounds(12, 259, 56, 16);
		panel.add(lblNumero);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Conector.agregar(dueno.getText(),modelo.getText(), contrasena.getText(),comentarios.getText(),numero.getText());
				frmAgregar.dispose();
			}
		});
		btnAgregar.setBounds(323, 298, 97, 25);
		panel.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAgregar.dispose();
			}
		});
		btnCancelar.setBounds(12, 298, 97, 25);
		panel.add(btnCancelar);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 111, 56, 16);
		panel.add(lblModelo);
		
		modelo = new JTextField();
		modelo.setBounds(100, 108, 116, 22);
		panel.add(modelo);
		modelo.setColumns(10);
	}
}
