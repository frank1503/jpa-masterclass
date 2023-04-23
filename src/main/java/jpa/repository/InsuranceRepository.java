package jpa.repository;

import jpa.domain.Insurance;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InsuranceRepository {

    int addInsurance(Insurance insurance);

    Insurance readInsurance(int id);
}
