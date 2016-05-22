package com.aidar.spring;

import com.aidar.app.Main;
import com.aidar.web.data.model.User;
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
@ComponentScan(basePackages = { "com.aidar.web" })
public class AppConfiguration {

    @Autowired
    private HelpApiService helpApiService;

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

    private GridPane infoProfilePane() {
        GridPane editProfilePane = new GridPane();
        editProfilePane.setAlignment(Pos.CENTER);
        editProfilePane.setHgap(10);
        editProfilePane.setVgap(10);
        editProfilePane.setPadding(new Insets(15, 15, 15, 15));

        ApiResponse apiResponse = helpApiService.profile();
        if (apiResponse.getHttpStatus() == HttpStatus.OK) {
            User user = apiResponse.getUser();

            Text name = new Text("Name: " + user.getName());
            editProfilePane.add(name, 0, 0, 2, 1);

            Text surname = new Text("Surname: " + user.getSurname());
            editProfilePane.add(surname, 0, 1, 2, 1);

            Text email = new Text("Email: " + user.getEmail());
            editProfilePane.add(email, 0, 2, 2, 1);

            Text role = new Text("Role: " + user.getRole().getRepresentation());
            editProfilePane.add(role, 0, 3, 2, 1);

            Text status = new Text("Status: " + user.getStatus().getRepresentation());
            editProfilePane.add(status, 0, 4, 2, 1);
        }

        return editProfilePane;
    }

    @Bean
    public Scene mainScene() {
        BorderPane mainPane = new BorderPane();

        MenuBar menu = new MenuBar();
        menu.prefWidthProperty().bind(Main.stage.widthProperty());
        mainPane.setTop(menu);

        // Profile
        Menu profileMenu = new Menu("Profile");
        MenuItem infoMenuItem = new MenuItem("Info");
        MenuItem exitMenuItem = new MenuItem("Exit");
        profileMenu.getItems().addAll(infoMenuItem, new SeparatorMenuItem(), exitMenuItem);
        infoMenuItem.setOnAction(e -> mainPane.setCenter(infoProfilePane()));
        exitMenuItem.setOnAction(e -> Main.signInScene());

        // Home
        Menu homeMenu = new Menu("Home");
//        homeMenu.setOnAction(e -> mainPane.setCenter());

        menu.getMenus().add(profileMenu);

        return new Scene(mainPane, 400, 350, Color.WHITE);
    }

}
