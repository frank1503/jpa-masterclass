package jpa.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "X_STADION")
public class Stadion {

    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "stadion_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    @Column(name = "STADION_ID")
    private int id;

    @Column(name = "STADION_NAAM")
    private String naam;

    @Column(name = "STADION_CAPACITEIT")
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
