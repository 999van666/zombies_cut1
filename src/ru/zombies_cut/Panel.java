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
	public static boolean controlmenue=false;

    public static boolean easy=true;
    public static boolean norm=false;
    public static boolean hard=false;
    public static boolean aud=true;
    public static boolean control=true;

    public static ControlMenue c_menue;

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

			 c_menue=new ControlMenue();

			 image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
			 g = (Graphics2D) image.getGraphics();

			 buttons = new ArrayList<SettMenue>();
			 buttons.add(new SettMenue(300,45,100,37,"","легко"));
			 buttons.add(new SettMenue(570,45,100,37,"","средне"));
			 buttons.add(new SettMenue(840,45,100,37,"","Невыносимо"));

			 buttons.add(new SettMenue(300,190,100,37,"","вкл"));
			 buttons.add(new SettMenue(600,190,100,37,"","выкл"));

			 buttons.add(new SettMenue(300,345,100,37,"","стандарт"));
			 buttons.add(new SettMenue(600,345,100,37,"","пользоват"));

			 buttons.add(new SettMenue(970,570,100,37,"","назад"));



			 addMouseListener(new Listeners());
			 addKeyListener(new Listeners());
			 addMouseMotionListener(new Listeners());
			 
		 }
		 public void actionPerformed(ActionEvent e) {
			 if (state.equals(STATES.MENUE)) {
				 
				 back.draw(g);
				 if(buttmenue) {
					 menue.draw(g);
					 moveButt(menue.button1);
					 moveButt(menue.button2);
					 moveButt(menue.button3);
					 moveButt(menue.button4);
					 moveButt(menue.button5);
				 }
				 if(settmenue){
                 moveSettButt();
				 }
                 if(controlmenue){
                     c_menue.moveContr(c_menue.button_up);
                     c_menue.moveContr(c_menue.button_d);
                     c_menue.moveContr(c_menue.button_l);
                     c_menue.moveContr(c_menue.button_r);
                     c_menue.moveContr(c_menue.button_f);
                     c_menue.moveContr(c_menue.button_k);
                 }
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
				          if (e.equals(menue.button2)) {e.f="game";
				          if(Menue.click){
				          	state=STATES.PLAY;
				          	Menue.click=false;
						  }

				          }
				          if (e.equals(menue.button3)) {e.f="settings";
				          if (Menue.click){
				          Panel.settmenue=true;
							  Panel.buttmenue=false;}
						  }
				          if (e.equals(menue.button4)) {e.f="specification";}
				          if (e.equals(menue.button5)) {e.f="exit";
				          if (Menue.click){
				          System.exit(0);}
						  }}
			  
					 else {e.s="menu/ser.png";
					  if (e.equals(menue.button1)) {e.f="Новый игрок";}
			          if (e.equals(menue.button2)) {e.f="Играть";}
			          if (e.equals(menue.button3)) {e.f="Настройки";}
			          if (e.equals(menue.button4)) {e.f="Правила";}
			          if (e.equals(menue.button5)) {e.f="Выход";}}
				
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
                        c_menue.button_up.f="ввехр";
                        c_menue.button_d.f="вниз";
                        c_menue.button_l.f="влево";
                        c_menue.button_r.f="вправо";
                        c_menue.button_f.f="рубить";
                    }
                }
                if(i==6){
                    if(Menue.click){
                        control=true;
                        settmenue=false;
                        controlmenue=false;

                    } }
                if(i==7){
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

