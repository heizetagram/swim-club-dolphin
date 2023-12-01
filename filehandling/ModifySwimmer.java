package filehandling;

import swimmer.CalculateSwimmerAge;
import swimmer.CompetitiveSwimmer;
import swimmer.PromptSwimmer;
import ui.ConsoleColors;
import ui.SystemMessages;
import ui.UI;
import swimmer.Swimmer;

public class ModifySwimmer {
    private FileHandling fileHandling;
    private PromptSwimmer promptSwimmer;
    private CompetitiveSwimmer competitiveSwimmer;
    private CalculateSwimmerAge calculateSwimmerAge;
    private String name;
    private String phone;
    private String newName;
    private String event;
    private int position;
    private String newBirthdate;
    private String newPhone;
    private String newEmail;

    // Constructor
    public ModifySwimmer() {
        fileHandling = new FileHandling();
        promptSwimmer = new PromptSwimmer();
        competitiveSwimmer = new CompetitiveSwimmer("", "", "","", null, "", "", "");
        calculateSwimmerAge = new CalculateSwimmerAge();
    }

    // Add swimmer
    public void addSwimmer() {
        UI.promptString(); // Scanner bug
        String name = promptSwimmer.promptSwimmerName();
        String birthdate = promptSwimmer.promptBirthdate();
        String phone = promptSwimmer.promptSwimmerPhoneNumber();
        String email = promptSwimmer.promptSwimmerEmail();

        fileHandling.getSwimmers().add(new Swimmer(name, birthdate, phone, email));
        calculateSwimmerAge.setSwimmersAge(fileHandling);
        fileHandling.saveSwimmerToFile();
        SystemMessages.printGreenColoredText("Successfully added a swimmer!");
    }

    // Add competitive swimmer
    public void addCompetitiveSwimmer(){
        UI.promptString(); // Scanner bug
        String name = promptSwimmer.promptSwimmerName();
        String birthdate = promptSwimmer.promptBirthdate();
        String phone = promptSwimmer.promptSwimmerPhoneNumber();
        String email = promptSwimmer.promptSwimmerEmail();
        String discipline = promptSwimmer.addCompetitiveSwimmerDiscipline(competitiveSwimmer);;
        String swimTime = promptSwimmer.promptSwimmersTime();
        String position = promptSwimmer.promptSwimmersPosition();
        String event = promptSwimmer.promptSwimmersEvent();

        fileHandling.getCompetitiveSwimmers().add(new CompetitiveSwimmer(name, birthdate, phone, email, discipline , swimTime, event, position));
        calculateSwimmerAge.setCompetitiveSwimmersAge(fileHandling);
        fileHandling.saveCompetitiveSwimmerToFile();
        SystemMessages.printGreenColoredText("Successfully added a swimmer!");
    }

    // Add event and position for competitive swimmer
    public void addEventAndPosition(){
        UI.promptString(); // Scanner bug
        UI.print("Enter event: ");
        String event = UI.promptString();
        UI.print("Enter position: ");
        String position = UI.promptString();

        fileHandling.addEventAndPositionToCompetitiveSwimmers(event, position);
        calculateSwimmerAge.setCompetitiveSwimmersAge(fileHandling);
        fileHandling.saveCompetitionResultsToFile();

        SystemMessages.printGreenColoredText("Event and Position added to Competitive Swimmers!");
    }

    // Edit swimmer
    public void editSwimmer() {
        initCurrentSwimmerPrompts();
        Swimmer swimmerToEdit = null;
        for (Swimmer swimmer : fileHandling.getSwimmers()){
            if (swimmer.getName().equals(name)
                && (swimmer.getEmail().equals(email)
                && (swimmer.getPhone().equals(phone)
                && swimmer.getBirthdate().equals(birthdate)))) {
                    swimmerToEdit = swimmer;

                    UI.print(ConsoleColors.YELLOW_BOLD + "\nENTER NEW INFO");

                    initNewSwimmerPrompts();

                    SystemMessages.printGreenColoredText("Successfully edited Swimmer\n");

                    setValueOfSwimmersToEdit(swimmerToEdit);
                    calculateSwimmerAge.setSwimmersAge(fileHandling);

                    fileHandling.saveSwimmerToFile();
                    fileHandling.saveCompetitiveSwimmerToFile();
                }
            if (swimmerToEdit == null) {
                SystemMessages.printRedColoredText("No Swimmer found!\n");
            }
        }
    }

    // Initialize current swimmer prompts
    private void initCurrentSwimmerPrompts() {
        UI.promptString(); // Scanner bug
        name = promptSwimmer.promptSwimmerName();
        birthdate = promptSwimmer.promptBirthdate();
        phone = promptSwimmer.promptSwimmerPhoneNumber();
    }

    // Initialize new swimmer prompts
    private void initNewSwimmerPrompts(){
        newName = promptSwimmer.promptSwimmerName();
        newBirthdate = promptSwimmer.promptBirthdate();
        newPhone = promptSwimmer.promptSwimmerPhoneNumber();
        newEmail = promptSwimmer.promptSwimmerEmail();
    }

    // Set value of swimmers to edit
    private void setValueOfSwimmersToEdit(Swimmer swimmersToEdit){
            swimmersToEdit.setName(newName);
            swimmersToEdit.setBirthdate(newBirthdate);
            swimmersToEdit.setPhone(newPhone);
            swimmersToEdit.setEmail(newEmail);
    }
}
