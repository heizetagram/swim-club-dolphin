package accountant;

import filehandling.FileHandling;
import swimmer.CompetitiveSwimmer;
import swimmer.Swimmer;

public class CalculateSwimmerSubscription {
    // Calculate swimmer subscription based on age group
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
            if (swimmer.getActivityType().equals("ACTIVE")) {
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
            if (competitiveSwimmer.getActivityType().equals("ACTIVE")) {
                int subscriptionFee = calculateSubscriptionFee(competitiveSwimmer);
                competitiveSwimmer.setSubscriptionFee(subscriptionFee);
            } else {
                competitiveSwimmer.setSubscriptionFee(500);
            }
        }
    }

    // Check if subscription is paid
    public void checkIfPaid(FileHandling fileHandling) {
        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            if (swimmer.getHasPaid().equals("true")) {
                swimmer.setSubscriptionFee(0);
            }
        }
        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
            if (competitiveSwimmer.getHasPaid().equals("true")) {
                competitiveSwimmer.setSubscriptionFee(0);
            }
        }
    }
}
