package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Sword extends superObject {
    public Sword(){
        name = "Sword";
        File file = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\Objects\\sword-weapon-pixel-art-pixelation-png-favpng-xQmK27gezdXv9AP5rRjE2KdLP.jpg");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            img = ImageIO.read(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
