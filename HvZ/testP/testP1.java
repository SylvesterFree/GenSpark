import Entities.P1;
import Game.KeyInput;
import Game.Land;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testP1 extends Land {
    P1 p;
    @BeforeEach
    void setUp(){
        KeyInput key = new KeyInput(this);
        p = new P1(this, key);
    }

    @Test
    void checkMove(){
        p.keyI.moveUp = true;
        p.update();
        assertEquals(p.direction, "up");
        assertEquals(p.y, 96);

    }
}
