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

INSERT INTO public.x_stadion (stadion_id, stadion_capaciteit, stadion_naam) VALUES (1, 55885, 'Johan Cruijff Arena');
INSERT INTO public.x_stadion (stadion_id, stadion_capaciteit, stadion_naam) VALUES (2, 51177, 'De Kuip');
INSERT INTO public.x_stadion (stadion_id, stadion_capaciteit, stadion_naam) VALUES (3, 35119, 'Philips Stadion');
INSERT INTO public.x_stadion (stadion_id, stadion_capaciteit, stadion_naam) VALUES (4, 35000, 'Gelredome ');

INSERT INTO public.x_voetbal_club (club_id, club_land, club_stad, club_naam, stdn_id) VALUES (1, 'Nederland', 'Amsterdam', 'Ajax', 1);
INSERT INTO public.x_voetbal_club (club_id, club_land, club_stad, club_naam, stdn_id) VALUES (2, 'Nederland', 'Rotterdam', 'Feyenoord', 2);
INSERT INTO public.x_voetbal_club (club_id, club_land, club_stad, club_naam, stdn_id) VALUES (3, 'Nederland', 'Eindoven', 'PSV', 3);
INSERT INTO public.x_voetbal_club (club_id, club_land, club_stad, club_naam, stdn_id) VALUES (4, 'Nederland', 'Arnhem', 'Vitesse', 4);

INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Remko Pasveer', 22, '1983-11-08', 1);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Jurrien Timber', 2, '2001-06-17', 1);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Kenneth Taylor', 8, '2002-05-16', 1);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Dusan Tadic', 10, '1988-11-20', 1);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Alireza Jahanbakish', 7, '1993-08-11', 2);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Quiten Timber', 8, '2001-06-17', 2);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Marcus Pedersen', 2, '2000-07-16', 2);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Justin Bijlow', 1, '1998-01-22', 2);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Boy Waterman', 24, '1984-01-24', 3);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Jordan Teze', 3, '1999-09-30', 3);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Xavi Simons', 7, '2003-04-21', 3);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Luuk de Jong', 9, '1990-08-27', 3);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Kjell Scherpen', 16, '2000-01-23', 4);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Enzo Cornelisse', 13, '2002-06-29', 4);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Davy Propper', 19, '1991-09-02', 4);
INSERT INTO public.x_speler (speler_naam, speler_rug_nummer, speler_geboorte_datum, clb_id) VALUES ('Bartosz Bialek', 14, '2001-11-11', 4);

INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (1, 'Ziggo');
INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (1, 'Adidas');
INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (1, 'Mercedes-Benz');
INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (2, 'EuroParcs');
INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (2, 'Heineken');
INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (3, 'Brainport');
INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (3, 'VDL');
INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (4, 'Etoro');
INSERT INTO public.club_sponsoren (club_id, sponsor) VALUES (4, 'Nike');

INSERT INTO public.x_voetbal_comp (comp_id, comp_naam) VALUES (1, 'Eredivisie');
INSERT INTO public.x_voetbal_comp (comp_id, comp_naam) VALUES (2, 'KNVB Beker');
INSERT INTO public.x_voetbal_comp (comp_id, comp_naam) VALUES (3, 'UEFA Champions League');
INSERT INTO public.x_voetbal_comp (comp_id, comp_naam) VALUES (4, 'UEFA Europa League');
INSERT INTO public.x_voetbal_comp (comp_id, comp_naam) VALUES (5, 'UEFA Europa Conference League');

INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (1, 1);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (1, 2);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (1, 3);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (2, 1);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (2, 2);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (2, 4);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (3, 1);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (3, 2);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (3, 4);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (4, 1);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (4, 2);
INSERT INTO public.club_competitie (club_id, competitie_id) VALUES (4, 5);
