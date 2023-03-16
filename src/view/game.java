package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import controller.logica_juego;
import model.Comida;
import model.Serpiente;
import model.cuerpo;

import java.util.ArrayList;

import javax.swing.JLabel;

public class game extends JPanel {

	public Serpiente serpiente;
	private int cont=0, fila=50;
	public ArrayList <Comida> manzanas;
	
	public game() {
		manzanas = new ArrayList<Comida> ();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setColor(Color.CYAN);
		g2d.fill3DRect(0, 0, getWidth(), getHeight(), true);
		g2d.setColor(new Color(189,245,102));
		g2d.fill3DRect(50, 50, getWidth()-75, getHeight()-100, true);
		g2d.setColor(new Color(150,245,102));
		
		for(int i=1;i<10;i++) {
			cont=i*100;
			for(int j=1;j<30;j++) {
				if(j%2==0) 
					g2d.fill3DRect(j*fila, cont,50, 50, true);
				else {
					g2d.fill3DRect(j*fila, cont-50, 50, 50, true);
				}
			}
		}
		g2d.setColor(Color.CYAN);
		g2d.fill3DRect(0, 650, getWidth(), getHeight(), true);
		g2d.fill3DRect(1300, 0, getWidth(), getHeight(), true);
		g2d.drawImage(manzanas.get(0).getSerpiente(),manzanas.get(0).getPosX(),manzanas.get(0).getPosY(),manzanas.get(0).getTamaño(),manzanas.get(0).getTamaño(),this);
		g2d.drawImage(serpiente.getSerpiente(),serpiente.getPosX()-50,serpiente.getPosY()-50,50,50,this);
		g2d.setColor(Color.GREEN);
		g2d.fillOval(serpiente.getPosAX()-50 , serpiente.getPosAY()-50, 50,50);
		g2d.setColor(Color.DARK_GRAY);
		g2d.setFont(new Font("Impact", Font.BOLD, 32));
		g2d.drawString("Puntaje: "+serpiente.getPuntaje() ,50,50);
	}

}
