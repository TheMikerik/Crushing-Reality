package java1.RUC0066.objects.map;

import java1.RUC0066.abstraction.DrawableSimulable;
import java1.RUC0066.IO.GameInfo;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Coins implements DrawableSimulable {
    private Point2D[] coinsLocation;
    private Coin[] coins;
    private int tileSize;
    private int level;

    public Coins(GameInfo gi){
        this.tileSize = gi.getTileSize();
        this.level = gi.getLevel();

        this.coinsLocation = getCoinsLocation(level);
        this.coins = new Coin[coinsLocation.length];
        this.initializeCoins();
    }

    private Point2D[] getCoinsLocation(int level){
        Point2D[] coinLocations;

        switch(level){
            case 1:
                coinLocations = new Point2D[]{
                        new Point2D(10, 4),
                        new Point2D(17, 7),
                        new Point2D(6, 7)
                };
                break;
            case 2:
                coinLocations = new Point2D[]{
                        new Point2D(2, 6),
                        new Point2D(9, 3),
                        new Point2D(19, 3)
                };
                break;
            default:
                return null;
        }

        return coinLocations;
    }

    private void initializeCoins(){
        Image texture = new Image(getClass().getResourceAsStream(("/java1/RUC0066/textures-16p/COIN.png")));
        for(int i=0; i < coinsLocation.length ; i++){
            Point2D coin = coinsLocation[i];
            coins[i] = new Coin(
                    (int) coin.getX() * 55,
                    (int) coin.getY() * 55,
                    this.tileSize, 
                    this.tileSize,
                    texture,
                    false );
        }
    }


    public Coin[] getCoins(){
        return this.coins;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        for( Coin coin : coins){
            coin.draw(gc);
        }
        gc.restore();
    }

    @Override
    public void simulate(GraphicsContext gc) {
        gc.save();
        for(Coin coin : coins){
            coin.draw(gc);
        }
        gc.restore();
    }
}
