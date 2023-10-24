package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;

import java.io.InputStream;
import java.util.HashMap;

public class Map implements DrawableSimulable{
    private static final double TILE_SIZE = 55;
    private Player player = new Player(new Point2D(5*TILE_SIZE, 5*TILE_SIZE));
    private char[][] worldMap = {
        {'V', 'V', 'c', 'b', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'c', 'V', 'V', 'V', 'b', 'V', 'V', 'V', 'V', 'V'},
        {'V', 'b', 'c', 'b', 'b', 'V', 'V', 'V', 'c', 'V', 'V', 'V', 'V', 'c', 'b', 'c', 'c', 'b', 'c', 'c', 'V', 'V', 'V'},
        {'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T'},
        {'D', 'D', 'D', 'D', 'D', 'B', 'B', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D'},
        {'D', 'D', 'D', 'D', 'D', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'd', '.', 'D', 'D', 'D', 'D', 'D'},
        {'D', 'D', 'D', 'D', 'D', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D'},
        {'D', 'D', 'D', 'D', 'D', '.', '.', '.', '.', '.', '.', '.', 'B', 'D', 'B', 'B', 'B', 'B', 'D', 'D', 'D', 'D', 'D'},
        {'e', 'e', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'B', '.', '.', '.', 'B', '.', '.', '.', '.', 'B', 'D', 'D', 'e', 'D'},
        {'D', 'D', 'D', 'D', 'B', 'B', 'B', 'B', 'B', '.', '.', 'D', '.', '.', '.', '.', '.', '.', '.', 'D', 'e', 'e', 'D'},
        {'D', 'D', 'D', 'D', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D'},
        {'D', 'D', 'D', 'D', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', '.', 'D', '.', '.', '.', '.', 'D', 'D', 'D', 'D'},
        {'D', 'D', 'D', 'D', '.', 'd', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'D', 'D', 'D', 'D', 'D'},
        {'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', '.', 'a', 'D', 'D', 'D', 'D', 'D'},
        {'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'a', '.', 'D', 'D', 'D', 'D', 'g', 'g'},
        {'D', 'a', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'e', 'e', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'g'}
    };
    private Collisionable[] map_blocks;
    private java.util.Map<Character, Image>  tileImages = new HashMap<>();

    public Map() {
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

    @Override
    public void draw(GraphicsContext gc) {
        for (int i = 0; i < worldMap.length; i++) {
            for (int j = 0; j < worldMap[i].length; j++) {
                char tile = worldMap[i][j];
                if (tileImages.containsKey(tile)) {
                    Image image = tileImages.get(tile);
                    gc.drawImage(image, j * TILE_SIZE, i * TILE_SIZE);
                    if(tile == '.' || tile == 'd') {
                        System.out.println("Void at " + i  + " " + j);
                    }
                    else{
                        map_blocks = new Collisionable[]{
                                        new Block(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE)};
                    }
                }
            }
        }
        player.draw(gc);
    }

    @Override
    public void simulate(double deltaT){
    }
}
