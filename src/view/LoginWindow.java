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

public final class LoginWindow {

    private LoginWindow() {} 

    public static void display(Stage stage) {
        stage.setTitle("IIUM Accident Detection System – Login");

        // ── UI controls ──────────────────────────────────────────────
        Label lblUsername = new Label("Username:");
        TextField tfUsername = new TextField();
        tfUsername.setPromptText("user | admin | responder");

        Label lblPassword = new Label("Password:");
        PasswordField pfPassword = new PasswordField();
        pfPassword.setPromptText("•••••");

        Button btnLogin = new Button("Login");
        btnLogin.setDefaultButton(true);          // Enter key submits

        Label lblMessage = new Label();           // feedback

        // ── event handling ───────────────────────────────────────────
        btnLogin.setOnAction(e ->
                attemptLogin(stage, tfUsername, pfPassword, lblMessage));

        // ── layout ───────────────────────────────────────────────────
        VBox layout = new VBox(10,
                lblUsername, tfUsername,
                lblPassword, pfPassword,
                btnLogin,
                lblMessage);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(layout, 400, 300));
        stage.show();
    }

    // ─────────────────────────────────────────────────────────────────
    private static void attemptLogin(Stage stage,
                                 TextField tfUsername,
                                 PasswordField pfPassword,
                                 Label lblMessage) {

    String username = tfUsername.getText().trim();
    String password = pfPassword.getText().trim();

    if ("user".equalsIgnoreCase(username) && password.equals("123")) {
        UserDashboardUI.display(stage);
        return;
    }
    
    if ("admin".equalsIgnoreCase(username) && password.equals("admin")) {
        AdminDashboardUI.display(stage);
        return;
    }
    
    if (username.equalsIgnoreCase("osem") && password.equals("123")) {
    ResponderDashboardUI.display(stage, "OSEM");
    return;
    } 
    
    if (username.equalsIgnoreCase("ambulance") && password.equals("123")) {
    ResponderDashboardUI.display(stage, "IIUMAmbulance");
    return;
    }


    // failed login
    lblMessage.setText("Invalid username or password.");
    pfPassword.clear();
   }
} 
