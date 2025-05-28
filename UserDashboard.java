public class UserDashboard 
    extends Dashboard implements StatusUpdate{
    private String userID;
    protected String userLocation;
    
    //Parametered Constructor
    public UserDashboard(String dashboardID, String lastUpdateTime, String userID, String userLocation){
        super(dashboardID, lastUpdateTime);
        this.userID = userID;
        this.userLocation = userLocation; //specific location
    }
    
    //Method to tell the location of accident
    public String displayNearbyAccidents(){
        return "nearby the " +userLocation;
    }
    
    //Method for user to make an accident report
    public String sendUserReport(){
        return userID+ " lodge an accident report ";
    }
    
    //Polymorphism
    @Override
    public String toString(){
        return "User ID: " +sendUserReport()+ displayNearbyAccidents();
    }
    
    //Interface
    @Override
    public String status(){
        return "Accident Status: ";
    }
}
 