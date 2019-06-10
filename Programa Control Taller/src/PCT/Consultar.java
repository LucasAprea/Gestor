package PCT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Consultar {

	private JFrame frmConsultar;
	private Choice choice;
	private JCheckBox mostrarClave;
	private JTextPane detalle;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JButton btnBorrar;
	
	public Consultar() {
		initialize();
		Listar();
		frmConsultar.setVisible(true);
	}
		
	private void initialize() {
		frmConsultar = new JFrame();
		frmConsultar.setTitle("Consultar");
		frmConsultar.setBounds(100, 100, 500, 600);
		frmConsultar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmConsultar.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		choice = new Choice();
		choice.setBounds(101, 10, 265, 22);
		panel.add(choice);
		
		Label label = new Label("Numero ");
		label.setBounds(25, 10, 70, 24);
		panel.add(label);
		
		mostrarClave = new JCheckBox("Mostrar Contraseña");
		mostrarClave.setBounds(8, 43, 144, 25);
		panel.add(mostrarClave);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultar.this.getDatos();
			}
		});
		btnBuscar.setBounds(160, 43, 97, 25);
		panel.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 77, 458, 463);
		panel.add(scrollPane);
		
		detalle = new JTextPane();
		detalle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(detalle);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultar.this.actualizar();
			}
		});
		btnActualizar.setBounds(373, 43, 97, 25);
		panel.add(btnActualizar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar();
			}
		});
		btnBorrar.setBounds(269, 43, 97, 25);
		panel.add(btnBorrar);
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Listar();
			}
		});
		btnRefrescar.setBounds(373, 10, 97, 25);
		panel.add(btnRefrescar);
	}
	
	private void Listar() {
		choice.removeAll();
		String[] telefonos = Conector.getTelefonos();
		for(int i=0; telefonos.length>i;i++) {
			choice.add(telefonos[i]);	
		}
	}
	
	private void actualizar() {
		int index = choice.getSelectedIndex();
		new Actualizar(index,this);
	}
	void getDatos() {
		int index = choice.getSelectedIndex();
		if(index != -1) {
			String texto = Conector.detalles(index,mostrarClave.isSelected());
			detalle.setText(texto);
		}
	}
	
	private void eliminar() {	
		
		Conector.eliminar(choice.getSelectedIndex());
		Listar();
	}
}