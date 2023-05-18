package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jpa.domain.VoetbalClub;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class VoetbalClubRepositroy {

    private  static final String NAAM = "naam";

    @PersistenceContext
    private EntityManager entityManager;

    public VoetbalClub vindVoetbalClubOpId(int id) {
        return entityManager.find(VoetbalClub.class, id);
    }

    public Optional<VoetbalClub> zoekVoetbalClubOpNaam(String naam) {
        TypedQuery<VoetbalClub> query = entityManager.createNamedQuery(VoetbalClub.VOETBAL_CLUB_OP_NAAM, VoetbalClub.class);
        query.setParameter(NAAM, naam);
        return query.getResultStream().findFirst();
    }

    public int slaVoetbalClubOp(VoetbalClub voetbalClub) {
        entityManager.persist(voetbalClub);
        return voetbalClub.getId();
    }

    public void updateVoetbalClub(VoetbalClub voetbalClub) {
        VoetbalClub vc = entityManager.merge(voetbalClub);
        entityManager.persist(vc);
    }

    public void verwijderVoetbalClub(int id) {
        VoetbalClub voetbalClub = entityManager.find(VoetbalClub.class, id);
        entityManager.remove(voetbalClub);
    }
}
