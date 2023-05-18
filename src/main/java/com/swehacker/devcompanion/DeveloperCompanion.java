package com.swehacker.devcompanion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class DeveloperCompanion extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageStyle style = StageStyle.DECORATED;

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/main.fxml")));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Developer Companion");

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((screenBounds.getWidth() - primaryStage.getScene().getWidth()) / 2);
        primaryStage.setY((screenBounds.getHeight() - primaryStage.getScene().getHeight()) / 2);

        primaryStage.setResizable(true);
        primaryStage.initStyle(style);

        primaryStage.show();
    }
}
