package menu;

import ui.ConsoleColors;
import ui.UI;

public class ShowMenu {

    // SHOW MENUS \\
    public static void showRoleSelection() {
        UI.println("Welcome to the Dolphin\nAre you: ");
        UI.println("(1) Trainer");
        UI.println("(2) Foreman");
        UI.println("(3) Accountant");
        UI.println("(9) Quit");
    }

    public static void showTrainerMenu() {
        UI.println("(1) View available swimmers");
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
        UI.println("(4) View swimmers on specific date");
        UI.println("(5) Add competitive swimmer");
        UI.println("(9) Quit");
    }

    public static void showSwimTimeMenu() {
        UI.println("Enter additional purchase:");
        UI.printf("%s%s%5d DKK%s%n", "(1) Shampoo", ConsoleColors.GREEN_BRIGHT, 50, ConsoleColors.RESET);
        UI.printf("%s%s%7d DKK%s%n", "(2) Balsam", ConsoleColors.GREEN_BRIGHT, 100, ConsoleColors.RESET);
        UI.printf("%s%s%5d DKK%s%n", "(3) Hairnet", ConsoleColors.GREEN_BRIGHT, 60, ConsoleColors.RESET);
        UI.print(ConsoleColors.BLACK_BRIGHT + "Press ENTER to skip" + ConsoleColors.RESET);
    }
}