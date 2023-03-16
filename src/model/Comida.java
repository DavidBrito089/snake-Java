package model;

import java.awt.Image;

import view.game;

public class Comida extends Serpiente{

	private Image manzana;
	private int tamaño;
	private boolean band;

	public Comida(Image manzana, game game) {
		super(manzana, game);
		this.manzana=manzana;
		band=true;
		tamaño=45;
		// TODO Auto-generated constructor stub
		int numX = (int) (Math.random() * 1251) + 50 ,numY = (int) (Math.random() * 570) + 50;
		
		if(numX%50!=0 || numY%50!=0 ) {
			while(numY%50!=0) {
				numY+=1;
			}
			while(numX%50!=0) {
				numX+=1;
			}
		}
		this.setPosX(numX);
		this.setPosY(numY);
	}
	
	public void run() {
		while(true) {
			if(band) {
				tamaño++;
				if(tamaño==50) {
					band=false;
				}
			}else{
				tamaño--;
				if(tamaño==45) {
					band=true;
				}
			}
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	
	public Image getManzana() {
		return manzana;
	}

	public void setManzana(Image manzana) {
		this.manzana = manzana;
	}
}
