package swimmer;

import java.util.ArrayList;

public class Team {
    private ArrayList<Swimmer> juniorTeam;
    private ArrayList<Swimmer> seniorTeam;

    public ArrayList<Swimmer> getJuniorTeam() {
        return juniorTeam;
    }

    public ArrayList<Swimmer> getSeniorTeam() {
        return seniorTeam;
    }

    /* Tilføj til korrekt klasse
    private void testtest(int age, Swimmer swimmer) {
        if (age > 18) {
            getSeniorTeam().add(swimmer);
        } else
            getJuniorTeam().add(swimmer);
    }
     */
}
