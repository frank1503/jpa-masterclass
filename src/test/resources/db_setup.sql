drop table if exists telefoonnummers cascade;

drop table if exists x_versicherung cascade;

drop table if exists person_to_club cascade;

drop table if exists xat403 cascade;

drop table if exists x_person_objekt cascade;

drop table if exists xat462 cascade;

drop table if exists insurance cascade;

drop table if exists person_telephonenumbers cascade;

drop table if exists person_sportsclubs cascade;

drop table if exists person cascade;

drop table if exists car cascade;

drop table if exists sportsclub cascade;

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

alter table person
    owner to postgres;

create table insurance
(
    id            serial
        primary key,
    pricepermonth numeric(38, 2),
    type          varchar(255),
    person_id     integer
        constraint fkgprnn3lt5f3ubwpb9dlh6bet1
            references person
);

alter table insurance
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

create table sportsclub
(
    id   serial
        primary key,
    name varchar(255)
);

alter table sportsclub
    owner to postgres;

create table person_sportsclubs
(
    members_id     integer not null
        constraint fkbdylvxu03q5p0acf1mpxkt4y4
            references person,
    sportsclubs_id integer not null
        constraint fk8xectdnlwrfkqd6qi8aohsbuk
            references sportsclub
);

alter table person_sportsclubs
    owner to postgres;

INSERT INTO public.car (registrationplate, sequencenumber, brand, color) VALUES ('P-468-LJ', 1, 'Seat', 'Blue');
INSERT INTO public.car (registrationplate, sequencenumber, brand, color) VALUES ('HH-DF-33', 1, 'Ford', 'Green');

INSERT INTO public.person (id, city, country, housenumber, streetname, zipcode, dateofbirth, firstname, gender, lastname, car_registrationplate, car_sequencenumber) VALUES (1, 'Eindhoven', 'Nederland', '10', 'Dolphijnstraat', '5632CZ', '1986-03-15', 'Frank', 'MALE', 'Rinkens', 'P-468-LJ', 1);
INSERT INTO public.person (id, city, country, housenumber, streetname, zipcode, dateofbirth, firstname, gender, lastname, car_registrationplate, car_sequencenumber) VALUES (2, 'Leerdam', 'Nederland', '7', 'Frederik Hendrikstraat', '4141JD', '1986-03-15', 'Rick', 'MALE', 'Roelofsen', 'HH-DF-33', 1);

INSERT INTO public.person_telephonenumbers (person_id, telephonenumbers) VALUES (1, '0629731948');
INSERT INTO public.person_telephonenumbers (person_id, telephonenumbers) VALUES (1, '0645859845');
INSERT INTO public.person_telephonenumbers (person_id, telephonenumbers) VALUES (2, '0659485231');
INSERT INTO public.person_telephonenumbers (person_id, telephonenumbers) VALUES (2, '0694164973');

INSERT INTO public.insurance (id, pricepermonth, type, person_id) VALUES (1, 48.99, 'car', 1);
INSERT INTO public.insurance (id, pricepermonth, type, person_id) VALUES (2, 105.99, 'house', 1);
INSERT INTO public.insurance (id, pricepermonth, type, person_id) VALUES (3, 55.99, 'car', 2);
INSERT INTO public.insurance (id, pricepermonth, type, person_id) VALUES (4, 155.99, 'house', 2);

INSERT INTO public.sportsclub (id, name) VALUES (1, 'CobraKai');
INSERT INTO public.sportsclub (id, name) VALUES (2, 'FC De Treffers');

INSERT INTO public.person_sportsclubs (members_id, sportsclubs_id) VALUES (1, 1);
INSERT INTO public.person_sportsclubs (members_id, sportsclubs_id) VALUES (1, 2);
INSERT INTO public.person_sportsclubs (members_id, sportsclubs_id) VALUES (2, 1);
INSERT INTO public.person_sportsclubs (members_id, sportsclubs_id) VALUES (2, 2);



