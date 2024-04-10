package com.example.jigsaw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class GameOverActivity extends Application {
    static Stage stage;
    static String time, moves;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainActivity.class.getResource
                ("game_over_view.fxml"));
        AnchorPane root = fxmlLoader.load();
        root.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,
                null, null)));

        Scene scene = new Scene(root, 320, 120);
        stage.setTitle("Game over");
        stage.getIcons().add(new Image(Objects.requireNonNull
                (MainActivity.class.getResourceAsStream("icon.png"))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        GameOverActivity.stage = stage;
        stage.show();
    }

    public static void start(String timePassed, String movesAmount) throws Exception {
        time = timePassed;
        moves = movesAmount;
        GameOverActivity activity = new GameOverActivity();
        activity.start(new Stage());
    }

    public static void close() {
        stage.close();
    }
}
