package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class VoetbalClubRepositroy {

    @PersistenceContext
    private EntityManager entityManager;

//    public VoetbalClub vindVoetbalClubOpId(int id) {
//
//    }
//
//    public Optional<VoetbalClub> zoekVoetbalClubOpNaam(String naam) {
//
//    }
//
//    public VoetbalClub zoekVoetbalClubEnSpelers(int id) {
//
//    }
//
//    public int slaVoetbalClubOp(VoetbalClub voetbalClub) {
//
//
//    }
//
//    public void verwijderVoetbalClub(String naam) {
//
//    }
}
