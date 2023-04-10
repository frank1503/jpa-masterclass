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
    serialnumber      integer      not null,
    type              varchar(255) not null,
    color             varchar(255),
    registrationplate varchar(255),
    primary key (serialnumber, type)
);