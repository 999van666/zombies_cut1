package ru.zombies_cut;

import java.awt.*;
import javax.swing.*;

public class Menue {
    private int n;
    private Color color1;
    private double x;
    private double y;
    private double w;
    private double h;
    public boolean user_m=false;
    public boolean game_m=false;
    public static boolean click = false;
    private String img ;
    
    String  [] list = new String[5];
   
    public Menue() {
    	x=20;
    	y=0;
    	w=396;
    	h=100;
    	n=5;
    	color1=Color.GREEN;
    	img= "menu/кнопка.png";
    	
    	list[0] ="Новый Игрок";
    	list[1] ="Играть";
    	list[2] ="Настройки";
    	list[3] ="Помощь";
    	list[4] ="Выход";
    	
    }
    //getters
    public double getX() {
    	return x;
    }
    public double getY() {
    	return y;
    }
    public double getW() {
    	return w;
    }
    public double getH() {
    	return h;
    }
    
    public void update() {
    	
    }
    
    public void draw(Graphics2D g) {
    	for (int i=0; i<n; i++) {
    	g.drawImage(new ImageIcon(img).getImage(), (int) x, (int) (y+140)*i,null );
       
    	g.setColor(color1);
    	Font font = new Font ("Arial", Font.ITALIC, 40  );
        g.setFont(font);
        long length = (int) g.getFontMetrics().getStringBounds(list[i],  g).getWidth();
        g.drawString(list[i], (int) (x+w/2) - (int) (length/2), (int) ((y+140)*i +(h/3)*2));
    	}
    	
    	if (user_m) {
    		Font font = new Font("Arial", Font.ITALIC, 30  );
    		g.setFont(font);
    		g.drawString("Придумайте имя для входа в игру",500,400);
    		g.drawString("сохронение прогресса",500,70);
    	}
    	
    	if (game_m) {
    		g.drawImage(new ImageIcon ("menu/121395927.gif").getImage(), 200, 200, null);
    		Font font = new Font("Arial", Font.ITALIC, 30  );
    		g.setFont(font);
    		g.drawString("Начать игру",500,200);
    	}
    }
    
    
    
}