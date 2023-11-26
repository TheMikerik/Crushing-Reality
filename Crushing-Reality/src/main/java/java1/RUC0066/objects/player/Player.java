package java1.RUC0066.objects.player;

import java1.RUC0066.abstraction.MovingObject;
import java1.RUC0066.objects.GameInfo;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class Player extends MovingObject {

    private boolean moveUp, moveDown, moveLeft, moveRight, jumping, respawn;
    private boolean collision = false;
    private Point2D SPAWN;
    private final int MOVEMENT_SPEED;
    private final int BOUNCE;

    public Player(GameInfo gi) {
        super(
            (int) gi.getSpawn().getX() + 8,
            (int) gi.getSpawn().getY() + 16,
            gi.getTileSize() - 16,
            gi.getTileSize() - 16,
            gi.getPlayerTexture(),
            true // COLLISION
        );
        this.MOVEMENT_SPEED = gi.getMovementSpeed();
        this.BOUNCE = gi.getPlayerBounce();
        this.SPAWN = gi.getSpawn();

        System.out.println("Player generated");
    }

    public void isInCollision(boolean col){
        collision = col;
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
        int orgX = this.getX();
        int orgY = this.getY();

        if (moveUp) {
            this.setY( collision ? ((this.getY() / 55) + 1) * 55 : this.getY() - MOVEMENT_SPEED);
            System.out.println("Player moved UP to: " + this.getX() + " " + this.getY());
        }
        if (moveDown) {
            this.setY( collision ? (this.getY() / 55) * 55 : this.getY() + MOVEMENT_SPEED);
            System.out.println("Player moved DOWN to: " + this.getX() + " " + this.getY());
        }
        if (moveLeft) {
            this.setX( collision ? ((this.getX() / 55) + 1) * 55 : this.getX() - MOVEMENT_SPEED);
            System.out.println("Player moved LEFT to: " + this.getX() + " " + this.getY());
        }
        if (moveRight) {
            this.setX( collision ? (this.getX() / 55) * 55 : this.getX() + MOVEMENT_SPEED);
            System.out.println("Player moved RIGHT to: " + this.getX() + " " + this.getY());
        }
        if (respawn){
            this.setX( (int)SPAWN.getX() + 8 );
            this.setY( (int)SPAWN.getY() + 16 );
            System.out.println("Player RESPAWNED to: " + this.getX() + " " + this.getY());
        }

        gc.save();
        gc.drawImage(this.getTexture(), this.getX(), this.getY(), this.getW(), this.getH());
        gc.restore();
    }
    public void handleKeyPress(KeyCode code){
        switch(code){
            case W:
                moveUp = true;
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
            case SPACE:
                jumping = true;
                break;
            case R:
                respawn = true;
                break;
        }
    }

    public void handleKeyRelease(KeyCode code){
        switch(code){
            case W:
                moveUp = false;
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
            case SPACE:
                jumping = false;
                break;
            case R:
                respawn = false;
                break;
        }
    }
}
