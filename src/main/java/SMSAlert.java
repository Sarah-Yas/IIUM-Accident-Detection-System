/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alertdispatcher;

/**
 *
 * @author User
 */
public class SMSAlert extends AlertDispatcher{
     private String phoneNumber;
    private String messageContent;
    
    //Constructor
    public SMSAlert(int dispatcherID, String dispatcherName,String phoneNumber, String messageContent){
        super(dispatcherID,dispatcherName);
        this.phoneNumber=phoneNumber;
        this.messageContent=messageContent;
    }
    
    //Getter and setter
     public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    
    //method
    public void composeSMS(){
        System.out.println("Composing SMS to " + getPhoneNumber() + ": " + getMessageContent());
    }
    public void sendSMS(){
        System.out.println("Sending SMS to " + getPhoneNumber());
    }
    
    @Override
    public void sendAlert() {
    composeSMS();
    sendSMS();
    updateAlertStatus("Sent");
}

   
}

