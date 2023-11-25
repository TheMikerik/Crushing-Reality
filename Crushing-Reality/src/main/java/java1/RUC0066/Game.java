package java1.RUC0066;

import java1.RUC0066.abstraction.DrawableSimulable;
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
        entities[0] = new Map(gameInfo.getTileSize());
        entities[1] = new Player(
                5 * gameInfo.getTileSize(),
                11 * gameInfo.getTileSize(),
                          gameInfo.getTileSize(),
                          gameInfo.getTileSize(),
                          new Image(getClass().getResourceAsStream("/java1/RUC0066/textures-16p/PLAYER.png"))
        );
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for( DrawableSimulable entity : entities){
            entity.draw(gc);
        }
    }

    public void simulate(double deltaT) {

    }
}
