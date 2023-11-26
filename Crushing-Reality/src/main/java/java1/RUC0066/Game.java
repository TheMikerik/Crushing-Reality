package java1.RUC0066;

import java1.RUC0066.abstraction.Collisionable;
import java1.RUC0066.abstraction.DrawableSimulable;
import java1.RUC0066.abstraction.GameObject;
import java1.RUC0066.objects.GameInfo;
import java1.RUC0066.objects.map.Map;
import java1.RUC0066.objects.player.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Game {
    private final Canvas canvas;

    private GameInfo gameInfo;

    private DrawableSimulable[] entities;
    //0-map, 1-player

    public Game(Canvas canvas) {
        this.canvas = canvas;
        this.gameInfo = new GameInfo();

        this.entities = new DrawableSimulable[2];
        entities[0] = new Map(gameInfo);
        entities[1] = new Player(gameInfo);
    }

    public void draw(GraphicsContext gc) {
        for( DrawableSimulable entity : entities){
            entity.draw(gc);
        }
    }

    public void simulate(GraphicsContext gc) {
        for (DrawableSimulable entity : entities) {
            entity.simulate(gc);

            if (entity instanceof Player player) {
                for(DrawableSimulable others : entities) {
                    if(entity != others && ( others instanceof GameObject object && object.collisional() )){
                        //if ( player.intersect(others))
                        System.out.println("collision");
                    }
                }
            }
//                for(DrawableSimulable others : entities) {
//                    if(entity != others && others instanceof Collisionable otherCollisionable){
//                        System.out.println("collision");
//                    }
//                }
        }
    }

    public Player getPlayer(){
        return (Player)this.entities[1];
    }
}
