package menu;

import filehandling.ModifySwimmer;
import ui.SystemMessages;
import ui.UI;

public class ChooseMenuOption {
    private ModifySwimmer modifySwimmer;

    // Constructor
    public ChooseMenuOption() {
        modifySwimmer = new ModifySwimmer();
    }

    // CHOOSE MENU OPTIONS \\

    // Choose option in role selection menu
    public void chooseRoleSelectionMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {ShowMenu.showTrainerMenu(); chooseTrainerMenuOption();}
            case 2 -> {ShowMenu.showForemanMenu(); chooseForemanMenuOption();}
            case 3 -> {ShowMenu.showAccountantMenu(); chooseAccountantMenuOption();}
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Trainer's Menu
    public void chooseTrainerMenuOption() {
        switch (UI.promptInt()) {
          // case 1 ->
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
            //case 4 -> {modifySwimmer.viewSwimmers(); SystemMessages.pressEnterToContinue();}
            case 5 -> {modifySwimmer.addCompetitiveSwimmer(); SystemMessages.pressEnterToContinue();}
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
