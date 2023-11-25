package java1.RUC0066;

import java1.RUC0066.map.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Game {
    private final Canvas canvas;
    private Map map;

    public Game(Canvas canvas) {
        super();
        this.canvas = canvas;
        this.map = new Map();
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        map.draw(gc);
    }

    public void simulate(double deltaT) {

    }
}
