/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alertdispatcher;

/**
 *
 * @author User
 */
public abstract class AlertDispatcher {
        private int dispatcherID;
        private String dispatcherName;
        private String alertStatus;
        
        //Constructor
        public AlertDispatcher(int dispatcherID,String dispatcherName){
            this.dispatcherID=dispatcherID;
            this.dispatcherName=dispatcherName;
            this.alertStatus = "Pending";
        }
 
     //Getters and Setters
    public int getDispatcherID() {
        return dispatcherID;
    }
    public void setDispatcherID(int dispatcherID) {
        this.dispatcherID = dispatcherID;
    }
    public String getDispatcherName() {
        return dispatcherName;
    }
    public void setDispatcherName(String dispatcherName) {
        this.dispatcherName = dispatcherName;
    }
    public String getAlertStatus() {
        return alertStatus;
    }
   
    // Abstract method to be implemented by all alert types
    public abstract void sendAlert();
        
public void updateAlertStatus(String Status){
    this.alertStatus=Status;
     System.out.println("Alert status updated to: " + Status);
}
}

   