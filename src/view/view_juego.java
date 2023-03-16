package view;

import java.awt.EventQueue;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logica_juego;
import model.Comida;
import model.Serpiente;
import model.cuerpo;

import java.io.File;
import java.io.IOException;

public class view_juego extends JFrame {

	public JPanel contentPane;
	private game gm;
	private logica_juego lj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_juego frame = new view_juego();
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
	public view_juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 Image character;
		 Image comida;
			try {
				character = ImageIO.read(new File("graphics/serpiente.png"));
				character.getScaledInstance(50, 50, 50);
				comida = ImageIO.read(new File("graphics/manzana.png"));
				comida.getScaledInstance(25, 25, 25);
				gm = new game();
				gm.setBounds(0, 0, getWidth(), getHeight());
				gm.serpiente = new Serpiente(character,gm);
				for(int i=0;i<200;i++) {
					Comida manzana=new Comida(comida, gm);
					gm.manzanas.add(manzana);
				}
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		contentPane.add(gm);
		
		lj=new logica_juego(gm,this);
	}
}
