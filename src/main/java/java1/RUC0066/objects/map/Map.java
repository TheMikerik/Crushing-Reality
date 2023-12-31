package java1.RUC0066.objects.map;

import java1.RUC0066.abstraction.DrawableSimulable;

import java1.RUC0066.IO.GameInfo;
import java1.RUC0066.IO.Readers.MapReader;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.HashMap;


public class Map implements DrawableSimulable {
    private char[][] worldMap;
    private java.util.Map<Character, Image>  tileImages = new HashMap<>();
    private Block[][] blocks;
    private int block_height;
    private int block_length;
    private int TILE_SIZE;
    private MapReader map_reader;

    private Point2D spawnPoint;
    private Point2D exitPoint;

    public Map(GameInfo gi) {
        TILE_SIZE = gi.getTileSize();

        initializeTileImages();

        this.map_reader = new MapReader(15,23);
        this.worldMap = map_reader.LoadNextMap(gi.getLevel());

        this.block_height = worldMap.length;
        this.block_length = worldMap[0].length;

        this.blocks = new Block[block_height][block_length];

        this.initializeBlocks();
        gi.saveMapBlocks(blocks);
        gi.setSpawn(this.getSpawnPoint());
        gi.setExit(this.getExitPoint());
    }

    private void initializeBlocks(){
        for (int i = 0; i < worldMap.length; i++) {
            for (int j = 0; j < worldMap[i].length; j++) {
                char tile = worldMap[i][j];
                if (tileImages.containsKey(tile)) {
                    Image image = tileImages.get(tile);

                    if (tile != '.' && tile != 'd' && tile != 'o'){
                        blocks[i][j] = new Block(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE, image, true);
                    }
                    else {
                        blocks[i][j] = new Block(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE, image, false);
                        if (tile == 'd') {
                            this.spawnPoint = new Point2D(j * TILE_SIZE, i * TILE_SIZE);
                        }
                        if (tile == 'o') {
                            this.exitPoint = new Point2D(j * TILE_SIZE, i * TILE_SIZE);
                        }
                    }
                }
            }
        }
    }

    private void initializeTileImages() {
        // Load and store images for each character in your map
        tileImages.put('V', loadImage("/java1/RUC0066/textures-16p/World/VOID.png"));
        tileImages.put('T', loadImage("/java1/RUC0066/textures-16p/World/DIRT_TOP.png"));
        tileImages.put('D', loadImage("/java1/RUC0066/textures-16p/World/DIRT.png"));
        tileImages.put('B', loadImage("/java1/RUC0066/textures-16p/World/DIRT_BOT.png"));
        tileImages.put('.', loadImage("/java1/RUC0066/textures-16p/World/BACKGROUND.png"));
        tileImages.put('I', loadImage("/java1/RUC0066/textures-16p/World/ICE.png"));
        tileImages.put('b', loadImage("/java1/RUC0066/textures-16p/World/BARREL.png"));
        tileImages.put('c', loadImage("/java1/RUC0066/textures-16p/World/CASE.png"));
        tileImages.put('d', loadImage("/java1/RUC0066/textures-16p/World/DOORS.png"));
        tileImages.put('o', loadImage("/java1/RUC0066/textures-16p/World/DOORS.png"));
        tileImages.put('a', loadImage("/java1/RUC0066/textures-16p/World/DIRT_DIA.png"));
        tileImages.put('g', loadImage("/java1/RUC0066/textures-16p/World/DIRT_GOLD.png"));
        tileImages.put('e', loadImage("/java1/RUC0066/textures-16p/World/DIRT_EMERALD.png"));

    }

    private Image loadImage(String fileName) {
        try {
            InputStream stream = getClass().getResourceAsStream(fileName);
            if (stream == null) {
                throw new RuntimeException("Texture     " + fileName + "     not loaded\n\n");
            }
            else {
                return new Image(stream, TILE_SIZE, TILE_SIZE, true, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Point2D getSpawnPoint(){
        return spawnPoint;
    }
    public Point2D getExitPoint(){
        return exitPoint;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        for (Block[] row : blocks) {
            for (Block block : row) {
                block.draw(gc);
            }
        }
        gc.restore();
        System.out.println("Map loaded successfully");
    }

    @Override
    public void simulate(GraphicsContext gc) {
        for (Block[] row : blocks) {
            for (Block block : row) {
                block.draw(gc);
            }
        }
    }
}