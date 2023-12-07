package master;

import filehandling.FileHandling;
import menu.ChooseMenuOption;
import menu.ShowMenu;
import swimmer.CompetitiveSwimmer;
import swimmer.Swimmer;
import system.SystemRunning;

public class Master {
    private FileHandling fileHandling;
    private ChooseMenuOption chooseMenuOption;

    private void initVars() {
        fileHandling = new FileHandling();
        chooseMenuOption = new ChooseMenuOption(fileHandling);
        SystemRunning.setRunning(true);
    }

    public static void main(String[] args) {
        new Master().run();
    }

    private void run() {
        initVars();

        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            swimmer.calculateAgeAndAgeGroup();
        }
        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
            competitiveSwimmer.calculateAgeAndAgeGroup();
        }

        fileHandling.saveSwimmerToFile();
        fileHandling.saveCompetitiveSwimmerToFile();

        while (SystemRunning.isRunning()) {
            ShowMenu.showRoleSelection();
            chooseMenuOption.chooseRoleSelectionMenuOption();
        }
    }
}
