package swimmer;

public class CompetitiveSwimmer extends Swimmer {
    private Discipline discipline;
    private String swimTime;

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

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setSwimTime(String swimmingTime) {
        this.swimTime = swimmingTime;
    }
}
