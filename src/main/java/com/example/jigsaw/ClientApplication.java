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

import java.util.Objects;

public class ClientApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource
                ("client_view.fxml"));
        ClientController controller = fxmlLoader.getController();
        AnchorPane root = fxmlLoader.load();
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE,
                null, null)));

        Scene scene = new Scene(root, 280, 370);
        stage.setTitle("Client application");

        stage.getIcons().add(new Image(Objects.requireNonNull
                (MainActivity.class.getResourceAsStream("icon.png"))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setOnHidden(e -> controller.shutdown());
        stage.show();
    }
}
