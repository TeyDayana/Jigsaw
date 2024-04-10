package com.example.jigsaw;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ServerController {
    private static Thread thread;
    public Label players_amount_lbl;
    public Label time_limit_lbl;
    public Button begin_btn;
    public TextField time_limit_text;
    public TextField players_amount_text;
    public Label server_msg_lbl;
    public Label server_message;

    public static Thread getThread() {
        return thread;
    }

    @FXML
    protected void onBeginBtnClick() throws Exception {
        int playersAmount, timeLimit;
        try {
            playersAmount = Integer.parseInt(players_amount_text.getText());
            timeLimit = Integer.parseInt(time_limit_text.getText());
        } catch (Exception e) {
            server_message.setText("Cannot parse data to integers... Try again.\n");
            return;
        }

        if (playersAmount > 0 && timeLimit > 0) {
            players_amount_text.setDisable(true);
            time_limit_text.setDisable(true);
            begin_btn.setDisable(true);

            thread = new Thread(new Server());
            Server.setPlayersAmount(playersAmount);
            Server.setTimeLimit(timeLimit);

            thread.start();
            server_message.setText("""
                    Server started successfully!
                    Please run Client Application.
                    Waiting for clients on port 5000.""");
        } else {
            server_message.setText("Please type in only positive numbers! Try again.\n");
        }
    }
}
