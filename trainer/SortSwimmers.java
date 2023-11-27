package trainer;

import filehandling.FileHandling;
import swimmer.CompetitiveSwimmer;
import ui.UI;

import java.util.ArrayList;
import java.util.Comparator;

public class SortSwimmers {
    private ArrayList<CompetitiveSwimmer> competitiveSwimmers;

    public SortSwimmers() {
        FileHandling fileHandling = new FileHandling();
        competitiveSwimmers = new ArrayList<>(fileHandling.getCompetitiveSwimmers());
    }

    // Sort competitive swimmer by Discipline and SwimTime
    public void compareDisciplineAndSwimTime() {
        Comparator<CompetitiveSwimmer> byDisciplineAndSwimTime = Comparator.comparing(CompetitiveSwimmer::getDiscipline).thenComparing(CompetitiveSwimmer::getSwimTime);
        competitiveSwimmers.sort(byDisciplineAndSwimTime);
    }

    // Print top 5 competitive swimmers for each Discipline
    public void printTop5CompetitiveSwimmers() {
        String currentDiscipline = "";
        int counter = 0;

        for (CompetitiveSwimmer competitiveSwimmer : competitiveSwimmers) {
            String discipline = competitiveSwimmer.getDiscipline();

            if (!discipline.equals(currentDiscipline)) {
                currentDiscipline = discipline;
                counter = 0;
            }

            if (counter < 5) {
                UI.println(competitiveSwimmer.getDiscipline() + ": " + competitiveSwimmer.getName() + ", " + competitiveSwimmer.getSwimTime());
                counter++;
            }
        }
    }

    // Getter
    public ArrayList<CompetitiveSwimmer> getCompetitiveSwimmers() {
        return competitiveSwimmers;
    }
}
