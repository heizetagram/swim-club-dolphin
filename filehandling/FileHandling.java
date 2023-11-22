package filehandling;

import swimmer.Swimmer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    private String[] parts;
    private Swimmer swimmer;

    public FileHandling() {
        this.swimmer = new Swimmer("", 0, "", "");
    }

    // Read appointments logic
    public void loadSwimmerFromFile() {
        File file = new File("swimmers.txt"); {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    parts = line.split(", ");
                    if (parts.length == 4) {
                        swimmer.getSwimmers().add(new Swimmer(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Save appointments logic
    public void saveSwimmerToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("swimmers.txt"))) {
            for (Swimmer swimmer : swimmer.getSwimmers()) {
                writer.write(swimmer.getName() + ", " + swimmer.getBirthYear() + ", " + swimmer.getEmail() + ", " + swimmer.getPhone());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
