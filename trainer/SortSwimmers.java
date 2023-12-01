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

    // Sort competitive swimmer by name
    public void compareCompetitiveName() {
        Comparator<CompetitiveSwimmer> byName = Comparator.comparing(CompetitiveSwimmer::getName);
        fileHandling.getCompetitiveSwimmers().sort(byName);
    }
}


