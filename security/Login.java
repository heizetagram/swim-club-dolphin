package security;

import menu.ChooseMenuOption;
import menu.ShowMenu;
import system.SystemRunning;
import ui.UI;

public class Login {

    private ShowMenu showMenu;
    private ChooseMenuOption chooseMenuOption;
    private Password password;

    // Constructor
    public Login() {
        password = new Password();
        showMenu = new ShowMenu();
        chooseMenuOption = new ChooseMenuOption();
    }

    // Customer
    public void loginTrainer() {
        while (SystemRunning.isRunning()) { // Keep showing Customer's menu while logged in
            showMenu.showTrainerMenu();
            chooseMenuOption.chooseTrainerMenuOption();
        }
    }

    // Harry password
    public void loginHarry() {
        UI.println("Enter password");
        UI.promptString(); // Scanner bug
        password.checkPassword(UI.promptString(), "1");
        while (password.isPasswordCorrect() && SystemRunning.isRunning()) { // Keep showing Harry's menu while logged in
            showMenu.showForemanMenu();
            chooseMenuOption.chooseForemanMenuOption();
        }
        if (!password.isPasswordCorrect()) {
            main.setRunning(false);
        }
    }

    // Accountant password
    public void loginAccountant() {
        UI.println("Enter password");
        UI.promptString(); // Scanner bug
        password.checkPassword(UI.promptString(), "1");
        while (password.isPasswordCorrect() && SystemRunning.isRunning()) { // Keep showing Accountant's menu while logged in
            showMenu.showAccountantMenu();
            chooseMenuOption.chooseAccountantMenuOption();
        }
        if (!password.isPasswordCorrect()) {
            SystemRunning.setRunning(false);
        }
    }
}
