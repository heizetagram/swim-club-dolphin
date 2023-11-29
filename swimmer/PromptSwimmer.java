package swimmer;


import ui.SystemMessages;
import ui.UI;

import java.util.Scanner;

public class PromptSwimmer {

    // Prompts user for swim time
    public String promptSwimmersTime() {
        CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer("", "", "", "", null, "");
        UI.print("Enter swimmers time! example: 00:00:00");
        String swimTime = UI.promptString();
        boolean running = true;

        String[] parts = swimTime.split(":");

        while (running) {
            if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 2) {
                SystemMessages.printRedColoredText("Time format must be (XX:XX:XX)");
                SystemMessages.tryAgain();
                swimTime = UI.promptString();
            } else {
                running = false;
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

        while (running ) {
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
        UI.print("Enter swimmer email: ");
        String email = UI.promptString();

        while (email.isEmpty() || !email.contains("@") || !email.contains(".")) {
            SystemMessages.printRedColoredText("Invalid email. Please enter a valid email adresse.");
            email = UI.promptString();
        }
        return email;
    }

    // Prompts user for discipline
    public String addCompetitiveSwimmerDiscipline(CompetitiveSwimmer competitiveSwimmer) {
        UI.print("Choose discipline:\n1. BACK\n2. BREAST\n3. CRAWL\n4. BUTTERFLY\n5. MEDLEY");
        String disciplineChoice = UI.promptString();
        String discipline = "";
        switch (disciplineChoice) {
            case "1" -> {discipline = "BACK"; competitiveSwimmer.setDiscipline(Discipline.BACK);}
            case "2" -> {discipline = "BREAST"; competitiveSwimmer.setDiscipline(Discipline.BREAST);}
            case "3" -> {discipline = "CRAWL"; competitiveSwimmer.setDiscipline(Discipline.CRAWL);}
            case "4" -> {discipline = "BUTTERFLY"; competitiveSwimmer.setDiscipline(Discipline.BUTTERFLY);}
            case "5" -> {discipline = "MEDLEY"; competitiveSwimmer.setDiscipline(Discipline.MEDLEY);}
            default -> {SystemMessages.printRedColoredText("Invalid discipline choice"); discipline = addCompetitiveSwimmerDiscipline(competitiveSwimmer);}
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