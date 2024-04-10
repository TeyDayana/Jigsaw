package com.example.jigsaw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class ServerApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ServerApplication.class.getResource
                ("server_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 280, 280);
        stage.setTitle("Server application");
        stage.getIcons().add(new Image(Objects.requireNonNull
                (MainActivity.class.getResourceAsStream("icon.png"))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        Thread thread = ServerController.getThread();
        if (thread != null) {
//            thread.stop();
            thread.interrupt();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}
