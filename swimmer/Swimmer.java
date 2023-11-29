
package swimmer;

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
    public int getAge() {
        return age;
    }
    public String getAgeGroup() {
        return ageGroup;
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
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}