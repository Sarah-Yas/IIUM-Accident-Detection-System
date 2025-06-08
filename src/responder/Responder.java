package responder;

public abstract class Responder {
    protected String responderID;
    protected String responderName;
    protected String contactNumber;

    public Responder(String responderID, String responderName, String contactNumber) {
        this.responderID = responderID;
        this.responderName = responderName;
        this.contactNumber = contactNumber;
    }

    public void dispatchResponder() {
        System.out.println("Dispatching responder: " + responderName + " (ID: " + responderID + ") ");
    }

    public void updateStatus(String status) {
        System.out.println("Responder " + responderName + " updated status: " + status);
    }

    public abstract void describeRole();
}