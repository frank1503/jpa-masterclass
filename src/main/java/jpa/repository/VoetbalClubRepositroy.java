package jpa.repository;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jpa.domain.VoetbalClub;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
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

    public VoetbalClub zoekVoetbalClubEnSpelers(int id) {
        EntityGraph<?> graph = entityManager.getEntityGraph(VoetbalClub.VOETBAL_CLUB_EN_SPELERS);

        Map<String, Object> hints = new HashMap<>();
        hints.put("jakarta.persistence.fetchgraph", graph);

        return entityManager.find(VoetbalClub.class, id, hints);
    }

    public int slaVoetbalClubOp(VoetbalClub voetbalClub) {
        entityManager.persist(voetbalClub);
        return voetbalClub.getId();
    }

    public void verwijderVoetbalClub(String naam) {
        TypedQuery<VoetbalClub> query = entityManager.createNamedQuery(VoetbalClub.VOETBAL_CLUB_OP_NAAM, VoetbalClub.class);
        query.setParameter(NAAM, naam);

        Optional<VoetbalClub> voetbalClub = query.getResultStream().findFirst();

        voetbalClub.ifPresent(club -> entityManager.remove(club));
    }
}
