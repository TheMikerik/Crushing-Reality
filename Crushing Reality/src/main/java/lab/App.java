package lab;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class App extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    private final int ROWS = 15;
    private final int COLUMNS = 23;
    private final int TILE_SIZE = 16;
    private final int SCALE = 3;

    private final int WIDTH = COLUMNS * TILE_SIZE * SCALE;
    private final int HEIGHT = ROWS * TILE_SIZE * SCALE;

    private Canvas canvas;
    private AnimationTimer timer;

    @Override
    public void start(Stage primaryStage) {
        try {
            //Construct a main window with a canvas.
            Group root = new Group();
            canvas = new Canvas(WIDTH, HEIGHT);
            root.getChildren().add(canvas);
            Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.resizableProperty().set(false);
            primaryStage.setTitle("Crushing Reality");
            primaryStage.show();

            //Exit program when main window is closed
            primaryStage.setOnCloseRequest(this::exitProgram);
            timer = new DrawingThread(canvas);
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void stop() throws Exception {
        timer.stop();
        super.stop();
    }

    private void exitProgram(WindowEvent evt) {
        System.exit(0);
    }
}
