package jpa.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Locatie {

    private String land;

    private String stad;

    public Locatie() {
    }

    public Locatie(String land, String stad) {
        this.land = land;
        this.stad = stad;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }
}
