package com.example.jigsaw;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.Random;

public class Figure {
    Random random = new Random();
    int type;

    public Polygon getFigure(int x, int y) {
        type = random.nextInt(31);
        return getPolygon(x, y, type);
    }

    public Polygon getFigure(int x, int y, int type) {
        return getPolygon(x, y, type);
    }

    private Polygon getPolygon(int x, int y, int type) {
        Polygon polygon = new Polygon(0, 0, 0, 0);

        if (type == 0) {
            polygon = new Polygon(x, y, x + 2 * 50, y, x + 2 * 50, y + 50,
                    x + 50, y + 50, x + 50, y + 3 * 50, x, y + 3 * 50);
        }

        if (type == 1) {
            polygon = new Polygon(x, y, x + 50, y, x + 50, y + 50,
                    x + 3 * 50, y + 50, x + 3 * 50, y + 2 * 50, x, y + 2 * 50);
        }

        if (type == 2) {
            polygon = new Polygon(x + 50, y, x + 2 * 50, y, x + 2 * 50, y + 3 * 50,
                    x, y + 3 * 50, x, y + 2 * 50, x + 50, y + 2 * 50);
        }

        if (type == 3) {
            polygon = new Polygon(x, y, x + 3 * 50, y, x + 3 * 50, y + 2 * 50,
                    x + 2 * 50, y + 2 * 50, x + 2 * 50, y + 50, x, y + 50);
        }

        if (type == 4) {
            polygon = new Polygon(x, y, x + 2 * 50, y, x + 2 * 50, y + 3 * 50,
                    x + 50, y + 3 * 50, x + 50, y + 50, x, y + 50);
        }

        if (type == 5) {
            polygon = new Polygon(x + 2 * 50, y, x + 3 * 50, y, x + 3 * 50, y + 2 * 50,
                    x, y + 2 * 50, x, y + 50, x + 2 * 50, y + 50);
        }

        if (type == 6) {
            polygon = new Polygon(x, y,
                    x + 50, y, x + 50, y + 2 * 50, x + 2 * 50, y + 2 * 50,
                    x + 2 * 50, y + 3 * 50, x, y + 3 * 50);
        }

        if (type == 7) {
            polygon = new Polygon(x, y, x + 3 * 50, y, x + 3 * 50, y + 50,
                    x + 50, y + 50, x + 50, y + 2 * 50, x, y + 2 * 50);
        }

        if (type == 8) {
            polygon = new Polygon(x, y, x + 50, y, x + 50, y + 50, x + 2 * 50, y + 50,
                    x + 2 * 50, y + 3 * 50, x + 50, y + 3 * 50, x + 50, y + 2 * 50, x, y + 2 * 50);
        }

        if (type == 9) {
            polygon = new Polygon(x + 50, y, x + 3 * 50, y, x + 3 * 50, y + 50, x + 2 * 50, y + 50,
                    x + 2 * 50, y + 2 * 50, x, y + 2 * 50, x, y + 50, x + 50, y + 50);
        }

        if (type == 10) {
            polygon = new Polygon(x + 50, y, x + 2 * 50, y, x + 2 * 50, y + 2 * 50, x + 50, y + 2 * 50,
                    x + 50, y + 3 * 50, x, y + 3 * 50, x, y + 50, x + 50, y + 50);
        }

        if (type == 11) {
            polygon = new Polygon(x, y, x + 2 * 50, y, x + 2 * 50, y + 50, x + 3 * 50, y + 50,
                    x + 3 * 50, y + 2 * 50, x + 50, y + 2 * 50, x + 50, y + 50, x, y + 50);
        }

        if (type == 12) {
            polygon = new Polygon(x + 2 * 50, y, x + 3 * 50, y, x + 3 * 50, y + 3 * 50,
                    x, y + 3 * 50, x, y + 2 * 50, x + 2 * 50, y + 2 * 50);
        }

        if (type == 13) {
            polygon = new Polygon(x, y, x + 50, y, x + 50, y + 2 * 50,
                    x + 3 * 50, y + 2 * 50, x + 3 * 50, y + 3 * 50, x, y + 3 * 50);
        }

        if (type == 14) {
            polygon = new Polygon(x, y, x + 3 * 50, y, x + 3 * 50, y + 50,
                    x + 50, y + 50, x + 50, y + 3 * 50, x, y + 3 * 50);
        }

        if (type == 15) {
            polygon = new Polygon(x, y, x + 3 * 50, y, x + 3 * 50, y + 3 * 50,
                    x + 2 * 50, y + 3 * 50, x + 2 * 50, y + 50, x, y + 50);
        }

        if (type == 16) {
            polygon = new Polygon(x + 50, y, x + 2 * 50, y, x + 2 * 50, y + 2 * 50, x + 3 * 50, y + 2 * 50,
                    x + 3 * 50, y + 3 * 50, x, y + 3 * 50, x, y + 2 * 50, x + 50, y + 2 * 50);
        }

        if (type == 17) {
            polygon = new Polygon(x, y, x + 3 * 50, y, x + 3 * 50, y + 50, x + 2 * 50, y + 50,
                    x + 2 * 50, y + 3 * 50, x + 50, y + 3 * 50, x + 50, y + 50, x, y + 50);
        }

        if (type == 18) {
            polygon = new Polygon(x, y, x + 50, y, x + 50, y + 50, x + 3 * 50, y + 50,
                    x + 3 * 50, y + 2 * 50, x + 50, y + 2 * 50, x + 50, y + 3 * 50, x, y + 3 * 50);
        }

        if (type == 19) {
            polygon = new Polygon(x + 2 * 50, y, x + 3 * 50, y, x + 3 * 50, y + 3 * 50, x + 2 * 50, y + 3 * 50,
                    x + 2 * 50, y + 2 * 50, x, y + 2 * 50, x, y + 50, x + 2 * 50, y + 50);
        }

        if (type == 20) {
            polygon = new Polygon(x, y, x + 3 * 50, y,
                    x + 3 * 50, y + 50, x, y + 50);
        }

        if (type == 21) {
            polygon = new Polygon(x, y, x + 50, y,
                    x + 50, y + 3 * 50, x, y + 3 * 50);
        }

        if (type == 22) {
            polygon = new Polygon(x, y, x + 50, y,
                    x + 50, y + 50, x, y + 50);
        }

        if (type == 23) {
            polygon = new Polygon(x, y, x + 2 * 50, y, x + 2 * 50, y + 50,
                    x + 50, y + 50, x + 50, y + 2 * 50, x, y + 2 * 50);
        }

        if (type == 24) {
            polygon = new Polygon(x, y, x + 2 * 50, y, x + 2 * 50, y + 2 * 50,
                    x + 50, y + 2 * 50, x + 50, y + 50, x, y + 50);
        }

        if (type == 25) {
            polygon = new Polygon(x + 50, y, x + 2 * 50, y, x + 2 * 50, y + 2 * 50,
                    x, y + 2 * 50, x, y + 50, x + 50, y + 50);
        }

        if (type == 26) {
            polygon = new Polygon(x, y, x + 50, y, x + 50, y + 50,
                    x + 2 * 50, y + 50, x + 2 * 50, y + 2 * 50, x, y + 2 * 50);
        }

        if (type == 27) {
            polygon = new Polygon(x, y, x + 50, y, x + 50, y + 50, x + 2 * 50, y + 50,
                    x + 2 * 50, y + 2 * 50, x + 50, y + 2 * 50, x + 50, y + 3 * 50, x, y + 3 * 50);
        }

        if (type == 28) {
            polygon = new Polygon(x, y, x + 3 * 50, y, x + 3 * 50, y + 50, x + 2 * 50, y + 50,
                    x + 2 * 50, y + 2 * 50, x + 50, y + 2 * 50, x + 50, y + 50, x, y + 50);
        }

        if (type == 29) {
            polygon = new Polygon(x + 50, y, x + 2 * 50, y, x + 2 * 50, y + 3 * 50, x + 50, y + 3 * 50,
                    x + 50, y + 2 * 50, x, y + 2 * 50, x, y + 50, x + 50, y + 50);
        }

        if (type == 30) {
            polygon = new Polygon(x + 50, y, x + 2 * 50, y, x + 2 * 50, y + 50, x + 3 * 50, y + 50,
                    x + 3 * 50, y + 2 * 50, x, y + 2 * 50, x, y + 50, x + 50, y + 50);
        }

        polygon.setStroke(Color.AQUAMARINE);
        polygon.setStrokeWidth(5);
        polygon.setFill(Color.LIGHTSEAGREEN);
        return polygon;
    }
}
