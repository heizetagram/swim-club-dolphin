
package swimmer;

import java.time.LocalDate;
import java.time.Period;

public class Swimmer {
    private String name;
    private String birthdate;
    private String phone;
    private String email;
    private int age;
    private String ageGroup;
    private String activityType;
    private String hasPaid;
    private int subscriptionFee;

    public Swimmer(String name, String birthdate, String phone, String email, String activityType, String hasPaid) {
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.activityType = activityType;
        this.hasPaid = hasPaid;
        calculateAgeAndAgeGroup();
    }

    // Converts String birthdate to LocalDateTime
    private LocalDate convertBirthdateToLocalDate() {
        String[] parts = birthdate.split("-");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return LocalDate.of(year, month, day);
    }

    // Calculates age
    // Subtracts user-given birthdate from the current date
    private int calculateAge(LocalDate birthdate) {
        Period yearDifference = Period.between(birthdate, LocalDate.now());
        return yearDifference.getYears();
    }

    // Calculates age group
    private String calculateAgeGroup(int age) {
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

    // Calculates age and age group
    public void calculateAgeAndAgeGroup () {
        age = calculateAge(convertBirthdateToLocalDate());
        ageGroup = calculateAgeGroup(age);
    }

    // Getters
    public int getSubscriptionFee() {
        return subscriptionFee;
    }
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
    public int getAge() {
        return age;
    }
    public String getAgeGroup() {
        return ageGroup;
    }
    public String getActivityType() {
        return activityType;
    }
    public String getHasPaid() {
        return hasPaid;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSubscriptionFee(int subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
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
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }
    public void setHasPaid(String hasPaid) {
        this.hasPaid = hasPaid;
    }
}