public class AIEngine {
    private int engineID;
    private int severityScore;

    public AIEngine(int engineID) {
        this.engineID = engineID;
    }

    public int analyzeImpactData(int impactForce, int vehicleSpeed, 
                                 int numberOfVictims,boolean isNight, 
                                 boolean isRainyTime){
  
        /* to calculate severityScore, impactForce, vehicleSpeed and 
           numberOfVictims are essential to be measured */
        severityScore = (impactForce * 2) + 
                        (vehicleSpeed * 1) + 
                        (numberOfVictims * 10);

        if (isNight) {
            severityScore += 10;
        }

        // severityScore will be added if it raining
        if (isRainyTime) {
            severityScore += 20;
        }

        System.out.println("Severity Score: " + severityScore);
        return severityScore;
    }

    public boolean validateAccident() {
        return severityScore > 50; //an accident occured
    }

    public String determineSeverity() {
        if (severityScore >= 80) {
            return "High"; // more serious responder need to be alert
        } else if (severityScore >= 50) {
            return "Moderate";
        } else {
            return "Low";
        }
    }
}
