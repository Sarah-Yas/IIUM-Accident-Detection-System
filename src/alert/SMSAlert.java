package alert;

public class SMSAlert extends AlertDispatcher {
    private String message;

    public SMSAlert(int dispatcherID, String dispatcherName, String contactInfo, String message) {
        super(dispatcherID, dispatcherName, contactInfo);
        this.message = message;
    }

    @Override
    public void sendAlert() {
        System.out.println("Sending SMS to " + contactInfo + ": " + message);
    }
}