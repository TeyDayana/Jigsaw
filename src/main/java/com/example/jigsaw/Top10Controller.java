package com.example.jigsaw;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Top10Controller {
    public TableView<GameSession> table;
    public TableColumn<GameSession, String> login_col;
    public TableColumn<GameSession, String> date_col;
    public TableColumn<GameSession, String> score_col;
    public TableColumn<GameSession, String> time_col;

    public void initialize() {
        
    }
}
