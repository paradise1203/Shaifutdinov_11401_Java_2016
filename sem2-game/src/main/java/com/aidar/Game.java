package com.aidar;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Created by paradise on 27.05.16.
 */
public class Game {

    private final Pane pane;

    private final Text start;

    private int count;
    private int countSuccess;

    public Game() {
        start = new Text(200, 200, "Click to start");
        start.setFont(new Font("Times New Roman", 17));
        start.setOnMouseClicked(e -> {
            FadeTransition ft = new FadeTransition(Duration.millis(1500), start);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.play();
            ft.setOnFinished(event -> start());
        });

        pane = new Pane();
        pane.setPrefSize(Const.WIDTH, Const.HEIGHT);
        pane.getChildren().add(start);
    }

    public Pane getPane() {
        return pane;
    }

    private void start() {
        count = 0;
        countSuccess = 0;
        Timeline timeline = null;
        for (double i = 0; i < Const.DURATION; i += 3) {
            final double j = i;
            timeline = new Timeline(new KeyFrame(Duration.seconds(j),
                    e -> {
                        int c = (int) ((j / Const.DURATION) * Const.MAX) + 1;
                        count += c;
                        for (int k = 0; k < c; k++) {
                            double rMax = 15;
                            Circle circle = new Circle(0);
                            int r = (int) (Math.random() * 255);
                            int g = (int) (Math.random() * 255);
                            int b = (int) (Math.random() * 255);
                            circle.setFill(Color.rgb(r, g, b));
                            circle.setLayoutX(Math.random() * (Const.WIDTH - 30));
                            circle.setLayoutY(Math.random() * (Const.HEIGHT - 30));
                            circle.setOnMouseClicked(ev -> {
                                pane.getChildren().remove(circle);
                                countSuccess++;
                            });
                            KeyValue rValue = new KeyValue(circle.radiusProperty(), rMax);
                            KeyFrame rFrame = new KeyFrame(Duration.millis(2000), rValue);
                            Timeline t = new Timeline(rFrame);
                            t.setCycleCount(2);
                            t.setAutoReverse(true);
                            pane.getChildren().add(circle);
                            t.play();
                        }
                    }
            ));
            timeline.play();
        }
        timeline.setOnFinished(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Your result");
            alert.setHeaderText(null);
            alert.setContentText("You have successfully clicked on " + countSuccess
                    + " from " + count + " circles!");
            alert.show();
            alert.setOnCloseRequest(ev -> {
                FadeTransition ft = new FadeTransition(Duration.millis(1500), start);
                ft.setFromValue(start.getOpacity());
                ft.setToValue(1);
                ft.play();
            });
        });
    }

}
