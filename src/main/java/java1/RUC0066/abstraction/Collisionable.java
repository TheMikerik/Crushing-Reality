package java1.RUC0066.abstraction;

import javafx.geometry.Rectangle2D;

public interface Collisionable {
    Rectangle2D getRectangle();

    boolean intersect(Rectangle2D rectangle);
}
