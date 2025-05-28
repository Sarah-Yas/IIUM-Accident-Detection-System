public class MonitorDashboard 
    extends UserDashboard {
    private String adminID;
    private String monitorArea;
    
    //Parametered Constructor
    public MonitorDashboard(String dashboardID,String lastUpdateTime,String userID, String userLocation, String adminID, String monitorArea){
        super(dashboardID, lastUpdateTime, userID, userLocation);
        this.adminID = adminID;
        this.monitorArea = monitorArea; //general location
    }

    /**
     * @return the adminID
     */
    public String getAdminID() {
        return adminID;
    }

    /**
     * @return the monitorArea
     */
    public String getMonitorArea() {
        return monitorArea;
    }
    
    //Method to display the Accident Details to the admin in charge
    public String showAllAccidents(){
        return "--- Accident Reports ---"
                +"\nMonitored Area: " +monitorArea
                +"\nAccident Location: " +userLocation
                +"\nAdmin in Charge: " +adminID;
    }
        
    //Display the updated status by admin
    public String updateStatus(){
        return refreshDashboard() +" by Admin ID: " +adminID;
    }
    
    //Polymorphism
    @Override
    public String toString(){
        return showAllAccidents()+ "\n" +status()+ "\n\n" +updateStatus();
    }
}
