package java1.RUC0066.objects.map;

import java1.RUC0066.abstraction.DrawableSimulable;
import java1.RUC0066.objects.GameInfo;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Traps implements DrawableSimulable {
    private Point2D[] trapLocation = {
            new Point2D(14, 12),
            new Point2D(9, 7),
            new Point2D(5, 11),
            new Point2D(8, 11)
    };
    private Point2D[] trapLocation2 = {
            new Point2D(3, 6),
            new Point2D(10, 3),
            new Point2D(20, 3)
    };

    private Trap[] traps;
    private int tileSize;

    public Traps(GameInfo gi){
        this.tileSize = gi.getTileSize();

        this.traps = new Trap[trapLocation.length];
        this.initializeTraps();
    }

    private void initializeTraps(){
        Image texture = new Image(getClass().getResourceAsStream(("/java1/RUC0066/textures-16p/World/TRAP.png")));
        for(int i=0; i < trapLocation.length ; i++){
            Point2D trap = trapLocation[i];
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
