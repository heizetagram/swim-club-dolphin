package swimmer;

import trainer.Trainer;

public class CompetitiveSwimmer extends Swimmer {
    private String discipline;
    private String swimTime;
    private Trainer trainer;
    private String event;
    private String position;


    public CompetitiveSwimmer(String name, String birthday, String phone, String email, String discipline, String swimTime, String event, String position) {
        super(name, birthday, phone, email);
        this.discipline = discipline;
        this.swimTime = swimTime;
        this.position = position;
        this.event = event;
    }

    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }

   public String getEvent(){
        return event;
   }
   public void setEvent(String event){
        this.event = event;
   }

    public String getDiscipline() {
        return discipline;
    }

    public String getSwimTime() {
        return swimTime;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = String.valueOf(discipline);
    }

    public void setSwimTime(String swimmingTime) {
        this.swimTime = swimmingTime;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
