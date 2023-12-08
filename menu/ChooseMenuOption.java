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
        printInfo = new PrintInfo(fileHandling);
        login = new Login();
    }

    // CHOOSE MENU OPTIONS \\

    // Choose option in role selection menu
    public void chooseRoleSelectionMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> login.loginForeman(this);
            case 2 -> login.loginTrainer(this);
            case 3 -> login.loginCompetitiveTrainer(this);
            case 4 -> login.loginAccountant(this);
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Trainer's Menu
    public void chooseTrainerMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {sortSwimmers.compareSwimmerAgeGroupAndName(); printInfo.printAllRegularSwimmers(); SystemMessages.pressEnterToContinue();}
            case 2 -> {modifySwimmer.editSwimmer(); SystemMessages.pressEnterToContinue();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Competitive trainer's menu
    public void chooseCompetitiveTrainerMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {sortSwimmers.compareSwimmerAgeGroupAndName(); printInfo.printAllRegularSwimmers(); SystemMessages.pressEnterToContinue();}
            case 2 -> {sortSwimmers.compareCompetitiveAgeGroupAndName(); printInfo.printAllCompetitiveSwimmers(); SystemMessages.pressEnterToContinue();}
            case 3 -> {sortSwimmers.compareCompetitiveDisciplineAndSwimTime(); printInfo.printTop5CompetitiveSwimmers(); SystemMessages.pressEnterToContinue();}
            case 4 -> {modifySwimmer.addCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
            case 5 -> {modifySwimmer.editCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
            case 6 -> {modifySwimmer.addEventAndPosition(); SystemMessages.pressEnterToContinue();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Foreman's Menu
    public void chooseForemanMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {sortSwimmers.compareSwimmerAgeGroupAndName(); printInfo.printAllRegularSwimmers(); SystemMessages.pressEnterToContinue();} // add compareRegularName()
            case 2 -> {sortSwimmers.compareCompetitiveAgeGroupAndName(); printInfo.printAllCompetitiveSwimmers(); SystemMessages.pressEnterToContinue();}
            case 3 -> {modifySwimmer.addSwimmer(); SystemMessages.pressEnterToContinue();}
            case 4 -> {modifySwimmer.addCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
            case 5 -> {modifySwimmer.editSwimmer(); SystemMessages.pressEnterToContinue();}
            case 6 -> {modifySwimmer.editCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Accountant's Menu
    public void chooseAccountantMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {sortSwimmers.compareSwimmerAgeGroupAndName(); sortSwimmers.compareCompetitiveAgeGroupAndName(); printInfo.printSwimmersInDebt(); SystemMessages.pressEnterToContinue();}
            case 2 -> {modifySwimmer.editPayment(fileHandling);SystemMessages.pressEnterToContinue();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }
}
