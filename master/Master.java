package master;

import filehandling.FileHandling;
import filehandling.ModifySwimmer;
import menu.ChooseMenuOption;
import menu.ShowMenu;
import swimmer.Swimmer;
import system.SystemRunning;

public class Master {
    private FileHandling fileHandling;
    private ChooseMenuOption chooseMenuOption;

    private void initVars() {
        fileHandling = new FileHandling();
        chooseMenuOption = new ChooseMenuOption();
    }

    public static void main(String[] args) {
        new Master().run();
    }

    private void run() {
        initVars();

        fileHandling.saveSwimmerToFile();
        fileHandling.loadSwimmerFromFile();

        ModifySwimmer modifySwimmer = new ModifySwimmer();
        modifySwimmer.addSwimmer();

        SystemRunning.setRunning(true);

        while (SystemRunning.isRunning()) {
            ShowMenu.showRoleSelection();
            chooseMenuOption.chooseRoleSelectionMenuOption();
        }
    }
}
