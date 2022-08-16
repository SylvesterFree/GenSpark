package Game;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setTitle("HVZ");

        Land l = new Land();
        f.add(l);
        f.pack();

        f.setLocationRelativeTo(null);
        f.setVisible(true);
        l.startGameThread();
        l.setupGame();
    }


}