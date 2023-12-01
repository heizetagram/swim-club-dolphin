package menu;

import filehandling.FileHandling;
import filehandling.ModifySwimmer;
import printinfo.PrintInfo;
import trainer.SortSwimmers;
import ui.SystemMessages;
import ui.UI;

public class ChooseMenuOption {
    private ModifySwimmer modifySwimmer;
    private FileHandling fileHandling;

    // Constructor
    public ChooseMenuOption() {
        modifySwimmer = new ModifySwimmer();
        fileHandling = new FileHandling();
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
            case 1 -> {fileHandling.printAllRegularSwimmers();SystemMessages.pressEnterToContinue();}
            case 2 -> {modifySwimmer.editSwimmer(); SystemMessages.tryAgain();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Competitive trainer's menu
    public void chooseCompetitiveTrainerMenuOption() {
        SortSwimmers sortSwimmers = new SortSwimmers(fileHandling);
        switch (UI.promptInt()) {
            case 1 -> {fileHandling.printAllRegularSwimmers(); SystemMessages.pressEnterToContinue();} // add compareRegularName()
            case 2 -> {sortSwimmers.compareCompetitiveName(); fileHandling.printAllCompetitiveSwimmers(); SystemMessages.pressEnterToContinue();}
            case 3 -> {sortSwimmers.compareDisciplineAndSwimTime(); PrintInfo.printTop5CompetitiveSwimmers(fileHandling); SystemMessages.pressEnterToContinue();}
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
