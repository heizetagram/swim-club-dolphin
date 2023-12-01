package menu;

import ui.ConsoleColors;
import ui.UI;

public class ShowMenu {

    // SHOW MENUS \\
    public static void showRoleSelection() {
        UI.println("Welcome to the " + ConsoleColors.BLUE + "Dolphin" + ConsoleColors.RESET + "\nChoose your role:");
        UI.println("(1) Foreman");
        UI.println("(2) Trainer");
        UI.println("(3) Competitive Trainer");
        UI.println("(4) Accountant");
        UI.println("(9) Quit");
    }

    public static void showTrainerMenu() {
        UI.println("(1) View regular swimmers");
        UI.println("(2) Edit swimmer");
        UI.println("(9) Quit");
    }

    public static void showCompetitiveTrainerMenu() {
        UI.println("(1) View regular swimmers");
        UI.println("(2) View competitive swimmers");
        UI.println("(3) View top 5 swim times");
        UI.println("(4) Add competitive swimmer");
        UI.println("(5) Edit competitive swimmer");
        UI.println("(9) Quit");
    }

    public static void showAccountantMenu() {
        UI.println("Membership Management:");
        UI.println("(1) Calculate Membership Fee");
        UI.println("(2) Apply discount");
        UI.println("(3) Manage Membership Fee Payments");
        UI.println("Overview of Members in Outstanding Payments:");
        UI.println("(4) View Members with Outstanding Payments");
        UI.println("(5) Register Members with Outstanding Payments");
        UI.println("(9) Quit");
    }

    public static void showForemanMenu() {
        UI.println("(1) Add swimmer");
        UI.println("(2) Delete swimmer");
        UI.println("(3) Edit swimmer");
        UI.println("(4) View swimmers");
        UI.println("(5) Add competitive swimmer");
        UI.println("(6) Add Event/position");
        UI.println("(9) Quit");
    }

    public static void showDisciplineMenu() {
        UI.println("(1) BACK");
        UI.println("(2) BREAST");
        UI.println("(3) CRAWL");
        UI.println("(4) BUTTERFLY");
        UI.println("(5) MEDLEY");
    }
}