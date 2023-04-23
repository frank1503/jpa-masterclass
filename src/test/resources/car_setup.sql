drop table if exists person_telephonenumbers;
drop table if exists person;
drop table if exists car;

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

INSERT INTO public.car (registrationplate, sequencenumber, brand, color) VALUES ('P-468-LJ', 1, 'Seat', 'Blue');
INSERT INTO public.person (id, city, country, housenumber, streetname, zipcode, dateofbirth, firstname, gender, lastname, car_registrationplate, car_sequencenumber) VALUES (1, 'Eindhoven', 'Nederland', '10', 'Dolphijnstraat', '5632CZ', '1986-03-15', 'Frank', 'MALE', 'Rinkens', 'P-468-LJ', 1);
INSERT INTO public.person_telephonenumbers (person_id, telephonenumbers) VALUES (1, '0629731948');
INSERT INTO public.person_telephonenumbers (person_id, telephonenumbers) VALUES (1, '0696857471');