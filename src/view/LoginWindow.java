/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import src.view.UserDashboardUI;

public class LoginWindow {
    private String role;

    public LoginWindow(String role) {
        this.role = role;
    }

    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter User ID");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(e -> {
            if (role.equals("user")) {
                new UserDashboardUI("U123", "KAED Gate").start(stage);
            }
        });

        root.getChildren().addAll(new Label("Login as " + role), usernameField, passwordField, loginBtn);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Login Window");
        stage.setScene(scene);
        stage.show();
    }
}