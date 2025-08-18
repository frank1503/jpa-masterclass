drop table if exists club_sponsoren;

drop table if exists x_speler;

drop table if exists club_competitie;

drop table if exists x_voetbal_club;

drop table if exists x_stadion;

drop table if exists x_voetbal_comp;

drop sequence if exists stadion_sequence;

create sequence stadion_sequence
    increment by 50;

alter sequence stadion_sequence owner to postgres;


create table x_stadion
(
    stadion_id         integer not null
        primary key,
    stadion_capaciteit integer,
    stadion_naam       varchar(255)
);

alter table x_stadion
    owner to postgres;

create table x_voetbal_club
(
    club_id   serial
        primary key,
    club_land varchar(255),
    club_stad varchar(255),
    club_naam varchar(255),
    stdn_id   integer
        constraint fk27179dhmghosm7rluooqq77h9
            references x_stadion
);

alter table x_voetbal_club
    owner to postgres;

create table club_sponsoren
(
    club_id integer not null
        constraint fk9i63dd70dbjpqjlbn8y669pgc
            references x_voetbal_club,
    sponsor varchar(255)
);

alter table club_sponsoren
    owner to postgres;

create table x_speler
(
    speler_naam           varchar(255) not null,
    speler_rug_nummer     integer      not null,
    speler_geboorte_datum date,
    clb_id                integer
        constraint fkj9wv8bgwc7hjkp47cdu1sae91
            references x_voetbal_club,
    primary key (speler_naam, speler_rug_nummer)
);

alter table x_speler
    owner to postgres;

create table x_voetbal_comp
(
    comp_id   serial
        primary key,
    comp_naam varchar(255)
);

alter table x_voetbal_comp
    owner to postgres;

create table club_competitie
(
    club_id       integer not null
        constraint fkqp0r408mv7qctgqpvgu0ib1rp
            references x_voetbal_club,
    competitie_id integer not null
        constraint fk40uv315oyiu8ajehhpl6qqiyp
            references x_voetbal_comp
);

alter table club_competitie
    owner to postgres;

INSERT INTO x_stadion (stadion_id, stadion_capaciteit, stadion_naam) VALUES (996, 55885, 'Johan Cruijff Arena');
INSERT INTO x_stadion (stadion_id, stadion_capaciteit, stadion_naam) VALUES (997, 51177, 'De Kuip');
INSERT INTO x_stadion (stadion_id, stadion_capaciteit, stadion_naam) VALUES (998, 35119, 'Philips Stadion');
INSERT INTO x_stadion (stadion_id, stadion_capaciteit, stadion_naam) VALUES (999, 35000, 'Gelredome ');

INSERT INTO x_voetbal_club (club_id, club_land, club_stad, club_naam, stdn_id) VALUES (996, 'Nederland', 'Amsterdam', 'Ajax', 996);
INSERT INTO x_voetbal_club (club_id, club_land, club_stad, club_naam, stdn_id) VALUES (997, 'Nederland', 'Rotterdam', 'Feyenoord', 997);
INSERT INTO x_voetbal_club (club_id, club_land, club_stad, club_naam, stdn_id) VALUES (998, 'Nederland', 'Eindoven', 'PSV', 998);
INSERT INTO x_voetbal_club (club_id, club_land, club_stad, club_naam, stdn_id) VALUES (999, 'Nederland', 'Arnhem', 'Vitesse', 999);

INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Remko Pasveer', 22, '1983-11-08', 996);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Jurrien Timber', 2, '2001-06-17', 996);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Kenneth Taylor', 8, '2002-05-16', 996);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Dusan Tadic', 10, '1988-11-20', 996);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Alireza Jahanbakish', 7, '1993-08-11', 997);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Quiten Timber', 8, '2001-06-17', 997);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Marcus Pedersen', 2, '2000-07-16', 997);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Justin Bijlow', 1, '1998-01-22', 997);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Boy Waterman', 24, '1984-01-24', 998);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Jordan Teze', 3, '1999-09-30', 998);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Xavi Simons', 7, '2003-04-21', 998);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Luuk de Jong', 9, '1990-08-27', 998);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Kjell Scherpen', 16, '2000-01-23', 999);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Enzo Cornelisse', 13, '2002-06-29', 999);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Davy Propper', 19, '1991-09-02', 999);
INSERT INTO x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Bartosz Bialek', 14, '2001-11-11', 999);

INSERT INTO club_sponsoren (club_id, sponsor) VALUES (996, 'Ziggo');
INSERT INTO club_sponsoren (club_id, sponsor) VALUES (996, 'Adidas');
INSERT INTO club_sponsoren (club_id, sponsor) VALUES (996, 'Mercedes-Benz');
INSERT INTO club_sponsoren (club_id, sponsor) VALUES (997, 'EuroParcs');
INSERT INTO club_sponsoren (club_id, sponsor) VALUES (997, 'Heineken');
INSERT INTO club_sponsoren (club_id, sponsor) VALUES (998, 'Brainport');
INSERT INTO club_sponsoren (club_id, sponsor) VALUES (998, 'VDL');
INSERT INTO club_sponsoren (club_id, sponsor) VALUES (999, 'Etoro');
INSERT INTO club_sponsoren (club_id, sponsor) VALUES (999, 'Nike');

INSERT INTO x_voetbal_comp (comp_id, comp_naam) VALUES (995, 'Eredivisie');
INSERT INTO x_voetbal_comp (comp_id, comp_naam) VALUES (996, 'KNVB Beker');
INSERT INTO x_voetbal_comp (comp_id, comp_naam) VALUES (997, 'UEFA Champions League');
INSERT INTO x_voetbal_comp (comp_id, comp_naam) VALUES (998, 'UEFA Europa League');
INSERT INTO x_voetbal_comp (comp_id, comp_naam) VALUES (999, 'UEFA Europa Conference League');

INSERT INTO club_competitie (club_id, competitie_id) VALUES (996, 995);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (996, 996);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (996, 997);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (997, 995);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (997, 996);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (997, 998);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (998, 995);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (998, 996);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (998, 998);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (999, 995);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (999, 996);
INSERT INTO club_competitie (club_id, competitie_id) VALUES (999, 999);
