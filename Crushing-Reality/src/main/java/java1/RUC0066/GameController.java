package java1.RUC0066;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
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
        System.out.println("Controller initialized");
    }

    public void startGame() {
        game = new Game(canvas);
        timer = new DrawingThread(canvas, game);
        timer.start();

        if (scene != null) {
            scene.setOnKeyPressed(e -> game.getPlayer().handleKeyPress(e.getCode()));
            scene.setOnKeyReleased(e -> game.getPlayer().handleKeyRelease(e.getCode()));

            System.out.println("KeyListener initialized");
        }
        else {
            throw new RuntimeException("KeyListener not initialized");
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
