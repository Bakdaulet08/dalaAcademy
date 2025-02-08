package org.example.dalaacademy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage" +
                ".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1540, 785);
        stage.setTitle("Dala Academy");
        stage.setScene(scene);
        stage.show();
        Image logo = new Image(new FileInputStream("src/main/resources/images/logoDala1.png"));
        stage.getIcons().add(logo);
    }

    public static void main(String[] args) {
        launch();
    }
}