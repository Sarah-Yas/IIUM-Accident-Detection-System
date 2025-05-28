public class CameraSensor extends Sensor {
    protected boolean status;

    public CameraSensor(int sensorID, String location, String impactData, 
                        boolean status) {
        super(sensorID, location, impactData);
        this.status = status;
    }

    public void detectFromCamera() {
        System.out.println("Camera detected movement at " + location);
    }

    public void captureImage() {
        System.out.println("Capturing image at " + location);
    }

    public void sendDataToAIEngine() {
        System.out.println("Sending image data to AI Engine...");
    }
}
