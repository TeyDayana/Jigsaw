package com.example.jigsaw;

import javafx.application.Platform;

public class Waiter implements Runnable {
    private final Act act;
    private final Check check;

    public Waiter(Act act, Check check) {
        this.act = act;
        this.check = check;
    }

    @Override
    public void run() {
        while (true) {
            if (check.check()) {
                break;
            }
        }
        Platform.runLater(act::act);
    }
}
