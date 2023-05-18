package jpa.rest.views;

import jpa.domain.VoetbalClub;
import jpa.rest.views.mappers.CompetitieMapper;
import jpa.rest.views.mappers.SpelerMapper;
import jpa.rest.views.mappers.StadionMapper;

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
            this.stadionView = StadionMapper.mapToStadionView(voetbalClub.getStadion());
        }

        this.spelersView.addAll(SpelerMapper.mapToSpelersView(voetbalClub.getSpelers()));

        this.competitiesView.addAll(CompetitieMapper.mapToCompetitiesView(voetbalClub.getCompetities()));
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
}
