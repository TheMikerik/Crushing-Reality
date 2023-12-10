package java1.RUC0066.IO;

import java1.RUC0066.IO.Writers.StatsWriter;
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
    private int current_level;


    public int die_counter;
    private int coins_picked;

    public GameInfo(){
        player_texture = new Image(getClass().getResourceAsStream("/java1/RUC0066/textures-16p/Player/PLAYER_AFK.png"));
        tileSize = 55;
        playerTile = tileSize-16;
        movementSpeed = 3;
        gravity = 5;
        current_level = 1;

        die_counter = 0;
        coins_picked = 0;
    }

    public void died(){
        this.die_counter++;
    }
    public void coins_picked(){
        this.coins_picked++;
    }
    public void save_stats(){
        new StatsWriter(die_counter, coins_picked);
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
    public int getLevel(){
        return this.current_level;
    }
    public void nextLevel(){
        this.current_level++;
    }
}
