package filehandling;

import accountant.CalculateSwimmerSubscription;
import promptuser.PromptUser;
import swimmer.*;
import ui.ConsoleColors;
import ui.SystemMessages;
import ui.UI;
import java.util.ArrayList;

public class ModifySwimmer {
    private final FileHandling fileHandling;
    private final PromptUser promptUser;
    private final CalculateSwimmerSubscription calculateSwimmerSubscription;
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
    public ModifySwimmer(FileHandling fileHandling) {
        this.fileHandling = fileHandling;
        promptUser = new PromptUser();
        calculateSwimmerSubscription = new CalculateSwimmerSubscription(fileHandling);
    }

    // Add swimmer
    public void addSwimmer() {
        UI.promptString(); // Scanner bug
        String name = promptUser.promptSwimmerName();
        String birthdate = promptUser.promptBirthdate();
        String phone = promptUser.promptSwimmerPhoneNumber();
        String email = promptUser.promptSwimmerEmail();

        fileHandling.getSwimmers().add(new Swimmer(name, birthdate, phone, email, "ACTIVE", "false"));
        fileHandling.saveSwimmerToFile();
        SystemMessages.printGreenColoredText("Successfully added a swimmer!");
    }

    // Add competitive swimmer
    public void addCompetitiveSwimmer() {
        boolean hasFoundCompetitiveSwimmer = false;
        UI.println("Who would you like to add as a competitive swimmer?");
        initCurrentSwimmerPrompts();

        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            if (swimmer.getName().equals(name) && (swimmer.getPhone().equals(phone))) {
                String discipline = promptUser.addCompetitiveSwimmerDiscipline();
                String swimTime = promptUser.promptSwimmersTime();
                String position = promptUser.promptSwimmersPosition();
                String event = promptUser.promptSwimmersEvent();

                fileHandling.getCompetitiveSwimmers().add(new CompetitiveSwimmer(name, swimmer.getBirthdate(), phone, swimmer.getEmail(), swimmer.getActivityType(), swimmer.getHasPaid(), discipline, swimTime, event, position));
                calculateSwimmerSubscription.setAllSwimmersSubscriptionFee("competitive");
                fileHandling.saveCompetitiveSwimmerToFile();
                deleteSwimmer(name, phone);

                SystemMessages.printGreenColoredText("Successfully made " + ConsoleColors.BLUE + name + ConsoleColors.GREEN_BRIGHT + " a competitive swimmer!");
                hasFoundCompetitiveSwimmer = true;
            }
        }
        if (!hasFoundCompetitiveSwimmer) {
            SystemMessages.printRedColoredText("No swimmer matching criteria");
        }
    }

    // Deletes a swimmer
    public void deleteSwimmer(String name, String phone) {
        ArrayList<Swimmer> updatedSwimmers = new ArrayList<>();

        for (Swimmer swimmer : fileHandling.getSwimmers()) {
            if (!(swimmer.getName().equals(name)) || !swimmer.getPhone().equals(phone)) {
                updatedSwimmers.add(swimmer);
            }
        }

        if (updatedSwimmers.size() < fileHandling.getSwimmers().size()) {
            fileHandling.setSwimmers(updatedSwimmers);
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
        fileHandling.saveCompetitionResultsToFile();

        SystemMessages.printGreenColoredText("Event and Position added to Competitive Swimmers!");
    }

    // Edit swimmer
    public void editSwimmer() {
        initCurrentSwimmerPrompts();
        Swimmer swimmerToEdit = null;
        for (Swimmer swimmer : fileHandling.getSwimmers()){
            if (swimmer.getName().equals(name) && (swimmer.getPhone().equals(phone))) {
                swimmerToEdit = swimmer;
                SystemMessages.printNewInfo();

                initNewSwimmerPrompts();

                setValueOfSwimmersToEdit(swimmerToEdit);
                swimmer.calculateAgeAndAgeGroup();
                calculateSwimmerSubscription.setAllSwimmersSubscriptionFee("regular");
                fileHandling.saveSwimmerToFile();

                SystemMessages.printGreenColoredText("Successfully edited Swimmer\n");
            }
        }
        if (swimmerToEdit == null) {
            SystemMessages.printRedColoredText("No Swimmer found!\n");
        }
    }

    // Initialize current swimmer prompts
    private void initCurrentSwimmerPrompts() {
        UI.promptString(); // Scanner bug
        name = promptUser.promptSwimmerName();
        phone = promptUser.promptSwimmerPhoneNumber();
    }

    // Initialize new swimmer prompts
    private void initNewSwimmerPrompts(){
        newName = promptUser.promptSwimmerName();
        newBirthdate = promptUser.promptBirthdate();
        newPhone = promptUser.promptSwimmerPhoneNumber();
        newEmail = promptUser.promptSwimmerEmail();
    }

    // Set value of swimmers to edit
    private void setValueOfSwimmersToEdit(Swimmer swimmersToEdit){
            swimmersToEdit.setName(newName);
            swimmersToEdit.setBirthdate(newBirthdate);
            swimmersToEdit.setPhone(newPhone);
            swimmersToEdit.setEmail(newEmail);

    }

    // Edit competitive swimmer
    public void editCompetitiveSwimmer() {
        initCurrentSwimmerPrompts();

        CompetitiveSwimmer competitiveSwimmerToEdit = null;
        for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
            if (competitiveSwimmer.getName().equals(name) && (competitiveSwimmer.getPhone().equals(phone))) {
                competitiveSwimmerToEdit = competitiveSwimmer;
                SystemMessages.printNewInfo();

                initNewCompetitiveSwimmerPrompts();

                setValueOfCompetitiveSwimmersToEdit(competitiveSwimmerToEdit);
                competitiveSwimmer.calculateAgeAndAgeGroup();

                fileHandling.saveCompetitiveSwimmerToFile();
                SystemMessages.printGreenColoredText("Successfully edited competitive swimmer");
            }
        }
        if (competitiveSwimmerToEdit == null) {
            SystemMessages.printRedColoredText("No competitive swimmer found!");
        }
    }

    // Initialize new swimmer prompts
    private void initNewCompetitiveSwimmerPrompts(){
        newName = promptUser.promptSwimmerName();
        newBirthdate = promptUser.promptBirthdate();
        newPhone = promptUser.promptSwimmerPhoneNumber();
        newEmail = promptUser.promptSwimmerEmail();
        newDiscipline = Discipline.valueOf(promptUser.addCompetitiveSwimmerDiscipline());
        newSwimTime = promptUser.promptSwimmersTime();
        newPosition = promptUser.promptSwimmersPosition();
        newEvent = promptUser.promptSwimmersEvent();

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

    // Edit payment
    public void editPayment(FileHandling fileHandling) {
        initCurrentSwimmerPrompts();
        boolean foundSwimmer = false;
         for (Swimmer swimmer : fileHandling.getSwimmers()) {
                if (name.equals(swimmer.getName()) && phone.equals(swimmer.getPhone())) {
                    UI.print("Enter payment status (true/false): ");
                    String paymentStatus = validatePaymentStatus();
                    swimmer.setHasPaid(paymentStatus);
                    foundSwimmer = true;
                    SystemMessages.printGreenColoredText("Successfully edited the payment");
                }
            }

         if (!foundSwimmer) {
             for (CompetitiveSwimmer competitiveSwimmer : fileHandling.getCompetitiveSwimmers()) {
                 if (name.equals(competitiveSwimmer.getName()) && phone.equals(competitiveSwimmer.getPhone())) {
                     UI.print("Enter payment status (true/false): ");
                     String paymentStatus = validatePaymentStatus();
                     competitiveSwimmer.setHasPaid(paymentStatus);
                     foundSwimmer = true;
                     SystemMessages.printGreenColoredText("Successfully edited the payment");
                 }
            }
        }

         if (!foundSwimmer) {
             SystemMessages.printRedColoredText("No swimmer matching criteria");
         }
        calculateSwimmerSubscription.setAllSwimmersSubscriptionFee("both");
        fileHandling.saveSwimmerToFile();
        fileHandling.saveCompetitiveSwimmerToFile();
    }

    // Validate payment status
    private String validatePaymentStatus() {
        String paymentStatus = UI.promptString();
        while (!paymentStatus.equalsIgnoreCase("true") && !paymentStatus.equalsIgnoreCase("false")){
            SystemMessages.printRedColoredText("Invalid input");
            SystemMessages.printRedColoredText("Please enter 'true' or 'false'");
            paymentStatus =UI.promptString();
        }
        return paymentStatus;
    }
}
