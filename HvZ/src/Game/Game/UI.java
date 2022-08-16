package Game;

import java.awt.*;

public class UI {
    Graphics2D g2;
    Land l;
    Font Arial;
    int Counter = 0;

    public UI(Land l){
        this.l = l;
        Arial = new Font("Arial", Font.PLAIN, 30);
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(Arial);
        g2.setColor(Color.white);

            if(l.player.hasSword == 1){
                g2.drawString("Damage up x "+l.player.hasSword, 15, 40);
                Counter++;
            }
            if(l.player.hasArmor == 1){
                g2.drawString("Health up x "+l.player.hasArmor, 15, 70);
                Counter++;
            }

        g2.drawString("health: "+ l.player.health, 400,40);



    }

}
