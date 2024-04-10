package com.example.jigsaw;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Field {
    static List<Integer> filledCells = new ArrayList<>();

    public static Pair<Integer, Integer> getLayout(double currentX, double currentY) {
        int layoutX, layoutY;
        int remainderX = (int)(currentX % 50);
        int remainderY = (int)(currentY % 50);

        if (remainderX <= 25) {
            layoutX = (int)currentX - remainderX;
        } else {
            layoutX = (int)currentX + 50 - remainderX;
        }

        if (remainderY <= 25) {
            layoutY = (int)currentY - remainderY;
        } else {
            layoutY = (int)currentY + 50 - remainderY;
        }
        return new Pair<>(layoutX, layoutY);
    }

    public static List<Integer> getCellNumbers(int type, int layoutX, int layoutY) {
        List<Integer> currentCells = new ArrayList<>();
        int remainder = layoutX / 50;
        int multiplier = layoutY / 50;
        int cellNumber = (multiplier - 1) * 9 + remainder - 1;

        if (type == 0) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 18);
        }

        if (type == 1) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 11);
        }

        if (type == 2) {
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 18);
            currentCells.add(cellNumber + 19);
        }

        if (type == 3) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 11);
        }

        if (type == 4) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 19);
        }

        if (type == 5) {
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 11);
        }

        if (type == 6) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 18);
            currentCells.add(cellNumber + 19);
        }

        if (type == 7) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 9);
        }

        if (type == 8) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 19);
        }

        if (type == 9) {
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
        }

        if (type == 10) {
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 18);
        }

        if (type == 11) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 11);
        }

        if (type == 12) {
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 11);
            currentCells.add(cellNumber + 18);
            currentCells.add(cellNumber + 19);
            currentCells.add(cellNumber + 20);
        }

        if (type == 13) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 18);
            currentCells.add(cellNumber + 19);
            currentCells.add(cellNumber + 20);
        }

        if (type == 14) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 18);
        }

        if (type == 15) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 11);
            currentCells.add(cellNumber + 20);
        }

        if (type == 16) {
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 18);
            currentCells.add(cellNumber + 19);
            currentCells.add(cellNumber + 20);
        }

        if (type == 17) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 19);
        }

        if (type == 18) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 11);
            currentCells.add(cellNumber + 18);
        }

        if (type == 19) {
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 11);
            currentCells.add(cellNumber + 20);
        }

        if (type == 20) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 2);
        }

        if (type == 21) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 18);
        }

        if (type == 22) {
            currentCells.add(cellNumber);
        }

        if (type == 23) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 9);
        }

        if (type == 24) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 10);
        }

        if (type == 25) {
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
        }

        if (type == 26) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
        }

        if (type == 27) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 18);
        }

        if (type == 28) {
            currentCells.add(cellNumber);
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 2);
            currentCells.add(cellNumber + 10);
        }

        if (type == 29) {
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 19);
        }

        if (type == 30) {
            currentCells.add(cellNumber + 1);
            currentCells.add(cellNumber + 9);
            currentCells.add(cellNumber + 10);
            currentCells.add(cellNumber + 11);
        }
        return currentCells;
    }

    public static boolean canLocate(List<Integer> layoutCells) {
        for (int cell : layoutCells) {
            if (filledCells.contains(cell)) {
                return false;
            }
        }
        filledCells.addAll(layoutCells);
        return true;
    }
}
