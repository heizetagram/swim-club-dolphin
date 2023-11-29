package swimmer;

import filehandling.FileHandling;

import java.time.LocalDate;
import java.time.Period;

public class CalculateSwimmerAge {
    // Jeg gider ik at kalde på fileHandling der ligger i main, men det virker : - (
    // Jeg forstår ikke hvorfor at man skal kalde på fileHandling i main
    public void setSwimmersAge(FileHandling fileHandling) {
        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            String[] parts = swimmer.getBirthdate().split("-");
            LocalDate localDateBirthdate = swimmer.convertBirthdateToLocalDate(parts);
            int age = calculateAge(localDateBirthdate);
            swimmer.setAge(age);
            swimmer.calculateAgeGroup(age);
        }
        fileHandling.saveSwimmerToFile();
    }

    // Calculates age
    // Subtracts user-given birthdate from the current date
    int calculateAge(LocalDate birthdate) {
        Period yearDifference = Period.between(birthdate, LocalDate.now());
        return yearDifference.getYears();
    }
}
