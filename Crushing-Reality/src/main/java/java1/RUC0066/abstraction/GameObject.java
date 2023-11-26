package java1.RUC0066.abstraction;

import javafx.geometry.Rectangle2D;

public abstract class GameObject implements Collisionable {
    private int positionX;
    private int positionY;
    private int width;
    private int height;

    private Rectangle2D rectangle;

    public GameObject(int positionX, int positionY, int width, int height){
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;

        this.rectangle = new Rectangle2D(positionX, positionY, width, height);
    }

    public int getX() { return positionX;}
    public int getY() { return positionY;}
    public int getW() { return width;}
    public int getH() { return height;}

    public void setX(int newX) { this.positionX = newX;}
    public void setY(int newY) { this.positionY = newY;}
}
