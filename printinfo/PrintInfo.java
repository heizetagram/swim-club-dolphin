package printinfo;

import filehandling.FileHandling;
import swimmer.CompetitiveSwimmer;
import swimmer.Swimmer;
import ui.ConsoleColors;
import ui.SystemMessages;
import ui.UI;

public class PrintInfo {
    private final FileHandling fileHandling;

    public PrintInfo(FileHandling fileHandling) {
        this.fileHandling = fileHandling;
    }
    // Prints all competitive swimmers
    public void printAllCompetitiveSwimmers() {
        if (fileHandling.getCompetitiveSwimmers().isEmpty()) {
            SystemMessages.printRedColoredText("No competitive swimmers available");
        } else {
            UI.println("Competitive swimmers:");
            UI.println("----------------------------------");
            for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
                printCompetitiveSwimmerInfo(competitiveSwimmer);
            }
        }
    }

    // Prints all competitive swimmers' info
    private void printCompetitiveSwimmerInfo(CompetitiveSwimmer competitiveSwimmer) {
        UI.println(competitiveSwimmer.getName());
        UI.printf("   %s%-13s%s +45 %s\n", ConsoleColors.GREEN_BRIGHT, "Phone:", ConsoleColors.RESET, competitiveSwimmer.getPhone());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Team:", ConsoleColors.RESET, competitiveSwimmer.getAgeGroup());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Discipline:", ConsoleColors.RESET, competitiveSwimmer.getDiscipline());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Pers. Record:", ConsoleColors.RESET, competitiveSwimmer.getSwimTime());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Competition:", ConsoleColors.RESET, competitiveSwimmer.getEvent());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Position:", ConsoleColors.RESET, competitiveSwimmer.getPosition());
        UI.println("----------------------------------");
    }

    // Prints out all regular swimmers
    public void printAllRegularSwimmers(){
        if (fileHandling.getSwimmers().isEmpty()) {
            SystemMessages.printRedColoredText("No swimmers available");
        } else {
            UI.println("Regular swimmers:");
            UI.println("----------------------------------");
            printRegularSwimmerInfo();
        }
    }

    // Prints all regular swimmers' info
    private void printRegularSwimmerInfo() {
        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            UI.println(swimmer.getName());
            UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "Birthdate:", ConsoleColors.RESET, swimmer.getBirthdate());
            UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "Age:", ConsoleColors.RESET, swimmer.getAge());
            UI.printf("   %s%-13s%s +45 %s\n", ConsoleColors.BLUE, "Phone:", ConsoleColors.RESET, swimmer.getPhone());
            UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "E-mail:", ConsoleColors.RESET, swimmer.getEmail());
            UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "Age group:", ConsoleColors.RESET, swimmer.getAgeGroup());
            UI.println("----------------------------------");
        }
    }

    // Print top 5 competitive swimmers for each Discipline
    public void printTop5CompetitiveSwimmers() {
        String currentDiscipline = "";
        int counter = 0;

        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
            String discipline = competitiveSwimmer.getDiscipline();

            if (!discipline.equals(currentDiscipline)) {
                currentDiscipline = discipline;
                counter = 0;
            }

            if (counter < 5) {
                UI.printf("%s%-10s%s %-10s : %s%s%s\n", ConsoleColors.BLUE, competitiveSwimmer.getDiscipline(), ConsoleColors.RESET, competitiveSwimmer.getName(), ConsoleColors.YELLOW, competitiveSwimmer.getSwimTime(), ConsoleColors.RESET);
                counter++;
            }
        }
    }

    // Prints all swimmers in debt
    public void printSwimmersInDebt() {
        UI.println(ConsoleColors.BLUE_BOLD + "Regular swimmers:" + ConsoleColors.RESET);
        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            if (swimmer.getSubscriptionFee() > 0) {
                printSwimmersInDebtInfo(swimmer);
            }
        }
        UI.println(ConsoleColors.GREEN_BOLD_BRIGHT + "\nCompetitive swimmers:" + ConsoleColors.RESET);
        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
            if (competitiveSwimmer.getSubscriptionFee() > 0) {
                printCompetitiveSwimmersInDebtInfo(competitiveSwimmer);
            }
        }
    }

    // Print regular swimmers in debt info
    private void printSwimmersInDebtInfo(Swimmer swimmer) {
        // if hasPaid.equals("false")
        UI.println(swimmer.getName());
        UI.printf("   %s%-13s%s +45 %s\n", ConsoleColors.BLUE, "Phone:", ConsoleColors.RESET, swimmer.getPhone());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "E-mail:", ConsoleColors.RESET, swimmer.getEmail());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "Age group:", ConsoleColors.RESET, swimmer.getAgeGroup());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "Status:", ConsoleColors.RESET, colorActivityType(swimmer.getActivityType()));
        printDueToBePaid(swimmer.getSubscriptionFee());
        UI.println("----------------------------------");
    }

    // Prints competitive swimmers in debt info
    private void printCompetitiveSwimmersInDebtInfo(CompetitiveSwimmer competitiveSwimmer) {
        UI.println(competitiveSwimmer.getName());
        UI.printf("   %s%-13s%s +45 %s\n", ConsoleColors.GREEN_BRIGHT, "Phone:", ConsoleColors.RESET, competitiveSwimmer.getPhone());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "E-mail:", ConsoleColors.RESET, competitiveSwimmer.getEmail());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Age group:", ConsoleColors.RESET, competitiveSwimmer.getAgeGroup());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Status:", ConsoleColors.RESET, colorActivityType(competitiveSwimmer.getActivityType()));
        printDueToBePaid(competitiveSwimmer.getSubscriptionFee());
        UI.println("----------------------------------");
    }

    // Color activity type
    private String colorActivityType(String activityType) {
        String coloredActivity = "";
        switch (activityType) {
          case "ACTIVE" -> coloredActivity = ConsoleColors.GREEN + "ACTIVE" + ConsoleColors.RESET;
          case "PASSIVE" -> coloredActivity = ConsoleColors.RED + "PASSIVE" + ConsoleColors.RESET;
        }
        return coloredActivity;
    }

    // Print subscription value to be paid
    private void printDueToBePaid(int subscriptionFee) {
        UI.printf("   %s%-13s%s %d%s\n", ConsoleColors.YELLOW, "To be paid:", ConsoleColors.RED_BOLD, subscriptionFee, ConsoleColors.RESET);
    }
}
