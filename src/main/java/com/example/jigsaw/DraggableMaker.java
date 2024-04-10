package com.example.jigsaw;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

public class DraggableMaker {
    private double currentX;
    private double currentY;
    public int currentFigureType;
    MainActivityController controller;

    public DraggableMaker(MainActivityController controller) {
        this.controller = controller;
    }

    public void setDraggable(Node node) {
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                currentX = mouseEvent.getX();
                currentY = mouseEvent.getY();
            }
        });

        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                node.setLayoutX(mouseEvent.getSceneX() - currentX);
                node.setLayoutY(mouseEvent.getSceneY() - currentY);
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boolean canLocate = true;
                double x = mouseEvent.getSceneX() - currentX + 675;
                double y = mouseEvent.getSceneY() - currentY + 250;

                if (x < 25 || y < 25) {
                    canLocate = false;
                }

                if (currentFigureType == 0 || currentFigureType == 2 || currentFigureType == 4 || currentFigureType == 6
                        || currentFigureType == 8 || currentFigureType == 10 || currentFigureType == 23 || currentFigureType == 24
                        || currentFigureType == 25 || currentFigureType == 26 || currentFigureType == 27
                        || currentFigureType == 29) {
                    if (x > 425) {
                        canLocate = false;
                    }
                } else if (currentFigureType == 1 || currentFigureType == 3 || currentFigureType == 5 || currentFigureType == 7
                        || currentFigureType == 9 || currentFigureType == 11 || currentFigureType == 12 || currentFigureType == 13
                        || currentFigureType == 14 || currentFigureType == 15 || currentFigureType == 16
                        || currentFigureType == 17 || currentFigureType == 18 || currentFigureType == 19
                        || currentFigureType == 20 || currentFigureType == 28 || currentFigureType == 30) {
                    if (x > 375) {
                        canLocate = false;
                    }
                } else {
                    if (x > 475) {
                        canLocate = false;
                    }
                }

                if (currentFigureType == 1 || currentFigureType == 3 || currentFigureType == 5 || currentFigureType == 7
                        || currentFigureType == 9 || currentFigureType == 11 || currentFigureType == 23
                        || currentFigureType == 24 || currentFigureType == 35 || currentFigureType == 26 || currentFigureType == 28
                        || currentFigureType == 30) {
                    if (y > 425) {
                        canLocate = false;
                    }
                } else if (currentFigureType == 0 || currentFigureType == 2 || currentFigureType == 4 || currentFigureType == 6
                        || currentFigureType == 8 || currentFigureType == 10 || currentFigureType == 12 || currentFigureType == 13
                        || currentFigureType == 14 || currentFigureType == 15 || currentFigureType == 16 || currentFigureType == 17
                        || currentFigureType == 18 || currentFigureType == 19 || currentFigureType == 21 || currentFigureType == 27
                        || currentFigureType == 29) {
                    if (y > 375) {
                        canLocate = false;
                    }
                } else {
                    if (y > 475) {
                        canLocate = false;
                    }
                }

                Pair<Integer, Integer> layout = new Pair<>(0, 0);
                if (canLocate) {
                    layout = Field.getLayout(x, y);
                    canLocate = Field.canLocate(Field.getCellNumbers
                            (currentFigureType, layout.getKey(), layout.getValue()));
                }

                if (canLocate) {
                    controller.enableGenerateBtn();
                    node.setLayoutX(layout.getKey() - 675);
                    node.setLayoutY(layout.getValue() - 250);
                    node.setDisable(true);
                } else {
                    node.setLayoutX(0);
                    node.setLayoutY(0);
                }
            }
        });
    }
}
