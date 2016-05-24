package com.aidar.spring;

import com.aidar.app.Main;
import com.aidar.app.PaneManager;
import com.aidar.web.service.HelpApiService;
import com.aidar.web.util.ApiResponse;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

/**
 * Created by paradise on 21.05.16.
 */
@Configuration
@ComponentScan(basePackages = { "com.aidar.web", "com.aidar.app" })
public class AppConfiguration {

    @Autowired
    private HelpApiService helpApiService;

    @Autowired
    private PaneManager paneManager;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Scene signInScene() {
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

        final Text error = new Text();
        gridPane.add(error, 0, 6, 2, 1);

        Button signIn = new Button("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(signIn);
        gridPane.add(hBox, 1, 4);

        signIn.setOnAction(e -> {
            ApiResponse apiResponse = helpApiService.signIn(email.getText(), pass.getText());
            if (apiResponse.getHttpStatus() == HttpStatus.OK) {
                Main.token = apiResponse.getToken();
                Main.mainScene();
            } else {
                error.setText(apiResponse.getErrors().get(0));
            }
        });

        return new Scene(gridPane, 350, 320);
    }

    @Bean
    public Scene mainScene() {
        BorderPane mainPane = new BorderPane();
        paneManager.setMainPane(mainPane);

        MenuBar menu = new MenuBar();
        menu.prefWidthProperty().bind(Main.stage.widthProperty());
        mainPane.setTop(menu);

        // Profile
        Menu profileMenu = new Menu("Profile");
        MenuItem infoMenuItem = new MenuItem("Info");
        MenuItem homeMenuItem = new MenuItem("Home");
        MenuItem exitMenuItem = new MenuItem("Exit");
        profileMenu.getItems().addAll(infoMenuItem, homeMenuItem,
                new SeparatorMenuItem(), exitMenuItem);
        infoMenuItem.setOnAction(e ->
                mainPane.setCenter(paneManager.infoProfilePane()));
        homeMenuItem.setOnAction(e ->
                mainPane.setCenter(paneManager.homePane()));
        exitMenuItem.setOnAction(e -> {
            //clean
            mainPane.setCenter(null);
            Main.signInScene();
        });

        menu.getMenus().addAll(profileMenu);

        return new Scene(mainPane, 500, 425, Color.WHITE);
    }

}
