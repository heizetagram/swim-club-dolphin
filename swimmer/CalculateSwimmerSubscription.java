package swimmer;

import filehandling.FileHandling;

public class CalculateSwimmerSubscription {
// calculates swimmer subscription based on agegroup
public int calculateSubscriptionFee(Swimmer swimmer) {
    return switch (swimmer.getAgeGroup()) {
        case "JUNIOR" -> 50;
        case "SENIOR" -> 150;
        case "ELDERLY" -> 100;
        default -> 0;
    };
}
    public void setSwimmersSubscription(FileHandling fileHandling) {
        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            int subscriptionFee = calculateSubscriptionFee(swimmer);
            swimmer.setSubscriptionFee(subscriptionFee);
        }
    }

}
