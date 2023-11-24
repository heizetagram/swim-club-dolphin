package ui;

import swimmer.Swimmer;
import system.SystemRunning;

import java.util.Scanner;

public class SystemMessages {
    private SystemRunning systemRunning;

    // Constructor
    public SystemMessages() {
        systemRunning = new SystemRunning();
    }

    // Prints swimmer information
    public static void printSwimmer(Swimmer swimmer) {
        // EMPTY BODY
    }

    // Press ENTER to continue
    public static void pressEnterToContinue() {
        Scanner scan = new Scanner(System.in);
        UI.print(ConsoleColors.BLACK_BRIGHT + "Press ENTER to continue" + ConsoleColors.RESET);
        scan.nextLine(); // Does not work with UI.promptString() for some reason !!!
        UI.println("");
    }

    // Try again
    public static void tryAgain() {
        printRedColoredText("Please try again!");
    }

    // Print green colored text
    public static void printGreenColoredText(String text) {
        UI.println(ConsoleColors.GREEN_BRIGHT + text + ConsoleColors.RESET);
    }

    // Print red colored text
    public static void printRedColoredText(String text) {
        UI.println(ConsoleColors.RED + text + ConsoleColors.RESET);
    }

    // Exit system
    public static void quitSystem() {
        UI.println("Cya!");
        SystemRunning.setRunning(false);
    }

}
