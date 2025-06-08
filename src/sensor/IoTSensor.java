package sensor;

public class IoTSensor extends Sensor {

    public IoTSensor(int sensorID, String location, String impactData) {
        super(sensorID, location, impactData);
    }

    @Override
    public void detectImpact() {
        System.out.println("IoT sensor detecting impact at " + location);
    }

    @Override
    public void sendImpactData() {
        System.out.println("IoT sensor sending impact data: " + impactData);
    }
}