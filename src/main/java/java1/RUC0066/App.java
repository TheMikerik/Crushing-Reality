package java1.RUC0066;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


   private GameController controller;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(App.class.getResource("GameView.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.resizableProperty().set(false);
        stage.setTitle("Crushing Reality");
        stage.show();

        stage.setOnCloseRequest(this::exitProgram);
        controller = loader.getController();
        controller.setScene(scene);
        controller.startGame();
    }

    public static void main(String[] args) {
        launch();
    }

    private void exitProgram(WindowEvent event)
    {
        controller.endGame();
        System.exit(0);
    }
}