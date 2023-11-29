package trainer;

import filehandling.FileHandling;
import swimmer.CompetitiveSwimmer;
import ui.ConsoleColors;
import ui.UI;

import java.util.Comparator;

public class SortSwimmers {
    private FileHandling fileHandling;

    public SortSwimmers(FileHandling fileHandling) {
        this.fileHandling = fileHandling;
    }

    // Sort competitive swimmer by Discipline and SwimTime
    public void compareDisciplineAndSwimTime() {
        Comparator<CompetitiveSwimmer> byDisciplineAndSwimTime = Comparator.comparing(CompetitiveSwimmer::getDiscipline).thenComparing(CompetitiveSwimmer::getSwimTime);
        fileHandling.getCompetitiveSwimmers().sort(byDisciplineAndSwimTime);
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
                UI.printf("%s%-6s%s: %-15s %s%s%s\n", ConsoleColors.BLUE, competitiveSwimmer.getDiscipline(), ConsoleColors.RESET, competitiveSwimmer.getName(), ConsoleColors.YELLOW, competitiveSwimmer.getSwimTime(), ConsoleColors.RESET);
                counter++;
            }
        }
    }
}


