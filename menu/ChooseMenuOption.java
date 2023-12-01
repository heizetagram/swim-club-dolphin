package menu;

import filehandling.FileHandling;
import filehandling.ModifySwimmer;
import printinfo.PrintInfo;
import swimmer.CalculateSwimmerAge;
import trainer.SortSwimmers;
import ui.SystemMessages;
import ui.UI;

public class ChooseMenuOption {
    private ModifySwimmer modifySwimmer;
    private FileHandling fileHandling;
    private PrintInfo printInfo;

    // Constructor
    public ChooseMenuOption() {
        modifySwimmer = new ModifySwimmer();
        fileHandling = new FileHandling();
        printInfo = new PrintInfo();
    }

    // CHOOSE MENU OPTIONS \\

    // Choose option in role selection menu
    public void chooseRoleSelectionMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {ShowMenu.showForemanMenu(); chooseForemanMenuOption();}
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
            case 2 -> {modifySwimmer.editSwimmer(); SystemMessages.tryAgain();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Competitive trainer's menu
    public void chooseCompetitiveTrainerMenuOption() {
        SortSwimmers sortSwimmers = new SortSwimmers(fileHandling);
        CalculateSwimmerAge calculateSwimmerAge = new CalculateSwimmerAge();
        calculateSwimmerAge.setCompetitiveSwimmersAge(fileHandling); // --Jeg hader at man skal kalde på calculateSwimmerAge, hver gang man skal bruge alderen/aldersgruppen

        switch (UI.promptInt()) {
            case 1 -> {printInfo.printAllRegularSwimmers(fileHandling); SystemMessages.pressEnterToContinue();} // add compareRegularName()
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
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }
}
