package jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jpa.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Car findCarByBrandAndColor(String brand, String color) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = builder.createQuery(Car.class);
        Root<Car> c = criteriaQuery.from(Car.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(c.get("brand"), brand));
        predicates.add(builder.equal(c.get("color"), color));
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Car> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}
