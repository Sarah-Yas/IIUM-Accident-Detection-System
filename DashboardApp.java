import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardApp extends Application {

    private final ObservableList<MonitorDashboard> data = FXCollections.observableArrayList(
        new MonitorDashboard("Aimi001", "2025-05-24 10:00AM", "U123", "Kuala Lumpur", "Aiman456", "Central Region")
    );

    private final Label statusLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        // TableView
        TableView<MonitorDashboard> table = new TableView<>();

        // Table columns
        TableColumn<MonitorDashboard, String> dashboardIDCol = new TableColumn<>("Dashboard ID");
        dashboardIDCol.setCellValueFactory(new PropertyValueFactory<>("dashboardID"));

        TableColumn<MonitorDashboard, String> lastUpdateCol = new TableColumn<>("Last Update");
        lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdateTime"));

        TableColumn<MonitorDashboard, String> userIDCol = new TableColumn<>("User ID");
        userIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));

        TableColumn<MonitorDashboard, String> userLocationCol = new TableColumn<>("User Location");
        userLocationCol.setCellValueFactory(new PropertyValueFactory<>("userLocation"));

        TableColumn<MonitorDashboard, String> adminIDCol = new TableColumn<>("Admin ID");
        adminIDCol.setCellValueFactory(new PropertyValueFactory<>("adminID"));

        TableColumn<MonitorDashboard, String> monitorAreaCol = new TableColumn<>("Monitor Area");
        monitorAreaCol.setCellValueFactory(new PropertyValueFactory<>("monitorArea"));

        table.getColumns().addAll(dashboardIDCol, lastUpdateCol, userIDCol, userLocationCol, adminIDCol, monitorAreaCol);
        table.setItems(data);

        // Refresh Status Button
        Button refreshButton = new Button("Refresh Status");
        refreshButton.setOnAction(e -> {
            MonitorDashboard selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                statusLabel.setText(selected.updateStatus());
            } else {
                statusLabel.setText("Please select a dashboard row first.");
            }
        });

        VBox vbox = new VBox(10, table, refreshButton, statusLabel);
        vbox.setStyle("-fx-padding: 20px;");
        Scene scene = new Scene(vbox, 850, 350);

        primaryStage.setTitle("Monitor Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
