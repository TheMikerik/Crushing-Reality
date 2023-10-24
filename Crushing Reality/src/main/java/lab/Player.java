package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

public class Player implements Collisionable {

    Point2D position;
    double width = 50;
    double height = 100;
    Rectangle2D rect;


    public Player(Point2D pos) {
        this.position = pos;

        this.rect = new Rectangle2D(pos.getX(), pos.getY(), width, height);
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(position.getX(), position.getY(), width, height);
    }

    @Override
    public Rectangle2D getBoundingBox(){
        return new Rectangle2D(this.position.getX(), this.position.getY(), width, height);
    }

}