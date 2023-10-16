package lab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MapGenerator extends Application {

	private static final int ROWS = 15;
	private static final int COLUMNS = 23;
	private static final int TILE_SIZE = 55; // Size of each tile in pixels

	private final String[] worldMap = {
			"VVcbVVVVVVVVVVVVcVVVbVV",
			"VbcbbVVVVcVVVVVcbcVVccb",
			"TTTTTTTTTTTTTTTTTTTTTTT",
			"DDDDBBB...........DDDDD",
			"DDDD...I........d.DDDDD",
			"DDDD...I....DBBDDDDDeDD",
			"DDDD...D...BB..BDDDeeDD",
			"eeDDDDDDD.......BDDDDDD",
			"DDDBBBBBBB.......DDDDDD",
			"DDD.........DDDDDDDDDgg",
			"DDD.........DDDDDDDDDDD",
			"DDD.d....DDDDDDDDDDDDDD",
			"DDDDDD.DDDDDDggDDDaDDDD",
			"DDDDDD.DDDDDDDDDDaaDDDD",
			"DaDDDDDDDDeeDDDDDDDDDgD",
	};

	private final Map<Character, String> tileImageMap = new HashMap<>();

	private void initializeTileImageMap() {
		tileImageMap.put('V', "16p/VOID.png");
		tileImageMap.put('T', "16p/DIRT_TOP.png");
		tileImageMap.put('D', "16p/DIRT.png");
		tileImageMap.put('B', "16p/DIRT_BOT.png");
		tileImageMap.put('.', "16p/BACKGROUND.png");
		tileImageMap.put('I', "16p/ICE.png");
		tileImageMap.put('b', "16p/BARREL.png");
		tileImageMap.put('c', "16p/CASE.png");
		tileImageMap.put('d', "16p/DOORS.png");
		tileImageMap.put('a', "16p/DIRT_DIA.png");
		tileImageMap.put('g', "16p/DIRT_GOLD.png");
		tileImageMap.put('e', "16p/DIRT_EMERALD.png");
	}

	@Override
	public void start(Stage primaryStage) {
		initializeTileImageMap();

		GridPane gridPane = new GridPane();

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				char tile = worldMap[i].charAt(j);
				ImageView imageView = new ImageView();
				imageView.setFitWidth(TILE_SIZE);
				imageView.setFitHeight(TILE_SIZE);

				// Check if the tile character is in the map
				if (tileImageMap.containsKey(tile)) {
					String imageFileName = tileImageMap.get(tile);
					Image textureImage = loadImage(imageFileName);
					if (textureImage != null) {
						imageView.setImage(textureImage);
					}
				}

				gridPane.add(imageView, j, i);
			}
		}

		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("Game World Map");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Image loadImage(String fileName) {
		try {
			InputStream stream = getClass().getResourceAsStream(fileName);
			if (stream != null) {
				return new Image(stream, TILE_SIZE, TILE_SIZE, true, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
