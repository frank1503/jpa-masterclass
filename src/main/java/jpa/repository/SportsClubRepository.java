package jpa.repository;

import jpa.domain.SportsClub;

public interface SportsClubRepository {

    int addSportsClub(SportsClub sportsClub);

    SportsClub readSportsClub(int id);
}
