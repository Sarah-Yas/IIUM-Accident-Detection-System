package alert;

public abstract class AlertDispatcher {
    protected int dispatcherID;
    protected String dispatcherName;
    protected String contactInfo;

    public AlertDispatcher(int dispatcherID, String dispatcherName, String contactInfo) {
        this.dispatcherID = dispatcherID;
        this.dispatcherName = dispatcherName;
        this.contactInfo = contactInfo;
    }

    public abstract void sendAlert();
}