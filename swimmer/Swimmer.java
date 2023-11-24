
package swimmer;

import java.time.LocalDateTime;
import ui.SystemMessages;
import java.time.DateTimeException;
import java.time.temporal.ChronoUnit;

public class Swimmer {
    private String name;
    private String birthdate;
    private String phone;
    private String email;
    private int age;
    private String isJunior;

    public Swimmer(String name, String birthdate, String phone, String email) {
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        isJunior = checkIfUnderage(age);
    }

    public boolean checkIfDateIsValid(String[] parts) {
        PromptSwimmer promptSwimmer = new PromptSwimmer();
        boolean running = true;
        try {
            // --calculate age in another method
            LocalDateTime localDateTimeBirthdate = convertBirthdateToLocalDateTime(parts);
            age = calculateAge(localDateTimeBirthdate);
            running = false;
        } catch (DateTimeException e) {
            SystemMessages.printRedColoredText("Date doesn't exist");
            SystemMessages.tryAgain();
            promptSwimmer.promptBirthdate();
        }
        return running;
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


    // Getters
  //  public ArrayList<Swimmer> getSwimmers() {
    //    return swimmers;
   // }

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

    public String getIsJunior() {
        return isJunior;
    }

    public int getAge() {
        return age;
    }


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

    public String checkIfUnderage(int age) {
        if (age > 18) {
            isJunior = "SENIOR";
        } else {
            isJunior = "JUNIOR";
        }
        return isJunior;
    }
}
