package com.example.jigsaw;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import java.util.concurrent.Callable;

public class MainActivityController {
    @FXML
    public Button finish_btn;
    public Label timer_lbl;
    public Button generate_btn;
    public Label players_lbl;
    public Label time_limit_lbl;
    public AnchorPane pane;
    public Label player_lbl;
    int movesCounter = 0;
    Timeline timeline;
    IntegerProperty timeCounter;
    private boolean firstFigure = true;

    @FXML
    protected void onFinishBtnClick() {
        timeline.stop();
        MainActivity.close();
        MainActivity.clientController.setResults(movesCounter, timeCounter.get());
    }

    @FXML
    protected void onGenerateBtnClick() {
        ++movesCounter;
        generate_btn.setDisable(true);
        Figure figure = new Figure();
        Client.printToServer("next figure type");
        Polygon polygon = figure.getFigure(675, 250, Integer.parseInt(Client.getFromServer()));

        DraggableMaker draggableMaker = new DraggableMaker(this);
        draggableMaker.setDraggable(polygon);
        draggableMaker.currentFigureType = figure.type;
        pane.getChildren().add(polygon);
    }

    @FXML
    protected void onFieldClick() {
        if (firstFigure) {
            onGenerateBtnClick();
        }
        firstFigure = false;
    }

    public void initialize() {
        timeCounter = new SimpleIntegerProperty(0);
        KeyFrame frame = new KeyFrame(Duration.seconds(1000), new KeyValue(timeCounter, 1000));
        timeline = new Timeline(frame);
        timer_lbl.textProperty().bind(Bindings.createStringBinding(new Callable<String>() {
            @Override
            public String call() {
                return "Time passed: " + timeCounter.get();
            }
        }, timeCounter));
        timeline.play();

        String player = Client.getPlayerName();
        player_lbl.setText("The game has started, " + player);
        Client.printToServer("players names");
        String players = Client.getFromServer();

        int playerIndex = players.indexOf(player);
        players = players.substring(0, playerIndex) + players.substring(playerIndex + player.length());
        if (players.startsWith(", ")) {
            players = players.substring(2);
        } else if (players.endsWith(", ")) {
            players = players.substring(0, players.length() - 2);
        } else {
            players = players.substring(0, playerIndex) + players.substring(playerIndex + 2);
        }

        players_lbl.setText("On server: " + players);
        Client.printToServer("time limit");
        time_limit_lbl.setText("Time limit: " + Client.getFromServer());
        generate_btn.setDisable(true);
        generate_btn.setVisible(false);
    }

    public void enableGenerateBtn() {
        onGenerateBtnClick();
    }
}