    package master;

    import filehandling.FileHandling;
    import menu.ChooseMenuOption;
    import menu.ShowMenu;
    import swimmer.CalculateSwimmerAge;
    import system.SystemRunning;
    import trainer.SortSwimmers;

    public class Master {
        private FileHandling fileHandling;
        private CalculateSwimmerAge calculateSwimmerAge;
        private CalculateSwimmerAge calculateCompetitiveSwimmerAge;
        private ChooseMenuOption chooseMenuOption;

        private void initVars() {
            calculateSwimmerAge = new CalculateSwimmerAge();
            calculateCompetitiveSwimmerAge = new CalculateSwimmerAge();
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
            calculateCompetitiveSwimmerAge.setCompetitiveSwimmersAge(fileHandling);

            SortSwimmers sortSwimmers = new SortSwimmers(fileHandling);

            sortSwimmers.compareDisciplineAndSwimTime();
            sortSwimmers.printTop5CompetitiveSwimmers();

            while (SystemRunning.isRunning()) {
                ShowMenu.showRoleSelection();
                chooseMenuOption.chooseRoleSelectionMenuOption();
            }
        }
    }
