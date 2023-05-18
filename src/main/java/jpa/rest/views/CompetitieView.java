package jpa.rest.views;

public class CompetitieView {

    private final int id;
    private final String naam;

    public CompetitieView(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
