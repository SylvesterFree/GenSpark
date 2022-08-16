package Entities;

import Game.Land;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Goblins extends Entities{


    public Goblins(Land l){
        super(l);



        damage = 2;
        name = "Goblin";
        speed = 2;
        health = 5;
        life = health;
        hitBox = new Rectangle(0,0,36,36);
        direction = "down";

        getImage();
        setAction();




    }

    public void getImage(){
        File file = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\Objects\\1f7e9.png");
        try {
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            img1 = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setAction(){
        actionLockCounter++;
        if(actionLockCounter == 60){
            Random r = new Random();
            int i = r.nextInt(100)+1;

            if(i<=25){
                direction = "up";
            }
            if(i>25 && i <= 50){
                direction = "down";
            }
            if(i>50 && i <= 75){
                direction = "left";
            }
            if(i>75 && i <= 100){
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = img1;
        g2.drawImage(image,x,y,50,50,null);
        g2.drawString("Goblin's health: "+ health, 400,500);


    }

}
