
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DragonTest {
    Dragon dragon;
    @BeforeEach
    void setUp(){
        dragon = new Dragon();
    }
    @Test
    void checkInput(){

    int val1 = 1;

    dragon.value = 1;

        assertEquals(dragon.checkInput(val1),dragon.checkInput(1));
    }
    @AfterEach
    void tearDown(){

    }
}
