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

public class Top10Activity extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainActivity.class.getResource
                ("top10_view.fxml"));
        AnchorPane root = fxmlLoader.load();
        root.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,
                null, null)));

        Scene scene = new Scene(root, 450, 400);
        stage.setTitle("TOP-10 games");
        stage.getIcons().add(new Image(Objects.requireNonNull
                (MainActivity.class.getResourceAsStream("icon.png"))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void close() {
        stage.close();
    }
}
