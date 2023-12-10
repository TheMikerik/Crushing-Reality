package java1.RUC0066;

import java1.RUC0066.abstraction.DrawableSimulable;
import java1.RUC0066.objects.GameInfo;
import java1.RUC0066.objects.map.*;
import java1.RUC0066.objects.player.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Game {
    private final Canvas canvas;

    private GameInfo gameInfo;

    private DrawableSimulable[] entities;
    //0-map, 1-player, 2-Coins

    public Game(Canvas canvas) {
        this.canvas = canvas;
        this.gameInfo = new GameInfo();
        this.entities = new DrawableSimulable[4];

        entities[0] = new Map(gameInfo);
        entities[1] = new Coins(gameInfo);
        entities[2] = new Traps(gameInfo);
        entities[3] = new Player(gameInfo);
    }

    public void switchMap(){
        if( this.getPlayer().get_picked_coins() == 3 && this.getPlayer().canExitMap() ) {
            System.out.println("Exiting map");
        }
    }
    public void draw(GraphicsContext gc) {
        for( DrawableSimulable entity : entities){
            entity.draw(gc);
        }
    }

    public void simulate(GraphicsContext gc) {
        this.switchMap();

        for (DrawableSimulable entity : entities) {
            entity.simulate(gc);
            if (entity instanceof Coins coins){
                for(Coin coin : coins.getCoins()) {
                    for (DrawableSimulable entity2 : entities){
                        if(entity2 instanceof Player player){
                           if(coin.intersect(player.getRectangle())){
                               if (coin.getDisplayStatus()) {
                                   this.getPlayer().pickCoin();
                                   coin.setNotDisplay();
                               }
                           }
                        }
                    }
                }
            }
            if (entity instanceof Traps traps){
                for(Trap trap : traps.getTraps()) {
                    for (DrawableSimulable entity2 : entities){
                        if(entity2 instanceof Player player){
                            if(trap.intersect(player.getRectangle())){
                                this.getPlayer().respawnPlayer();
                            }
                        }
                    }
                }
            }
        }
    }

    public Player getPlayer(){
        return (Player)this.entities[3];
    }
}
