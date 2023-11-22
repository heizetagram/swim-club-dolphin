package menu;

import filehandling.ModifySwimmer;
import ui.SystemMessages;
import ui.UI;

public class ChooseMenuOption {
    private String currentRole;
    private ModifySwimmer modifySwimmer;

    // Constructor
    public ChooseMenuOption() {
        modifySwimmer = new ModifySwimmer();
    }

    // CHOOSE MENU OPTIONS \\

    // Choose option in role selection menu
    public void chooseRoleSelectionMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> chooseTrainerMenuOption();
            case 2 -> chooseForemanMenuOption();
            case 3 -> chooseAccountantMenuOption();
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Customer's Menu
    public void chooseTrainerMenuOption() {
        switch (UI.promptInt()) {
          //  case 1 ->
            case 9 -> SystemMessages.quitSystem();
            default -> SystemMessages.tryAgain();
        }
    }

    // Choose option in Harry's Menu
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

    // Choose option in Accountant Menu
    public void chooseAccountantMenuOption() {
        switch (UI.promptInt()) {
            case 1 -> {modifyAppointment.viewAllSortedAppointments(); systemMessages.pressEnterToContinue();}
            case 2 -> {financialAppointmentInfo.viewFinancialAppointment(); systemMessages.pressEnterToContinue();}
            case 3 -> {dailyTurnover.calculateDailyTurnover(); systemMessages.pressEnterToContinue();}
            case 9 -> systemMessages.quitSystem();
            default -> systemMessages.tryAgain();
        }
    }
}
