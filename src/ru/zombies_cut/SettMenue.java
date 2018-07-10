package ru.zombies_cut;
import javax.swing.*;
import java.awt.*;
public class SettMenue {
    private double x;
    private double y;
    private double w;
    private double h;

    public Color color1;
    public String f;
    public String s;

    public SettMenue(int x, int y, int w, int h, String s, String f) {
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
        g.setColor(Color.red);
        Font font = new Font("Arial", Font.ITALIC, 40);
        g.setFont(font);
        g.drawString("Сложность", 40, 100);
        g.drawString("Звук", 40, 250);
        g.drawString("Управление", 40, 400);
        g.drawImage(new ImageIcon(s).getImage(), (int) x, (int) y, null);
        g.setColor(color1);
        Font font1 = new Font("Arial", Font.ITALIC, 40);
        g.setFont(font1);
        long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth();
        g.drawString(f, (int) (x + w /2) - (int) (length / 20), (int) y + (int) (h / 1) * 2);

        g.setColor(Color.green);
        Font font2 = new Font("Arial", Font.ITALIC, 40);
        g.setFont(font2);
        if(Panel.easy)g.drawString("Легко",900,250);
        if(Panel.norm)g.drawString("Средне",900,250);
        if(Panel.hard)g.drawString("Невыносимо",1000,250);
        if(Panel.aud)g.drawImage(new ImageIcon("menu/on.gif").getImage(), 900,350,null);
        if(!Panel.aud)g.drawImage(new ImageIcon("menu/off.png").getImage(), 900,350,null);
        if(Panel.control)g.drawString("стандарт",500,500);
        if(!Panel.control)g.drawString("пользовательское",500,500);
    }
}


