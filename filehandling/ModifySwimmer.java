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
    private String birthdate;
    private String email;
    private String phone;
    private String newName;
    private String newBirthdate;
    private String newPhone;
    private String newEmail;


    public ModifySwimmer() {
        fileHandling = new FileHandling();
        promptSwimmer = new PromptSwimmer();
        competitiveSwimmer = new CompetitiveSwimmer("", "", "","", null, "");
        calculateSwimmerAge = new CalculateSwimmerAge();
    }

    public void addSwimmer() {
        UI.promptString(); //scanner bug
        String name = promptSwimmer.promptSwimmerName();
        String birthdate = promptSwimmer.promptBirthdate();
        String phone = promptSwimmer.promptSwimmerPhoneNumber();
        UI.promptString();
        String email = promptSwimmer.promptSwimmerEmail();

        fileHandling.getSwimmers().add(new Swimmer(name, birthdate, phone, email));
        calculateSwimmerAge.setCompetitiveSwimmersAge(fileHandling.getc);
        fileHandling.saveSwimmerToFile();
        SystemMessages.printGreenColoredText("Successfully added a swimmer!");
    }

    public void addCompetitiveSwimmer(){
        UI.promptString(); //scanner bug
        String name = promptSwimmer.promptSwimmerName();
        String birthdate = promptSwimmer.promptBirthdate();
        String phone = promptSwimmer.promptSwimmerPhoneNumber();
        UI.promptString();
        String email = promptSwimmer.promptSwimmerEmail();
        String discipline = promptSwimmer.addCompetitiveSwimmerDiscipline(competitiveSwimmer);;
        String swimTime = promptSwimmer.promptSwimmersTime();

        fileHandling.getCompetitiveSwimmers().add(new CompetitiveSwimmer(name, birthdate, phone, email, discipline , swimTime));
        fileHandling.saveCompetitiveSwimmerToFile();
    }


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

                    fileHandling.saveSwimmerToFile();
                    fileHandling.saveCompetitiveSwimmerToFile();
                }
            if (swimmerToEdit == null) {
                SystemMessages.printRedColoredText("No Swimmer found!\n");
            }
        }
    }

    private void initCurrentSwimmerPrompts() {
        UI.promptString(); // Scanner bug
        name = promptSwimmer.promptSwimmerName();
        birthdate = promptSwimmer.promptBirthdate();
        phone = promptSwimmer.promptSwimmerPhoneNumber();
        email = promptSwimmer.promptSwimmerEmail();

    }
    private void initNewSwimmerPrompts(){
        newName = promptSwimmer.promptSwimmerName();
        newBirthdate = promptSwimmer.promptBirthdate();
        newPhone = promptSwimmer.promptSwimmerPhoneNumber();
        newEmail = promptSwimmer.promptSwimmerEmail();
    }
    private void setValueOfSwimmersToEdit(Swimmer swimmersToEdit){
            swimmersToEdit.setName(newName);
            swimmersToEdit.setBirthdate(newBirthdate);
            swimmersToEdit.setPhone(newPhone);
            swimmersToEdit.setEmail(newEmail);
    }
}
