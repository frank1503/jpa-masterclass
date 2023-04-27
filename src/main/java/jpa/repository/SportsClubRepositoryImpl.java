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

    @Override
    public int addSportsClub(SportsClub sportsClub) {
        entityManager.persist(sportsClub);
        return sportsClub.getId();
    }

    @Override
    public SportsClub readSportsClub(int id) {
        return entityManager.find(SportsClub.class, id);
    }
}
