/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package iiumaccidentdetection;

/**
 *
 * @author sarah
 */
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
