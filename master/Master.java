package master;

import filehandling.FileHandling;
import menu.ChooseMenuOption;
import menu.ShowMenu;
import accountant.CalculateSwimmerSubscription;
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
            swimmer.calculateAge(swimmer.convertBirthdateToLocalDate());
            swimmer.calculateAgeGroup(swimmer.getAge());
        }

        CalculateSwimmerSubscription calculateSwimmerSubscription = new CalculateSwimmerSubscription();
        calculateSwimmerSubscription.setSwimmersSubscription(fileHandling);
        calculateSwimmerSubscription.setCompetitiveSwimmersSubscription(fileHandling);
        calculateSwimmerSubscription.checkIfPaid(fileHandling);

        while (SystemRunning.isRunning()) {
            ShowMenu.showRoleSelection();
            chooseMenuOption.chooseRoleSelectionMenuOption();
        }
    }
}
