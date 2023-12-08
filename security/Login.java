package security;

import menu.ChooseMenuOption;
import menu.ShowMenu;
import system.SystemRunning;
import ui.UI;

public class Login {
    private Password password;

    // Constructor
    public Login() {
        password = new Password();
    }

    // Login Trainer
    public void loginTrainer(ChooseMenuOption chooseMenuOption) {
        UI.println("Enter password");
        UI.promptString(); // Scanner bug
        password.checkPassword(UI.promptString(), "1");
        while (password.isPasswordCorrect() && SystemRunning.isRunning()) {
            ShowMenu.showTrainerMenu();
            chooseMenuOption.chooseTrainerMenuOption();
        }
        if (!password.isPasswordCorrect()) {
            SystemRunning.setRunning(false);
        }
    }

    // Login Competitive Trainer
    public void loginCompetitiveTrainer(ChooseMenuOption chooseMenuOption) {
        UI.println("Enter password");
        UI.promptString(); // Scanner bug
        password.checkPassword(UI.promptString(), "1");
        while (password.isPasswordCorrect() && SystemRunning.isRunning()) {
            ShowMenu.showCompetitiveTrainerMenu();
            chooseMenuOption.chooseCompetitiveTrainerMenuOption();
        }
        if (!password.isPasswordCorrect()) {
            SystemRunning.setRunning(false);
        }
    }


    // Foreman password
    public void loginForeman(ChooseMenuOption chooseMenuOption) {
        UI.println("Enter password");
        UI.promptString(); // Scanner bug
        password.checkPassword(UI.promptString(), "1");
        while (password.isPasswordCorrect() && SystemRunning.isRunning()) {
            ShowMenu.showForemanMenu();
            chooseMenuOption.chooseForemanMenuOption();
        }
        if (!password.isPasswordCorrect()) {
            SystemRunning.setRunning(false);
        }
    }

    // Accountant password
    public void loginAccountant(ChooseMenuOption chooseMenuOption) {
        UI.println("Enter password");
        UI.promptString(); // Scanner bug
        password.checkPassword(UI.promptString(), "2");
        while (password.isPasswordCorrect() && SystemRunning.isRunning()) { // Keep showing Accountant's menu while logged in
            ShowMenu.showAccountantMenu();
            chooseMenuOption.chooseAccountantMenuOption();
        }
        if (!password.isPasswordCorrect()) {
            SystemRunning.setRunning(false);
        }
    }
}
