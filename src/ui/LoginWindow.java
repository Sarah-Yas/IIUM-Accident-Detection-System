
package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginWindow {
    public static void display(Stage stage) {
        Label titleLabel = new Label("Accident Detection System Login");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim().toLowerCase();
            String password = passwordField.getText().trim();

            switch (username) {
                case "user":
                    if (password.equals("123")) {
                        UserDashboardUI.display(stage);
                    } else {
                        messageLabel.setText("Invalid password for user.");
                    }
                    break;
                case "admin":
                    if (password.equals("admin")) {
                        AdminDashboardUI.display(stage);
                    } else {
                        messageLabel.setText("Invalid password for admin.");
                    }
                    break;
                case "responder":
                    if (password.equals("111")) {
                        ResponderDashboardUI.display(stage);
                    } else {
                        messageLabel.setText("Invalid password for responder.");
                    }
                    break;
                default:
                    messageLabel.setText("Invalid username or password.");
            }
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton, messageLabel);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
}

