package jpa.rest.commands;

import jpa.domain.Locatie;
import jpa.domain.VoetbalClub;

public class VoetbalClubCommand {

    private String naam;
    private String land;
    private String stad;

    public String getNaam() {
        return naam;
    }

    public String getLand() {
        return land;
    }

    public String getStad() {
        return stad;
    }

    public VoetbalClub mapToVoetbalClub() {
        VoetbalClub voetbalClub = new VoetbalClub();

        voetbalClub.setNaam(naam);
        voetbalClub.setLocatie(new Locatie(land, stad));

        return voetbalClub;
    }
}
