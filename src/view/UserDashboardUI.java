/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserDashboardUI {
    public static void display(Stage stage) {
        stage.setTitle("User Dashboard");

        Label titleLabel = new Label("Welcome to the User Dashboard");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextArea infoArea = new TextArea();
        infoArea.setEditable(false);
        infoArea.setWrapText(true);
        infoArea.setPrefHeight(250);
        infoArea.setText("- View Today’s Accidents\n- Report New Accident");

        Button btnReportAccident = new Button("Report New Accident");
        btnReportAccident.setOnAction(e -> AccidentReportUI.display(stage));

        Button btnBack = new Button("Back to Login");
        btnBack.setOnAction(e -> LoginWindow.display(stage));

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                titleLabel,
                infoArea,
                btnReportAccident,
                btnBack
        );

        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}