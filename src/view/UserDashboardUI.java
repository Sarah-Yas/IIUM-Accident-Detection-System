/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.model.UserDashboard;

public class UserDashboardUI extends Application {
    private String userID;
    private String location;

    public UserDashboardUI() {}

    public UserDashboardUI(String userID, String location) {
        this.userID = userID;
        this.location = location;
    }

    @Override
    public void start(Stage stage) {
        UserDashboard user = new UserDashboard("D001", "28-05-2025 10:00 AM", userID, location);

        Label welcomeLabel = new Label("Welcome, User " + user.getDashboardID());
        Label lastUpdate = new Label(user.refreshDashboard());

        Button viewAccidentBtn = new Button("View Accidents Nearby");
        viewAccidentBtn.setOnAction(e -> {
            Label nearbyLabel = new Label(user.displayNearbyAccidents());
            VBox root = (VBox) stage.getScene().getRoot();
            root.getChildren().add(nearbyLabel);
        });

        Button reportBtn = new Button("Report Accident");
        reportBtn.setOnAction(e -> {
            Label reportLabel = new Label(user.sendUserReport());
            VBox root = (VBox) stage.getScene().getRoot();
            root.getChildren().add(reportLabel);
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(welcomeLabel, lastUpdate, viewAccidentBtn, reportBtn);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("User Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
