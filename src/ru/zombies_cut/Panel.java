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

