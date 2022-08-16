package Game;


import Entities.Entities;
import Entities.P1;

import object.superObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class Land extends JPanel implements Runnable {

    final int OtileSize = 16;
    final int scale = 3;
    public final int tileSize = OtileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    public int playState = 1;

    int FPS = 60;
    KeyInput key = new KeyInput(this);
    Thread gameThread;
    public P1 player = new P1(this,key);

    public Entities Goblins[] = new Entities[5];
    TileManager tm = new TileManager(this);
    public Collision check = new Collision(this);
    public superObject obj[] = new superObject[10];
    public AssetSetter as = new AssetSetter(this);
    public int gameState=1;
    public final int dialogueState = 3;
    public UI ui = new UI(this);
    public Land(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void setupGame(){
        as.setObject();
        as.setGoblin();
    }
    @Override
    public void run() {
        double drawInt = 1000000000/FPS;
        double nextDrawlTime = System.nanoTime() + drawInt;
        while(gameThread != null){

            update();

            repaint();
            double remainingTime = nextDrawlTime - System.nanoTime();
            remainingTime = remainingTime / 1000000;
            if(remainingTime<0){
                remainingTime=0;
            }
            try {
                Thread.sleep((long) remainingTime);
                nextDrawlTime += drawInt;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update(){
        player.update();
        for(int i =0; i<Goblins.length; i++) {
            if (Goblins[i] != null) {
                Goblins[i].update();
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tm.draw(g2);
        for(int i =0; i<obj.length; i++){
            if(obj[i]!= null){
                obj[i].draw(g2,this);
            }
        }
        for(int i =0; i<Goblins.length; i++){
            if(Goblins[i]!= null){
                Goblins[i].draw(g2);
            }
        }

        player.drawl(g2);

        ui.draw(g2);
        g2.dispose();
    }
}
