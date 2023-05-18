package jpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "X_VOETBAL_CLUB")
@NamedQuery(
        name = VoetbalClub.VOETBAL_CLUB_OP_NAAM,
        query = "select v from VoetbalClub v where v.naam = :naam")
public class VoetbalClub {

    public static final String VOETBAL_CLUB_OP_NAAM = "voetbalClubOpNaam";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLUB_ID")
    private int id;

    @Column(name = "CLUB_NAAM")
    private String naam;

    @Embedded
    @AttributeOverride(name = "land", column = @Column(name = "CLUB_LAND"))
    @AttributeOverride(name = "stad", column = @Column(name = "CLUB_STAD"))
    private Locatie locatie;

    @ElementCollection
    @CollectionTable(name = "CLUB_SPONSOREN", joinColumns = @JoinColumn(name = "CLUB_ID"))
    @Column(name = "SPONSOR")
    private List<String> sponsoren;

    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(name = "STDN_ID", referencedColumnName = "STADION_ID")
    private Stadion stadion;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "voetbalClub"
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

    public VoetbalClub() {
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    public List<String> getSponsoren() {
        return sponsoren;
    }

    public void setSponsoren(List<String> sponsoren) {
        this.sponsoren = sponsoren;
    }

    public Stadion getStadion() {
        return stadion;
    }

    public void setStadion(Stadion stadion) {
        this.stadion = stadion;
    }

    public List<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }

    public List<Competitie> getCompetities() {
        return competities;
    }

    public void setCompetities(List<Competitie> competities) {
        this.competities = competities;
    }
}
