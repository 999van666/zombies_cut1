package ru.zombies_cut;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON1){
		       if (Panel.state==Panel.STATES.MENUE) {
				Menue.click = true;	
				} 
			}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON1){
		       if (Panel.state==Panel.STATES.MENUE) {
				Menue.click = false;	
				} 
			}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// TODO Auto-generated method stub
		if (key == KeyEvent.VK_ESCAPE) {
			if (Panel.state == Panel.STATES.PLAY) Panel.state = Panel.STATES.MENUE;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


