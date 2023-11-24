package filehandling;

import menu.ShowMenu;
import swimmer.CompetitiveSwimmer;
import swimmer.Discipline;
import swimmer.PromptSwimmer;
import ui.ConsoleColors;
import ui.SystemMessages;
import ui.UI;
import swimmer.Swimmer;

public class ModifySwimmer {
    private FileHandling fileHandling;
    private PromptSwimmer promptSwimmer;
    private Swimmer swimmmer;
    private CompetitiveSwimmer competitiveSwimmer;
    private String name;
    private String birthdate;
    private String email;
    private int phone;
    private String newName;
    private String newBirthdate;
    private int newPhone;
    private String newEmail;


    public ModifySwimmer() {
        swimmmer = new Swimmer("", "", 0, "");
        fileHandling = new FileHandling();
        promptSwimmer = new PromptSwimmer();
        competitiveSwimmer = new CompetitiveSwimmer("", "", 0,"", null, "");
    }

    public void addSwimmer(){
        UI.promptString(); //scanner bug
        String name = promptSwimmer.promptSwimmerName();
        String birthdate = promptSwimmer.promptBirthdate();
        int phone = promptSwimmer.promptSwimmerPhoneNumber();
        UI.promptString();
        String email = promptSwimmer.promptSwimmerEmail();

        swimmmer.getSwimmers().add(new Swimmer(name, birthdate, phone, email ));
        fileHandling.saveSwimmerToFile();
           }

    public void addCompetitiveSwimmer() {
        UI.promptString(); //scanner bug
            String discipline = UI.promptString();
            switch (discipline) {
                case "1" -> competitiveSwimmer.setDiscipline(Discipline.BACK);
                case "2" -> competitiveSwimmer.setDiscipline(Discipline.BREAST);
                case "3" -> competitiveSwimmer.setDiscipline(Discipline.CRAWL);
                case "4" -> competitiveSwimmer.setDiscipline(Discipline.BUTTERFLY);
                case "5" -> competitiveSwimmer.setDiscipline(Discipline.MEDLEY);

            }
    }

public void editSwimmer() {
initCurrentSwimmerPrompts();
Swimmer swimmerToEdit = null;
for (Swimmer swimmer : swimmmer.getSwimmers()){
if (swimmer.getName().equals(name)
        && (swimmer.getEmail().equals(email)
        && (swimmer.getPhone() == phone
        && swimmer.getBirthdate().equals(birthdate)))) {
        swimmerToEdit = swimmer;

        UI.print(ConsoleColors.YELLOW_BOLD + "\nENTER NEW INFO");

        initNewSwimmerPrompts();

        SystemMessages.printGreenColoredText("Successfully edited Swimmer\n");

        setValueOfSwimmersToEdit(swimmerToEdit);

        fileHandling.saveSwimmerToFile();
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
