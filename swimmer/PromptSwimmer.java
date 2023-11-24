package swimmer;


import ui.SystemMessages;
import ui.UI;


import java.util.Scanner;

public class PromptSwimmer {

    public String promptSwimmersTime(){
        CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer("", "", "", "", null, "");
        UI.print("Enter swimmers time! example: 00:00:00");
        String swimTime = UI.promptString();
        boolean running = true;

        String[] parts = swimTime.split(":");

        while (running) {
            if (parts[0].length() != 2 || parts[1].length() != 2){
                SystemMessages.printRedColoredText("Time format must be (XX:XX:XX)");
                SystemMessages.tryAgain();
                swimTime = UI.promptString();

            }
            }
        return swimTime;
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
        Swimmer swimmer = new Swimmer("", "", "", "");
        boolean running = true;

        UI.print("Enter birthdate (DD-MM-YYYY): ");
        String userBirthdate = UI.promptString();

        String[] parts = userBirthdate.split("-");

        while (running) {
            if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
                SystemMessages.printRedColoredText("Date format must be (DD-MM-YYYY)");
                SystemMessages.tryAgain();
                userBirthdate = UI.promptString();
            } else {
                running = swimmer.checkIfDateIsValid(parts);
            }
        }
        return userBirthdate;
    }

    // Prompts user for email
    public String promptSwimmerEmail() {
        String email = "";
        UI.print("Enter swimmer email: ");
        while (email.isEmpty()) {
            email = UI.promptString();

            if (email.isEmpty()) {
                SystemMessages.printRedColoredText("Customer must have an email");
            }
        }
        return email;
    }

    // Prompts user for phone number
    public String promptSwimmerPhoneNumber(){
        boolean running = true;
        Scanner scan = new Scanner(System.in);
        int phone = 0;
        String phoneDigits = "";

        UI.print("Enter swimmer's phone number: ");

        while (running) {
            if (scan.hasNextInt()) { // Checks if user-input is an int
                phone = UI.promptInt();
                phoneDigits = Integer.toString(phone);

                // Checks if phone number is 8 digits
                phoneDigits = checkIfPhoneDigitsIs8(phoneDigits, phone);
                running = false;
            } else {
                SystemMessages.printRedColoredText("Phone number must be integer");
                SystemMessages.tryAgain();
            }
        }
        return phoneDigits;
        }

        // Checks if phone digits is 8
        private String checkIfPhoneDigitsIs8(String phoneDigits, int phone) {
            while (phoneDigits.length() != 8) {
                SystemMessages.printRedColoredText("Phone number must be 8 digits");
                SystemMessages.tryAgain();
                phone = UI.promptInt();
                phoneDigits = Integer.toString(phone);
            }
            return phoneDigits;
        }
    }

