package jpa.rest.views;

import jpa.domain.Competitie;
import jpa.domain.Speler;
import jpa.domain.Stadion;
import jpa.domain.VoetbalClub;

import java.util.ArrayList;
import java.util.List;

public class VoetbalClubView {

    private final int id;
    private final String naam;
    private final String land;
    private final String stad;
    private final List<String> sponsoren = new ArrayList<>();
    private StadionView stadionView;
    private final List<SpelerView> spelersView = new ArrayList<>();
    private final List<CompetitieView> competitiesView = new ArrayList<>();

    public VoetbalClubView(VoetbalClub voetbalClub) {
        this.id = voetbalClub.getId();
        this.naam = voetbalClub.getNaam();
        this.land = voetbalClub.getLocatie().getLand();
        this.stad = voetbalClub.getLocatie().getStad();

        this.sponsoren.addAll(voetbalClub.getSponsoren());

        if (voetbalClub.getStadion() != null) {
            this.stadionView = mapToStadionView(voetbalClub.getStadion());
        }

        this.spelersView.addAll(mapToSpelersView(voetbalClub.getSpelers()));

        this.competitiesView.addAll(mapToCompetitiesView(voetbalClub.getCompetities()));
    }

    public int getId() {
        return id;
    }

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

    public StadionView getStadionView() {
        return stadionView;
    }

    public List<SpelerView> getSpelersView() {
        return spelersView;
    }

    public List<CompetitieView> getCompetitiesView() {
        return competitiesView;
    }

    private StadionView mapToStadionView(Stadion stadion) {
        return new StadionView(
                stadion.getId(),
                stadion.getNaam(),
                stadion.getCapaciteit()
        );
    }

    private List<SpelerView> mapToSpelersView(List<Speler> spelers) {
        List<SpelerView> spelersView = new ArrayList<>();

        spelers.forEach(s -> spelersView.add(mapToSpelerView(s)));

        return spelersView;
    }

    private SpelerView mapToSpelerView(Speler speler) {
        return new SpelerView(
                speler.getNaam(),
                speler.getRugNummer(),
                speler.getGeboorteDatum(),
                speler.getLeeftijd()
        );
    }

    private List<CompetitieView> mapToCompetitiesView(List<Competitie> competities) {
        List<CompetitieView> competitiesView = new ArrayList<>();

        competities.forEach(c -> competitiesView.add(mapToCompetitieView(c)));

        return competitiesView;
    }

    private CompetitieView mapToCompetitieView(Competitie competitie) {
        return new CompetitieView(
                competitie.getId(),
                competitie.getNaam()
        );
    }
}
