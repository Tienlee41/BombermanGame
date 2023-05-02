package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import uet.oop.bomberman.Scene.LobbyController;
import uet.oop.bomberman.Scene.PlayingController;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static uet.oop.bomberman.GameControll.GameStatus.GAME_LOBBY;
import static uet.oop.bomberman.GameControll.GameStatus.GAME_PLAYING;

public class GameControll {
    /**
     * Game status control.
     */
    public enum GameStatus {
        GAME_LOBBY,
        GAME_START,
        GAME_PLAYING,
        LOAD_CURRENT_LEVEL,
        WIN_ONE,
        WIN_ALL,
        GAME_LOSE,
        GAME_PAUSE,
        GAME_UNPAUSE
    }

    private Stage stage;
    private String username = "";
    private static GameControll gameControll = null;

    public static GameControll getGameControll(Stage stage) {
        if (gameControll == null) {
            gameControll = new GameControll(stage);
        }
        return gameControll;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void plusPoint(int rewardPoint) {
        gamePoint.addAndGet(rewardPoint);
    }

    public static GameStatus gameStatus;

    public static final int MAX_LEVEL = 4;

    int currentLevelCode = 0;

    private LobbyController lobbyController;
    private PlayingController playingController;

    private AtomicInteger gamePoint = new AtomicInteger();
    /**
     * AudioController can be used anywhere to play any audio if needed.
     * See how to play audio at {@link AudioController}.
     */
    private Level currentLevel;

    /**
     * Constructor with available stage.
     */
    private GameControll(Stage stage) {
        this.stage = stage;
        currentLevel = new Level(gamePoint);
    }

    public Stage getStage() {
        return stage;
    }


    /**
     * Database
     */
    private static final String url = "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6585210";
    private static final String user = "sql6585210";
    private static final String password = "Y2HBnkgMFy";
    private static final String sql = "select * from bomberman_database";
    Connection connection;
    Statement statement;


    /**
     * Timer for scenes.
     */

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            render();
            update();
        }

    };
    Scene playingScene;
    Scene lobbyScene;

    protected void update() {
    }

    protected void render() {
    }
}