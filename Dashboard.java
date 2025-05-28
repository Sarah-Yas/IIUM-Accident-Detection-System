public class Dashboard {
    private String dashboardID;
    private String lastUpdateTime;
    
    
    //Parametered Constructor
    public Dashboard(String dashboardID, String lastUpdateTime){
        this.dashboardID = dashboardID;
        this.lastUpdateTime = lastUpdateTime;
    }
    
    /**
     * @return the dashboardID
     */
    public String getDashboardID() {
        return dashboardID;
    }

    /**
     * @param dashboardID the dashboardID to set
     */
    public void setDashboardID(String dashboardID) {
        this.dashboardID = dashboardID;
    }

    /**
     * @return the lastUpdateTime
     */
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdateTime the lastUpdateTime to set
     */
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    
    //Method to load the Accident Data
    public void loadData(){
        System.out.println("Loading data from ---" +dashboardID+ "---");
    }
    
    //Method to display last updated time 
    public String refreshDashboard(){
        return "Last updated at: " +lastUpdateTime;
    }

}
