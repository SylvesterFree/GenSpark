
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GuessTest {
    Guess guess;

    @BeforeEach
    void setUp(){
        guess = new Guess();
    }

    @Test
    void checkGuess(){
        String check = "0";
        InputStream input = new ByteArrayInputStream(check.getBytes());
        System.setIn(input);
        int result = guess.CheckGuess();
        assertEquals(0,result);
    }
    @Test
    void CheckName(){
        String check = "Sly";
        String check1 = "123";
        assertEquals(check.matches("[a-zA-Z]+"),guess.CheckName("Sly").matches("[a-zA-Z]+"));
        assertEquals(check1.matches("[a-zA-Z]+"),guess.CheckName("sly").matches("[a-zA-Z]+"), "Contains Numbers");
    }

    @AfterEach
    void tearDown(){

    }
}
