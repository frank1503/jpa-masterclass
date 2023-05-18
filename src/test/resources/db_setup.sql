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

