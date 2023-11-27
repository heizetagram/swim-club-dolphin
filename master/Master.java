    package master;

    import filehandling.FileHandling;
    import menu.ChooseMenuOption;
    import menu.ShowMenu;
    import swimmer.CompetitiveSwimmer;
    import system.SystemRunning;
    import trainer.SortSwimmers;

    public class Master {
        private FileHandling fileHandling;
        private ChooseMenuOption chooseMenuOption;

        private void initVars() {
            fileHandling = new FileHandling();
            fileHandling.loadSwimmerFromFile();
            fileHandling.loadCompetitiveSwimmerFromFile();

            chooseMenuOption = new ChooseMenuOption();
            SystemRunning.setRunning(true);
        }

        public static void main(String[] args) {
            new Master().run();
        }

        private void run() {
            initVars();

            SortSwimmers sortSwimmers = new SortSwimmers();

            CompetitiveSwimmer c1 = new CompetitiveSwimmer("c1", "10-10-2000", "12121212", "12@12.com", "BREAST", "12:00:00");
            CompetitiveSwimmer c2 = new CompetitiveSwimmer("c2", "10-10-2000", "12121212", "12@12.com", "BREAST", "11:00:00");
            CompetitiveSwimmer c3 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "BREAST", "13:00:00");
            CompetitiveSwimmer c4 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "BREAST", "16:00:00");
            CompetitiveSwimmer c5 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "BREAST", "13:40:00");

            CompetitiveSwimmer c6 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "BACK", "15:40:00");
            CompetitiveSwimmer c7 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "BACK", "12:40:00");
            CompetitiveSwimmer c8 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "BACK", "17:40:00");
            CompetitiveSwimmer c9 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "BACK", "11:40:00");
            CompetitiveSwimmer c10 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "BACK", "16:40:00");

            CompetitiveSwimmer c11 = new CompetitiveSwimmer("c3", "10-10-2000", "12121212", "12@12.com", "MEDLEY", "16:40:00");

            sortSwimmers.getCompetitiveSwimmers().add(c2);
            sortSwimmers.getCompetitiveSwimmers().add(c3);
            sortSwimmers.getCompetitiveSwimmers().add(c10);
            sortSwimmers.getCompetitiveSwimmers().add(c7);
            sortSwimmers.getCompetitiveSwimmers().add(c4);
            sortSwimmers.getCompetitiveSwimmers().add(c6);
            sortSwimmers.getCompetitiveSwimmers().add(c1);
            sortSwimmers.getCompetitiveSwimmers().add(c9);
            sortSwimmers.getCompetitiveSwimmers().add(c5);
            sortSwimmers.getCompetitiveSwimmers().add(c8);
            sortSwimmers.getCompetitiveSwimmers().add(c11);

            sortSwimmers.compareDisciplineAndSwimTime();

            sortSwimmers.printTop5CompetitiveSwimmers();

            while (SystemRunning.isRunning()) {
                ShowMenu.showRoleSelection();
                chooseMenuOption.chooseRoleSelectionMenuOption();
            }
        }
    }
