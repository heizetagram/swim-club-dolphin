package swimmer;

import java.util.ArrayList;

public class Swimmer {
    private ArrayList<Swimmer> swimmers;
    private String name;
    private String birthdate;
    private int phone;
    private String email;
    private boolean isJunior;

    public Swimmer(String name, String birthdate, int phone, String email) {
        swimmers = new ArrayList<>();
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        //isJunior = checkIfUnderage(age);
    }

    /*
    private boolean checkIfUnderage(int age) {
    }
     */


    // Getters
    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    // Setters
    public void setSwimmers(ArrayList<Swimmer> swimmers) {
        this.swimmers = swimmers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
