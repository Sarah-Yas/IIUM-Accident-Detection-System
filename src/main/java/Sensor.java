public class Sensor {
    protected int sensorID;
    protected String location;
    protected String impactData;

    public Sensor(int sensorID, String location, String impactData) {
        this.sensorID = sensorID;
        this.location = location;
        this.impactData = impactData;
    }

    public void detectImpact() {
        System.out.println("Impact detected at " + location);
    }

    public void sendImpactData() {
        System.out.println("Sending impact data: " + impactData);
    }
}
