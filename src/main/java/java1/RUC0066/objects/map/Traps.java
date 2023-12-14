package java1.RUC0066.objects.map;

import java1.RUC0066.abstraction.DrawableSimulable;
import java1.RUC0066.IO.GameInfo;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Traps implements DrawableSimulable {
    private Point2D[] trapsLocation;
    private Trap[] traps;
    private int tileSize;
    private int level;

    public Traps(GameInfo gi){
        this.tileSize = gi.getTileSize();
        this.level = gi.getLevel();

        this.trapsLocation = getTrapsLocation(level);
        this.traps = new Trap[trapsLocation.length];
        this.initializeTraps();
    }

    private Point2D[] getTrapsLocation(int level){
        Point2D[] trapsLocation;

        switch(level){
            case 1:
                trapsLocation = new Point2D[]{
                        new Point2D(9, 7),
                        new Point2D(5, 11),
                        new Point2D(8, 11)
                };
                break;
            case 2:
                trapsLocation = new Point2D[]{
                        new Point2D(11, 12),
                        new Point2D(10, 12),
                        new Point2D(9, 12),
                        new Point2D(8, 3),
                        new Point2D(17, 12),
                        new Point2D(18, 12),
                        new Point2D(19, 12)
                };
                break;
            default:
                return null;
        }

        return trapsLocation;
    }

    private void initializeTraps(){
        Image texture = new Image(getClass().getResourceAsStream(("/java1/RUC0066/textures-16p/World/TRAP.png")));
        for(int i=0; i < trapsLocation.length ; i++){
            Point2D trap = trapsLocation[i];
            traps[i] = new Trap(
                    (int) trap.getX() * 55 + 7,
                    (int) trap.getY() * 55 + 14,
                    this.tileSize - 14,
                    this.tileSize - 14,
                    texture,
                    false );
        }
    }

    public Trap[] getTraps(){
        return this.traps;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        for( Trap trap : traps ){
            trap.draw(gc);
        }
        gc.restore();
    }

    @Override
    public void simulate(GraphicsContext gc) {
        gc.save();
        for( Trap trap : traps ){
            trap.draw(gc);
        }
        gc.restore();
    }
}
