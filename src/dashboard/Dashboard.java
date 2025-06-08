
package dashboard;

public class Dashboard {
    private String dashboardID;
    private String lastUpdateTime;

    public Dashboard(String dashboardID, String lastUpdateTime) {
        this.dashboardID = dashboardID;
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getDashboardID() {
        return dashboardID;
    }

    public void setDashboardID(String dashboardID) {
        this.dashboardID = dashboardID;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void loadData() {
        System.out.println("Loading data from ---" + dashboardID + "---");
    }

    public String refreshDashboard() {
        return "Last updated at: " + lastUpdateTime;
    }
}