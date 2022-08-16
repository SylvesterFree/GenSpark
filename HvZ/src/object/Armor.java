package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Armor extends superObject{
    public Armor(){
        name = "Armor";
        File file = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\Objects\\png-transparent-minecraft-pocket-edition-breastplate-armour-diamond-minecraft-chest-blue-angle-rectangle-thumbnail.png");
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
