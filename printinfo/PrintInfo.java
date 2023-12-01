package printinfo;

import filehandling.FileHandling;
import swimmer.CompetitiveSwimmer;
import swimmer.Swimmer;
import ui.ConsoleColors;
import ui.UI;

public class PrintInfo {
    static public void printCompetitiveSwimmerInfo(CompetitiveSwimmer competitiveSwimmer) {
        UI.println(competitiveSwimmer.getName());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Team:", ConsoleColors.RESET, competitiveSwimmer.getAgeGroup());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT,  "Discipline:", ConsoleColors.RESET, competitiveSwimmer.getDiscipline());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Pers. Record:", ConsoleColors.RESET, competitiveSwimmer.getSwimTime());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Competition:", ConsoleColors.RESET, competitiveSwimmer.getEvent());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.GREEN_BRIGHT, "Position:", ConsoleColors.RESET, competitiveSwimmer.getPosition());
        UI.println("----------------------------------");
    }

    static public void printRegularSwimmerInfo(Swimmer swimmer) {
        UI.println(swimmer.getName());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "Birthdate:", ConsoleColors.RESET, swimmer.getBirthdate());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "Age:", ConsoleColors.RESET, swimmer.getAge());
        UI.printf("   %s%-13s%s +45 %s\n", ConsoleColors.BLUE, "Phone:", ConsoleColors.RESET, swimmer.getPhone());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "E-mail:", ConsoleColors.RESET, swimmer.getEmail());
        UI.printf("   %s%-13s%s %s\n", ConsoleColors.BLUE, "Age group:", ConsoleColors.RESET, swimmer.getAgeGroup());
        UI.println("----------------------------------");
    }

    // Print top 5 competitive swimmers for each Discipline
    static public void printTop5CompetitiveSwimmers(FileHandling fileHandling) {
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
