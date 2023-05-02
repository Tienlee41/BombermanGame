package uet.oop.bomberman;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.map.Map;
import uet.oop.bomberman.Scene.SceneController;

import java.util.concurrent.atomic.AtomicInteger;

public class Level {
    public static int MAX_TIME = 180;
    private final AtomicInteger levelCode = new AtomicInteger(0);
    private Map gameMap;
    private int levelPoint;
    AtomicInteger gamePoint;
    public static Canvas playingCanvas = new Canvas(SceneController.SCREEN_WIDTH,
            SceneController.SCREEN_HEIGHT - 30);
    private GraphicsContext gc = playingCanvas.getGraphicsContext2D();

    public Level(AtomicInteger gamePoint) {
    }
    
    public AtomicInteger getLevelCode() {
        return levelCode;
    }
    public void update() {
    }
    public void render() {
    }
    public void reset() {
    }
    public void plusPoint(int rewardPoint) {
        levelPoint += rewardPoint;
        gamePoint.addAndGet(rewardPoint);
    }

    public int bonusRewardPoint() {
        return levelCode.get() * 100;
    }

    public Map getGameMap() {
        return gameMap;
    }
}
