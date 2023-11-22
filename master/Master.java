package master;

import filehandling.FileHandling;

public class Master {
    private FileHandling fileHandling;

    private void initVars() {
        fileHandling = new FileHandling();
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
