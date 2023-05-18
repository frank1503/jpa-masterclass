package jpa.rest.views.mappers;

import jpa.domain.Competitie;
import jpa.rest.views.CompetitieView;

import java.util.ArrayList;
import java.util.List;

public class CompetitieMapper {

    public static List<CompetitieView> mapToCompetitiesView(List<Competitie> competities) {
        List<CompetitieView> competitiesView = new ArrayList<>();

        competities.forEach(c -> competitiesView.add(mapToCompetitieView(c)));

        return competitiesView;
    }

    private static CompetitieView mapToCompetitieView(Competitie competitie) {
        return new CompetitieView(
                competitie.getId(),
                competitie.getNaam()
        );
    }
}
