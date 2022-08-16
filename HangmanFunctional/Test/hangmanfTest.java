import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class hangmanfTest {
    Main m;

    @BeforeEach
    void setUp(){
        m = new Main();
    }

    @Test
    void checkGuess(){
        assertEquals(m.checkGuess("a","apple"), true);
    }


}
