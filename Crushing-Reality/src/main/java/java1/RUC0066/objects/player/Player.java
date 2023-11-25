package java1.RUC0066.objects.player;

import java1.RUC0066.abstraction.MovingObject;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player extends MovingObject {
    public Player(int positionX, int positionY, int width, int height, Image texture) {
        super(positionX, positionY, width, height, texture);
        System.out.println("Player generated");
    }

    @Override
    public Rectangle2D getRectangle() {
        return new Rectangle2D(this.getX(), this.getY(), this.getW(), this.getH());
    }

    @Override
    public boolean intersect(Rectangle2D rectangle) {
        return false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        gc.drawImage(this.getTexture(), this.getX(), this.getY(), this.getW(), this.getH());
        gc.restore();
    }

    @Override
    public void simulate(double deltaT) {
    }
}
