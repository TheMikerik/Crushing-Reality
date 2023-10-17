package lab;

import javafx.scene.canvas.GraphicsContext;

public class Game{

    private final double width;
    private final double height;
    private final double scale = 55;
    private Map map;

    public Game(double width, double height) {
        this.width = width;
        this.height = height;
        this.map = new Map();
    }

    public void draw(GraphicsContext gc) {
        map.draw(gc);
    }

    public void simulate(double deltaT) {
    }
}
