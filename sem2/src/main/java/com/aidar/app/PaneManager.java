package com.aidar.app;

import com.aidar.web.data.enums.Role;
import com.aidar.web.data.model.*;
import com.aidar.web.data.util.RequestTable;
import com.aidar.web.data.util.Transformer;
import com.aidar.web.service.HelpApiService;
import com.aidar.web.util.ApiResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by paradise on 24.05.16.
 */
@Component
public class PaneManager {

    @Autowired
    private HelpApiService helpApiService;

    private BorderPane mainPane;

    public void setMainPane(BorderPane mainPane) {
        this.mainPane = mainPane;
    }

    public GridPane infoProfilePane() {
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

    private void setCommunityPane(ApiResponse apiResponse, GridPane homePane) {
        GridPane communityPane = new GridPane();
        communityPane.setAlignment(Pos.CENTER);
        communityPane.setHgap(10);
        communityPane.setVgap(10);
        communityPane.setPadding(new Insets(15, 15, 15, 15));

        Community community = apiResponse.getCommunity();

        Text name = new Text("Name: " + community.getName());
        communityPane.add(name, 0, 0, 2, 1);

        Text description = new Text("Description: " + community.getDescription());
        communityPane.add(description, 0, 1, 2, 1);

        User user = community.getFounder();
        Text founder = new Text("Founded by " + user.getName() + " " + user.getSurname());
        communityPane.add(founder, 0, 2, 2, 1);

        Text createdAt = new Text("Created at: " + community.getCreatedAt());
        communityPane.add(createdAt, 0, 3, 2, 1);

        int row = 4;

        if (apiResponse.isMembership() || apiResponse.getUser().getRole() == Role.ROLE_ADMIN) {
            Text heading = new Text("News:");
            communityPane.add(heading, 0, row++, 2, 1);
            List<News> news = community.getNews();
            for (News n : news) {
                User author = n.getAuthor();
                Text record = new Text(n.getText() + " by "
                        + author.getName() + " " + author.getSurname() + " at " + n.getCreatedAt());
                communityPane.add(record, 0, row++, 2, 1);
            }
        }

        Button back = new Button("back");
        communityPane.add(back, 0, row, 1, 1);
        back.setOnAction(e -> mainPane.setCenter(homePane));

        mainPane.setCenter(communityPane);
    }

    private void setDialogPane(ApiResponse apiResponse, GridPane homePane) {
        GridPane dialogPane = new GridPane();
        dialogPane.setAlignment(Pos.CENTER);
        dialogPane.setHgap(10);
        dialogPane.setVgap(10);
        dialogPane.setPadding(new Insets(15, 15, 15, 15));

        User friend = apiResponse.getFriend();

        Text heading = new Text("Dialog with " + friend.getName() + " " + friend.getSurname() + ":");
        dialogPane.add(heading, 0, 0, 2, 1);

        int row = 1;

        List<Message> messages = apiResponse.getDialog();
        for (Message m : messages) {
            String sender = m.getSender().equals(friend) ?
                    friend.getName() + " " + friend.getSurname() : "You";
            Text message = new Text(sender + " : " + m.getText() + " at " + m.getCreatedAt());
            dialogPane.add(message, 0, row++, 2, 1);
        }

        TextArea message = new TextArea();
        dialogPane.add(message, 0, row, 2, 3);
        row += 3;

        Button send = new Button("send");
        dialogPane.add(send, 1, row, 1, 1);
        send.setOnAction(e -> helpApiService.sendMessage(friend.getId(), message.getText()));

        Button back = new Button("back");
        dialogPane.add(back, 0, row, 1, 1);
        back.setOnAction(e -> mainPane.setCenter(homePane));

        mainPane.setCenter(dialogPane);
    }

    public GridPane homePane() {
        GridPane homePane = new GridPane();
        homePane.setAlignment(Pos.CENTER);
        homePane.setHgap(10);
        homePane.setVgap(10);
        homePane.setPadding(new Insets(15, 15, 15, 15));

        ApiResponse apiResponse = helpApiService.home();
        if (apiResponse.getHttpStatus() == HttpStatus.OK) {
            int row = 0;

            if (apiResponse.getUser().getRole() == Role.ROLE_USER) {
                Text heading = new Text("Active dialogs with:");
                homePane.add(heading, 0, row++, 2, 1);
                List<User> penFriends = apiResponse.getPenFriends();
                for (User f : penFriends) {
                    Hyperlink link = new Hyperlink(f.getName() + " " + f.getSurname());
                    homePane.add(link, 0, row++, 2, 1);
                    link.setOnAction(e ->
                            setDialogPane(helpApiService.dialog(f.getId()), homePane)
                    );
                }

                heading = new Text("My communities:");
                homePane.add(heading, 0, row++, 2, 1);
                List<Community> communities = apiResponse.getCommunities();
                for (Community c : communities) {
                    Hyperlink link = new Hyperlink(c.getName());
                    homePane.add(link, 0, row++, 2, 1);
                    link.setOnAction(e ->
                            setCommunityPane(helpApiService.community(c.getId()), homePane)
                    );
                }

                heading = new Text("My rating:");
                homePane.add(heading, 0, row, 1, 1);
                homePane.add(new Text(String.valueOf(apiResponse.getRating())), 1, row, 1, 1);

            } else if (apiResponse.getUser().getRole() == Role.ROLE_ADMIN) {
                Text heading = new Text("Recently founded communities:");
                homePane.add(heading, 0, row++, 2, 1);
                List<Community> communities = apiResponse.getCommunities();
                for (Community c : communities) {
                    Hyperlink link = new Hyperlink(c.getName());
                    homePane.add(link, 0, row++, 2, 1);
                    link.setOnAction(e ->
                            setCommunityPane(helpApiService.community(c.getId()), homePane)
                    );
                }

                heading = new Text("Recently created requests:");
                homePane.add(heading, 0, row++, 2, 1);
                List<Request> requests = apiResponse.getRequests();
                for (Request r : requests) {
                    Hyperlink link = new Hyperlink("Issued by " + r.getNeedy().getName()
                            + " " + r.getNeedy().getSurname() + " at " + r.getCreatedAt());
                    homePane.add(link, 0, row++, 2, 1);
                }
            }
        }

        return homePane;
    }

    public StackPane requestsPane() {
        StackPane requestsPane = new StackPane();
        requestsPane.setPadding(new Insets(15, 15, 15, 15));

        ApiResponse apiResponse = helpApiService.requests();
        ObservableList<RequestTable> requests = FXCollections
                .observableArrayList(Transformer.transformRequests(apiResponse.getRequests()));

        TableView<RequestTable> table = new TableView<>();
        table.setEditable(true);
        String[] columns = {
                "needy", "volunteer", "address", "createdAt", "serviceType", "status"
        };
        for (String c : columns) {
            TableColumn column = new TableColumn(c);
            column.setCellValueFactory(new PropertyValueFactory<>(c));
            table.getColumns().add(column);
        }
        table.setItems(requests);

        requestsPane.getChildren().add(table);
        return requestsPane;
    }

}
