package date;

import ui.SystemMessages;
import ui.UI;

import java.time.DateTimeException;
import java.time.LocalDate;

public class CheckDate {

    // Check if date format is correct
    public String checkIfDateFormatIsCorrect(String[] parts, String userBirthdate) {
        boolean running = true;
        while (running) {
            try {
                if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
                    printDateFormatException();
                    userBirthdate = UI.promptString();
                    parts = userBirthdate.split("-");
                } else {
                    userBirthdate = checkIfDateIsValid(parts, userBirthdate);
                    running = false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                printDateFormatException();
                userBirthdate = UI.promptString();
                parts = userBirthdate.split("-");
            }
        }
        return userBirthdate;
    }

    // Checks if user-given date is valid
    private String checkIfDateIsValid(String[] parts, String userBirthdate) {
        CheckDate checkDate = new CheckDate();
        boolean running = true;
        while (running) {
            try {
                LocalDate birthdateLocalDate = checkDate.convertBirthdateToLocalDate(parts);
                userBirthdate = checkDate.checkIfDateIsInTheFuture(birthdateLocalDate, userBirthdate);
                running = false;
            } catch (DateTimeException e) {
                SystemMessages.printRedColoredText("Date doesn't exist");
                SystemMessages.tryAgain();
                userBirthdate = UI.promptString();
                parts = userBirthdate.split("-");
            }
        }
        return userBirthdate;
    }

    // Checks if the user-given birthdate is in the future
    public String checkIfDateIsInTheFuture(LocalDate birthdate, String userBirthdate) {
        do {
            if (birthdate.isAfter(LocalDate.now())) {
                SystemMessages.printRedColoredText("Cannot have birthdate in the future");
                SystemMessages.tryAgain();
                userBirthdate = UI.promptString();
                String[] parts = userBirthdate.split("-");

                userBirthdate = checkIfDateFormatIsCorrect(parts, userBirthdate);
                parts = userBirthdate.split("-");

                birthdate = convertBirthdateToLocalDate(parts);
            }
        } while (birthdate.isAfter(LocalDate.now()));
    return userBirthdate;
    }

    // Converts String birthdate to LocalDateTime
    LocalDate convertBirthdateToLocalDate(String[] parts) {
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return LocalDate.of(year, month, day);
    }

    // Prints date format exception
    private void printDateFormatException() {
        SystemMessages.printRedColoredText("Date format must be (DD-MM-YYYY)");
        SystemMessages.tryAgain();
    }
}
