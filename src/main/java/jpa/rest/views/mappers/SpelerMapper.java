package jpa.rest.views.mappers;

import jpa.domain.Speler;
import jpa.rest.views.SpelerView;

import java.util.ArrayList;
import java.util.List;

public class SpelerMapper {

    public static List<SpelerView> mapToSpelersView(List<Speler> spelers) {
        List<SpelerView> spelersView = new ArrayList<>();

        spelers.forEach(s -> spelersView.add(mapToSpelerView(s)));

        return spelersView;
    }

    private static SpelerView mapToSpelerView(Speler speler) {
        return new SpelerView(
                speler.getNaam(),
                speler.getRugNummer(),
                speler.getGeboorteDatum(),
                speler.getLeeftijd()
        );
    }
}
