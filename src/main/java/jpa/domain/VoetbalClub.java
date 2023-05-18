package jpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class VoetbalClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String naam;

    @Embedded
    private Locatie locatie;

    @ElementCollection
    private List<String> sponsoren;

    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Stadion stadion;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true,
            mappedBy = "stadion"
    )
    private List<Speler> spelers = new ArrayList<>();

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    @JoinTable(
            name = "club_competitie"
            , joinColumns = @JoinColumn(name = "club_id")
            , inverseJoinColumns = @JoinColumn(name = "competitie_id")
    )
    private List<Competitie> competities = new ArrayList<>();
}
