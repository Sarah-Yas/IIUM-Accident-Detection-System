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

public class LoginWindow {

    public static void display(Stage stage) {
        stage.setTitle("Login");

        Label lblUsername = new Label("Username:");
        TextField tfUsername = new TextField();
        Label lblPassword = new Label("Password:");
        PasswordField pfPassword = new PasswordField();
        Button btnLogin = new Button("Login");

        Label lblMessage = new Label();

        btnLogin.setOnAction(e -> {
            String username = tfUsername.getText();
            String password = pfPassword.getText();

            // Simple login logic
            if (username.equals("user") && password.equals("123")) {
                UserDashboardUI.display(stage);  // For user
            } else if (username.equals("admin") && password.equals("admin")) {
                AdminDashboardUI.display(stage);  // For admin
            } else if (username.equals("responder") && password.equals("111")){
                ResponderDashboardUI.display(stage); //For responder
            }else {
                lblMessage.setText("Invalid username or password.");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(lblUsername, tfUsername, lblPassword, pfPassword, btnLogin, lblMessage);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
