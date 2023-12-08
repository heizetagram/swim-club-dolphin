package swimmer;

import filehandling.FileHandling;

public class LoadAge {
    // Loads age and sets age in ArrayLists + .txt files
    // -- To account for someone's birthday when their age is updated
    public static void loadAge(FileHandling fileHandling) {
        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            swimmer.calculateAgeAndAgeGroup();
        }
        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
            competitiveSwimmer.calculateAgeAndAgeGroup();
        }

        fileHandling.saveSwimmerToFile();
        fileHandling.saveCompetitiveSwimmerToFile();
    }
}
