package lab;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MapGen {
    private static final int TILE_SIZE = 48;
    private char[][] worldMap;
    private Map<Character, Image> tileImages = new HashMap<>();

    public MapGen(char[][] worldMap) {
        this.worldMap = worldMap;
        initializeTileImages();
    }

    private void initializeTileImages() {
        // Load and store images for each character in your map
        tileImages.put('V', loadImage("16p/VOID.png"));
        tileImages.put('T', loadImage("16p/DIRT_TOP.png"));
        tileImages.put('D', loadImage("16p/DIRT.png"));
        tileImages.put('B', loadImage("16p/DIRT_BOT.png"));
        tileImages.put('.', loadImage("16p/BACKGROUND.png"));
        tileImages.put('I', loadImage("16p/ICE.png"));
        tileImages.put('b', loadImage("16p/BARREL.png"));
        tileImages.put('c', loadImage("16p/CASE.png"));
        tileImages.put('d', loadImage("16p/DOORS.png"));
        tileImages.put('a', loadImage("16p/DIRT_DIA.png"));
        tileImages.put('g', loadImage("16p/DIRT_GOLD.png"));
        tileImages.put('e', loadImage("16p/DIRT_EMERALD.png"));
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

    public void drawMap(GraphicsContext gc) {
        for (int i = 0; i < worldMap.length; i++) {
            for (int j = 0; j < worldMap[i].length; j++) {
                char tile = worldMap[i][j];
                if (tileImages.containsKey(tile)) {
                    Image image = tileImages.get(tile);
                    gc.drawImage(image, j * TILE_SIZE, i * TILE_SIZE);
                }
            }
        }
    }
}
