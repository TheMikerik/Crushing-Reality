package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Game{

    private final double width;
    private final double height;
    private final double scale = 48;
    private MapGen mapGenerator;

    public Game(double width, double height) {
        this.width = width;
        this.height = height;

        char[][] worldMap = {
                {'V', 'V', 'c', 'b', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'c', 'V', 'V', 'V', 'b', 'V', 'V', 'D', 'D'},
                {'V', 'b', 'c', 'b', 'b', 'V', 'V', 'V', 'c', 'V', 'V', 'V', 'V', 'c', 'b', 'c', 'c', 'b', 'c', 'c', 'D', 'D'},
                {'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'D', 'D'},
                {'D', 'D', 'D', 'D', 'B', 'B', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D'},
                {'D', 'D', 'D', 'D', '.', '.', '.', 'I', '.', '.', '.', '.', '.', '.', '.', 'd', '.', 'D', 'D', 'D', 'D', 'D'},
                {'D', 'D', 'D', 'D', '.', '.', '.', 'I', '.', '.', '.', 'D', 'B', 'B', 'D', 'D', 'e', 'D', 'D', 'D', 'D', 'D'},
                {'D', 'D', 'D', 'D', '.', '.', '.', 'D', '.', '.', '.', 'B', 'B', '.', '.', '.', 'D', 'D', 'D', 'D', 'D', 'D'},
                {'e', 'e', 'D', 'D', 'D', 'D', 'D', 'D', 'D', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D', 'D'},
                {'D', 'D', 'B', 'B', 'B', 'B', 'B', 'B', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D', 'D'},
                {'D', 'D', 'D', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'g', 'g', 'D', 'D'},
                {'D', 'D', 'D', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D', 'D'},
                {'D', 'D', 'D', '.', 'd', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D', 'D'},
                {'D', 'D', 'D', 'D', 'D', 'D', '.', 'D', 'D', 'D', 'D', 'D', '.', 'D', 'D', 'a', 'a', 'D', 'D', 'D', 'D', 'D'},
                {'D', 'D', 'D', 'D', 'D', 'D', '.', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'a', 'a', 'D', 'D', 'D', 'D', 'D', 'D'},
                {'D', 'a', 'D', 'D', 'D', 'D', 'D', 'D', 'e', 'e', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'g', 'D', 'D', 'D'}
        };

        mapGenerator = new MapGen(worldMap);
    }

    public void draw(GraphicsContext gc) {
        mapGenerator.drawMap(gc);
        // Other game drawing logic goes here
    }

    public void simulate(double deltaT) {
        // Your simulation logic goes here
    }
}
