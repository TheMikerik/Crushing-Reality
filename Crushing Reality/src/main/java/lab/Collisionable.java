package lab;

import javafx.geometry.Rectangle2D;

public interface Collisionable {
    Rectangle2D getBoundingBox();

    default boolean checkCollision(Object obstacle){
        if (obstacle instanceof Collisionable obs && this.getBoundingBox().intersects(obs.getBoundingBox())){
            return true;
        }
        return false;
    }
}
