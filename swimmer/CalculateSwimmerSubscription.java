package swimmer;

import filehandling.FileHandling;

public class CalculateSwimmerSubscription {
    // Calculates swimmer subscription based on agegroup
    private int calculateSubscriptionFee(Swimmer swimmer) {
        return switch (swimmer.getAgeGroup()) {
            case "JUNIOR" -> 1000;
            case "SENIOR" -> 1600;
            case "ELDERLY" -> (int) (1600 * 0.75);
            default -> 0;
        };
    }

    // Sets regular swimmer's subscription price
    public void setSwimmersSubscription(FileHandling fileHandling) {
        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            if (swimmer.getActivityType()) {
                int subscriptionFee = calculateSubscriptionFee(swimmer);
                swimmer.setSubscriptionFee(subscriptionFee);
            } else {
                swimmer.setSubscriptionFee(500);
            }
        }
    }

      // Sets competitive swimmer's subscription price
    public void setCompetitiveSwimmersSubscription(FileHandling fileHandling) {
        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
            System.out.println(competitiveSwimmer.getActivityType());
            if (competitiveSwimmer.getActivityType()) {
                int subscriptionFee = calculateSubscriptionFee(competitiveSwimmer);
                competitiveSwimmer.setSubscriptionFee(subscriptionFee);
            } else {
                competitiveSwimmer.setSubscriptionFee(500);
            }
        }
    }
}
