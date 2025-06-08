package responder;

public class OSEM extends Responder {
    private String badgeNumber;

    public OSEM(String responderID, String responderName, String contactNumber, String badgeNumber) {
        super(responderID, responderName, contactNumber);
        this.badgeNumber = badgeNumber;
    }

    @Override
    public void describeRole() {
        System.out.println("OSEM " + responderName + " (Badge: " + badgeNumber + ") ensures scene safety and manages traffic.");
    }

    public void secureAccidentArea() {
        System.out.println("OSEM " + responderName + " is securing the accident area.");
    }

    public void controlTraffic() {
        System.out.println("OSEM " + responderName + " is controlling traffic.");
    }
}