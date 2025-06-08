
package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboardUI {
    public static void display(Stage stage) {
        stage.setTitle("Admin Dashboard");

        Label titleLabel = new Label("Admin Dashboard");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button btnMonitorIncidents = new Button("Monitor Incidents");
        Button btnDispatchResponders = new Button("Dispatch Responders");
        Button btnViewResponderStatus = new Button("View Responder Status");
        Button btnBack = new Button("Back to Login");

        btnMonitorIncidents.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incidents Overview");
            alert.setHeaderText("Real-Time Incident Monitoring");
            alert.setContentText("- Accident at Gate 1\n- Severity: Critical\n- Status: Awaiting Response");
            alert.showAndWait();
        });

        btnDispatchResponders.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dispatch Responders");
            alert.setHeaderText("Responder Dispatched Successfully");
            alert.setContentText("OSEM and IIUM Ambulance have been dispatched to the scene.");
            alert.showAndWait();
        });

        btnViewResponderStatus.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Responder Status");
            alert.setHeaderText("Current Responder Activities");
            alert.setContentText("OSEM - Securing Area\nAmbulance - Transporting Victims");
            alert.showAndWait();
        });

        btnBack.setOnAction(e -> LoginWindow.display(stage));

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, btnMonitorIncidents, btnDispatchResponders, btnViewResponderStatus, btnBack);

        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

}
