package PCT;

import java.util.ArrayList;

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

	private JFrame frmConsultarTelefono;
	private Telefono[] telefonos;
	private ArrayList<Telefono> t;
	private Choice choice;
	private JCheckBox mostrarClave;
	private JTextPane detalle;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JButton btnBorrar;
	
	private Main m;
	
	public Consultar(ArrayList<Telefono> tel, Main m) {
		initialize();
		this.m = m;
		t = tel;
		Listar();
		frmConsultarTelefono.setVisible(true);
	}
		
	private void initialize() {
		frmConsultarTelefono = new JFrame();
		frmConsultarTelefono.setTitle("Consultar");
		frmConsultarTelefono.setBounds(100, 100, 500, 600);
		frmConsultarTelefono.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmConsultarTelefono.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		choice = new Choice();
		choice.setBounds(101, 10, 369, 22);
		panel.add(choice);
		
		Label label = new Label("Numero ");
		label.setBounds(25, 10, 70, 24);
		panel.add(label);
		
		mostrarClave = new JCheckBox("Mostrar Contrase\u00F1a");
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
	}
	private void Listar() {
		choice.removeAll();
		if(!t.isEmpty()) {
			Object[] aux = t.toArray();
			telefonos = new Telefono[aux.length];
			if(aux != null) {
				for(int i=0; aux.length>i;i++) {
					Telefono temp = (Telefono)aux[i];
					telefonos[i] = temp;
					choice.add(temp.getNumero());
				}
			}
		}
		
	}
	private void actualizar() {
		int index = choice.getSelectedIndex();
		new Actualizar(telefonos[index],m,this);
	}
	void getDatos() {
		int index = choice.getSelectedIndex();
		if(index != -1) {
			Telefono aux = telefonos[index];
			detalle.setText(aux.toString(mostrarClave.isSelected()));
		}
	}
	
	private void eliminar() {	
		
		t.remove(choice.getSelectedIndex());
		Listar();
	}
}