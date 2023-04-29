package jpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XAT462")
public class SportsClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SC_ID")
    private int id;
    @Column(name = "SC_NAME")
    private String name;

    @ManyToMany(mappedBy = "sportsClubs", cascade = CascadeType.PERSIST)
    private List<Person> members = new ArrayList<>();

    public SportsClub() {
    }

    public SportsClub(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }
}
