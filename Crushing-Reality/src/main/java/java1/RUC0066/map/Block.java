package java1.RUC0066.map;

import java1.RUC0066.abstraction.TextureObject;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Block extends TextureObject {
    private int x;
    private int y;
    private int w;
    private int h;

    Block(int positionX, int positionY, int width, int height, Image texture) {
        super(positionX, positionY, width, height, texture);
        this.x = positionX;
        this.y = positionY;
        this.w = width;
        this.h = height;
    }

    @Override
    public boolean intersect(Rectangle2D rectangle) {
        return false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        gc.drawImage(this.getTexture(), x, y, w, h);
        gc.restore();
    }

    @Override
    public void simulate(double deltaT) {
    }
}
