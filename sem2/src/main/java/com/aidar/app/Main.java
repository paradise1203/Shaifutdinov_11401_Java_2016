package com.aidar.app;

import com.aidar.web.ApiResponse;
import com.aidar.web.HelpApiServiceImpl;
import com.aidar.web.HttpResponse;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by paradise on 19.05.16.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text greeting = new Text("Welcome, friend!");
        gridPane.add(greeting, 0, 0, 2, 1);

        Label emailLabel = new Label("Email:");
        gridPane.add(emailLabel, 0, 1);

        TextField email = new TextField();
        gridPane.add(email, 1, 1);

        Label passLabel = new Label("Password:");
        gridPane.add(passLabel, 0, 2);

        PasswordField pass = new PasswordField();
        gridPane.add(pass, 1, 2);

        Button signIn = new Button("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(signIn);
        gridPane.add(hBox, 1, 4);

        final Text error = new Text();
        gridPane.add(error, 0, 6, 2, 1);

        signIn.setOnAction(e -> {
            ApiResponse apiResponse = new HelpApiServiceImpl().signIn(email.getText(), pass.getText());
            if (apiResponse.getHttpResponse() == HttpResponse.SUCCESS) {
                error.setText(apiResponse.getResponseData().toString());
            } else {
                error.setText(apiResponse.getErrors().get(0));
            }
        });

        Scene scene = new Scene(gridPane, 350, 320);

        primaryStage.setTitle("Help!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
