
package swimmer;

public class Swimmer {
    private String name;
    private String birthdate;
    private String phone;
    private String email;
    private int age;
    private String ageGroup;
    private boolean activityType;
    private boolean hasPaid;
    private int subscriptionFee;

    public Swimmer(String name, String birthdate, String phone, String email) {
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        activityType = true;
        hasPaid = false;
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
    public boolean getActivityType() {
        return activityType;
    }
    public String getActivityTypeAsString() {
        String activityType;
        if (this.activityType) {
            activityType = "ACTIVE";
        } else {
            activityType = "PASSIVE";
        }
        return activityType;
    }
    public boolean getHasPaid() {
        return hasPaid;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSubscriptionFee(int subscriptionFee)
    {
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
    public void setActivityType(boolean activityType) {
        this.activityType = activityType;
    }
    public void setActivityTypeStringToBoolean(String activityTypeAsString) {
        switch (activityTypeAsString) {
            case "ACTIVE" -> activityType = true;
            case "PASSIVE" -> activityType = false;
        }
    }
    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}