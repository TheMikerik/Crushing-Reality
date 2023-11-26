package java1.RUC0066.objects;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class GameInfo {

    private final int tileSize;
    private final int movementSpeed;
    private final Image player_texture;
    private final int player_bounce;
    private Point2D spawn;
    private Point2D exit;
    public GameInfo(){
        tileSize = 55;
        movementSpeed = 2;
        player_texture = new Image(getClass().getResourceAsStream("/java1/RUC0066/textures-16p/PLAYER.png"));
        player_bounce = 3;
    }

    public int getTileSize(){
        return tileSize;
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
    public int getPlayerBounce(){
        return player_bounce;
    }
}
