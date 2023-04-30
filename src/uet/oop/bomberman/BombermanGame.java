package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.utils.PathFile;
import uet.oop.bomberman.utils.Size;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class BombermanGame extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static final String OS_TYPE = System.getProperty("os.name");
    private static final String TITLE = "Bomberman Game";
    private static final String ICON_PATH = "/start/icon.png";
    private static final Size MAP_VIEW_SIZE = new Size(25, 15);
    public static final int SCENE_WIDTH = MAP_VIEW_SIZE.getWidthAsPixel();
    public static final int SCENE_HEIGHT = MAP_VIEW_SIZE.getHeightAsPixel();

    public static Screen_state screen_state = Screen_state.End_Game;
    public static boolean pause = false;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
    }
}
