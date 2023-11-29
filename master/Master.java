    package master;

    import filehandling.FileHandling;
    import menu.ChooseMenuOption;
    import menu.ShowMenu;
    import swimmer.CalculateSwimmerAge;
    import swimmer.Swimmer;
    import system.SystemRunning;

    public class Master {
        private FileHandling fileHandling;
        private CalculateSwimmerAge calculateSwimmerAge;
        private ChooseMenuOption chooseMenuOption;

        private void initVars() {
            calculateSwimmerAge = new CalculateSwimmerAge();
            fileHandling = new FileHandling();

            chooseMenuOption = new ChooseMenuOption();
            SystemRunning.setRunning(true);
        }

        public static void main(String[] args) {
            new Master().run();
        }

        private void run() {
            initVars();

            calculateSwimmerAge.setSwimmersAge(fileHandling);

            for (Swimmer swimmer : fileHandling.getSwimmers()) {
                System.out.println(swimmer.getName() + ": " + swimmer.getAge() + ", " + swimmer.getAgeGroup());
            }

            while (SystemRunning.isRunning()) {
                ShowMenu.showRoleSelection();
                chooseMenuOption.chooseRoleSelectionMenuOption();
            }
        }
    }
