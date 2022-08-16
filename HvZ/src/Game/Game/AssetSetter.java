package Game;


import Entities.Goblins;
import object.Armor;
import object.Sword;

public class AssetSetter {
    Land l;
    public AssetSetter(Land l){
        this.l=l;
    }

    public void setObject(){
        l.obj[0]= new Sword();
        l.obj[0].x = 7*l.tileSize;
        l.obj[0].y = 7*l.tileSize;

        l.obj[1] = new Armor();
        l.obj[1].x = 7*l.tileSize;
        l.obj[1].y = 9*l.tileSize;

    }

    public void setGoblin(){
        l.Goblins[0] = new Goblins(l);
        l.Goblins[0].x = l.tileSize*7;
        l.Goblins[0].y = l.tileSize*5;

    }
}
