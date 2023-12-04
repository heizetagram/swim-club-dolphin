package swimmer;

import filehandling.FileHandling;
import ui.SystemMessages;
import ui.UI;

import java.time.LocalDate;
import java.time.Period;

public class CalculateSwimmerAge {

    // Jeg gider ik at kalde på fileHandling der ligger i main, men det virker : - (
    // Jeg forstår ikke hvorfor at man skal kalde på fileHandling i main
    // Det er som om at, når jeg bruger fileHandling.getSwimmers fra en lokal FileHandling instans, laver den bare en kopi af FileHandling.getSwimmers, og opdaterer ArrayListen lokalt.
    public void setSwimmersAge(FileHandling fileHandling) {
        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            String[] parts = swimmer.getBirthdate().split("-");
            LocalDate localDateBirthdate = convertBirthdateToLocalDate(parts);
            int age = calculateAge(localDateBirthdate);
            swimmer.setAge(age);
            swimmer.setAgeGroup(calculateAgeGroup(age));
        }
        fileHandling.saveSwimmerToFile();
    }

    // Calculates age
    // Subtracts user-given birthdate from the current date
    int calculateAge(LocalDate birthdate) {
        Period yearDifference = Period.between(birthdate, LocalDate.now());
        return yearDifference.getYears();
    }

    // Checks if the user-given birthdate is in the future
    public String checkIfDateIsInTheFuture(LocalDate birthdate, String userBirthdate) {
        PromptSwimmer promptSwimmer = new PromptSwimmer();
        do {
            if (birthdate.isAfter(LocalDate.now())) {
                SystemMessages.printRedColoredText("Cannot have birthdate in the future");
                SystemMessages.tryAgain();
                userBirthdate = UI.promptString();
                String[] parts = userBirthdate.split("-");

                userBirthdate = promptSwimmer.checkIfDateFormatIsCorrect(parts, userBirthdate);
                parts = userBirthdate.split("-");

                birthdate = convertBirthdateToLocalDate(parts);
            }
        } while (birthdate.isAfter(LocalDate.now()));
    return userBirthdate;
    }

    // Set Competitive Swimmer's age
    public void setCompetitiveSwimmersAge(FileHandling fileHandling) {
        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
            String[] parts = competitiveSwimmer.getBirthdate().split("-");
            LocalDate localDateBirthdate = convertBirthdateToLocalDate(parts);
            int age = calculateAge(localDateBirthdate);
            competitiveSwimmer.setAge(age);
            competitiveSwimmer.setAgeGroup(calculateAgeGroup(age));
        }
        fileHandling.saveCompetitiveSwimmerToFile();
    }

    // Converts String birthdate to LocalDateTime
    LocalDate convertBirthdateToLocalDate(String[] parts) {
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return LocalDate.of(year, month, day);
    }

    // Calculates age group
    public String calculateAgeGroup(int age) {
        String ageGroup;
        if (age < 18) {
            ageGroup = "JUNIOR";
        } else if (age < 60) {
            ageGroup = "SENIOR";
        } else {
            ageGroup = "ELDERLY";
        }
        return ageGroup;
    }
}
