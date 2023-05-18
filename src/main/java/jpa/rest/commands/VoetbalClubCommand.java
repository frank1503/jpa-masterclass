package jpa.rest.commands;

import jpa.domain.Locatie;
import jpa.domain.Speler;
import jpa.domain.Stadion;
import jpa.domain.VoetbalClub;

import java.util.List;

public class VoetbalClubCommand {

    private String naam;
    private String land;
    private String stad;
    private List<String> sponsoren;
    private Stadion stadion;
    private List<Speler> spelers;

    public String getNaam() {
        return naam;
    }

    public String getLand() {
        return land;
    }

    public String getStad() {
        return stad;
    }

    public List<String> getSponsoren() {
        return sponsoren;
    }

    public Stadion getStadion() {
        return stadion;
    }

    public List<Speler> getSpelers() {
        return spelers;
    }

    public VoetbalClub mapToVoetbalClub() {
        VoetbalClub voetbalClub = new VoetbalClub();

        voetbalClub.setNaam(naam);
        voetbalClub.setLocatie(new Locatie(land, stad));

        if (sponsoren != null) {
            voetbalClub.getSponsoren().addAll(sponsoren);
        }

        if (stadion != null) {
            voetbalClub.setStadion(stadion);
        }

        if (spelers != null) {
            spelers.forEach(voetbalClub::addSpeler);
        }

        return voetbalClub;
    }
}
