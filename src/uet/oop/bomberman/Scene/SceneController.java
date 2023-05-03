package uet.oop.bomberman.Scene;

import javafx.stage.Stage;
import uet.oop.bomberman.GameControll;

public abstract class SceneController {
    
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 400;

    Stage stage;
    GameControll gameControll;

    public void setGameControll(GameControll gameControll) {
        this.gameControll = gameControll;
        this.stage = gameControll.getStage();
    }
}
