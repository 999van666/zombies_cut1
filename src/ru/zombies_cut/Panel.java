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
	Player player=new Player();
	Menue menue = new Menue();

		 public Panel() {
			 super();
			 setFocusable(true);
			 requestFocus();
			 mainTimer.start();
			 image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
			 g = (Graphics2D) image.getGraphics();
			 
			 addMouseListener(new Listeners());
			 addKeyListener(new Listeners());
			 addMouseMotionListener(new Listeners());
			 
		 }
		 public void actionPerformed(ActionEvent e) {
			 if (state.equals(STATES.MENUE)) {
				 
				 back.draw(g);
				 menue.draw(g);
				 moveButt(menue.button1);
				 moveButt(menue.button2);
				 moveButt(menue.button3);
				 moveButt(menue.button4);
				 moveButt(menue.button5);
				 gameDraw();	 
			 }

		     if (state.equals(STATES.PLAY)) {
		    	 gameUpdate();
		    	 gameRender();
		    	 gameDraw();
		     }
		 }
		  private void moveButt(Menue.ButtMenue e) {
			  if (  mouseX>e.getX() && mouseX<e.getX()+e.getW()  &&
						 mouseY>e.getY() && mouseY<e.getY()+e.getH()) {
				          e.s="menu/ред.png";
				          if (e.equals(menue.button1)) {e.f="new user";}
				          if (e.equals(menue.button2)) {e.f="game";}
				          if (e.equals(menue.button3)) {e.f="settings";}
				          if (e.equals(menue.button4)) {e.f="specification";}
				          if (e.equals(menue.button5)) {e.f="exit";}}
			  
					 else {e.s="menu/ser.png";
					  if (e.equals(menue.button1)) {e.f="Новый игрок";}
			          if (e.equals(menue.button2)) {e.f="Играть";}
			          if (e.equals(menue.button3)) {e.f="Настройки";}
			          if (e.equals(menue.button4)) {e.f="Правила";}
			          if (e.equals(menue.button5)) {e.f="Выход";}}
				
		  }
		private void gameRender() {
			 back.draw(g);
			 player.draw(g);
		}
	
		private void gameUpdate() {
			player.update();
			
		}
		private void gameDraw() {
			
			Graphics g2 = this.getGraphics();
			 g2.drawImage(image, 0, 0, null);
			 g2.dispose();
		}
}

