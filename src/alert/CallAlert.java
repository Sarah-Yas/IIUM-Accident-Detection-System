package alert;

public class CallAlert extends AlertDispatcher {
    private int durationInSeconds;

    public CallAlert(int dispatcherID, String dispatcherName, String contactInfo, int durationInSeconds) {
        super(dispatcherID, dispatcherName, contactInfo);
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public void sendAlert() {
        System.out.println("Placing call to " + contactInfo + " for " + durationInSeconds + " seconds.");
    }
}