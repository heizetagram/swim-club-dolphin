package promptuser;

import date.CheckDate;
import menu.ShowMenu;
import ui.SystemMessages;
import ui.UI;

import java.util.Scanner;

public class PromptUser {

    // Prompts user for swim time
    public String promptSwimmersTime() {
        UI.print("Enter swimmers time! example: 00:00:00: "); // -- Should be MM:SS:SSS
        String swimTime = UI.promptString();
        boolean running = true;

        String[] parts = swimTime.split(":");

        while (running) {
            if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 2) {
                SystemMessages.printRedColoredText("Time format must be (XX:XX:XX) ");
                SystemMessages.tryAgain();
                swimTime = UI.promptString();
            } else {
                running = false;
            }
        }
        return swimTime;
    }

    // Prompt user for swimmer's position
    public String promptSwimmersPosition(){
        String position = "";
        UI.print("Enter swimmers position: ");
        while (position.isEmpty()) {
            position = UI.promptString();
            if(position.isEmpty())
                SystemMessages.printGreenColoredText("Swimmer must have obtained a ranking");
        }
        return position;
    }

    // Prompt user for swimmer's event
    public String promptSwimmersEvent(){
        String event = "";
        UI.print("Enter name of the event: ");
        while (event.isEmpty()){
            event = UI.promptString();
            if(event.isEmpty()) {
                SystemMessages.printRedColoredText("Event must have a name");
            }
        }
        return event;
    }

    // Prompts user for name
    public String promptSwimmerName() {
        String name = "";
        UI.print("Enter swimmer name: ");
        while (name.isEmpty()) {
            name = UI.promptString();

            if (name.isEmpty()) {
                SystemMessages.printRedColoredText("Customer must have name");
            }
        }
        return name;
    }

    // Prompts user for birthdate
    public String promptBirthdate() {
        CheckDate checkDate = new CheckDate();
        UI.print("Enter birthdate (DD-MM-YYYY): ");
        String userBirthdate = UI.promptString();
        String[] parts = userBirthdate.split("-");
        userBirthdate = checkDate.checkIfDateFormatIsCorrect(parts, userBirthdate);
        return userBirthdate;
    }

    // Prompts user for email
    public String promptSwimmerEmail() {
        UI.print("Enter swimmer email: ");
        String email = UI.promptString();

        while (email.isEmpty() || !email.contains("@") || !email.contains(".")) {
            SystemMessages.printRedColoredText("Invalid email. Please enter a valid email address");
            email = UI.promptString();
        }
        return email;
    }

    // Prompts user for discipline
    public String addCompetitiveSwimmerDiscipline() {
        UI.println("Choose discipline: ");
        ShowMenu.showDisciplineMenu();
        String disciplineChoice = UI.promptString();
        String discipline = "";
        switch (disciplineChoice) {
            case "1" -> discipline = "BACK";
            case "2" -> discipline = "BREAST";
            case "3" -> discipline = "CRAWL";
            case "4" -> discipline = "BUTTERFLY";
            case "5" -> discipline = "MEDLEY";
            default -> SystemMessages.printRedColoredText("Invalid discipline choice");
        }
        return discipline;
    }

    // Prompts user for phone number
    public String promptSwimmerPhoneNumber() {
        boolean running = true;
        Scanner scan = new Scanner(System.in);
        String phoneDigits = "";

        UI.print("Enter swimmer's phone number: ");
        while (running) {
            if (scan.hasNextInt()) {
                phoneDigits = Integer.toString(scan.nextInt()); // UI.promptInt() didn't work but scan.nextInt() did
                scan.nextLine(); // Clears buffer
                phoneDigits = checkIfPhoneDigitsIs8(phoneDigits);
                running = false;
            } else {
                SystemMessages.printRedColoredText("Phone number must be integer");
                SystemMessages.tryAgain();
                scan.nextLine(); // Clears buffer
            }
        }
        return phoneDigits;
    }

    // Checks if phone digits is 8
    private String checkIfPhoneDigitsIs8(String phoneDigits) {
        Scanner scan = new Scanner(System.in);
        while (phoneDigits.length() != 8) {
            SystemMessages.printRedColoredText("Phone number must be 8 digits");
            SystemMessages.tryAgain();
            phoneDigits = Integer.toString(scan.nextInt()); // Again, does not work with UI.promptInt()
        }
        return phoneDigits;
    }
}