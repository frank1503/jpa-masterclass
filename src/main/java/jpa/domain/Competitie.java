package jpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "X_VOETBAL_COMP")
public class Competitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMP_ID")
    private int id;

    @Column(name = "COMP_NAAM")
    private String naam;

    @ManyToMany(mappedBy = "competities")
    private List<VoetbalClub> voetbalClubs = new ArrayList<>();

    public Competitie() {
    }

    public Competitie(String naam) {
        this.naam = naam;
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

    public List<VoetbalClub> getVoetbalClubs() {
        return voetbalClubs;
    }

    public void setVoetbalClubs(List<VoetbalClub> voetbalClubs) {
        this.voetbalClubs = voetbalClubs;
    }
}
