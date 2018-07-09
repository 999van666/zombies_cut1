package ru.zombies_cut;

import java.awt.*;
import javax.swing.*;

public class Menu {
    private int n;
    private Color color1;
    private double x;
    private double y;
    private double w;
    private double h;
    
    private String img ;
    
    String  [] list = new String[3];
   
    public Menu() {
    	x=20;
    	y=120;
    	w=396;
    	h=100;
    	n=3;
    	color1=Color.GREEN;
    	img= "menu/кнопка.png";
    	
    	list[0] ="Играть";
    	list[1] ="Настройки";
    	list[2] ="Выход";
    	
    }
    
    public void update() {
    	
    }
    
    public void draw(Graphics2D g) {
    	for (int i=0; i<n; i++) {
    	g.drawImage(new ImageIcon(img).getImage(), (int) x, (int) (y+100)*i,null );
       
    	g.setColor(color1);
    	Font font = new Font ("Arial", Font.ITALIC, 40  );
        g.setFont(font);
        long length = (int) g.getFontMetrics().getStringBounds(list[i],  g).getWidth();
        g.drawString(list[i], (int) (x+w/3) - (int) (length/2), (int) ((y+100)*i +(h/2)*2));
    	}
    }
    
    
    
}
