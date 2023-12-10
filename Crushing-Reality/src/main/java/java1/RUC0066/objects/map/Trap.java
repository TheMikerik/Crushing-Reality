package java1.RUC0066.objects.map;

import java1.RUC0066.abstraction.TextureObject;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Trap extends TextureObject {
    Trap(int positionX, int positionY, int width, int height, Image texture, boolean collision_allowed) {
        super(positionX, positionY, width, height, texture, collision_allowed);
    }

    @Override
    public Rectangle2D getRectangle() {
        return new Rectangle2D(this.getX(), this.getY(), this.getH(), this.getW());
    }

    @Override
    public boolean intersect(Rectangle2D rectangle) {
        return getRectangle().intersects(rectangle);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        gc.drawImage(this.getTexture(), this.getX(), this.getY(), this.getH(), this.getW());
        gc.restore();
    }

    @Override
    public void simulate(GraphicsContext gc) {

    }
}
