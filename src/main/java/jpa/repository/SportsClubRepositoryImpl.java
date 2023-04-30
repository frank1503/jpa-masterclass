package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jpa.domain.SportsClub;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SportsClubRepositoryImpl implements SportsClubRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SportsClub findSportsClubByName(String name) {
        Query query = entityManager.createNativeQuery("select * from sportsclub s where s.name = :name", SportsClub.class);
        query.setParameter("name", name);
        return (SportsClub) query.getSingleResult();
    }
}
