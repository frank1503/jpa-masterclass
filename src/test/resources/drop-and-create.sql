drop table person;
drop table car;

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

create table car
(
    sequenceNumber   integer      not null,
    registrationplate varchar(255) not null,
    brand              varchar(255),
    color             varchar(255),
    primary key (sequenceNumber, registrationplate)
);