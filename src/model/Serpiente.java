package model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.game;


public class Serpiente extends Thread{

	public static int DERECHA=1,IZQUIERDA=2,ARRIVA=4,ABAJO=5;
	private int posX,posY,posAX,posAY,dir,dirAnterior;
	private Image serpiente;
	protected game game;
	private boolean restando,sumando,siguientePosicion;
	private int puntaje;

	public Serpiente(Image serpiente,game game) {
		puntaje=0;
		posY = game.getHeight()/2;
		posX = game.getWidth()/2;
		
		while(getPosY()%50!=0) {
			setPosY(getPosY()-1);	
		}
		while(getPosX()%50!=0) {
			setPosX(getPosX()-1);	
		}
		
		posAX=getPosX()-50;
		posAY=getPosY();
		
		siguientePosicion=true;
		restando=false;
		sumando=false;
		this.game = game;
		this.serpiente=serpiente;

	}

	public void posicionAnteriorDerecha() {
		 if(getPosY()==getPosAY())
			setPosAX(getPosAX()+1);
		 
		else if(getPosY()>getPosAY())
			setPosAY(getPosAY()+1);
		else if(getPosY()<getPosAY())
			setPosAY(getPosAY()-1);

	}
	
	public void posicionAnteriorIzquierda() {	
		if(getPosY()>getPosAY())
			setPosAY(getPosAY()+1);
		else if(getPosY()<getPosAY())
			setPosAY(getPosAY()-1);
		else if(getPosY()==getPosAY())
			setPosAX(getPosAX()-1);
	}
	
	public void posicionAnteriorArriba() {
		if(getPosX()>getPosAX())
			setPosAX(getPosAX()+1);
		else if(getPosX()<getPosAX())
			setPosAX(getPosAX()-1);
		else if(getPosX()==getPosAX())
			setPosAY(getPosAY()-1);
	}
	
	public void posicionAnteriorAbajo() {
		if(getPosX()==getPosAX())
			setPosAY(getPosAY()+1);
		
		else if(getPosX()>getPosAX())
			setPosAX(getPosAX()+1);
		else if(getPosX()<getPosAX())
			setPosAX(getPosAX()-1);
	}
	
	public void MoverArriba() {
		posicionAnteriorArriba();
		if(getPosX()%50==0) {
			setPosY(getPosY()-1);
			restando=true;
		}					
		if(sumando && getPosX()%50!=0) {
			setPosX(getPosX()+1);
		}else if(getPosX()%50==0){
			sumando=false;
		}
		if(restando && getPosX()%50!=0 && !sumando) {
			setPosX(getPosX()-1);
		}
		
	}
	
	public void MoverIzquierda() {
		posicionAnteriorIzquierda();
		if(getPosY()%50==0) {
			setPosX(getPosX()-1);
			restando=true;
		}
		if(sumando && getPosY()%50!=0 && !restando) {
			setPosY(getPosY()+1);
		}else if(getPosY()%50==0){
			sumando=false;
		}
		if(restando && getPosY()%50!=0) {
			setPosY(getPosY()-1);
		}
	}
	
	public void MoverAbajo() {
		posicionAnteriorAbajo();
		if(getPosX()%50==0) {
			setPosY(getPosY()+1);
			sumando=true;						
		}
		
		if(sumando && getPosX()%50!=0) {
			setPosX(getPosX()+1);
		}
		
		if(restando && getPosX()%50!=0) {
			setPosX(getPosX()-1);
			}else if(getPosX()%50==0){
			restando=false;
		}
	}
	
	public void MoverDerecha() {
		posicionAnteriorDerecha();
		if(getPosY()%50==0) {
			setPosX(getPosX()+1);
			sumando=true;
		}
		
		if(sumando && getPosY()%50!=0) {
			setPosY(getPosY()+1);
		}
		
		if(restando && getPosY()%50!=0) {
			setPosY(getPosY()-1);
		}else if(getPosY()%50==0){
			restando=false;
		}
	}
	
	public void run() {
		boolean band=false;
		while(true) {
			if(posX>50&&posX<game.getWidth()-15 && posY>25&&posY<game.getHeight()-15) {
				
					if (checkCollision(game.manzanas.get(0))) {
						game.manzanas.remove(0);
						puntaje++;
					}

					if(dir==ARRIVA && siguientePosicion) {
						MoverArriba();
					}
					
					if(dir==IZQUIERDA && siguientePosicion) {
						MoverIzquierda();
					}
					
					if(dir==ABAJO  && siguientePosicion) {
						MoverAbajo();					
					}
					
					if(dir==DERECHA && siguientePosicion) {
						MoverDerecha();
					}

					if(!band) {
						if(getPosY()%50==0 && getPosX()%50==0){
							band=true;
							dir=DERECHA;
						}
					}
				game.repaint();
			}else {	
				JOptionPane.showMessageDialog(game, "Moriste");
				System.exit(0);
				break;
			}

			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Image getSerpiente() {
		return serpiente;
	}

	public void setSerpiente(Image serpiente) {
		this.serpiente = serpiente;
	}
	
	public int getPosAX() {
		return posAX;
	}

	public void setPosAX(int posAX) {
		this.posAX = posAX;
	}

	public int getPosAY() {
		return posAY;
	}

	public void setPosAY(int posAY) {
		this.posAY = posAY;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public boolean checkCollision(Serpiente other){
		Rectangle myRect = new Rectangle();
		Rectangle otherRect = new Rectangle();
		myRect.setBounds(getPosX(), getPosY(), 50, 50);
		otherRect.setBounds(other.getPosX()+50, other.getPosY()+50, 50, 50);

		return myRect.intersects(otherRect);
	}
}
