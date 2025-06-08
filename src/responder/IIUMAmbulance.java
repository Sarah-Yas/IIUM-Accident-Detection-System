package responder;

public class IIUMAmbulance extends Responder {
    private String vehicleID;
    private String staffID;

    public IIUMAmbulance(String responderID, String responderName, String contactNumber, String vehicleID, String staffID) {
        super(responderID, responderName, contactNumber);
        this.vehicleID = vehicleID;
        this.staffID = staffID;
    }

    @Override
    public void describeRole() {
        System.out.println("IIUM Ambulance " + responderName + " (Vehicle: " + vehicleID + ", Staff: " + staffID + ") provides medical aid.");
    }

    public void provideFirstAid() {
        System.out.println("Ambulance " + responderName + " is providing first aid.");
    }

    public void transportVictims() {
        System.out.println("Ambulance " + responderName + " is transporting victims.");
    }
}