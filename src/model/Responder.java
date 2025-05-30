/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

public abstract class Responder {
    // Variables
    protected String responderID;
    protected String responderName;
    protected String contactNumber;
    
    // Constructor
    public Responder (String responderID, String responderName, String contactNumber) {
        this.responderID = responderID;
        this.responderName = responderName;
        this.contactNumber = contactNumber;
    }
    
    // Methids
    public void dispatchResponder() {
        System.out.println("Dispatching responder: " + responderName + 
                " (ID: " + responderID + ") ");
    }
    
    public void updateStatus(String status) {
        System.out.println("Responder " + responderName + " updated status: " + status);
    }
    
    // Polymorphic method to describe the responder
    public abstract void describeRole();
    
}
