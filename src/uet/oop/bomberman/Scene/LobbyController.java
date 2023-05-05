package uet.oop.bomberman.Scene;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.GameControll;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LobbyController extends SceneController implements Initializable {
    /**
     * RankTable includes rank, username, point and time columns.
     * RankTable is updated whenever user click rank button or finish playing.
     */
    
    @FXML
    private TableColumn<Object, Object> rankColumn;
    @FXML
    private TableColumn<Object, Object> pointColumn;
    @FXML
    private TableColumn<Object, Object> timeColumn;
    @FXML
    private TableColumn<Object, Object> usernameColumn;

    /**
     * Scale value allows scaling table view with animation.
     */
    double scaleValue = 0;
    private Scene playingScene;

    /**
     * Set playing scene.
     */
    public void setPlayingScene(Scene playingScene) {
        this.playingScene = playingScene;
    }

    /**
     * Initialize.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        URL lobbyURL = BombermanGame.class.getResource("/UI_fxml/LobbyScene.fxml");
        if (location.equals(lobbyURL)) {
            pointColumn.setCellValueFactory(new PropertyValueFactory<>("point"));
            usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
            timeColumn.setCellValueFactory(new PropertyValueFactory<>("timeDate"));
        }
    }

    /**
     * After clicking play button, a dialog appears and allows users enter their names,
     * then system saves username and switch to playing scene.
     */
    @FXML
    public void clickPlayButton() {
        

        TextInputDialog getNameInputDialog = new TextInputDialog("username");
        getNameInputDialog.setTitle(stage.getTitle());
        getNameInputDialog.setHeaderText("Please enter your name.\nYou can cancel or close the dialog \nif you do not want game save your information.");
        getNameInputDialog.setContentText("Your name: ");
        getNameInputDialog.setGraphic(new ImageView("start/name.png"));

        Optional<String> nameInput = getNameInputDialog.showAndWait();
        if (!nameInput.isPresent()) gameControll.setUsername("username");
        else gameControll.setUsername(nameInput.get());
        GameControll.gameStatus = GameControll.GameStatus.GAME_START;
        stage.setScene(playingScene);
    }

    /**
     * Click quit button.
     */
    @FXML
    public void clickQuitButton() {
        Alert alert = new Alert(Alert.AlertType.WARNING,
                "You really want to exit :(",
                ButtonType.YES, ButtonType.CANCEL);
        alert.setHeaderText(null);
        alert.setTitle("EXIT Notification");
        alert.setGraphic((new ImageView("start/notice.png")));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) if (result.get() == ButtonType.YES) {
            System.exit(0);
        }
    }

    /**
     * Click audio button.
     */
    public void clickAudioButton() {
        GameControll.audioController.setMuted(!GameControll.audioController.isMuted());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setGraphic((new ImageView("start/notice.png")));
        alert.setTitle("AUDIO Notification");
        alert.setHeaderText(null);
        alert.setContentText("Audio has been turn " + (GameControll.audioController.isMuted() ? "off!" : "on!"));
        alert.showAndWait();
    }
}
