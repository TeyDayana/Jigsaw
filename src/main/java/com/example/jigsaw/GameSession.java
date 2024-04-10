package com.example.jigsaw;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GameSession {
    private String login;
    private Timestamp date;
    private int score, time;

    public GameSession(String login, String score, String time) {
        this.login = login;
        this.date = Timestamp.valueOf(LocalDateTime.now());
        this.score = Integer.parseInt(score);
        this.time = Integer.parseInt(time);
    }

    public String getLogin() {
        return login;
    }

    public Timestamp getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }
}
