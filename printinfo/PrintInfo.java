package printinfo;

import filehandling.FileHandling;
import swimmer.CalculateSwimmerAge;
import swimmer.CompetitiveSwimmer;
import swimmer.Swimmer;
import ui.ConsoleColors;
import ui.SystemMessages;
import ui.UI;

public class PrintInfo {
    private CalculateSwimmerAge calculateSwimmerAge;

    public PrintInfo() {
        calculateSwimmerAge = new CalculateSwimmerAge();
    }

    // Prints all competitive swimmers
    public void printAllCompetitiveSwimmers(FileHandling fileHandling) {
        calculateSwimmerAge.setCompetitiveSwimmersAge(fileHandling);
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
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Team:", ConsoleColors.RESET, competitiveSwimmer.getAgeGroup());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT,  "Discipline:", ConsoleColors.RESET, competitiveSwimmer.getDiscipline());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Pers. Record:", ConsoleColors.RESET, competitiveSwimmer.getSwimTime());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Competition:", ConsoleColors.RESET, competitiveSwimmer.getEvent());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Position:", ConsoleColors.RESET, competitiveSwimmer.getPosition());
        UI.println("----------------------------------");
    }

    // Prints out all regular swimmers
    public void printAllRegularSwimmers(FileHandling fileHandling){
        calculateSwimmerAge.setSwimmersAge(fileHandling); // -- Hvorfor skal man calculate age, før at den gider at vise alderen og aldersgruppen
        if (fileHandling.getSwimmers().isEmpty()) {
            SystemMessages.printRedColoredText("No swimmers available");
        } else {
            UI.println("Regular swimmers:");
            UI.println("----------------------------------");
            printRegularSwimmerInfo(fileHandling);
        }
    }

    // Prints all regular swimmers' info
    private void printRegularSwimmerInfo(FileHandling fileHandling) {
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
    public void printTop5CompetitiveSwimmers(FileHandling fileHandling) {
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
}
