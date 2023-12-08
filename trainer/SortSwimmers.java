package trainer;

import filehandling.FileHandling;
import swimmer.CompetitiveSwimmer;
import swimmer.Swimmer;

import java.util.Comparator;

public class SortSwimmers {
    private FileHandling fileHandling;

    public SortSwimmers(FileHandling fileHandling) {
        this.fileHandling = fileHandling;
    }

    // Sort competitive swimmer by Discipline and SwimTime
    public void compareCompetitiveDisciplineAndSwimTime() {
        Comparator<CompetitiveSwimmer> byDisciplineAndSwimTime = Comparator.comparing(CompetitiveSwimmer::getDiscipline).thenComparing(CompetitiveSwimmer::getSwimTime);
        fileHandling.getCompetitiveSwimmers().sort(byDisciplineAndSwimTime);
    }

    // Sort competitive swimmer by age group and name
    public void compareCompetitiveAgeGroupAndName() {
        Comparator<CompetitiveSwimmer> byAgeGroupAndName = Comparator.comparing(CompetitiveSwimmer::getAgeGroup).thenComparing(CompetitiveSwimmer::getName);
        fileHandling.getCompetitiveSwimmers().sort(byAgeGroupAndName);
    }

    // Sort regular swimmer by age group and name
    public void compareSwimmerAgeGroupAndName() {
        Comparator<Swimmer> byAgeGroupAndName = Comparator.comparing(Swimmer::getAgeGroup).thenComparing(Swimmer::getName);
        fileHandling.getSwimmers().sort(byAgeGroupAndName);
    }
}


