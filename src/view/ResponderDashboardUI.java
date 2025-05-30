/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import src.model.IIUMAmbulance;
import src.model.OSEM;
import src.model.Responder;
import src.model.CallAlert;
import src.model.SMSAlert;
import src.model.AlertDispatcher;
import src.model.CameraSensor;
import src.model.IoTSensor;
import src.model.Sensor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ResponderDashboardUI {
    public static void display(Stage stage) {
        stage.setTitle("Responder Dashboard");

        Label titleLabel = new Label("Responder Dashboard");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Responder osem = new OSEM("R001", "Ahmad Zaki", "013-1234567", "BZ456");
        Responder ambulance = new IIUMAmbulance("R002", "Nur Aisyah", "012-9876543", "VAN3021", "STF9981");

        TextArea statusArea = new TextArea();
        statusArea.setEditable(false);
        statusArea.setWrapText(true);
        statusArea.setPrefHeight(250);

        Button btnDescribeRoles = new Button("Describe Roles");
        btnDescribeRoles.setOnAction(e -> {
            osem.describeRole();
            ambulance.describeRole();
            statusArea.setText("Roles described in console.");
        });

        Button btnExecuteTasks = new Button("Execute Tasks");
        btnExecuteTasks.setOnAction(e -> {
            osem.dispatchResponder();
            osem.updateStatus("On site");
            if (osem instanceof OSEM o) {
                o.secureAccidentArea();
                o.controlTraffic();
            }

            ambulance.dispatchResponder();
            ambulance.updateStatus("Providing Aid");
            if (ambulance instanceof IIUMAmbulance amb) {
                amb.provideFirstAid();
                amb.transportVictims();
            }

            statusArea.setText("Responder tasks executed. Check console for output.");
        });

        Button btnSendAlerts = new Button("Send Alerts");
        btnSendAlerts.setOnAction(e -> {
            SMSAlert smsAlert = new SMSAlert(101, "Dispatcher 1", "019-8877665", "Emergency at Gate 2");
            CallAlert callAlert = new CallAlert(102, "Dispatcher 2", "999", 45);

            smsAlert.sendAlert();
            callAlert.sendAlert();

            statusArea.setText("Alerts sent. Check console for output.");
        });

        Button btnRunSensors = new Button("Run Sensors");
        btnRunSensors.setOnAction(e -> {
            Sensor iotSensor = new IoTSensor(201, "Main Road Junction", "High Impact Detected");
            CameraSensor cameraSensor = new CameraSensor(202, "South Entrance", "Vehicle Movement", true);

            iotSensor.detectImpact();
            iotSensor.sendImpactData();

            cameraSensor.detectFromCamera();
            cameraSensor.captureImage();
            cameraSensor.sendDataToAIEngine();

            statusArea.setText("Sensors activated. Check console for output.");
        });

        Button btnBack = new Button("Back to Login");
        btnBack.setOnAction(e -> LoginWindow.display(stage));

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                titleLabel,
                btnDescribeRoles,
                btnExecuteTasks,
                btnSendAlerts,
                btnRunSensors,
                statusArea,
                btnBack
        );

        Scene scene = new Scene(layout, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
}
