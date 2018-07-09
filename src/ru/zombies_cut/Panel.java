package ru.zombies_cut;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static int mouseX;
	public static int mouseY;
	
	public static enum STATES{MENUE,PLAY}
	public static STATES state = STATES.MENUE;
	
	private BufferedImage image;
	private Graphics2D g;
	
	Timer mainTimer = new Timer (30, this);
	Back back = new Back();
	Menue menue = new Menue();

		 public Panel() {
			 super();
			 setFocusable(true);
			 requestFocus();
			 image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
			 g = (Graphics2D) image.getGraphics();
			 mainTimer.start();
			
		 }
		 public void actionPerformed(ActionEvent e) {
			 if (state.equals(STATES.MENUE)) {
				 back.draw(g);
				 menue.draw(g);
				 if (Panel.mouseX>menue.getX()&& Panel.mouseX < menue.getX()+menue.getW()&& Panel.mouseY> (menue.getY()+140)*0 && Panel.mouseY< (menue.getY()+140)*0 + menue.getH()){
			                         menue.list[0]="new user";
			                         menue.user_m=true;
						 }
				 else { 
				      menue.list[0]=String.valueOf("Новый Игрок"); 
				      menue.user_m=false; 
				             }
				 
				 if (Panel.mouseX>menue.getX()&& Panel.mouseX < menue.getX()+menue.getW()&& Panel.mouseY> (menue.getY()+140)*1 && Panel.mouseY< (menue.getY()+140)*1 + menue.getH()){
			                         menue.list[1]="games";
			                         menue.game_m=true;
			     if (Menue.click) {
			                        	 state = STATES.PLAY;
			                        	 Menue.click=false;
			                         }
						 }
				 else { 
				      menue.list[1]=String.valueOf("Играть"); 
				      menue.game_m=false; 
				             }
				 
				 if (Panel.mouseX>menue.getX()&& Panel.mouseX<menue.getX()+menue.getW()&& Panel.mouseY>(menue.getY()+140)*2 && Panel.mouseY<(menue.getY()+140)*2+menue.getH()){
							 menue.list[2]="settings";
						 }
				 else { 
				            	 menue.list[2]=String.valueOf("Настройки"); 
				            	 
				             }
				 
				 if (Panel.mouseX>menue.getX()&& Panel.mouseX<menue.getX()+menue.getW() && Panel.mouseY>(menue.getY()+140)*3 && Panel.mouseY<(menue.getY()+140)*3+menue.getH()){
							 menue.list[3]="Help";
						 }
				 else { 
				            	 menue.list[3]=String.valueOf("Помощь"); 
				            	 
				             }
				 
				 if (Panel.mouseX>menue.getX()&& Panel.mouseX<menue.getX()+menue.getW() && Panel.mouseY>(menue.getY()+140)*4 && Panel.mouseY<(menue.getY()+140)*4+menue.getH()){
							 menue.list[4]="Exit";
				             if (Menue.click)
	                         {
	                        	System.exit(0);
	                         }
						 }
				 else { 
				            	 menue.list[4]=String.valueOf("Выход"); 
				            	 
				             }
				 gameDraw();	 
			 }
		 
		     if (state.equals(STATES.PLAY)) {
		    	 gameRender();
		    	 gameDraw();
		     }
		 }
		  
		private void gameRender() {
			 back.draw(g);
			
		}
		private void gameDraw() {
			
			Graphics g2 = this.getGraphics();
			 g2.drawImage(image, 0, 0, null);
			 g2.dispose();
		}
}

