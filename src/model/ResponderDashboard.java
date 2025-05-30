/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

public class ResponderDashboard extends Dashboard implements StatusUpdate {
    private String responderID;
    private String responderUnit;  // e.g., OSEM, IIUM Ambulance

    public ResponderDashboard(String dashboardID, String lastUpdateTime, String responderID, String responderUnit) {
        super(dashboardID, lastUpdateTime);
        this.responderID = responderID;
        this.responderUnit = responderUnit;
    }

    public String getResponderID() {
        return responderID;
    }

    public void setResponderID(String responderID) {
        this.responderID = responderID;
    }

    public String getResponderUnit() {
        return responderUnit;
    }

    public void setResponderUnit(String responderUnit) {
        this.responderUnit = responderUnit;
    }

    // Method to simulate receiving an alert
    public String receiveAlert(String accidentLocation) {
        return responderUnit + " unit (ID: " + responderID + ") received alert at " + accidentLocation;
    }

    // Method to update the status of the incident handled by responder
    public String updateIncidentStatus(String newStatus) {
        return "Responder " + responderID + " updated incident status to: " + newStatus;
    }

    @Override
    public void loadData() {
        System.out.println("Loading responder dashboard data for " + responderUnit + " (ID: " + responderID + ")");
    }

    @Override
    public String refreshDashboard() {
        return super.refreshDashboard() + " | Responder: " + responderID + " (" + responderUnit + ")";
    }

    @Override
    public String status() {
        return "Responder Status: Available";
    }

    @Override
    public String toString() {
        return "ResponderDashboard for " + responderUnit + " [ID=" + responderID + "]\n" 
                + "Dashboard ID: " + getDashboardID() + "\n"
                + refreshDashboard();
    }
}

