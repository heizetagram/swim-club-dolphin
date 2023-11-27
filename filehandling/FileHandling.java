package filehandling;

import swimmer.CompetitiveSwimmer;
import swimmer.Swimmer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
    private String[] parts;
    private ArrayList<Swimmer> swimmers;
    private ArrayList<CompetitiveSwimmer> competitiveSwimmers;

    public FileHandling() {

        this.swimmers = new ArrayList<>();
        this.competitiveSwimmers = new ArrayList<>();
        loadSwimmerFromFile();
        loadCompetitiveSwimmerFromFile();
    }

    // Read appointments logic
    public void loadSwimmerFromFile() {
        Swimmer swimmer = new Swimmer("", "", "", "");
        File file = new File("swimmers.txt"); {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    parts = line.split(", ");
                    if (parts.length == 4) {
                        swimmers.add(new Swimmer(parts[0], parts[1], parts[2], parts[3]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Save swimmer logic
    public void saveSwimmerToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("swimmers.txt"))) {
            ArrayList<Swimmer> allSwimmers = new ArrayList<>(getSwimmers());
            for (Swimmer swimmer : swimmers) {
                writer.write(swimmer.getName()
                        + ", " + swimmer.getBirthdate()
                        + ", " + swimmer.getPhone()
                        + ", " + swimmer.getEmail());
                writer.newLine();
            }
            this.swimmers = allSwimmers;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCompetitiveSwimmerFromFile() {
        CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer("", "", "", "", null, "");
        File file = new File("competitiveswimmers.txt"); {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    parts = line.split(", ");
                    if (parts.length == 6) {
                        competitiveSwimmers.add(new CompetitiveSwimmer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveCompetitiveSwimmerToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("competitiveswimmers.txt"))) {
            ArrayList<CompetitiveSwimmer> allCompetitiveSwimmers = new ArrayList<>(getCompetitiveSwimmers());
            for (CompetitiveSwimmer competitiveSwimmer : competitiveSwimmers) {
                writer.write(competitiveSwimmer.getName()
                        + ", " + competitiveSwimmer.getBirthdate()
                        + ", " + competitiveSwimmer.getPhone()
                        + ", " + competitiveSwimmer.getEmail()
                        + ", " + competitiveSwimmer.getDiscipline()
                        + ", " + competitiveSwimmer.getSwimTime());
                writer.newLine();
            }
            this.competitiveSwimmers = allCompetitiveSwimmers;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }
    public ArrayList<CompetitiveSwimmer> getCompetitiveSwimmers() {
        return competitiveSwimmers;
    }
}
