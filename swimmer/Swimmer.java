
package swimmer;

import java.time.LocalDate;

import ui.SystemMessages;
import java.time.DateTimeException;

public class Swimmer {
    private String name;
    private String birthdate;
    private String phone;
    private String email;
    private int age;
    private String ageGroup;

    public Swimmer(String name, String birthdate, String phone, String email) {
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        //setAgeFromBirthDate();
        ageGroup = calculateAgeGroup(age);
    }

    // Checks if user-given date is valid
    boolean checkIfDateIsValid(String[] parts) {
        PromptSwimmer promptSwimmer = new PromptSwimmer();
        boolean running = true;
        try {
            convertBirthdateToLocalDate(parts);
            running = false;
        } catch (DateTimeException e) {
            SystemMessages.printRedColoredText("Date doesn't exist");
            SystemMessages.tryAgain();
            promptSwimmer.promptBirthdate();
        }
        return running;
    }

    // Converts String birthdate to LocalDateTime
    LocalDate convertBirthdateToLocalDate(String[] parts) {
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return LocalDate.of(year, month, day);
    }

    // Calculates age group based on age
    public String calculateAgeGroup(int age) {
        if (age < 18) {
            ageGroup = "JUNIOR";
        } else if (age > 18 && age < 60) {
            ageGroup = "SENIOR";
        } else {
            ageGroup = "ELDERLY";
        }
        return ageGroup;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getAgeGroup() {
        return ageGroup;
    }
    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }
}