package menu;

import filehandling.FileHandling;
import filehandling.ModifySwimmer;
import printinfo.PrintInfo;
import security.Login;
import trainer.SortSwimmers;
import ui.SystemMessages;
import ui.UI;

public class ChooseMenuOption {
    private ModifySwimmer modifySwimmer;
    private FileHandling fileHandling;
    private SortSwimmers sortSwimmers;
    private PrintInfo printInfo;
    private Login login;

    // Constructor
    public ChooseMenuOption(FileHandling fileHandling) {
        this.fileHandling = fileHandling;
        modifySwimmer = new ModifySwimmer(fileHandling);
        sortSwimmers = new SortSwimmers(fileHandling);
        printInfo = new PrintInfo();
        login = new Login();
    }

    // CHOOSE MENU OPTIONS \\

    // Choose option in role selection menu
    public void chooseRoleSelectionMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> login.loginForeman(this);
            case 2 -> {ShowMenu.showTrainerMenu(); chooseTrainerMenuOption();}
            case 3 -> {ShowMenu.showCompetitiveTrainerMenu(); chooseCompetitiveTrainerMenuOption();}
            case 4 -> {ShowMenu.showAccountantMenu(); chooseAccountantMenuOption();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Trainer's Menu
    public void chooseTrainerMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {printInfo.printAllRegularSwimmers(fileHandling); SystemMessages.pressEnterToContinue();}
            case 2 -> {modifySwimmer.editSwimmer(); SystemMessages.pressEnterToContinue();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Competitive trainer's menu
    public void chooseCompetitiveTrainerMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {printInfo.printAllRegularSwimmers(fileHandling); SystemMessages.pressEnterToContinue();} // add compareRegularName()
            // Tilføj en case der også kan vise competitive swimmer's info (ald er, email osv.)
            case 2 -> {sortSwimmers.compareCompetitiveAgeGroupAndName(); printInfo.printAllCompetitiveSwimmers(fileHandling); SystemMessages.pressEnterToContinue();}
            case 3 -> {sortSwimmers.compareCompetitiveDisciplineAndSwimTime(); printInfo.printTop5CompetitiveSwimmers(fileHandling); SystemMessages.pressEnterToContinue();}
            case 4 -> {modifySwimmer.addCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
            case 5 -> {modifySwimmer.editCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Foreman's Menu
    public void chooseForemanMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {modifySwimmer.addSwimmer(); SystemMessages.pressEnterToContinue();}
            //case 2 -> {modifySwimmer.deleteSwimmer(); SystemMessages.pressEnterToContinue();}
            case 3 -> {modifySwimmer.editSwimmer(); SystemMessages.pressEnterToContinue();}
            case 4 -> {modifySwimmer.editCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
            case 5 -> {modifySwimmer.addCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
            case 6 -> {modifySwimmer.addEventAndPosition(); SystemMessages.pressEnterToContinue();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Accountant's Menu
    public void chooseAccountantMenuOption() {
        switch (UI.promptInt()) {
            // add compareSwimmerAgeGroupAndName
            case 1 -> {sortSwimmers.compareCompetitiveAgeGroupAndName(); printInfo.printSwimmersInDebt(fileHandling); SystemMessages.pressEnterToContinue();}
            case 2 -> {modifySwimmer.editPayment(fileHandling);SystemMessages.pressEnterToContinue();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }
}
