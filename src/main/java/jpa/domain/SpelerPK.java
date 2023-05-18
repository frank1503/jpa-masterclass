package jpa.domain;

import java.io.Serializable;
import java.util.Objects;

public class SpelerPK implements Serializable {

    private String naam;

    private int rugNummer;

    public SpelerPK() {
    }

    public SpelerPK(String naam, int rugNummer) {
        this.naam = naam;
        this.rugNummer = rugNummer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpelerPK spelerPK = (SpelerPK) o;
        return rugNummer == spelerPK.rugNummer && Objects.equals(naam, spelerPK.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, rugNummer);
    }
}
