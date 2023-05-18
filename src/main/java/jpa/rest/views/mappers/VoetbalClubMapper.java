package jpa.rest.views.mappers;

import jpa.domain.VoetbalClub;
import jpa.rest.views.VoetbalClubView;

public class VoetbalClubMapper {
    public static VoetbalClubView mapToVoetbalClubView(VoetbalClub voetbalClub) {
        return new VoetbalClubView(voetbalClub);
    }
}
