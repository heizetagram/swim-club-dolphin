package filehandling;

import swimmer.*;
import ui.ConsoleColors;
import ui.SystemMessages;
import ui.UI;

import java.util.ArrayList;

public class ModifySwimmer {
    private FileHandling fileHandling;
    private PromptSwimmer promptSwimmer;
    private CompetitiveSwimmer competitiveSwimmer;
    private CalculateSwimmerAge calculateSwimmerAge;
    private String name;
    private String phone;
    private String newName;
    private String newBirthdate;
    private String newPhone;
    private String newEmail;
    private Discipline newDiscipline;
    private String newSwimTime;
    private String newEvent;
    private String newPosition;

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
        UI.println("Who would you like to add as a competitive swimmer?");
        initCurrentSwimmerPrompts();

        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            if (swimmer.getName().equals(name)
                && (swimmer.getPhone().equals(phone))) {
                String discipline = promptSwimmer.addCompetitiveSwimmerDiscipline(competitiveSwimmer);;
                String swimTime = promptSwimmer.promptSwimmersTime();
                String position = promptSwimmer.promptSwimmersPosition();
                String event = promptSwimmer.promptSwimmersEvent();
                fileHandling.getCompetitiveSwimmers().add(new CompetitiveSwimmer(name, swimmer.getBirthdate(), phone, swimmer.getEmail(), discipline, swimTime, event, position));
                calculateSwimmerAge.setCompetitiveSwimmersAge(fileHandling);

                for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
                    if (competitiveSwimmer.getName().equals(name)
                    && (competitiveSwimmer.getPhone().equals(phone))) {
                        competitiveSwimmer.setActivityType(swimmer.getActivityType());
                        competitiveSwimmer.setHasPaid(swimmer.getHasPaid());
                        fileHandling.saveCompetitiveSwimmerToFile();
                        SystemMessages.printGreenColoredText("Successfully made " + ConsoleColors.BLUE + name + ConsoleColors.GREEN_BRIGHT + " a competitive swimmer!");
                        deleteSwimmer(name, phone);
                    }
                }
            }
        }
    }

    // Deletes a swimmer
    public void deleteSwimmer(String name, String phone) {
        ArrayList<Swimmer> updatedSwimmers = new ArrayList<>();

        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            if (!(swimmer.getName().equals(name))
                    || !swimmer.getPhone().equals(phone)) {
                updatedSwimmers.add(swimmer);
            }
        }

        if (updatedSwimmers.size() < fileHandling.getSwimmers().size()) {
            fileHandling.setSwimmers(updatedSwimmers);
            calculateSwimmerAge.setSwimmersAge(fileHandling);
            fileHandling.saveSwimmerToFile();
            //SystemMessages.printGreenColoredText("Successfully deleted swimmer");
        } else {
            SystemMessages.printRedColoredText("No swimmer matching criteria");
        }
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
                && (swimmer.getPhone().equals(phone))) {
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
    public void editCompetitiveSwimmer() {
        initCurrentCompetitiveSwimmerPrompts();
        CompetitiveSwimmer competitiveSwimmerToEdit = null;
        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()){
            if (competitiveSwimmer.getName().equals(name)
                    && (competitiveSwimmer.getPhone().equals(phone))) {
                competitiveSwimmerToEdit = competitiveSwimmer;

                UI.print(ConsoleColors.YELLOW_BOLD + "\nENTER NEW INFO");

                initNewCompetitiveSwimmerPrompts();

                SystemMessages.printGreenColoredText("Successfully edited competitive swimmer\n");

                setValueOfCompetitiveSwimmersToEdit(competitiveSwimmerToEdit);
                calculateSwimmerAge.setSwimmersAge(fileHandling);

                fileHandling.saveCompetitiveSwimmerToFile();
                fileHandling.saveCompetitiveSwimmerToFile();
            }
            if (competitiveSwimmerToEdit == null) {
                SystemMessages.printRedColoredText("No competitive swimmer found!\n");
            }
        }
    }
    private void initCurrentCompetitiveSwimmerPrompts() {
        UI.promptString(); // Scanner bug
        name = promptSwimmer.promptSwimmerName();
        phone = promptSwimmer.promptSwimmerPhoneNumber();
       /* discipline = promptSwimmer.addCompetitiveSwimmerDiscipline(competitiveSwimmer);
        swimtime = promptSwimmer.promptSwimmersTime();
        position = promptSwimmer.promptSwimmersPosition();
        event = promptSwimmer.promptSwimmersEvent(); */


    }

    // Initialize new swimmer prompts
    private void initNewCompetitiveSwimmerPrompts(){
        newName = promptSwimmer.promptSwimmerName();
        newBirthdate = promptSwimmer.promptBirthdate();
        newPhone = promptSwimmer.promptSwimmerPhoneNumber();
        newEmail = promptSwimmer.promptSwimmerEmail();
        newDiscipline = Discipline.valueOf(promptSwimmer.addCompetitiveSwimmerDiscipline(competitiveSwimmer));
        newSwimTime = promptSwimmer.promptSwimmersTime();
        newPosition = promptSwimmer.promptSwimmersPosition();
        newEvent = promptSwimmer.promptSwimmersEvent();

    }

    // Set value of swimmers to edit
    private void setValueOfCompetitiveSwimmersToEdit(CompetitiveSwimmer competitiveSwimmersToEdit){
        competitiveSwimmersToEdit.setName(newName);
        competitiveSwimmersToEdit.setBirthdate(newBirthdate);
        competitiveSwimmersToEdit.setPhone(newPhone);
        competitiveSwimmersToEdit.setEmail(newEmail);
        competitiveSwimmersToEdit.setSwimTime(newSwimTime);
        competitiveSwimmersToEdit.setDiscipline(newDiscipline);
        competitiveSwimmersToEdit.setEvent(newEvent);
        competitiveSwimmersToEdit.setPosition(newPosition);
    }
}
