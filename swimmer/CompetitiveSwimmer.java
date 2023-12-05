package swimmer;

public class CompetitiveSwimmer extends Swimmer {
    private String discipline;
    private String swimTime;
    private String event;
    private String position;


    public CompetitiveSwimmer(String name, String birthday, String phone, String email, String activityType, String hasPaid, String discipline, String swimTime, String event, String position) {
        super(name, birthday, phone, email, activityType, hasPaid);
        this.discipline = discipline;
        this.swimTime = swimTime;
        this.position = position;
        this.event = event;
    }

    // Getters
    public String getPosition() {
        return position;
    }
    public String getEvent() {
        return event;
    }
    public String getDiscipline() {
        return discipline;
    }
    public String getSwimTime() {
        return swimTime;
    }

    // Setters
    public void setPosition(String position) {
        this.position = position;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public void setDiscipline(Discipline discipline) {
        this.discipline = String.valueOf(discipline);
    }
    public void setSwimTime(String swimmingTime) {
        this.swimTime = swimmingTime;
    }
}
