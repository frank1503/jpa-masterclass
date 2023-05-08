package jpa.repository;

import jpa.domain.Insurance;

public interface InsuranceRepository {

    int addInsurance(Insurance insurance);

    Insurance readInsurance(int id);
}
