/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

public class CallAlert extends AlertDispatcher {
    private String phoneNumber;
    private int callDuration;
    
    //Constructor
    public CallAlert(int dispatcherID, String dispatcherName,String phoneNumber,int callDuration){
        super(dispatcherID,dispatcherName);
        this.phoneNumber=phoneNumber;
        this.callDuration=callDuration;
    }
    
    //Getter and Setter
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    //Method
    public void MakeEmergencyCall(){
        System.out.println("Dialing emergency number: " + getPhoneNumber());
    }
    public void EndCall(){
        System.out.println("Call ended. Duration: " + getCallDuration() + " seconds");
    }
    
    @Override
    public void sendAlert() {
    MakeEmergencyCall();
    EndCall();
    updateAlertStatus("Completed");
}
}