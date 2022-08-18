package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import funciones.Utilidades;


public class VentanaCalculaMedia extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JLabel lblNota;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalculaMedia frame = new VentanaCalculaMedia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCalculaMedia() {
		setTitle("Calcular media MF0227");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][107.00,grow][][][grow][][][][grow]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 1 1,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 2 1 8 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("UF2404:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 1 3,alignx trailing");
		
		txt4 = new JTextField();
		contentPane.add(txt4, "cell 2 3,growx");
		txt4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("UF2405:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2, "cell 4 3,alignx trailing");
		
		txt5 = new JTextField();
		contentPane.add(txt5, "cell 5 3,growx");
		txt5.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("UF2406");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3, "cell 8 3,alignx trailing");
		
		txt6 = new JTextField();
		contentPane.add(txt6, "cell 9 3,growx");
		txt6.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular Nota");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		contentPane.add(btnCalcular, "cell 4 6");
		
		JLabel lblNewLabel_6 = new JLabel("Nota Media:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_6, "cell 1 7");
		
		lblNota = new JLabel("0.0");
		lblNota.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNota, "cell 2 7");
		
		JLabel lblNewLabel_5 = new JLabel("Resultado:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_5, "cell 1 8");
		
		lblResultado = new JLabel("No calculado a\u00FAn");
		lblResultado.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblResultado, "cell 2 8");
	}
	
	protected void calcular() {
		if (txtNombre.getText()==null || txtNombre.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, 
					"Debe introducir el nombre",
					"Compruebe los datos", JOptionPane.WARNING_MESSAGE);
			
			return;
		} else {			
		String nombre = txtNombre.getText();
		double nota4 = Double.parseDouble(txt4.getText());
		double nota5 = Double.parseDouble(txt5.getText());
		double nota6 = Double.parseDouble(txt6.getText());
		
		double nota = (nota4 + nota5 + nota6)/3;
	
		lblNota.setText(""+nota);
		lblResultado.setText(nombre + " ha sacado un " + devuelveNota(nota));
		
	}

}
	
	
	public String devuelveNota(double nota) {
		String descripcion = "Matrícula";
		
		if (nota<0.0 || nota >10) {
			throw new ArithmeticException("La nota debe estar entre 0.0 y 10");
		} else if (nota<5.0) {
			descripcion="Suspenso";
		} else if (nota <6.5) {
			descripcion = "Bien";
		} else if (nota<8.5) {
			descripcion ="Notable";
		} else if (nota<10) {
			descripcion ="Sobresaliente";
		} else {
			descripcion = "Matrícula";
		}
		
		return descripcion;
	}
}
