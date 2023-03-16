package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Serpiente;
import view.game;
import view.view_juego;


public class logica_juego implements KeyListener{

	private game gam;
	
	public logica_juego(game gam, view_juego vj) {
		// TODO Auto-generated constructor stub
		this.gam=gam;
		gam.serpiente.start();
		for(int i=0;i<gam.manzanas.size();i++) {
			gam.manzanas.get(i).start();
		}
		
		vj.addKeyListener(this);
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			gam.serpiente.setDir(gam.serpiente.ARRIVA);
			break;
		case KeyEvent.VK_A:
			gam.serpiente.setDir(gam.serpiente.IZQUIERDA);
			break;
		case KeyEvent.VK_S:
			gam.serpiente.setDir(gam.serpiente.ABAJO);
			break;
		case KeyEvent.VK_D:
			gam.serpiente.setDir(gam.serpiente.DERECHA);
			break;
		default:System.out.println("ok");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
