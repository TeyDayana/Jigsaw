package com.example.jigsaw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainActivity extends Application {
    static Stage stage;
    static AnchorPane root;
    static ClientController clientController;

    MainActivity(ClientController controller) {
        clientController = controller;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainActivity.class.getResource
                ("main_view.fxml"));
        root = fxmlLoader.load();
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE,
                null, null)));

        Canvas canvas = new Canvas(510, 510);
        drawField(canvas.getGraphicsContext2D());
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 1024, 600);
        stage.setTitle("Jigsaw");
        stage.getIcons().add(new Image(Objects.requireNonNull
                (MainActivity.class.getResourceAsStream("icon.png"))));
        stage.setResizable(false);
        stage.setScene(scene);
        MainActivity.stage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void close() {
        stage.close();
    }

    private void drawField(GraphicsContext context) {
        context.setFill(Color.LIGHTSKYBLUE);
        context.fillRect(50, 50, 450, 450);
        context.setStroke(Color.AQUAMARINE);
        context.setLineWidth(5);

        int horizontalY = 50;
        for (int i = 0; i < 10; ++i, horizontalY += 50) {
            context.strokeLine(50, horizontalY, 500, horizontalY);
        }

        int verticalX = 50;
        for (int i = 0; i < 10; ++i, verticalX += 50) {
            context.strokeLine(verticalX, 50, verticalX, 500);
        }
    }
}