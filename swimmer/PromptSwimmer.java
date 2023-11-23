package swimmer;


import system.SystemRunning;
import ui.SystemMessages;
import ui.UI;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PromptSwimmer {
    private int age;

    // Constructor
    public PromptSwimmer() {
        age = 0;
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

    // Prompts user for birthdate and calculates age
    public int promptBirthYearAndCalculateAge() {
        String birthdate = promptBirthdate();
        return age;
    }

    // Prompts user for birthdate
    public String promptBirthdate() {
        boolean running = true;

        UI.print("Enter birthdate (DD-MM-YYYY): ");
        String userBirthdate = UI.promptString();

        String[] parts = userBirthdate.split("-");

        while (running) {
            if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
                SystemMessages.printRedColoredText("Date format must be (DD-MM-YYYY)");
                SystemMessages.tryAgain();
            } else {
                LocalDateTime localDateTimeBirthdate = convertBirthdateToLocalDateTime(parts);
                calculateAge(localDateTimeBirthdate);
                running = false;
            }
        }
        return userBirthdate;
    }

    // Converts String birthdate to LocalDateTime
    private LocalDateTime convertBirthdateToLocalDateTime(String[] parts) {
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return LocalDateTime.of(year, month, day, 0, 0);
    }

    // Calculates age
    // Subtracts user-given birthdate from the current date
    private int calculateAge(LocalDateTime birthdate) {
        LocalDateTime currentDate = LocalDateTime.now();
        return (int) ChronoUnit.YEARS.between(birthdate, currentDate); // Typecasts long to int
    }

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

    public int promptSwimmerPhoneNumber(){
        UI.print("Enter swimmer phone number: ");
        int phone = UI.promptInt();
        String phoneDigits = Integer.toString(phone);

        // Checks if phone number is 8 digits
        while (phoneDigits.length() != 8) {
            SystemMessages.printRedColoredText("Phone number must be 8 digits");
            SystemMessages.tryAgain();
            phone = UI.promptInt();
            phoneDigits = Integer.toString(phone);
        }
        return phone;
        }
    }

