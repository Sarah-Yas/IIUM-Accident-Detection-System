
package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AdminDashboardUI {
    private static final String ACCIDENT_FILE = "accidents.txt";

    public static class AccidentRecord {
        private final String time;
        private final String location;
        private String severity;
        private final String description;
        private String status;

        public AccidentRecord(String time, String location, String severity, String description, String status) {
            this.time = time;
            this.location = location;
            this.severity = severity;
            this.description = description;
            this.status = status;
        }

        public String getTime() { 
            return time; 
        }
        public String getLocation() { 
            return location; 
        }
        public String getSeverity() { 
            return severity; 
        }
        public String getDescription() { 
            return description; 
        }
        public String getStatus() { 
            return status; 
        }

        public void setSeverity(String severity) { 
            this.severity = severity; 
        }
        public void setStatus(String status) { 
            this.status = status; 
        }
    }

    public static void display(Stage stage) {
        stage.setTitle("Admin Dashboard");

        Label titleLabel = new Label("Admin Dashboard");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Accident table setup
        TableView<AccidentRecord> table = new TableView<>();
        table.setEditable(true);
        table.setPrefHeight(300);

        TableColumn<AccidentRecord, String> colTime = new TableColumn<>("Time");
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<AccidentRecord, String> colLocation = new TableColumn<>("Location");
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<AccidentRecord, String> colSeverity = new TableColumn<>("Severity");
        colSeverity.setCellValueFactory(new PropertyValueFactory<>("severity"));

        TableColumn<AccidentRecord, String> colDescription = new TableColumn<>("Description");
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<AccidentRecord, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colStatus.setCellFactory(column -> {
            ComboBoxTableCell<AccidentRecord, String> cell = new ComboBoxTableCell<>("Pending", "Alert is OTW", "Resolved");
            cell.setTooltip(new Tooltip("Click to update status"));
            return cell;
        });
        colStatus.setOnEditCommit(event -> {
            AccidentRecord record = event.getRowValue();
            record.setStatus(event.getNewValue());
            updateStatusInFile(record);
        });

        table.getColumns().addAll(colTime, colLocation, colSeverity, colDescription, colStatus);
        loadAccidents(table);

        table.setRowFactory(tv -> {
            TableRow<AccidentRecord> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    table.edit(row.getIndex(), colStatus);
                }
            });
            return row;
        });

        Button btnDelete = new Button("Delete Selected");
        Button btnDispatch = new Button("Dispatch Responder");
        Button btnResponderStatus = new Button("View Responder Status");
        Button btnViewAccidentReport = new Button("View Accident Report");
        Button btnBack = new Button("Back to Login");

        btnDelete.setOnAction(e -> {
            AccidentRecord selected = table.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showError("Please select a record to delete.");
                return;
            }
            try {
                List<String> lines = Files.readAllLines(Paths.get(ACCIDENT_FILE));
                String identifier = "Time: " + selected.getTime();
                List<String> updated = new ArrayList<>();
                for (int i = 0; i < lines.size(); ) {
                    if (lines.get(i).equals(identifier)) {
                        i += 6;
                    } else {
                        updated.add(lines.get(i++));
                    }
                }
                Files.write(Paths.get(ACCIDENT_FILE), updated);
                loadAccidents(table);
            } catch (IOException ex) {
                showError("Error deleting record.");
            }
        });

        btnDispatch.setOnAction(e -> {
            AccidentRecord selected = table.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showError("Please select an incident to dispatch responder.");
                return;
            }
            showInfo("Responder Dispatched Successfully", "OSEM and IIUM Ambulance dispatched to: " + selected.getLocation());
        });

        btnResponderStatus.setOnAction(e -> showInfo("Responder Status", "OSEM - Securing Area\nAmbulance - Transporting Victims"));

        btnViewAccidentReport.setOnAction(e -> {
            try {
                File file = new File(ACCIDENT_FILE);
                if (file.exists()) {
                    String content = new String(Files.readAllBytes(file.toPath()));
                    showAccidentReportWindow(content);
                } else {
                    showAccidentReportWindow("No accident reports found.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btnBack.setOnAction(e -> LoginWindow.display(stage));

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        HBox buttonRow = new HBox(10, btnDelete, btnDispatch, btnResponderStatus, btnViewAccidentReport, btnBack);
        buttonRow.setAlignment(Pos.CENTER);

        root.getChildren().addAll(titleLabel, table, buttonRow);

        Scene scene = new Scene(root, 900, 550);
        stage.setScene(scene);
        stage.show();
    }

    private static void loadAccidents(TableView<AccidentRecord> table) {
        table.getItems().clear();
        try {
            List<String> lines = Files.readAllLines(Paths.get(ACCIDENT_FILE));
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith("Time: ")) {
                    String time = lines.get(i).substring(6);
                    String location = lines.get(++i).substring(10);
                    String severity = lines.get(++i).substring(10);
                    String description = lines.get(++i).substring(13);
                    String status = lines.get(++i).substring(8);
                    table.getItems().add(new AccidentRecord(time, location, severity, description, status));
                }
            }
        } catch (IOException ignored) {}
    }

    private static void updateStatusInFile(AccidentRecord record) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(ACCIDENT_FILE));
            String identifier = "Time: " + record.getTime();
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).equals(identifier)) {
                    lines.set(i + 4, "Status: " + record.getStatus());
                    break;
                }
            }
            Files.write(Paths.get(ACCIDENT_FILE), lines);
        } catch (IOException e) {
            showError("Failed to update status.");
        }
    }

    private static void showAccidentReportWindow(String content) {
        Stage reportStage = new Stage();
        reportStage.setTitle("Accident Reports");

        TextArea textArea = new TextArea(content);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        VBox layout = new VBox(10, textArea);
        layout.setPadding(new Insets(15));

        Scene scene = new Scene(layout, 600, 400);
        reportStage.setScene(scene);
        reportStage.show();
    }

    private static void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Action Required");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private static void showInfo(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
