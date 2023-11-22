package master;

import filehandling.FileHandling;
import menu.ChooseMenuOption;
import menu.ShowMenu;
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

        SystemRunning.setRunning(true);

        while (SystemRunning.isRunning()) {
            ShowMenu.showRoleSelection();
            chooseMenuOption.chooseRoleSelectionMenuOption();
        }
    }
}
