package ru.zombies_cut;
import javax.swing.*;
import java.awt.*;
public class Player {

    private double x;
    private double y;
    private double w;
    private double h;
    private int speed;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    Image img = new ImageIcon("").getImage();

    public Player(){
x=400;
    y=500;
    w=142;
    h=229;
    speed=5;
    up=false;
        down=false;
        left=false;
        right=false;
    }
    public double getX() {return x;}
    public double getY() {return y;}
    public double getW() {return w;}
    public double getH() {return h;}
    public void update(){
        if (up && y>20){
            y-=speed;
        }
        if (down && y<Panel.HEIGHT-h){
            y+=speed;
        }
        if (left && y>0){
            x-=speed;
        }
        if (right && y<Panel.WIDTH-w){
            x+=speed;
        }
    }
    public void  draw (Graphics2D g){
        g.drawImage(img,(int)x,(int)y, null);
    }
}
