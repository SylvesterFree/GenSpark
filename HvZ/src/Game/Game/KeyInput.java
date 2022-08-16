package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    Land l;
    public boolean moveUp, moveLeft, moveRight, moveDown, enter;


    public KeyInput(Land l){
        this.l = l;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

            if(code==KeyEvent.VK_W){
                moveUp = true;
            }
            if(code==KeyEvent.VK_A){
                moveLeft = true;
            }
            if(code==KeyEvent.VK_S){
                moveDown = true;
            }
            if(code==KeyEvent.VK_D){
                moveRight = true;
            }
            if(code == KeyEvent.VK_ENTER){
                enter = true;
            }


    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
            if(code==KeyEvent.VK_W){
                moveUp = false;
            }
            if(code==KeyEvent.VK_A){
                moveLeft = false;
            }
            if(code==KeyEvent.VK_S){
                moveDown = false;
            }
            if(code==KeyEvent.VK_D){
                moveRight = false;
            }
        if(code == KeyEvent.VK_ENTER){
            enter = false;

        }

    }
}
