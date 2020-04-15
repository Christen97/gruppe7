package grp7.semproject.Domain.DTO;

public class Production {
    int id;
    String title;
    String releaseDate;
    String programType;
    String producer;

    public Production(int id, String title, String releaseDate, String programType, String producer) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.programType = programType;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return  "{title=" + title +
                ", releaseDate=" + releaseDate +
                ", programType=" + programType +
                ", producer=" + producer +
                ", id=" + id +
                '}';
    }

}
