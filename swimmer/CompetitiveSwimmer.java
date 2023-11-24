package swimmer;

public class CompetitiveSwimmer extends Swimmer {
    private Discipline discipline;
    private String swimTime;
    private Trainer trainer;

    public CompetitiveSwimmer(String name, String birthday, int phone, String email, Discipline discipline, String swimTime) {
        super(name, birthday, phone, email);
        this.discipline = discipline;
        this.swimTime = swimTime;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public String getSwimTime() {
        return swimTime;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setSwimTime(String swimmingTime) {
        this.swimTime = swimmingTime;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
