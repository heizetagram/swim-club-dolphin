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
    public void printSwimmer(Swimmer swimmer) {
        // EMPTY BODY
    }

    // Press ENTER to continue
    public void pressEnterToContinue() {
        Scanner scan = new Scanner(System.in);
        UI.print(ConsoleColors.BLACK_BRIGHT + "Press ENTER to continue" + ConsoleColors.RESET);
        scan.nextLine(); // Does not work with UI.promptString() for some reason !!!
        UI.println("");
    }

    // Try again
    public void tryAgain() {
        UI.println(ConsoleColors.RED + "Try again!" + ConsoleColors.RESET);
        UI.promptString(); // User prompt - Enter to show menu again
    }

    // Exit system
    public void quitSystem() {
        UI.println("Cya!");
        SystemRunning.setRunning(false);
    }

}
