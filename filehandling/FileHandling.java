package filehandling;

import accountant.CalculateSwimmerSubscription;
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
        swimmers = new ArrayList<>();
        competitiveSwimmers = new ArrayList<>();
        loadSwimmerFromFile();
        loadCompetitiveSwimmerFromFile();
        CalculateSwimmerSubscription calculateSwimmerSubscription = new CalculateSwimmerSubscription(this);
        calculateSwimmerSubscription.setAllSwimmersSubscriptionFee("both");
        calculateSwimmerSubscription.resetSubscriptionAnnually();
    }

    // Load swimmers logic
    public void loadSwimmerFromFile() {
        File file = new File("swimmers.txt"); {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    parts = line.split(", ");
                    if (parts.length == 9) {
                        swimmers.add(new Swimmer(parts[0], parts[1], parts[3], parts[4], parts[6], parts[7]));
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
            for (Swimmer swimmer : swimmers) {
                writer.write(swimmer.getName()
                        + ", " + swimmer.getBirthdate()
                        + ", " + swimmer.getAge()
                        + ", " + swimmer.getPhone()
                        + ", " + swimmer.getEmail()
                        + ", " + swimmer.getAgeGroup()
                        + ", " + swimmer.getActivityType()
                        + ", " + swimmer.getHasPaid()
                        + ", " + swimmer.getSubscriptionFee());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load competitive swimmers
    public void loadCompetitiveSwimmerFromFile() {
        File file = new File("competitiveswimmers.txt"); {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    parts = line.split(", ");
                    if (parts.length == 13) {
                        competitiveSwimmers.add(new CompetitiveSwimmer(parts[0], parts[1], parts[3], parts[4], parts[6], parts[7], parts[9], parts[10], parts[11], parts[12]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Save competitive swimmers
    public void saveCompetitiveSwimmerToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("competitiveswimmers.txt"))) {
            ArrayList<CompetitiveSwimmer> allCompetitiveSwimmers = new ArrayList<>(getCompetitiveSwimmers());
            for (CompetitiveSwimmer competitiveSwimmer : competitiveSwimmers) {
                writer.write(competitiveSwimmer.getName()
                        + ", " + competitiveSwimmer.getBirthdate()
                        + ", " + competitiveSwimmer.getAge()
                        + ", " + competitiveSwimmer.getPhone()
                        + ", " + competitiveSwimmer.getEmail()
                        + ", " + competitiveSwimmer.getAgeGroup()
                        + ", " + competitiveSwimmer.getActivityType()
                        + ", " + competitiveSwimmer.getHasPaid()
                        + ", " + competitiveSwimmer.getSubscriptionFee()
                        + ", " + competitiveSwimmer.getDiscipline()
                        + ", " + competitiveSwimmer.getSwimTime()
                        + ", " + competitiveSwimmer.getEvent()
                        + ", " + competitiveSwimmer.getPosition());
                writer.newLine();
            }
            this.competitiveSwimmers = allCompetitiveSwimmers;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adds event to competitive swimmers
    public void addEventAndPositionToCompetitiveSwimmers (String event, String position){
        for (CompetitiveSwimmer competitiveSwimmer : competitiveSwimmers) {
            competitiveSwimmer.setEvent(event);
            competitiveSwimmer.setPosition(position);

        }
        saveCompetitiveSwimmerToFile(); // Save the changes to the main competitive swimmers file
        saveCompetitionResultsToFile(); // save the changes to the competition results' file
    }

    // Saves competition results to file
    public void saveCompetitionResultsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("competitionresults.txt"))) {
            for (CompetitiveSwimmer competitiveSwimmer : competitiveSwimmers) {
                writer.write(competitiveSwimmer.getName()
                        + ", " + competitiveSwimmer.getEvent()
                        + ", " + competitiveSwimmer.getPosition()
                        + ", " + competitiveSwimmer.getSwimTime());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }
    public ArrayList<CompetitiveSwimmer> getCompetitiveSwimmers() {
        return competitiveSwimmers;
    }

    // Setters
    public void setSwimmers(ArrayList<Swimmer> swimmers) {
        this.swimmers = swimmers;
    }
}