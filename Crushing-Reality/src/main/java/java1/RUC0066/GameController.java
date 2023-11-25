package java1.RUC0066;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;

public class GameController {

    @FXML
    private Canvas canvas;

    @FXML
    private AnchorPane anchorPane;

    private Scene scene;

    private AnimationTimer timer;

    private Game game;


    public GameController(){
    }

    public void startGame() {
        game = new Game(canvas);
        timer = new DrawingThread(canvas, game);
        timer.start();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
