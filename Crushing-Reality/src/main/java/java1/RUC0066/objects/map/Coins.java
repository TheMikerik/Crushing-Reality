package java1.RUC0066.objects.map;

import java1.RUC0066.abstraction.DrawableSimulable;
import java1.RUC0066.objects.GameInfo;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Coins implements DrawableSimulable {
    private Point2D[] coinLocations2 = {
        new Point2D(10, 4),
        new Point2D(17, 7),
        new Point2D(6, 8)
    };
    private Point2D[] coinLocations = {
            new Point2D(11, 12),
            new Point2D(9, 3),
            new Point2D(19, 3)
    };

    private Coin[] coins;
    private int tileSize;

    public Coins(GameInfo gi){
        this.tileSize = gi.getTileSize();

        this.coins = new Coin[coinLocations.length];
        this.initializeCoins();
        gi.saveCoins(coins);
    }

    private void initializeCoins(){
        Image texture = new Image(getClass().getResourceAsStream(("/java1/RUC0066/textures-16p/COIN.png")));
        for(int i=0; i < coinLocations.length ; i++){
            Point2D coin = coinLocations[i];
            coins[i] = new Coin(
                    (int)coin.getX() * 55,
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
