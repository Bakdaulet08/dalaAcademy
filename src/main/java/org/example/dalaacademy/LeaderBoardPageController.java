package org.example.dalaacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;

public class LeaderBoardPageController {
    private Stage stage;
    private Scene scene;
    @FXML
    private ListView<String> leaderBoard;

    private ObservableList<String> leaderboardData;

    @FXML
    private Button addMember;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField playerScoreField;

    @FXML
    private TextField playerNameFIeld;
    @FXML
    Pane menu;
    private boolean menuFlag = false;
    private Timeline timeline;
    public void openMenu(){
        menuFlag = !menuFlag;
        menu.setVisible(menuFlag);
    }

    @FXML
    public void initialize() {
        leaderboardData = FXCollections.observableArrayList();
        leaderBoard.setItems(leaderboardData);

        timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }



    private void sortLeaderboard() {
        leaderboardData.sort((a, b) -> {
            int scoreA = Integer.parseInt(a.split("- ")[1].split(" ")[0]);
            int scoreB = Integer.parseInt(b.split("- ")[1].split(" ")[0]);
            return Integer.compare(scoreB, scoreA);
        });
    }

    @FXML
    private void handleAddPlayer() {
        String playerName = playerNameFIeld.getText();
        String playerScoreText = playerScoreField.getText();

        if (playerName.isEmpty() || playerScoreText.isEmpty()) {
            errorLabel.setText("Введите имя и очки участника!");
        } else {
            try {
                int playerScore = Integer.parseInt(playerScoreText);
                String newPlayer = playerName + " - " + playerScore + " points";
                leaderboardData.add(newPlayer);
                sortLeaderboard();
                errorLabel.setText("");

                playerNameFIeld.clear();
                playerScoreField.clear();
            } catch (NumberFormatException e) {
                errorLabel.setText("Очки должны быть числом!");
            }
        }

    }
    public void switchToPlan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("planPage.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
    }

    public void switchToMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
    }
}