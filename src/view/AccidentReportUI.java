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

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccidentReportUI {
    public static void display(Stage stage) {
        stage.setTitle("Accident Reporting");

        Label titleLabel = new Label("Report New Accident");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField tfLocation = new TextField();
        tfLocation.setPromptText("Enter accident location");

        TextField tfSeverity = new TextField();
        tfSeverity.setPromptText("Enter severity level (Low/Medium/High)");

        TextArea tfDescription = new TextArea();
        tfDescription.setPromptText("Describe the accident details");
        tfDescription.setWrapText(true);
        tfDescription.setPrefRowCount(4);

        Label messageLabel = new Label();

        Button btnSubmit = new Button("Submit Report");
        btnSubmit.setOnAction(e -> {
            String location = tfLocation.getText();
            String severity = tfSeverity.getText();
            String description = tfDescription.getText();

            if (location.isEmpty() || severity.isEmpty() || description.isEmpty()) {
                messageLabel.setText("All fields are required!");
                return;
            }

            try (FileWriter writer = new FileWriter("accidents.txt", true)) {
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                writer.write("Accident Reported:\n");
                writer.write("Time: " + time + "\n");
                writer.write("Location: " + location + "\n");
                writer.write("Severity: " + severity + "\n");
                writer.write("Description: " + description + "\n");
                writer.write("----------------------\n");
                messageLabel.setText("Accident reported successfully.");

                tfLocation.clear();
                tfSeverity.clear();
                tfDescription.clear();
            } catch (IOException ex) {
                messageLabel.setText("Error writing to file.");
            }
        });

        Button btnBack = new Button("Back to Dashboard");
        btnBack.setOnAction(e -> UserDashboardUI.display(stage));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                titleLabel, tfLocation, tfSeverity, tfDescription, btnSubmit, messageLabel, btnBack
        );

        Scene scene = new Scene(layout, 500, 450);
        stage.setScene(scene);
        stage.show();
    }
}

