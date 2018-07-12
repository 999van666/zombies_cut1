package ru.zombies_cut;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
    //размеры панели
	public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	//координаты мыши
	public static int mouseX;
	public static int mouseY;

	//активные страницы меню
	public static boolean buttmenue =true;
	public static boolean settmenue =false;

    public static boolean easy=true;
    public static boolean norm=false;
    public static boolean hard=false;
    public static boolean aud=true;
    public static boolean control=true;


	public static enum STATES{MENUE,PLAY}//обЪявляем перечесление
	public static STATES state = STATES.MENUE;//изначальная работа с вкл. меню

	private BufferedImage image;
	private Graphics2D g;

	private ArrayList<SettMenue> buttons;

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

			 buttons = new ArrayList<SettMenue>();
			 buttons.add(new SettMenue(300,45,100,37,"","легко"));
			 buttons.add(new SettMenue(570,45,100,37,"","средне"));
			 buttons.add(new SettMenue(840,45,100,37,"","Невыносимо"));

			 buttons.add(new SettMenue(300,190,100,37,"","вкл"));
			 buttons.add(new SettMenue(600,190,100,37,"","выкл"));

			 buttons.add(new SettMenue(300,345,100,37,"","стандарт"));

			 buttons.add(new SettMenue(970,570,100,37,"","назад"));



			 addMouseListener(new Listeners());
			 addKeyListener(new Listeners());
			 addMouseMotionListener(new Listeners());

		 }
		 public void actionPerformed(ActionEvent e) {
			 if (state.equals(STATES.MENUE)) {
                 back.draw(g);
                 if (buttmenue) {
                     menue.draw(g);
                     menue.moveButt(menue.button1);
                     menue.moveButt(menue.button2);
                     menue.moveButt(menue.button3);
                 }

				 if(settmenue){
                 moveSettButt();
				 }

                 gameDraw();
			 }

		     if (state.equals(STATES.PLAY)) {
		    	 gameUpdate();
		    	 gameRender();
		    	 gameDraw();
		     }
		 }

	private void moveSettButt() {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).draw(g);
			if (Panel.mouseX > buttons.get(i).getX() && Panel.mouseX < buttons.get(i).getX() + buttons.get(i).getW() &&
					Panel.mouseY > buttons.get(i).getY() && Panel.mouseY < buttons.get(i).getY() + buttons.get(i).getH()) {
			buttons.get(i).s="menu/черная.png";
			if(i==0){
			    if(Menue.click){
			        easy=true;
			        norm=false;
			        hard=false;
                }
            }
                if(i==1){
                    if(Menue.click){
                        easy=false;
                        norm=true;
                        hard=false;
                    }
                }
                if(i==2){
                    if(Menue.click){
                        easy=false;
                        norm=false;
                        hard=true;
                    }
                }
                if(i==3){
                    if(Menue.click){
                        aud=true;

                    }
                }
                if(i==4){
                    if(Menue.click){
                        aud=false;

                    }
                }
                if(i==5){
                    if(Menue.click){
                        control=true;

                    }
                }

                if(i==6){
                    if(Menue.click){
                        settmenue=false;
                        buttmenue=true;
                    } }
			}
			else{
				buttons.get(i).s="menu/елоу1.png";
			}

		}
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

