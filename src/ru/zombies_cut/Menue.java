package ru.zombies_cut;

import java.awt.*;
import javax.swing.*;

public class Menue {
	public static boolean click = false;
	
  ButtMenue button1 = new ButtMenue(10,0,396,100,"menu/ser.png","Новый игрок");
  ButtMenue button2 = new ButtMenue(10,150,396,100,"menu/ser.png","Играть");
  ButtMenue button3 = new ButtMenue(10,300,396,100,"menu/ser.png","Настройки");
  ButtMenue button4 = new ButtMenue(10,450,396,100,"menu/ser.png","Правила");
  ButtMenue button5 = new ButtMenue(10,600,396,100,"menu/ser.png","Выход");
	
  public void draw (Graphics2D g) {
	  button1.draw(g);
	  button2.draw(g);
	  button3.draw(g);
	  button4.draw(g);
	  button5.draw(g);
  }
  
  
  class ButtMenue{
		
	    private double x;
	    private double y;
	    private double w;
	    private double h;
	    public Color color1;
	    public String f;
	    public String s;
	    
	    public ButtMenue (int x, int y, int w, int h, String s, String f) {
	    	this.x=x;
	    	this.y=y;
	    	this.w=w;
	    	this.h=h;
	    	this.f=f;
	    	this.s=s;
	    	color1 = Color.GREEN;
	   
	    }
	    
	    //gets
	    public double getX() {return x;}
	    public double getY() {return y;}
	    public double getW() {return w;}
	    public double getH() {return h;}
	    
	public void draw(Graphics2D g) {
    	g.drawImage(new ImageIcon(s).getImage(), (int) x, (int) y, null );
           	g.setColor(color1);
    	Font font = new Font ("Arial", Font.ITALIC, 40  );
        g.setFont(font);
        long length = (int) g.getFontMetrics().getStringBounds(f,  g).getWidth();
        g.drawString(f, (int) (x+w/3) - (int) (length/2.5), (int) y + (int) (h/3)*2);
       
    	}
    
    
}
}