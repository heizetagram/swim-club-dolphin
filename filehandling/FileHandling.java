package filehandling;

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

    public FileHandling() {

        this.swimmers = new ArrayList<>();
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
            for (Swimmer swimmer : swimmers) {
                writer.write(swimmer.getName()
                        + ", " + swimmer.getBirthdate()
                        + ", " + swimmer.getPhone()
                        + ", " + swimmer.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }
}
