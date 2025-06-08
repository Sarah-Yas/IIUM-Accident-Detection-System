
package dashboard;

public class UserDashboard extends Dashboard implements StatusUpdate {
    private String userID;
    protected String userLocation;

    public UserDashboard(String dashboardID, String lastUpdateTime, String userID, String userLocation) {
        super(dashboardID, lastUpdateTime);
        this.userID = userID;
        this.userLocation = userLocation;
    }

    public String displayNearbyAccidents() {
        return "nearby the " + userLocation;
    }

    public String sendUserReport() {
        return userID + " lodged an accident report.";
    }

    @Override
    public String toString() {
        return "User ID: " + sendUserReport() + " " + displayNearbyAccidents();
    }

    @Override
    public String status() {
        return "Accident Status: Active";
    }
}

