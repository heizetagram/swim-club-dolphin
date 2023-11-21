import filehandling.FileHandling;

public class Master {
    private FileHandling fileHandling;

    private void initVars() {
        fileHandling = new FileHandling();
    }

    public static void main(String[] args) {
        new Master().run();
    }

    private void run() {
        initVars();

        fileHandling.saveAppointmentsToFile();
        fileHandling.loadAppointmentsFromFile();
    }
}
