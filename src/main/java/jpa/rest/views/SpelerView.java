package jpa.rest.views;

import java.time.LocalDate;

public class SpelerView {

    private final String naam;
    private final int rugNummer;
    private final LocalDate geboorteDatum;
    private final int leeftijd;

    public SpelerView(String naam, int rugNummer, LocalDate geboorteDatum, int leeftijd) {
        this.naam = naam;
        this.rugNummer = rugNummer;
        this.geboorteDatum = geboorteDatum;
        this.leeftijd = leeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public int getRugNummer() {
        return rugNummer;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public int getLeeftijd() {
        return leeftijd;
    }
}
