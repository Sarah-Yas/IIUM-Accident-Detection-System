
package ui;

import responder.IIUMAmbulance;
import responder.OSEM;
import responder.Responder;
import alert.CallAlert;
import alert.SMSAlert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import sensor.CameraSensor;
import sensor.IoTSensor;
import sensor.Sensor;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ResponderDashboardUI {
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
        stage.setTitle("Responder Dashboard");

        TextArea statusArea = new TextArea();
        statusArea.setEditable(false);
        statusArea.setWrapText(true);
        statusArea.setPrefHeight(250);

        OSEM osem = new OSEM("R001", "Ahmad Zaki", "013-1234567", "BZ456");
        IIUMAmbulance ambulance = new IIUMAmbulance("R002", "Nur Aisyah", "012-9876543", "VAN3021", "STF9981");

        // Tab 1: Main Menu
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

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(new Label("Today's Accident Reports:"), table);

        // Tab 2: OSEM
        VBox osemLayout = new VBox(10);
        osemLayout.setPadding(new Insets(10));

        Label osemInfo = new Label("OSEM ID: " + osem.responderID + ", Name: " + osem.responderName);

        Button describeOsem = new Button("Describe Role");
        describeOsem.setOnAction(e -> {
            statusArea.appendText("Role: OSEM " + osem.responderName + " (Badge: BZ456) ensures scene safety and manages traffic.\n");
        });

        Button taskOsem = new Button("Execute Tasks");
        taskOsem.setOnAction(e -> {
            statusArea.appendText("Dispatching " + osem.responderName + "...\n");
            osem.dispatchResponder();
            osem.updateStatus("On Site");
            osem.secureAccidentArea();
            osem.controlTraffic();
            statusArea.appendText("OSEM tasks completed.\n");
        });

        Button alertOsem = new Button("Send Alerts");
        alertOsem.setOnAction(e -> {
            SMSAlert sms = new SMSAlert(101, "Dispatcher OSEM", "013-1111111", "Accident at East Gate");
            sms.sendAlert();
            statusArea.appendText("OSEM alert sent.\n");
        });

        Button sensorOsem = new Button("Run Sensors");
        sensorOsem.setOnAction(e -> {
            Sensor sensor = new IoTSensor(201, "Gate A", "Heavy Impact");
            sensor.detectImpact();
            sensor.sendImpactData();
            statusArea.appendText("OSEM sensor triggered.\n");
        });

        osemLayout.getChildren().addAll(osemInfo, describeOsem, taskOsem, alertOsem, sensorOsem);

        // Tab 3: IIUM Ambulance
        VBox ambLayout = new VBox(10);
        ambLayout.setPadding(new Insets(10));

        Label ambInfo = new Label("Ambulance ID: " + ambulance.responderID + ", Name: " + ambulance.responderName);

        Button describeAmb = new Button("Describe Role");
        describeAmb.setOnAction(e -> {
            statusArea.appendText("Role: IIUM Ambulance " + ambulance.responderName + " provides medical aid.\n");
        });

        Button taskAmb = new Button("Execute Tasks");
        taskAmb.setOnAction(e -> {
            ambulance.dispatchResponder();
            ambulance.updateStatus("Providing Aid");
            ambulance.provideFirstAid();
            ambulance.transportVictims();
            statusArea.appendText("Ambulance tasks completed.\n");
        });

        Button alertAmb = new Button("Send Alerts");
        alertAmb.setOnAction(e -> {
            CallAlert call = new CallAlert(102, "Dispatcher Ambulance", "999", 30);
            call.sendAlert();
            statusArea.appendText("Ambulance call alert sent.\n");
        });

        Button sensorAmb = new Button("Run Sensors");
        sensorAmb.setOnAction(e -> {
            CameraSensor cam = new CameraSensor(202, "North Entrance", "Car Movement", true);
            cam.detectFromCamera();
            cam.captureImage();
            cam.sendDataToAIEngine();
            statusArea.appendText("Ambulance camera sensor triggered.\n");
        });

        ambLayout.getChildren().addAll(ambInfo, describeAmb, taskAmb, alertAmb, sensorAmb);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabMain = new Tab("Main Menu", mainLayout);
        Tab tabOsem = new Tab("OSEM", osemLayout);
        Tab tabAmbulance = new Tab("IIUM Ambulance", ambLayout);

        tabPane.getTabs().addAll(tabMain, tabOsem, tabAmbulance);

        Button btnBack = new Button("Back to Login");
        btnBack.setOnAction(e -> LoginWindow.display(stage));

        VBox mainContainer = new VBox(10);
        mainContainer.setPadding(new Insets(10));
        mainContainer.getChildren().addAll(tabPane, statusArea, btnBack);

        Scene scene = new Scene(mainContainer, 700, 600);
        stage.setScene(scene);
        stage.show();
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

    private static void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Action Required");
        alert.setContentText(msg);
        alert.showAndWait();
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
        } catch (IOException ignored) {
        }
    }
}
