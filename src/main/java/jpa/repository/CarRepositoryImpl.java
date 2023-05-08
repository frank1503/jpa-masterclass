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

    //TODO 13i Haal een Car op op basis van brand en color. Gebruik de Criteria API
    @Override
    public Car findCarByBrandAndColor(String brand, String color) {

        return null;
    }
}
