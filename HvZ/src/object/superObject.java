package object;

import Game.Land;

import java.awt.*;
import java.awt.image.BufferedImage;

public class superObject{
    public BufferedImage img;
    public String name;
    public boolean collision = false;
    public Rectangle hitBox = new Rectangle(0,0,48,48);
    public int hitBoxDefaultX=0;
    public int hitBoxDefaultY=0;
    public int x,y;

    public void draw(Graphics2D g2, Land l){
        g2.drawImage(img,x,y,l.tileSize,l.tileSize, null);
    }
}
