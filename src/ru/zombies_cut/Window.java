package ru.zombies_cut;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class Window {


		public static void main (String[] args) {
			JFrame f = new JFrame ("Java zombies_cut");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setLocation(0,0);
			Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	        f.setSize(screenSize);
	        f.setSize(1280,720);
			f.add(new Panel());
			f.setResizable(false);
			f.setLocationRelativeTo(null);
	        f.setVisible(true);
	        
	       
		

	}

}