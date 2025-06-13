
package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserDashboardUI {
    private static final String ACCIDENT_FILE = "accidents.txt";

    public static void display(Stage stage) {
        stage.setTitle("User Dashboard");

        Label titleLabel = new Label("Welcome to the User Dashboard");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextArea accidentArea = new TextArea();
        accidentArea.setEditable(false);
        accidentArea.setWrapText(true);
        accidentArea.setPrefHeight(300);
        accidentArea.setText("Loading today's accidents...");

        Button btnRefresh = new Button("Refresh");
        btnRefresh.setOnAction(e -> loadAccidents(accidentArea));

        Button btnReportAccident = new Button("Report New Accident");
        btnReportAccident.setOnAction(e -> AccidentReportUI.display(stage));

        Button btnBack = new Button("Back to Login");
        btnBack.setOnAction(e -> LoginWindow.display(stage));

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                titleLabel,
                accidentArea,
                btnRefresh,
                btnReportAccident,
                btnBack
        );

        loadAccidents(accidentArea); 

        Scene scene = new Scene(layout, 600, 500);
        stage.setScene(scene);
        stage.show();
    }

    private static void loadAccidents(TextArea area) {
        area.clear();
        try {
            List<String> lines = Files.readAllLines(Paths.get(ACCIDENT_FILE));
            if (lines.isEmpty()) {
                area.setText("No accidents reported today.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Today’s Reported Accidents:\n\n");

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith("Time: ")) {
                    sb.append(lines.get(i)).append("\n"); // Time
                    sb.append(lines.get(++i)).append("\n"); // Location
                    sb.append(lines.get(++i)).append("\n"); // Severity
                    sb.append(lines.get(++i)).append("\n"); // Description
                    sb.append(lines.get(++i)).append("\n"); // Status
                    sb.append("\n");
                }
            }
            area.setText(sb.toString());
        } catch (IOException e) {
            area.setText("Failed to load accident data.");
        }
    }
}
