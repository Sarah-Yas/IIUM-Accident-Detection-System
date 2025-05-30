/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package src;

// File: src/MainApp.java
import javafx.application.Application;
import javafx.stage.Stage;
import src.view.MainMenu;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        new MainMenu().start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
