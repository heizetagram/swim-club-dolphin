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
            fileHandling.loadSwimmerFromFile();

            chooseMenuOption = new ChooseMenuOption();
            SystemRunning.setRunning(true);
        }

        public static void main(String[] args) {
            new Master().run();
        }

        private void run() {
            initVars();

            while (SystemRunning.isRunning()) {
                ShowMenu.showRoleSelection();
                chooseMenuOption.chooseRoleSelectionMenuOption();
            }
        }
    }
