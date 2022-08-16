package tile;

import Game.Land;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TileManager {
    Land l;
    public tile[] tile;
    public int[][] tileMap;
    public TileManager(Land l){
        this.l = l;
        tile = new tile[10];
        tileMap = new int[l.maxScreenCol][l.maxScreenRow];
        getTileImage();
        loadMap();
    }

    private void getTileImage() {

        try {
            File file = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\tile\\grasstop.png");
            File file1 = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\tile\\6ce8e7836c369d8.png");
            FileInputStream fis = new FileInputStream(file);
            FileInputStream fis1 = new FileInputStream(file1);
            tile[0] = new tile();
            tile[0].image = ImageIO.read(fis);
            tile[1] = new tile();
            tile[1].image = ImageIO.read(fis1);
            tile[1].collison = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadMap(){
        File file4 = new File("C:\\Users\\freeman\\IdeaProjects\\HvZ\\res\\map\\map.txt");

        InputStream is = getClass().getResourceAsStream(String.valueOf(file4));
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file4));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int col = 0;
        int row = 0;

        while(col < l.maxScreenCol && row < l.maxScreenRow){
            try {
                String line = br.readLine();
                while(col < l.maxScreenCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    tileMap[col][row] = num;
                    col++;
                }
                if(col==l.maxScreenCol){
                    col = 0;
                    row++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while(col < l.maxScreenCol && row < l.maxScreenRow){

            int tileNum = tileMap[col][row];
            
            g2.drawImage(tile[tileNum].image,x,y,l.tileSize,l.tileSize, null);
            col++;
            x+=l.tileSize;
            if(col == l.maxScreenCol){
                x=0;
                col=0;
                row++;
                y+=l.tileSize;
            }
        }

    }
}
