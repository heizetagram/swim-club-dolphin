package accountant;

public class Accountant {
    // membership fee based on the member's age and activity type.
    public double calculateMembershipFee(int age, String activityType) {
        double baseFee = 0.0;

        if (activityType.equalsIgnoreCase("active")) {
            if (age < 18) {
                baseFee = 1000.0; // Junior active fee
            } else {
                baseFee = 1600.0; // Senior active fee
            }
        } else if (activityType.equalsIgnoreCase("passive")) {
            baseFee = 500.0; // Passive fee
        }

        // discounts for members over 60 years on the senior rate.
        if (age > 60 && activityType.equalsIgnoreCase("active")) {
            baseFee *= 0.75; // Apply 25% discount for seniors on the senior active rate
        }

        return baseFee;
    }
}
