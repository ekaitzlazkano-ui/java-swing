package es.ingenieria.swing.p1;



import java.awt.Color;

import javax.swing.JFrame;


public class JFrameHolaMundo extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public JFrameHolaMundo(){
		setTitle("Hola Mundo");
		setSize(300,200);	
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		getContentPane().setBackground(new Color(255, 170, 150));
		
	}

	public static void main(String[] args) {
		JFrameHolaMundo jframeHolaMundo = new JFrameHolaMundo();
		jframeHolaMundo .setVisible(true);
	}

}
