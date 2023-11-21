package swimmer;

import java.util.ArrayList;

public class Swimmer {
    private ArrayList<Swimmer> swimmers;
    private String name;
    private int birthYear;
    private String email;
    private String phone;

    public Swimmer(String name, int birthYear, String email, String phone) {
        swimmers = new ArrayList<>();
        this.name = name;
        this. birthYear = birthYear;
        this.email = email;
        this.phone = phone;
    }

    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
