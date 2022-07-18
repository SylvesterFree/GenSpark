

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class HangGameTest {
    HangGame hg;
    @BeforeEach
    void setUp(){
        hg = new HangGame();
        File text = new File(" C:\\Users\\freeman\\Downloads\\Words\\word.txt");
        try{
            Scanner scan = new Scanner(text);
            System.out.println("File Found");
        }catch(FileNotFoundException e){
            System.out.println("No file found");
        }
    }

    @Test
     void GenWord() {
        ArrayList<String> words = new ArrayList<>();
        words.add("hi");
        words.add("bye");
        words.add("pie");
        String test = hg.ranWord;
        hg.GenWord(words);
        String test2 = hg.ranWord;
        assertEquals(test.matches("[a-zA-Z]+"),test2.matches("[a-zA-Z]+"));


    }
}
