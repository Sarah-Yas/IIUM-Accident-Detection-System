
package main;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.LoginWindow;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        LoginWindow.display(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
