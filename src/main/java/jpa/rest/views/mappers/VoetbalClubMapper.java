//package jpa.rest.views.mappers;
//
//import jpa.domain.VoetbalClub;
//import jpa.rest.views.CompetitieView;
//import jpa.rest.views.SpelerView;
//import jpa.rest.views.StadionView;
//import jpa.rest.views.VoetbalClubView;
//
//import java.util.List;
//
//public class VoetbalClubMapper {
//
//    public static VoetbalClubView mapToVoetbalClubView(VoetbalClub voetbalClub) {
//        VoetbalClubView voetbalClubView = new VoetbalClubView(
//                voetbalClub.getId(),
//                voetbalClub.getNaam(),
//                voetbalClub.getLocatie().getLand(),
//                voetbalClub.getLocatie().getStad()
//        );
//
//        voetbalClubView.getSponsoren().addAll(voetbalClub.getSponsoren());
//
//        List<CompetitieView> competities = CompetitieMapper.mapToCompetitiesView(voetbalClub.getCompetities());
//        voetbalClubView.getCompetitiesView().addAll(competities);
//
//        List<SpelerView> spelers = SpelerMapper.mapToSpelersView(voetbalClub.getSpelers());
//        voetbalClubView.getSpelersView().addAll(spelers);
//
//        if (voetbalClub.getStadion() != null) {
//            StadionView stadion = StadionMapper.mapToStadionView(voetbalClub.getStadion());
//            voetbalClubView.setStadionView(stadion);
//        }
//
//        return voetbalClubView;
//    }
//
//    public static VoetbalClubView mapMetSpelers(VoetbalClub voetbalClub) {
//        VoetbalClubView voetbalClubView = new VoetbalClubView(
//                voetbalClub.getId(),
//                voetbalClub.getNaam(),
//                voetbalClub.getLocatie().getLand(),
//                voetbalClub.getLocatie().getStad()
//        );
//
//        List<SpelerView> spelers = SpelerMapper.mapToSpelersView(voetbalClub.getSpelers());
//        voetbalClubView.getSpelersView().addAll(spelers);
//
//        return voetbalClubView;
//    }
//}
