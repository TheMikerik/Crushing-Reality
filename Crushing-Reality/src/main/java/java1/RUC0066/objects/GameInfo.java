package java1.RUC0066.objects;

import java1.RUC0066.objects.map.Block;
import java1.RUC0066.objects.map.Coin;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class GameInfo {

    private final int tileSize;
    private final int playerTile;
    private final int movementSpeed;
    private final Image player_texture;
    private Point2D spawn;
    private Point2D exit;
    private final int gravity;
    private Block[][] blocks;

    public GameInfo(){
        tileSize = 55;
        playerTile = tileSize-16;
        movementSpeed = 3;
        gravity = 5;
        player_texture = new Image(getClass().getResourceAsStream("/java1/RUC0066/textures-16p/Player/PLAYER_AFK.png"));
    }

    public int getTileSize(){
        return tileSize;
    }
    public int getPlayerTile(){
        return playerTile;
    }
    public int getMovementSpeed(){
        return movementSpeed;
    }
    public Image getPlayerTexture(){
        return player_texture;
    }
    public void setSpawn(Point2D spawn){
        this.spawn = spawn;
        System.out.println("Spawn Point initialized");
    }
    public void setExit(Point2D exit){
        this.exit = exit;
        System.out.println("Exit Point initialized");
    }
    public Point2D getSpawn(){
        return spawn;
    }
    public Point2D getExit(){
        return exit;
    }
    public void saveMapBlocks(Block[][] blocks){
        this.blocks = blocks;
    }
    public Block[][] getMapBlocks(){
        return this.blocks;
    }
    public int getGravity(){
        return gravity;
    }
}
