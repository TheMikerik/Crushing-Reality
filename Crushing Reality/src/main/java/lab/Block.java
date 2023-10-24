package lab;

import javafx.geometry.Rectangle2D;

public class Block implements Collisionable {

    Rectangle2D block;

    public Block(double wdth, double hght, double tile, double tileSize) {
        new Rectangle2D(wdth, hght, tile, tile);
    }

    @Override
    public Rectangle2D getBoundingBox() {
        return this.block;
    }
}