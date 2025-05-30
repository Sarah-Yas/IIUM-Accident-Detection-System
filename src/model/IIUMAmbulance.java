/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

public class IIUMAmbulance extends Responder {
    // Variable
    private String ambulanceID;
    private String plateNumber;
    private String staffOnDutyID;
    
    // Constructor
    public IIUMAmbulance(String responderID, String responderName, String contactNumber,
            String plateNumber, String staffOnDutyID) {
        super(responderID, responderName, contactNumber);
        this.ambulanceID = ambulanceID;
        this.plateNumber = plateNumber;
        this.staffOnDutyID = staffOnDutyID;
    }
    
    // Methods
    public void provideFirstAid() {
        System.out.println("Medical staff (ID: " + staffOnDutyID + " ) is "
                + "providing first aid.");
    }
    
    public void transportVictims() {
        System.out.println("Ambulance " + plateNumber + " is trasnporting "
                + "victims to the hospital.");
    }
    
    // Polymorphism
    @Override
    public void describeRole() {
        System.out.println("IIUM Ambulance [" + ambulanceID + ", Plate: " + 
                plateNumber + "] " + "drove by responder" + responderName
                        + ", provides emergency care via staff ID: "+ staffOnDutyID);
    }
}
