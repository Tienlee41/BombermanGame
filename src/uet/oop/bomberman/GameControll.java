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
            try {
                update();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };
    Scene playingScene;
    Scene lobbyScene;

    /**
     * Run game engine.
     */
    public void run() {
        stage.getIcons().add(new Image("/stageIcon.png"));
        stage.setTitle("BOMBERMAN");
        stage.setResizable(false);
        FXMLLoader fxmlLoader1 = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/UI_fxml/LobbyScene.fxml")));
        FXMLLoader fxmlLoader2 = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/UI_fxml/PlayingScene.fxml")));

        try {
            lobbyScene = new Scene(fxmlLoader1.load());
            playingScene = new Scene(fxmlLoader2.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        lobbyController = (fxmlLoader1).getController();
        playingController = (fxmlLoader2).getController();

        lobbyController.setPlayingScene(playingScene);
        playingController.setLobbyScene(lobbyScene);

        lobbyController.setGameController(this);
        playingController.setGameController(this);

        gameStatus = GameStatus.GAME_LOBBY;
        stage.setScene(lobbyScene);
        stage.show();

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (
                SQLException e) {
            e.printStackTrace();
            //System.exit(0);
        }

        timer.start();


    }

    public ResultSet getRankingSet() {
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void editRankingSet(String name, int point) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String sql = " insert into bomberman_database (name, point, date)"
                + " values (?, ?, ?)";
        PreparedStatement preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, name);
        preparedStmt.setInt(2, point);
        preparedStmt.setString(3, formatter.format(date));
        preparedStmt.execute();
    }

    /**
     * Update all specs of game, set scenes.
     */
    private void update() throws SQLException {
        lobbyController.updateStatus();
        playingController.updateStatus();

    }

    private void render() {
        if (gameStatus == GAME_PLAYING) {
            currentLevel.render();
        }
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Render into playing canvas by gc.
     */

    public void reset() {
        gamePoint.set(0);
        currentLevelCode = 0;
        currentLevel.loadLevel(currentLevelCode);
        GameControll.gameStatus = GAME_LOBBY;
    }

    /**
     * Get username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get game points.
     */
    public int getGamePoint() {
        return gamePoint.get();
    }
}
