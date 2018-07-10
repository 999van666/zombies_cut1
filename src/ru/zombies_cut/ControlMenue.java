package ru.zombies_cut;

import java.awt.*;
import javax.swing.*;

public class ControlMenue {
    ButtControl button_up = new ButtControl(550, 10, 100, 37, "menu/елоу1.png", "вверх");
    ButtControl button_d = new ButtControl(550, 110, 100, 37, "menu/елоу1.png", "вниз");
    ButtControl button_l = new ButtControl(550, 210, 100, 37, "menu/елоу1.png", "влево");
    ButtControl button_r = new ButtControl(550, 310, 100, 37, "menu/елоу1.png", "вправо");
    ButtControl button_f = new ButtControl(550, 410, 100, 37, "menu/елоу1.png", "рубить");
    ButtControl button_k = new ButtControl(50, 20, 100, 37, "menu/елоу1.png", "назад");

    public void draw(Graphics2D g) {
        button_up.draw(g);
        button_d.draw(g);
        button_l.draw(g);
        button_r.draw(g);
        button_f.draw(g);
        button_k.draw(g);
    }

    public void moveContr(ButtControl b) {
        if (Panel.mouseX > b.getX() && Panel.mouseX < b.getX() + b.getW() &&
                Panel.mouseY > b.getY() && Panel.mouseY < b.getY() + b.getH()) {
            b.s = "menu/елоу1.png";
            if (b.equals(button_up)) {
                editContr(b);
            }
            if (b.equals(button_d)) {
                editContr(b);
            }
            if (b.equals(button_l)) {
                editContr(b);
            }
            if (b.equals(button_r)) {
                editContr(b);
            }
            if (b.equals(button_f)) {
                editContr(b);
            }
            if (b.equals(button_k)) {
                if (Menue.click) {
                    Panel.buttmenue = false;
                    Panel.controlmenue = false;
                    Panel.settmenue = true;
                }

            }
        } else {
            b.s = "menu/черная.png";
            b.zamen = false;
        }
    }

    public void editContr(ButtControl b) {
        if (Menue.click) {
            b.f = "";
            b.zamen = true;
        }
    }


    class ButtControl {

        private double x;
        private double y;
        private double w;
        private double h;
        public Color color1;
        public String f;
        public String s;
        public boolean zamen = false;

        public ButtControl(int x, int y, int w, int h, String s, String f) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.f = f;
            this.s = s;
            color1 = Color.GREEN;

        }

        //gets
        public double getX() {
            return this.x;
        }

        public double getY() {
            return this.y;
        }

        public double getW() {
            return this.w;
        }

        public double getH() {
            return this.h;
        }

        public void draw(Graphics2D g) {
            g.drawImage(new ImageIcon(s).getImage(), (int) x, (int) y, null);
            g.setColor(color1);
            Font font = new Font("Arial", Font.ITALIC, 20);
            g.setFont(font);

            long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth();
            g.drawString(f, (int) (x + w / 3) - (int) (length / 2.5), (int) y + (int) (h / 3) * 2);
            g.setColor(Color.BLACK);
            Font font1 = new Font("Arial", Font.ITALIC, 20);
            g.setFont(font1);

            g.drawString("движение вверх", 750, 40);
            g.drawString("движение вниз", 750, 140);
            g.drawString("движение влево", 750, 240);
            g.drawString("движение вправо", 750, 340);
            g.drawString("рубить", 750, 440);
        }
    }
}

