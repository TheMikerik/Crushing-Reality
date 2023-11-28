package java1.RUC0066.objects.player;

import java1.RUC0066.abstraction.MovingObject;
import java1.RUC0066.objects.GameInfo;
import java1.RUC0066.objects.map.Block;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class Player extends MovingObject {

    private boolean jump, moveDown, moveLeft, moveRight, inAir, respawn, inJump;
    private Point2D SPAWN;
    private final int MOVEMENT_SPEED;
    private final int TILE_SIZE;
    private final int PLAYER_TILE;
    private final int GRAVITY;
    private final Block[][] MAP_BLOCKS;

    private final int maxJump;
    private int jump_partition;

    public Player(GameInfo gi) {
        super(
            (int) gi.getSpawn().getX() + 8,
            (int) gi.getSpawn().getY() + 16,
            gi.getPlayerTile(),
            gi.getPlayerTile(),
            gi.getPlayerTexture(),
            true // COLLISION
        );
        this.MOVEMENT_SPEED = gi.getMovementSpeed();
        this.SPAWN = gi.getSpawn();
        this.MAP_BLOCKS = gi.getMapBlocks();
        this.TILE_SIZE = gi.getTileSize();
        this.PLAYER_TILE = gi.getPlayerTile();
        this.GRAVITY = gi.getGravity();

        this.inAir = false;
        this.inJump = false;
        this.maxJump = TILE_SIZE/2 + 2*TILE_SIZE;

        System.out.println("Player generated");
    }


    private boolean canMoveThere(int newX, int newY){
        int row = (newX / TILE_SIZE);
        int col = (newY / TILE_SIZE);

        Rectangle2D newPosition = new Rectangle2D(newX, newY, PLAYER_TILE, PLAYER_TILE);


        for(int x = row-1; x <= row+1; x++) {
            for (int y = col - 1; y <= col + 1; y++) {
                Block block = MAP_BLOCKS[y][x];
                if ( block.collisional() && newPosition.intersects(block.getRectangle()) ){
                    return false;
                }
            }
        }
        return true;
    }

    private void jumpTick(){
        this.setPlayerTexture("JUMP");

        if ( ! canFall() && jump_partition != 0 ){ // Is on the ground
            this.inAir = false;
            return;
        }
        if ( ! this.canMoveThere(this.getX(), this.getY() - MOVEMENT_SPEED) ){ // Hit the ceiling
            inJump = false;
        }

        if (inJump){
            if(jump_partition >= maxJump){
                inJump = false;
            }
            else{
                jump_partition += GRAVITY;
                this.setY(this.getY() - GRAVITY);
            }
        }
        if (!inJump && inAir){
            if( this.canMoveThere(this.getX(), this.getY() + GRAVITY) ) {
                this.setY(this.getY() + GRAVITY);
            }
        }
    }

    private boolean canFall(){
        return this.canMoveThere(this.getX(), this.getY() + MOVEMENT_SPEED);
    }

    private void checkMovement(){
        int orgX = this.getX();
        int orgY = this.getY();

        if (inAir){
            this.jumpTick();
        }
        if ( canFall() && !inJump ){
            this.inAir = true;
        }

        if (jump && !inAir  && this.canMoveThere(orgX, orgY - MOVEMENT_SPEED)) {
            this.inJump = true;
            this.inAir = true;
            this.jump_partition = 0;
            this.jumpTick();
        }
        if (moveDown && canFall()) {
            this.setPlayerTexture("AFK");
            if (inJump) {
                inJump = false;
            }
        }
        if (moveLeft && this.canMoveThere(orgX - MOVEMENT_SPEED, orgY)) {
            if (this.getX() % 60 < 20) {
                this.setPlayerTexture("LEFT");
            }
            else if (this.getX() % 60 < 40){
                this.setPlayerTexture("LEFT2");
            }
            else{
                this.setPlayerTexture("LEFT3");
            }
            this.setX(orgX - MOVEMENT_SPEED);
        }
        if (moveRight && this.canMoveThere(orgX + MOVEMENT_SPEED, orgY)) {
            if (this.getX() % 60 < 20) {
                this.setPlayerTexture("RIGHT");
            }
            else if (this.getX() % 60 < 40){
                this.setPlayerTexture("RIGHT2");
            }
            else{
                this.setPlayerTexture("RIGHT3");
            }
            this.setX(orgX + MOVEMENT_SPEED);
        }

        if (respawn){
            this.setX( (int)SPAWN.getX() + 8 );
            this.setY( (int)SPAWN.getY() + 16 );
        }
    }


    @Override
    public Rectangle2D getRectangle() {
        return new Rectangle2D(this.getX(), this.getY(), this.getW(), this.getH());
    }

    @Override
    public boolean intersect(Rectangle2D rectangle) {
        return getRectangle().intersects(rectangle);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        gc.drawImage(this.getTexture(), this.getX(), this.getY(), this.getW(), this.getH());
        gc.restore();
    }

    @Override
    public void simulate(GraphicsContext gc) {
        this.setPlayerTexture("AFK");
        this.checkMovement();

        gc.save();
        gc.drawImage(this.getTexture(), this.getX(), this.getY(), this.getW(), this.getH());
        gc.restore();
    }
    public void handleKeyPress(KeyCode code){
        switch(code){
            case W:
                jump = true;
                break;
            case S:
                moveDown = true;
                break;
            case A:
                moveLeft = true;
                break;
            case D:
                moveRight = true;
                break;
            case R:
                respawn = true;
                break;
        }
    }

    public void handleKeyRelease(KeyCode code){
        switch(code){
            case W:
                jump = false;
                break;
            case S:
                moveDown = false;
                break;
            case A:
                moveLeft = false;
                break;
            case D:
                moveRight = false;
                break;
            case R:
                respawn = false;
                break;
        }
    }
}
