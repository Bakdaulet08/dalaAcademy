
    package org.example.dalaacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

    public class cons1 {
        private Stage stage;
        private Scene scene;

        @FXML
        private Label resPoint, resPoint2;
        @FXML
        Pane menu, pane2;
        private boolean menuFlag = false,menuFlag1 = false;
        @FXML
        private RadioButton ans1, ans2, ans3, ans4, ans5;
        @FXML
        private RadioButton cr1, cr2, cr3, cr4, cr5;
        public void openMenu1(){
            menuFlag = !menuFlag;
            menu.setVisible(menuFlag);
        }
        @FXML
        private ToggleGroup q1, q2, q3, q4, q5, q10, q9, q8, q7, q6;
        public void openMenu(){
            menuFlag1 = !menuFlag1;
            pane2.setVisible(menuFlag1);
        }
        public void checkAns(){
            int counter = 0;
            if (ans1.isSelected() && q1.getSelectedToggle() != null){
                counter++;
            }
            if (ans2.isSelected() && q2.getSelectedToggle() != null){
                counter++;
            }if (ans3.isSelected() && q3.getSelectedToggle() != null){
                counter++;
            }if (ans4.isSelected() && q4.getSelectedToggle() != null){
                counter++;
            }if (ans5.isSelected() && q5.getSelectedToggle() != null){
                counter++;
            }
            System.out.println(counter);
            resPoint.setText(String.valueOf(counter));
        }
        public void checkAns2(){
            int counter = 0;
            if (cr1.isSelected() && q6.getSelectedToggle() != null){
                counter++;
            }
            if (cr2.isSelected() && q7.getSelectedToggle() != null){
                counter++;
            }if (cr3.isSelected() && q8.getSelectedToggle() != null){
                counter++;
            }if (cr4.isSelected() && q9.getSelectedToggle() != null){
                counter++;
            }if (cr5.isSelected() && q10.getSelectedToggle() != null){
                counter++;
            }
            resPoint2.setText(String.valueOf(counter));
            System.out.println(counter);
        }
        public void switchToMain(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            stage.setScene(scene);
        }
        public void switchToPlan(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("planPage.fxml"));
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

