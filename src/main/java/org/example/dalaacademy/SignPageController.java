package org.example.dalaacademy;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignPageController {

    @FXML
    private ResourceBundle resources;
    Pane smthIsEmpty;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistr;

    @FXML
    private TextField setLogin;

    @FXML
    private TextField setName;

    @FXML
    private PasswordField setPass;

    @FXML
    void initialize() {

    }
    @FXML
    private void signUpNewUser(ActionEvent event) {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String userName = setName.getText().trim();
        String userMail = setLogin.getText().trim();
        String userPassword = setPass.getText().trim();

        if (userName.isEmpty() || userMail.isEmpty() || userPassword.isEmpty()) {
            System.out.println("Все поля должны быть заполнены.");
            FadeTransition fd1 = new FadeTransition(Duration.millis(3000), smthIsEmpty);
            fd1.setFromValue(1.0);
            fd1.setToValue(0.0);
            fd1.play();

        }

        User user = new User(userName, userMail, userPassword);

        try {
            dbHandler.signUpUser(user);
            System.out.println("Регистрация прошла успешно!");

            Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка регистрации: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Класс не найден: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка загрузки страницы логина: " + ex.getMessage());
        }
    }

}
