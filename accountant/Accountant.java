package accountant;

public class Accountant {
    // membership fee based on the member's age and activity type.
    public double calculateMembershipFee(String ageGroup, String activityType) {
        double baseFee = 0.0;

        if (activityType.equalsIgnoreCase("active")) {
            if (ageGroup.equals("JUNIOR")) {
                baseFee = 1000.0; // Junior active fee
            } else {
                baseFee = 1600.0; // Senior active fee
            }
        } else if (activityType.equalsIgnoreCase("passive")) {
            baseFee = 500.0; // Passive fee
        }

        // discounts for members over 60 years on the senior rate.
        if (ageGroup.equals("ELDERLY") && activityType.equalsIgnoreCase("active")) {
            baseFee *= 0.75; // Apply 25% discount for seniors on the senior active rate
        }

        return baseFee;
    }
}
