package jpa.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@IdClass(SpelerPK.class)
@Table(name = "X_SPELER")
public class Speler {

    @Id
    @Column(name = "SPELER_NAAM")
    private String naam;

    @Id
    @Column(name = "SPELER_RUG_NUMMER")
    private int rugNummer;

    @Column(name = "SPELER_GEBOORTE_DATUM")
    private LocalDate geboorteDatum;

    @Transient
    private int leeftijd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLB_ID", referencedColumnName = "CLUB_ID")
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

    public VoetbalClub getVoetbalClub() {
        return voetbalClub;
    }

    public void setVoetbalClub(VoetbalClub voetbalClub) {
        this.voetbalClub = voetbalClub;
    }

    @PostLoad
    void berekenLeeftijd() {
        this.leeftijd = Period.between(this.geboorteDatum, LocalDate.now()).getYears();
    }
}
