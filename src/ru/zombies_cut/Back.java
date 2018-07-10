package ru.zombies_cut;

import javax.swing.*;

import java.awt.*;

public class Back {
	
	Image img1 = new ImageIcon("menu/anigif2.gif").getImage();
	
	Image img2 = new ImageIcon("maps/main_island/img/main_island_atlas.png").getImage();
	
	public void draw(Graphics2D g) {  
		
		if(Panel.state.equals(Panel.STATES.MENUE)) g.drawImage(img1,(int)0,(int)0,null);
		
		if(Panel.state.equals(Panel.STATES.PLAY))  g.drawImage(img2,(int)0,(int)0,null);
        
		
	}
}

