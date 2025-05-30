/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import src.view.LoginWindow;

public class MainMenu {
    public void start(Stage stage) {
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);

        Button userLoginBtn = new Button("User Login");
        userLoginBtn.setOnAction(e -> new LoginWindow("user").start(stage));

        root.getChildren().addAll(userLoginBtn);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Accident Detection System - Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}
