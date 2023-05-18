package jpa.rest.views;

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

    public VoetbalClubView(int id, String naam, String land, String stad) {
        this.id = id;
        this.naam = naam;
        this.land = land;
        this.stad = stad;
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

    public void setStadionView(StadionView stadionView) {
        this.stadionView = stadionView;
    }

    public List<SpelerView> getSpelersView() {
        return spelersView;
    }

    public List<CompetitieView> getCompetitiesView() {
        return competitiesView;
    }
}
