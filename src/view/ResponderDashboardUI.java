/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ResponderDashboardUI {
    public static void display(Stage stage) {
        stage.setTitle("Responder Dashboard");

        Label titleLabel = new Label("Responder Dashboard");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button btnViewAssignedAccidents = new Button("View Assigned Accidents");
        Button btnUpdateStatus = new Button("Update Status");
        Button btnRespondToAlert = new Button("Respond to Alert");
        Button btnBack = new Button("Back to Login");

        btnViewAssignedAccidents.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Assigned Accidents");
            alert.setHeaderText("Accidents Assigned to You");
            alert.setContentText("(Sample) - Accident at Gate 2, Severity: High");
            alert.showAndWait();
        });

        btnUpdateStatus.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Update Status");
            dialog.setHeaderText("Enter new status");
            dialog.setContentText("Status:");

            dialog.showAndWait().ifPresent(status -> {
                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setTitle("Status Updated");
                info.setContentText("Your status has been updated to: " + status);
                info.showAndWait();
            });
        });

        btnRespondToAlert.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Responding");
            alert.setHeaderText("Responding to latest alert");
            alert.setContentText("Alert responded successfully via Call & SMS.");
            alert.showAndWait();
        });

        btnBack.setOnAction(e -> LoginWindow.display(stage));

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, btnViewAssignedAccidents, btnUpdateStatus, btnRespondToAlert, btnBack);

        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
