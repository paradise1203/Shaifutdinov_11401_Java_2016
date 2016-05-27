package com.aidar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by paradise on 25.05.16.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new Game();
        Scene scene = new Scene(game.getPane(), Const.WIDTH, Const.HEIGHT);
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.setTitle("Reaction");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
