package java1.RUC0066.objects;

public class GameInfo {

    private final int tileSize;
    private final int movementSpeed;
    public GameInfo(){
        tileSize = 55;
        movementSpeed = 2;
    }

    public int getTileSize(){
        return tileSize;
    }
    public int getMovementSpeed(){
        return movementSpeed;
    }
}
