package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jpa.domain.SportsClub;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SportsClubRepositoryImpl implements SportsClubRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //TODO 11h implementeer de methode zodat de club wordt opgeslagen
    @Override
    public int addSportsClub(SportsClub sportsClub) {
        //return id van sportsClub ipv 0
        return 0;
    }
}
