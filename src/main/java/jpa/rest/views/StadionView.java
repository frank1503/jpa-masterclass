package jpa.rest.views;

public class StadionView {

    private final int id;
    private final String naam;
    private final int capaciteit;

    public StadionView(int id, String naam, int capaciteit) {
        this.id = id;
        this.naam = naam;
        this.capaciteit = capaciteit;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public int getCapaciteit() {
        return capaciteit;
    }
}
