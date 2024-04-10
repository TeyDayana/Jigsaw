package com.example.jigsaw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {
    @FXML
    public Label time_passed_lbl;
    public Label moves_amount_lbl;

    @FXML
    protected void onExitBtnClick() {
        MainActivity.close();
        GameOverActivity.stage.close();
    }

    @FXML
    protected void onNewGameBtnClick() throws IOException {
        onExitBtnClick();
        MainActivity activity = new MainActivity(MainActivity.clientController);
        activity.start(new Stage());
    }

    public void initialize() {
        time_passed_lbl.setText(GameOverActivity.time + " seconds");
        moves_amount_lbl.setText("Moves made: " + GameOverActivity.moves);
    }
}
