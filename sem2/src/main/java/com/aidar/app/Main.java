package com.aidar.app;

import com.aidar.spring.AppConfiguration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by paradise on 19.05.16.
 */
public class Main extends Application {

    public static Stage stage;

    public static String token;

    private static ApplicationContext context;

    public static void signInScene() {
        Scene signInScene = (Scene) context.getBean("signInScene");
        stage.setTitle("Sign in");
        stage.setScene(signInScene);
        stage.show();
    }

    public static void mainScene() {
        Scene mainScene = (Scene) context.getBean("mainScene");
        stage.setTitle("Home");
        stage.setScene(mainScene);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        signInScene();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
