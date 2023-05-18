package jpa.rest.views.mappers;

import jpa.domain.Stadion;
import jpa.rest.views.StadionView;

public class StadionMapper {

    public static StadionView mapToStadionView(Stadion stadion) {
        return new StadionView(
                stadion.getId(),
                stadion.getNaam(),
                stadion.getCapaciteit()
        );
    }
}
