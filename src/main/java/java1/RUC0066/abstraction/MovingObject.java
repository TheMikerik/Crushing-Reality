package java1.RUC0066.abstraction;

import javafx.scene.image.Image;

public abstract class MovingObject extends TextureObject{
    public MovingObject(int positionX, int positionY, int width, int height, Image texture, boolean collision_allowed) {
        super(positionX, positionY, width, height, texture, collision_allowed);
    }
}
