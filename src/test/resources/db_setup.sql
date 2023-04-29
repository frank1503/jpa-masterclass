drop table if exists telefoonnummers cascade;

drop table if exists x_versicherung cascade;

drop table if exists person_to_club cascade;

drop table if exists xat403 cascade;

drop table if exists x_person_objekt cascade;

drop table if exists xat462 cascade;

create table x_person_objekt
(
    x_nummernschild varchar(255) not null,
    x_seriennummer  integer      not null,
    x_marke         varchar(255),
    x_farbe         varchar(255),
    primary key (x_nummernschild, x_seriennummer)
);

alter table x_person_objekt
    owner to postgres;

create table xat403
(
    p_id            serial
        primary key,
    a_city          varchar(255),
    a_country       varchar(255),
    a_house_number  varchar(255),
    a_street_name   varchar(255),
    a_zip_code      varchar(255),
    p_date_of_birth date,
    p_first_name    varchar(255),
    p_gender        varchar(255),
    p_last_name     varchar(255),
    x_numschild     varchar(255),
    x_seriennum     integer,
    constraint fk2k1pnmv0njul5pwevlgysqn7k
        foreign key (x_numschild, x_seriennum) references x_person_objekt
);

alter table xat403
    owner to postgres;

create table telefoonnummers
(
    p_id           integer not null
        constraint fk3dek7upvh3u37dqbo5if6jgbs
            references xat403,
    telefoonnummer varchar(255)
);

alter table telefoonnummers
    owner to postgres;

create table x_versicherung
(
    x_ver_id      serial
        primary key,
    x_ist_rate_dm numeric(38, 2),
    x_ver_typ     varchar(255),
    fk_p_id       integer
        constraint fklntjnucor0t9ni37n09v5soix
            references xat403
);

alter table x_versicherung
    owner to postgres;

create table xat462
(
    sc_id   serial
        primary key,
    sc_name varchar(255)
);

alter table xat462
    owner to postgres;

create table person_to_club
(
    p_id  integer not null
        constraint fkr4v089890s2vaxf9q3k3n2vgn
            references xat403,
    sc_id integer not null
        constraint fk5pby558axbkpbolp4kujp9n2g
            references xat462
);

alter table person_to_club
    owner to postgres;

