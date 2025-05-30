/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

public class OSEM extends Responder {
    // Variable
    private String badgeNumber;
    
    // Cosntructor
    public OSEM(String responderID, String responderName, String contactNumber,
            String badgeNumber) {
        super(responderID, responderName, contactNumber);
        this.badgeNumber = badgeNumber;
    }
    
    // Methods
    public void controlTraffic() {
        System.out.println("OSEM " + responderName + " is controlling traffic.");
    }
    
    public void secureAccidentArea() {
        System.out.println("OSEM " + responderName + " is securing the accident area.");
    }
    
    // Polymorphism 
    @Override
    public void describeRole() {
        System.out.println("OSEM Officer with badge number " + badgeNumber +
                " ensures traffic control and accident area security.");
    }
    
}
