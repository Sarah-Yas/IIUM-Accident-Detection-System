/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResponderDashboardUI {

    public static void display(Stage stage, String responderType) {
        stage.setTitle(responderType + " Dashboard");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Label titleLabel = new Label(responderType + " Dashboard");
        layout.getChildren().add(titleLabel);

        if (responderType.equalsIgnoreCase("OSEM")) {
            // Example simplified responder info
            layout.getChildren().addAll(
                new Label("Responder: OSEM Officer Afiq"),
                new Label("Contact: 019-1122334"),
                new Label("Status: On Site"),
                new Label("Alert: Call Alert Sent")
            );
            // Additional setup and method calls can be here
        } else if (responderType.equalsIgnoreCase("IIUMAmbulance")) {
            layout.getChildren().addAll(
                new Label("Responder: IIUM Ambulance Team"),
                new Label("Contact: 017-9876543"),
                new Label("Status: Responding"),
                new Label("Alert: SMS Alert Sent")
            );
            // Additional setup and method calls here
        } else {
            layout.getChildren().add(new Label("Invalid responder type"));
        }

        Scene scene = new Scene(layout, 500, 350);
        stage.setScene(scene);
        stage.show();
    }
}
