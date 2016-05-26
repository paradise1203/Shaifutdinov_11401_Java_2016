package com.aidar;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by paradise on 25.05.16.
 */
public class Main extends Application {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    private static final int COUNT = 150;
    private Pane pane;
    private static final double DURATION = 60000;
    private static final int MAX = 7;

    private void startAnimation() {
        long startTime = System.currentTimeMillis();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3),
                e -> {
                    long now = System.currentTimeMillis();
                    long diff = now - startTime;
                    if (diff < DURATION) {
                        int count = (int) ((diff / DURATION) * MAX) + 1;
                        for (int i = 0; i < count; i++) {
                            double rMax = 15;
                            Circle circle = new Circle(0);
                            circle.setLayoutX(Math.random() * (WIDTH - 20));
                            circle.setLayoutY(Math.random() * (HEIGHT - 20));
                            circle.setOnMouseClicked(ev -> pane.getChildren().remove(circle));
                            KeyValue rValue = new KeyValue(circle.radiusProperty(), rMax);
                            KeyFrame rFrame = new KeyFrame(Duration.millis(2000), rValue);
                            Timeline t = new Timeline(rFrame);
                            t.setCycleCount(2);
                            t.setAutoReverse(true);
                            pane.getChildren().add(circle);
                            t.play();
                        }
                    }
                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        Text start = new Text(200, 200, "Click to start");
        start.setFont(new Font("Times New Roman", 17));
        start.setOnMouseClicked(e -> {
            FadeTransition ft = new FadeTransition(Duration.millis(1500), start);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.play();
            ft.setOnFinished(event -> startAnimation());
        });
        pane.getChildren().add(start);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.setTitle("Reaction");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
