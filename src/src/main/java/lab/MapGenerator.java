package lab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MapGenerator extends Application {

	private static final int ROWS = 15;
	private static final int COLUMNS = 22;
	private static final int TILE_SIZE = 55; // Size of each tile in pixels

	private String[] worldMap = {
			"VVcbVVVVVVVVVVVVVVVVcc",
			"VbcbbVVVVcVVVVVcbVVcbb",
			"TTTTTTTTTTTTTTTTTTTTTT",
			"DDDDB..........BDDDDDD",
			"DDDD............BDDDDD",
			"DDDB.............BDDDD",
			"DDB...I............DDD",
			"DD....I............DDD",
			"DD...II............DDD",
			"DDDDDDDB.......BDDDDDD",
			"DDDDDDB.........BDDDDD",
			"DDDDDB...........DDDDD",
			"DDDD.............DDDDD",
			"DDDD.........DDDDDDDDD",
			"DDDDDDDDDDDDDDDDDDDDDD",
	};

//			"VVVVVVVVVVVVVVVVVVVVVV",
//			"TTTTTTTTTTTTTTTTTTTTTT",
//			"DDDDD..........DDDDDDD",
//			"DDDD............DDDDDD",
//			"DDDD.............DDDDD",
//			"DDD......I.........DDD",
//			"DD.......I.........DDD",
//			"DD.......I.........DDD",
//			"DDDDDDDD.......DDDDDDD",
//			"DDDDDDD.........DDDDDD",
//			"DDDDDD...........DDDDD",
//			"DDDD.............DDDDD",
//			"DDDD.........DDDDDDDDD",
//			"DDDD........DDDDDDDDDD",
//			"BBBBBBBBBBBBBBBBBBBBBB",

	private void initializeWorldMap() {
		// Initialize your worldMap matrix with values
	}

	@Override
	public void start(Stage primaryStage) {
		initializeWorldMap();

		GridPane gridPane = new GridPane();

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				char tile = worldMap[i].charAt(j);

				ImageView imageView = new ImageView();
				imageView.setFitWidth(TILE_SIZE);
				imageView.setFitHeight(TILE_SIZE);

				if (tile == 'V') {
					// Load the 'border.png' image
					Image textureImage = new Image(getClass().getResourceAsStream("16p/VOID.png"), TILE_SIZE, TILE_SIZE, true, true);
					imageView.setImage(textureImage);
				} else if (tile == 'T') {
					// Load the 'background.png' image
					Image textureImage = new Image(getClass().getResourceAsStream("16p/TOPDIRT.png"), TILE_SIZE, TILE_SIZE, true, true);
					imageView.setImage(textureImage);
				} else if (tile == 'D') {
					// Load the 'background.png' image
					Image textureImage = new Image(getClass().getResourceAsStream("16p/DIRT.png"), TILE_SIZE, TILE_SIZE, true, true);
					imageView.setImage(textureImage);
				} else if (tile == 'B') {
					// Load the 'background.png' image
					Image textureImage = new Image(getClass().getResourceAsStream("16p/BOTTOMDIRT.png"), TILE_SIZE, TILE_SIZE, true, true);
					imageView.setImage(textureImage);
				}
				else if (tile == '.') {
					// Load the 'background.png' image
					Image textureImage = new Image(getClass().getResourceAsStream("16p/BACKGROUND.png"), TILE_SIZE, TILE_SIZE, true, true);
					imageView.setImage(textureImage);
				}
				else if (tile == 'I') {
					// Load the 'background.png' image
					Image textureImage = new Image(getClass().getResourceAsStream("16p/ICE.png"), TILE_SIZE, TILE_SIZE, true, true);
					imageView.setImage(textureImage);
				}
				else if (tile == 'b') {
					// Load the 'background.png' image
					Image textureImage = new Image(getClass().getResourceAsStream("16p/BARREL.png"), TILE_SIZE, TILE_SIZE, true, true);
					imageView.setImage(textureImage);
				}
				else if (tile == 'c') {
					// Load the 'background.png' image
					Image textureImage = new Image(getClass().getResourceAsStream("16p/CASE.png"), TILE_SIZE, TILE_SIZE, true, true);
					imageView.setImage(textureImage);
				}

				gridPane.add(imageView, j, i);
			}
		}

		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("Game World Map");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}