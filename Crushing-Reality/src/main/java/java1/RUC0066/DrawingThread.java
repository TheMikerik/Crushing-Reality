package java1.RUC0066;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawingThread extends AnimationTimer {

    private final GraphicsContext gc;
    private final Game game;
    private final Canvas canvas;
    private long lastTime = -1;
    private boolean first = true;

    public DrawingThread(Canvas canvas, Game game) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.game = game;

        System.out.println("Drawing thread started");
    }

    @Override
    public void handle(long now) {
        if (first) {
            game.draw(gc);
            first = false;
        }
        if (lastTime > 0){
//            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//            game.simulate((now - lastTime) / 1e9);
            game.simulate(gc);
        }
        lastTime = now;
    }
}