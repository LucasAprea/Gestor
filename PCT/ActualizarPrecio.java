package PCT;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActualizarPrecio {

	private JFrame frame;
	private JTextField textField;
	private Telefono tel;

	public ActualizarPrecio(Telefono t) {
		initialize();
		tel = t;
		frame.setVisible(true);
	}

	private void Guardar() {
		if(textField.getText() != "") {
			tel.valorArreglo = Double.parseDouble(textField.getText());
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 354, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPrecioNuevo = new JLabel("Precio Nuevo");
		lblPrecioNuevo.setBounds(12, 13, 98, 16);
		frame.getContentPane().add(lblPrecioNuevo);
		
		textField = new JTextField();
		textField.setBounds(111, 10, 186, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Guardar();
			}
		});
		btnAceptar.setBounds(227, 62, 97, 25);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(12, 62, 97, 25);
		frame.getContentPane().add(btnCancelar);
	}
}
