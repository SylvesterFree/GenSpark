package Entities;

import Game.Land;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entities {
    public Land l;
    public BufferedImage image;
    public boolean attacking=false;
    public int x,y,speed,life, invincibleCounter = 0;
    public int health, damage;
    public int actionLockCounter = 0;
    public BufferedImage img1;
    public Rectangle hitBox;
    public Rectangle attackBox = new Rectangle(0,0,0,0);
    public String direction, name;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public Boolean collisionON = false, invincible = false;
    public Entities(Land l){
        this.l=l;
    }

    public void setAction(){

    }
    public void update(){
        setAction();


        l.check.checkTile(this);
        l.check.checkObject(this,false);
        l.check.checkPlayer(this);
        if(!collisionON){
            switch(direction){
                case"up":
                    y -= speed;
                    break;
                case "down":
                    y += speed;
                    break;
                case "right":
                    x += speed;
                    break;
                case "left":
                    x -= speed;
                    break;
            }
        }
    }
    public void draw(Graphics2D g2){
       g2.drawImage(image,x,y,l.tileSize,l.tileSize,null);
    }

}
