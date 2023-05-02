package jpa.repository;

import jpa.domain.Insurance;

public interface InsuranceRepository {

    void addInsurance(Insurance insurance);

    Insurance readInsurance(int id);
}
