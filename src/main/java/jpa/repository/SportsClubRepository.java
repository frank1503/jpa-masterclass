package jpa.repository;

import jpa.domain.SportsClub;

public interface SportsClubRepository {

    SportsClub findSportsClubByName(String name);
}
