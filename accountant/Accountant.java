package accountant;

import swimmer.CalculateSwimmerAge;
import swimmer.Swimmer;

public class Accountant {
    // membership fee based on the member's age and activity type.
    public double calculateMembershipFee(int age, String activityType) {
        double baseFee = 0.0;
        Swimmer swimmer = new Swimmer("", "", "", "");
        swimmer.setAge(age);
        CalculateSwimmerAge calculateSwimmerAge = new CalculateSwimmerAge();
        String ageGroup = calculateSwimmerAge.calculateAgeGroup(age);
        if (activityType.equalsIgnoreCase("active")) {
            if (ageGroup.equalsIgnoreCase("JUNIOR")) {
                baseFee = 1000.0; // Junior active fee
            } else {
                baseFee = 1600.0; // Senior active fee
            }
        } else if (activityType.equalsIgnoreCase("passive")) {
            baseFee = 500.0; // Passive fee
        }

        // discounts for members over 60 years(ELDERLY) on the senior rate.
        if (age > 60 && activityType.equalsIgnoreCase("active")) {
            baseFee *= 0.75; // Apply 25% discount for Elderly (60 or more) on the senior active rate
        }

        return baseFee;
    }
}