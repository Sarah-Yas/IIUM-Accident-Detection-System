/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StatusUpdateUI {
    public static void display(Stage stage) {
        stage.setTitle("Responder Status Update");

        Label titleLabel = new Label("Update Responder Status");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField responderIdField = new TextField();
        responderIdField.setPromptText("Responder ID");

        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("On the way", "On site", "Handling Incident", "Completed");
        statusComboBox.setPromptText("Select Status");

        Button updateButton = new Button("Update Status");
        TextArea logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setWrapText(true);

        updateButton.setOnAction(e -> {
            String id = responderIdField.getText();
            String status = statusComboBox.getValue();
            if (id.isEmpty() || status == null) {
                logArea.setText("Please enter ID and select status.");
            } else {
                logArea.setText("Responder ID " + id + " updated to status: " + status);
                System.out.println("[LOG] Responder ID " + id + " updated to status: " + status);
            }
        });

        Button btnBack = new Button("Back to Dashboard");
        btnBack.setOnAction(e -> ResponderDashboardUI.display(stage));

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(titleLabel, responderIdField, statusComboBox, updateButton, logArea, btnBack);

        Scene scene = new Scene(layout, 500, 450);
        stage.setScene(scene);
        stage.show();
    }
}
