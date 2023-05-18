package jpa.domain;

import jakarta.persistence.*;

@Entity
public class Stadion {

    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "stadion_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    private int id;

    private String naam;

    private int capaciteit;

    public Stadion() {
    }

    public Stadion(String naam, int capaciteit) {
        this.naam = naam;
        this.capaciteit = capaciteit;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }
}
