package org.example.dalaacademy;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController {
    private Stage stage;
    private Scene scene;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField getMail;

    @FXML
    private PasswordField getPass;

    @FXML
    private Button toMain;

    @FXML
    private Button toSignUp;

    @FXML
    void initialize() {
        toMain.setOnAction(event -> {
            String loginMail = getMail.getText().trim();
            String loginPass = getPass.getText().trim();

            if (!loginMail.equals("") && !loginPass.equals("")) {
                try {
                    loginUser(loginMail, loginPass);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else System.out.println("Login or Password is empty");

        });

    }
    private void loginUser(String loginMail, String loginPass) throws SQLException, IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserMail(loginMail);
        user.setPassword(loginPass);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        while (result.next()) {
            counter++;
        }
        if (counter >= 1) {
            System.out.println("Success");
            switchMain();



        } else {
            Shake userLoginAnim = new Shake(getMail);
            Shake userPassAnim = new Shake(getPass);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();

        }
    }
    public void switchToSignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
    }
    public void switchMain() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));

        Stage stage = (Stage) getMail.getScene().getWindow();  // Получаем Stage через один из элементов на сцене

        Scene scene = new Scene(root);

        stage.setScene(scene);
    }


}
