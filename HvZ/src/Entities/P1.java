package Entities;

import Game.KeyInput;
import Game.Land;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class P1 extends Entities{

    public KeyInput keyI;

    public int hasSword = 0;
    public int hasArmor = 0;
    private BufferedImage image, img2, img3, img4, img5;


    public P1(Land l, KeyInput keyI){
        super(l);

        this.keyI = keyI;
        SetDefaultValues();
        hitBox = new Rectangle(0,0,48,48);
        solidAreaDefaultX = hitBox.x;
        solidAreaDefaultY = hitBox.y;
        attackBox.width = 36;
        attackBox.height = 36;
        getPlayerImage();
        attackImage();
        SetDefaultValues();

    }
    public void SetDefaultValues(){
        health = 5;
        damage = 2;
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
        image = img1;
    }
    public void getPlayerImage(){
        File file = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\tile\\large_PolyTan-3_7501UP_1471502084.jpg");

        try {
            img1 = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void attackImage(){
        File file = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\tile\\aup.jpg");
        File file1 = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\tile\\aDown.jpg");
        File file2 = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\tile\\aLeft.jpg");
        File file3 = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\tile\\aRight.jpg");

        try {
            img5  = ImageIO.read(file);
            img2 = ImageIO.read(file1);
            img3 = ImageIO.read(file2);
            img4 = ImageIO.read(file3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(){
        if(keyI.enter==true){
            attacking1();
            attacking=false;
        }
    if(keyI.moveUp == true || keyI.moveDown == true || keyI.moveLeft == true || keyI.moveRight==true){
        if(keyI.moveUp==true){
            direction = "up";

        }
        if(keyI.moveDown==true){
            direction = "down";

        }
        if(keyI.moveRight==true){
            direction = "right";

        }
        if (keyI.moveLeft==true) {
            direction = "left";

        }

        collisionON = false;
        l.check.checkTile(this);

        int objIndex = l.check.checkObject(this, true);
        pickUpItem(objIndex);

        int entCollision = l.check.checkEnt(this, l.Goblins);
        interact(entCollision);


        if(collisionON == false){
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
        if(invincible==true){
            invincibleCounter++;
            if(invincibleCounter>60){
                invincible=false;
                invincibleCounter=0;
            }
        }

    }

    }

    private void attacking1() {
        int currentWorldX = x;
        int currentWorldY = y;
        int solidAreaWidth = solidAreaDefaultX;
        int solidAreaHeight = solidAreaDefaultY;

        switch(direction){
            case "up": y -= attackBox.height; break;
            case "down": y += attackBox.width; break;
            case "left": x -= attackBox.height; break;
            case "right": x += attackBox.width; break;
        }
        solidAreaDefaultX = attackBox.width;
        solidAreaDefaultY = attackBox.height;

        int monsterIndex = l.check.checkEnt(this, l.Goblins);
        damageGoblin(monsterIndex);
        x = currentWorldX;
        y = currentWorldY;
        solidAreaDefaultX = solidAreaWidth;
        solidAreaDefaultY = solidAreaHeight;

    }

    public void interact(int entCollision) {
        if(entCollision != 999){
            if(invincible==false){
                health-=1;
                invincible=true;
            }

        }else{
            attacking=true;
        }
    }

    public void pickUpItem(int i){
        if(i!= 999){
           String objName = l.obj[i].name;
           switch (objName){
               case "Sword":
                   damage += 3;
                   hasSword++;
                   l.obj[i]=null;
               break;
               case "Armor":
                   health += 3;
                   hasArmor++;
                   l.obj[i]=null;
                   break;
           }
        }
    }
    public void damageGoblin(int i){
        if(i!=999){
            if(l.Goblins[i].invincible==false&&l.Goblins[i]!=null){
                l.Goblins[i].health-= damage;
                l.Goblins[i].invincible=true;
                if(l.Goblins[i].health<=0){
                    l.Goblins[i] = null;
                }
            }

        }
    }
    public void drawl(Graphics2D g2){

        int tempX;
        int tempY;
        switch(direction){
            case"up":
                if(attacking == true&& keyI.enter){
                    image = img5;
                    tempY = y-l.tileSize;
                    g2.drawImage(image,x,tempY,l.tileSize,l.tileSize*2,null);
                }else{
                    image = img1;
                    g2.drawImage(image,x,y,l.tileSize,l.tileSize,null);
                }
                break;
            case"down":
                if(attacking == true&& keyI.enter){
                    image = img2;
                    g2.drawImage(image,x,y,l.tileSize,l.tileSize*2,null);
                }else{
                    image = img1;
                    g2.drawImage(image,x,y,l.tileSize,l.tileSize,null);
                }
                break;
            case"left":
                if(attacking == true&& keyI.enter){
                    image = img3;
                    tempX = x-l.tileSize;
                    g2.drawImage(image,tempX,y,l.tileSize*2,l.tileSize,null);
                }else{
                    image = img1;
                    g2.drawImage(image,x,y,l.tileSize,l.tileSize,null);
                }
                break;
            case"right":
                if(attacking == true&& keyI.enter){
                    image = img4;
                    g2.drawImage(image,x,y,l.tileSize*2,l.tileSize,null);
                }else{
                    image = img1;
                    g2.drawImage(image,x,y,l.tileSize,l.tileSize,null);
                }
                break;
        }

    }


}
