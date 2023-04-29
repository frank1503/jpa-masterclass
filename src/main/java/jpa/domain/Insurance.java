package jpa.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private BigDecimal pricePerMonth;
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    public Insurance() {
    }

    public Insurance(String type, BigDecimal pricePerMonth) {
        this.type = type;
        this.pricePerMonth = pricePerMonth;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(BigDecimal pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
