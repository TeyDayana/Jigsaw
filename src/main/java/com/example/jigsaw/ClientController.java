package com.example.jigsaw;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class ClientController {
    public Label server_host_lbl;
    public Label server_port_lbl;
    public Button connect_btn;
    public Button play_again_btn;
    public TextField server_port_text;
    public TextField server_host_text;
    public Label server_msg_lbl;
    public Label server_message;
    public Label name_lbl;
    public TextField name_text;
    public Button top10_btn;
    private int moves;
    private int time;
    private final Vector<Top10Activity> top10Activities = new Vector<>();

    @FXML
    protected void onConnectBtnClick() throws Exception {
        closeTop10Activities();
        top10_btn.setDisable(true);
        String host, port, name;

        if (name_text.getText().trim().isEmpty()) {
            server_message.setText("Please set name and try again.\n");
            return;
        }

        if (server_host_text.getText().trim().isEmpty()) {
            server_host_text.setText("localhost");
        }

        if (server_port_text.getText().trim().isEmpty()) {
            server_port_text.setText("5000");
        }

        host = server_host_text.getText();
        port = server_port_text.getText();
        name = name_text.getText();

        try {
            Client.start(host, port);
            Client.setPlayerName(name);
            Client.printToServer(name);

            server_host_text.setDisable(true);
            server_port_text.setDisable(true);
            name_text.setDisable(true);
            server_message.setText("Connected successfully!\nWait for others.");
            connect_btn.setVisible(false);

//            while (!Client.waitOthers()) {
//                Client.waitOthers();
//            }
//            begin();
            new Thread(new Waiter(this::begin, Client::waitOthers)).start();
        } catch (Exception ex) {
            server_message.setText("Can't connect.\nRun the Server Application.");
        }
    }

    @FXML
    protected void onPlayAgainBtnClick() {
        closeTop10Activities();
        top10_btn.setDisable(true);
        Client.printToServer(name_text.getText() + " is ready to play again");
        server_message.setText("Wait for others.");

        play_again_btn.setVisible(false);
        Field.filledCells = new ArrayList<>();
//            while (!Client.waitOthers()) {
//                Client.waitOthers();
//            }
//            begin();
        new Thread(new Waiter(this::begin, Client::waitOthers)).start();
    }
    
    @FXML
    protected void onTop10BtnClick() throws Exception {
        Top10Activity top10Activity = new Top10Activity();
        top10Activity.start(new Stage());
        top10Activities.add(top10Activity);
    }

    public void initialize() {
        play_again_btn.setVisible(false);
    }

    public void shutdown() {
        Client.printToServer("bye");
        DatabaseClient.finish();
        Platform.exit();
    }

    public void begin() {
        server_message.setText("Game is running...");
        DatabaseClient.create();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainActivity(ClientController.this).start(new Stage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setResults(int moves, int time) {
        server_message.setText("Game closed\nScore: " + moves + "\nTime: " + time);
        this.moves = moves;
        this.time = time;
        Client.printToServer(Client.getPlayerName() + " finished with score " + moves
                + " and time " + time);

        play_again_btn.setVisible(true);
        play_again_btn.setDisable(true);
//        while (!Client.waitFinish()) {
//            Client.waitFinish();
//        }
//        finish();
        new Thread(new Waiter(this::finish, Client::waitFinish)).start();
    }

    private void finish() {
        top10_btn.setDisable(false);
        String winner = Client.getWinnerName();
        if (Objects.equals(winner, name_text.getText())) {
            server_message.setText("Congrats!\nYou won with score " + moves + " for " + time + "sec");
        } else {
            server_message.setText(winner + " won\nYour score: " + moves + "\nYour time: " + time);
        }
        DatabaseClient.addSession(name_text.getText(), moves, time);
        play_again_btn.setDisable(false);
    }

    private void closeTop10Activities() {
        if (!top10Activities.isEmpty()) {
            for (Top10Activity activity : top10Activities) {
                activity.close();
            }
        }
    }
}
