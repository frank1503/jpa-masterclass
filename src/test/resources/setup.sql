drop table if exists Car cascade;
drop table if exists Person cascade;
drop table if exists Person_telephoneNumbers cascade;

create table car
(
    registrationplate varchar(255) not null,
    sequencenumber    integer      not null,
    brand             varchar(255),
    color             varchar(255),
    primary key (registrationplate, sequencenumber)
);

alter table car
    owner to postgres;

create table person
(
    id          serial
        primary key,
    city        varchar(255),
    country     varchar(255),
    housenumber varchar(255),
    streetname  varchar(255),
    zipcode     varchar(255),
    dateofbirth date,
    firstname   varchar(255),
    gender      varchar(255),
    lastname    varchar(255)
);

alter table person
    owner to postgres;

create table person_telephonenumbers
(
    person_id        integer not null
        constraint fkij2vg4r8c9kt8mm5he2idgyva
            references person,
    telephonenumbers varchar(255)
);

alter table person_telephonenumbers
    owner to postgres;

