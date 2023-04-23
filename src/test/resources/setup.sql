drop table person_telephonenumbers;
drop table person;
drop table car;

create table car
(
    registrationplate varchar(255) not null,
    sequencenumber    integer      not null,
    brand             varchar(255),
    color             varchar(255),
    primary key (registrationplate, sequencenumber)
);

create table person
(
    id                    serial
        primary key,
    city                  varchar(255),
    country               varchar(255),
    housenumber           varchar(255),
    streetname            varchar(255),
    zipcode               varchar(255),
    dateofbirth           date,
    firstname             varchar(255),
    gender                varchar(255),
    lastname              varchar(255),
    car_registrationplate varchar(255),
    car_sequencenumber    integer,
    constraint fk5o8otu2be52jalkqsvm74qohx
        foreign key (car_registrationplate, car_sequencenumber) references car
);

create table person_telephonenumbers
(
    person_id        integer not null
        constraint fkij2vg4r8c9kt8mm5he2idgyva
            references person,
    telephonenumbers varchar(255)
);
