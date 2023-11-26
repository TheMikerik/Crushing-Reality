package java1.RUC0066.abstraction;

import javafx.scene.image.Image;

public abstract class TextureObject extends GameObject implements DrawableSimulable {
    protected Image texture;

    public TextureObject(int positionX, int positionY, int width, int height, Image texture, boolean collision_allowed){
        super(positionX, positionY, width, height, collision_allowed);
        this.texture = texture;
    }

    public Image getTexture(){
        return texture;
    }
}