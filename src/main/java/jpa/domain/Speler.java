package jpa.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@IdClass(SpelerPK.class)
public class Speler {

    @Id
    private String naam;

    @Id
    private int rugNummer;

    private LocalDate geboorteDatum;

    @Transient
    private int leeftijd;

    @ManyToOne(fetch = FetchType.LAZY)
    private VoetbalClub voetbalClub;

    public Speler() {
    }

    public Speler(String naam, int rugNummer, LocalDate geboorteDatum) {
        this.naam = naam;
        this.rugNummer = rugNummer;
        this.geboorteDatum = geboorteDatum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getRugNummer() {
        return rugNummer;
    }

    public void setRugNummer(int rugNummer) {
        this.rugNummer = rugNummer;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    @PostLoad
    void berekenLeeftijd() {
        this.leeftijd = Period.between(this.geboorteDatum, LocalDate.now()).getYears();
    }
}
