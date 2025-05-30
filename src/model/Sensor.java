/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

public class Sensor {
    protected int sensorID;
    protected String location;
    protected String impactData;

    public Sensor(int sensorID, String location, String impactData) {
        this.sensorID = sensorID;
        this.location = location;
        this.impactData = impactData;
    }

    public void detectImpact() {
        System.out.println("Impact detected at " + location);
    }

    public void sendImpactData() {
        System.out.println("Sending impact data: " + impactData);
    }
}

