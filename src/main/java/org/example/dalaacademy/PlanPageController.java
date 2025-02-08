package org.example.dalaacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class PlanPageController {
    @FXML
    AnchorPane pane1;
    @FXML
    private TextField getPlan;
    private int counter = 1;
    private Stage stage;
    private Scene scene;
    int recX = 0;
    int recY = 0-74;
    int labX = 10;
    int labY = 0-74;
    @FXML
    Pane menu;
    public void addPlan() {
        Rectangle rec = new Rectangle();
        rec.setWidth(598);
        rec.setHeight(60);
        rec.setStyle(
                "-fx-fill: #e5e8ec; " +
                        "-fx-stroke: black; " +
                        "-fx-stroke-width: 1;"
        );
        rec.setLayoutX(recX);
        rec.setLayoutY(recY += 74);

        Label lab = new Label();
        lab.setMaxWidth(575);
        lab.setStyle("-fx-font-size: 20;");
        lab.setMaxHeight(52);

        if (getPlan != null && !getPlan.getText().trim().isEmpty()) {
            lab.setText(counter++ + ". " + getPlan.getText());
        } else {
            lab.setText(counter++ + ". [Пустое поле]");
        }
        lab.setLayoutX(labX);
        lab.setLayoutY(labY += 74);

        pane1.setPrefHeight(pane1.getPrefHeight() + 74);

        pane1.getChildren().addAll(rec, lab);

        getPlan.setText("");
    }




    private boolean menuFlag = false;
    public void openMenu(){
        menuFlag = !menuFlag;
        menu.setVisible(menuFlag);
    }
    public void switchToMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
    }
    public void switchToLeaderBoardPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaderBoardFxml.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
    }
}
