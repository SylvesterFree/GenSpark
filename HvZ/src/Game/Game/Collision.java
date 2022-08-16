package Game;

import Entities.Entities;

public class Collision {
    Land l;
    public Collision(Land l){
        this.l = l;
    }
    public void checkTile(Entities ent){
        int entityLeftX = ent.x + ent.hitBox.x;
        int entityRightX= ent.x + ent.hitBox.x+ent.hitBox.width;
        int entityTopY = ent.y + ent.hitBox.y;
        int entityBottomY = ent.y + ent.hitBox.y+ent.hitBox.height;

        int entityLeftCol = entityLeftX/l.tileSize;
        int entityRightCol = entityRightX/l.tileSize;
        int entityTopRow = entityTopY/l.tileSize;
        int entityBottomRow = entityBottomY/l.tileSize;

        int tileNum1, tileNum2;

        switch(ent.direction){
            case "up":
                entityTopRow = (entityTopY-ent.speed)/l.tileSize;
                tileNum1 = l.tm.tileMap[entityLeftCol][entityTopRow];
                tileNum2 = l.tm.tileMap[entityRightCol][entityTopRow];
                if(l.tm.tile[tileNum1].collison==true || l.tm.tile[tileNum2].collison == true){
                    ent.collisionON = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomY+ent.speed)/l.tileSize;
                tileNum1 = l.tm.tileMap[entityLeftCol][entityBottomRow];
                tileNum2 = l.tm.tileMap[entityRightCol][entityBottomRow];
                if(l.tm.tile[tileNum1].collison==true || l.tm.tile[tileNum2].collison == true){
                    ent.collisionON = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX-ent.speed)/l.tileSize;
                tileNum1 = l.tm.tileMap[entityLeftCol][entityTopRow];
                tileNum2 = l.tm.tileMap[entityLeftCol][entityBottomRow];
                if(l.tm.tile[tileNum1].collison==true || l.tm.tile[tileNum2].collison == true){
                    ent.collisionON = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightX+ent.speed)/l.tileSize;
                tileNum1 = l.tm.tileMap[entityRightCol][entityTopRow];
                tileNum2 = l.tm.tileMap[entityRightCol][entityBottomRow];
                if(l.tm.tile[tileNum1].collison==true || l.tm.tile[tileNum2].collison == true){
                    ent.collisionON = true;
                }
                break;
        }
    }
    public int checkObject(Entities ent, boolean p1){
        int index = 999;

        for(int i=0; i<l.obj.length; i++){
            if(l.obj[i]!= null){
                ent.hitBox.x = ent.x + ent.hitBox.x;
                ent.hitBox.y = ent.y + ent.hitBox.y;

                l.obj[i].hitBox.x = l.obj[i].x + l.obj[i].hitBox.x;
                l.obj[i].hitBox.y = l.obj[i].y + l.obj[i].hitBox.y;

                switch(ent.direction){
                    case "up":
                        ent.hitBox.y -= ent.speed;
                        if(ent.hitBox.intersects(l.obj[i].hitBox)){
                            if(l.obj[i].collision==true){
                                ent.collisionON = true;
                            }
                            if (p1 == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        ent.hitBox.y += ent.speed;
                        if(ent.hitBox.intersects(l.obj[i].hitBox)){
                            if(l.obj[i].collision==true){
                                ent.collisionON = true;
                            }
                            if (p1 == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        ent.hitBox.x -= ent.speed;
                        if(ent.hitBox.intersects(l.obj[i].hitBox)){
                            if(l.obj[i].collision==true){
                                ent.collisionON = true;
                            }
                            if (p1 == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        ent.hitBox.x += ent.speed;
                        if(ent.hitBox.intersects(l.obj[i].hitBox)){
                            if(l.obj[i].collision==true){
                                ent.collisionON = true;
                            }
                            if (p1 == true){
                                index = i;
                            }
                            break;
                        }
                }
                ent.hitBox.x = ent.solidAreaDefaultX;
                ent.hitBox.y = ent.solidAreaDefaultY;
                l.obj[i].hitBox.x = l.obj[i].hitBoxDefaultX;
                l.obj[i].hitBox.y = l.obj[i].hitBoxDefaultY;
            }

        }
        return index;
    }
    public int checkEnt(Entities ent, Entities[] target){
        int index = 999;

        for(int i=0; i<target.length; i++){
            if(target[i]!= null){
                ent.hitBox.x = ent.x + ent.hitBox.x;
                ent.hitBox.y = ent.y + ent.hitBox.y;

                target[i].hitBox.x = target[i].x + target[i].hitBox.x;
                target[i].hitBox.y = target[i].y + target[i].hitBox.y;

                switch(ent.direction){
                    case "up":
                        ent.hitBox.y -= ent.speed;
                        if(ent.hitBox.intersects(target[i].hitBox)){
                                ent.collisionON = true;
                                index = i;
                        }
                        break;
                    case "down":
                        ent.hitBox.y += ent.speed;
                        if(ent.hitBox.intersects(target[i].hitBox)){
                            ent.collisionON = true;
                                index = i;

                        }
                        break;
                    case "left":
                        ent.hitBox.x -= ent.speed;
                        if(ent.hitBox.intersects(target[i].hitBox)){
                                ent.collisionON = true;
                                index = i;
                        }
                        break;
                    case "right":
                        ent.hitBox.x += ent.speed;
                        if(ent.hitBox.intersects(target[i].hitBox)){
                                ent.collisionON = true;
                                index = i;
                            break;
                        }
                }
                ent.hitBox.x = ent.solidAreaDefaultX;
                ent.hitBox.y = ent.solidAreaDefaultY;
                target[i].hitBox.x = target[i].solidAreaDefaultX;
            target[i].hitBox.y = target[i].solidAreaDefaultX;
            }

    }
        return index;
    }
    public void checkPlayer(Entities ent){
        ent.hitBox.x = ent.x + ent.hitBox.x;
        ent.hitBox.y = ent.y + ent.hitBox.y;

        l.player.hitBox.x = l.player.x + l.player.hitBox.x;
        l.player.hitBox.y = l.player.y + l.player.hitBox.y;

        switch(ent.direction){
            case "up":
                ent.hitBox.y -= ent.speed;
                if(ent.hitBox.intersects(l.player.hitBox)){
                    ent.collisionON = true;
                }
                break;
            case "down":
                ent.hitBox.y += ent.speed;
                if(ent.hitBox.intersects(l.player.hitBox)){
                    ent.collisionON = true;
                }
                break;
            case "left":
                ent.hitBox.x -= ent.speed;
                if(ent.hitBox.intersects(l.player.hitBox)){
                    ent.collisionON = true;
                }
                break;
            case "right":
                ent.hitBox.x += ent.speed;
                if(ent.hitBox.intersects(l.player.hitBox)){
                    ent.collisionON = true;
                    break;
                }
        }
        ent.hitBox.x = ent.solidAreaDefaultX;
        ent.hitBox.y = ent.solidAreaDefaultY;
        l.player.hitBox.x = l.player.solidAreaDefaultX;
        l.player.hitBox.y = l.player.solidAreaDefaultX;
    }
    }

