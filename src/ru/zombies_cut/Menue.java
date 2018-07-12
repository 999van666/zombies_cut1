package ru.zombies_cut;

		import java.awt.*;
		import javax.swing.*;

public class Menue {
	public static boolean click = false;

	ButtMenue button1 = new ButtMenue(10,10,396,100,"menu/ser.png","Играть");
	ButtMenue button2 = new ButtMenue(10,250,396,100,"menu/ser.png","Настройки");
	ButtMenue button3 = new ButtMenue(10,500,396,100,"menu/ser.png","Выход");

	public void draw (Graphics2D g) {
		button1.draw(g);
		button2.draw(g);
		button3.draw(g);
	}
	public void moveButt(Menue.ButtMenue e) {
		if (  Panel.mouseX>e.getX() && Panel.mouseX<e.getX()+e.getW()  &&
				Panel.mouseY>e.getY() && Panel.mouseY<e.getY()+e.getH()) {
			e.s="menu/ред.png";
			if (e.equals(button1)) {e.f="game";
				if(Menue.click){
					Panel.state=Panel.STATES.PLAY;
					Menue.click=false;
				}

			}
			if (e.equals(button2)) {e.f="settings";
				if (Menue.click){
					Panel.settmenue=true;
					Panel.buttmenue=false;}
			}
			if (e.equals(button3)) {e.f="exit";
				if (Menue.click){
					System.exit(0);}
			}}

		else {e.s="menu/ser.png";
			if (e.equals(button1)) {e.f="Играть";}
			if (e.equals(button2)) {e.f="Настройки";}
			if (e.equals(button3)) {e.f="Выход";}}

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