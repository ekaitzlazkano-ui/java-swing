package es.ingenieria.swing.p2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private static String ultimo = " ";
	
	

	public Calculadora() throws HeadlessException {
		
		//VENTANA
		setTitle("Calculadora Básica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10,10));
		
		//COLORES
		Color blanco = new Color(255,255,255);
		
		
		
		//pantalla
		
		JTextField pantalla = new JTextField("");
		pantalla.setBackground(blanco);
		pantalla.setEditable(true);
		pantalla.setFont(new Font("Courier", Font.BOLD, 24));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		add(pantalla, BorderLayout.NORTH);
		
		
		//panel de botones
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(4,4,10,10));
		String[] buttonsText = {
				"7", "8", "9", "/",
				"4", "5", "6", "*",
				"1", "2", "3", "-",
				"0", ".", "=", "+"
				};
		for (String s: buttonsText) {
			JButton boton = new JButton(s);
			boton.setBackground(blanco);
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String textoAnterior = pantalla.getText();
					for (char c: ultimo.toCharArray()) {
						for (char schar: s.toCharArray()) {
							
							
							if (!Character.isDigit(c) && (!Character.isDigit(schar))) { //dos simbolos seguidos
								
								
								if (ultimo.equals(" ") && (s.equals("-"))) {		//Excepción por número negativo
									ultimo = s;
									pantalla.setText(s);
								} else {
								JOptionPane.showMessageDialog(null, "No puedes poner un símbolo ahí", "ERROR", JOptionPane.WARNING_MESSAGE);
								}
								
								
						 } else if(s.equals("=")) {
							 JOptionPane.showMessageDialog(null, "Y ahora calculamos el resultado", "AVISO", JOptionPane.INFORMATION_MESSAGE);
							 pantalla.setText("");
						 }
							else { //correcto
							 pantalla.setText(textoAnterior +s);
								ultimo = s;
						 }
						}
					}
				}
			});
			
			buttonPanel.add(boton);
		}
		add(buttonPanel, BorderLayout.CENTER);
		
		//bordes
		
	
		
		
	}



	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		calculadora.setVisible(true);
	}
	
	

}
