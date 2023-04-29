package jpa.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "X_VERSICHERUNG")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "X_VER_ID")
    private int id;
    @Column(name = "X_VER_TYP")
    private String type;
    @Column(name = "X_IST_RATE_DM")
    private BigDecimal pricePerMonth;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "P_ID")
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
