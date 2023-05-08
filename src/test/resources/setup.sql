alter table if exists Insurance
drop constraint if exists FKgprnn3lt5f3ubwpb9dlh6bet1;

alter table if exists Person
drop constraint if exists FK5o8otu2be52jalkqsvm74qohx;

alter table if exists Person_sportsClubs
drop constraint if exists FK8xectdnlwrfkqd6qi8aohsbuk;

alter table if exists Person_sportsClubs
drop constraint if exists FKbdylvxu03q5p0acf1mpxkt4y4;

alter table if exists Person_telephoneNumbers
drop constraint if exists FKij2vg4r8c9kt8mm5he2idgyva;

drop table if exists Car cascade;

drop table if exists Insurance cascade;

drop table if exists Person cascade;

drop table if exists Person_sportsClubs cascade;

drop table if exists Person_telephoneNumbers cascade;

drop table if exists SportsClub cascade;

create table Car (
                     registrationPlate varchar(255) not null,
                     sequenceNumber integer not null,
                     brand varchar(255),
                     color varchar(255),
                     primary key (registrationPlate, sequenceNumber)
);

create table Insurance (
                           id serial not null,
                           pricePerMonth numeric(38,2),
                           type varchar(255),
                           person_id integer,
                           primary key (id)
);

create table Person (
                        id serial not null,
                        city varchar(255),
                        country varchar(255),
                        houseNumber varchar(255),
                        streetName varchar(255),
                        zipCode varchar(255),
                        dateOfBirth date,
                        firstName varchar(255),
                        gender varchar(255),
                        lastName varchar(255),
                        car_registrationPlate varchar(255),
                        car_sequenceNumber integer,
                        primary key (id)
);

create table Person_sportsClubs (
                                    members_id integer not null,
                                    sportsClubs_id integer not null
);

create table Person_telephoneNumbers (
                                         Person_id integer not null,
                                         telephoneNumbers varchar(255)
);

create table SportsClub (
                            id serial not null,
                            name varchar(255),
                            primary key (id)
);

alter table if exists Insurance
    add constraint FKgprnn3lt5f3ubwpb9dlh6bet1
    foreign key (person_id)
    references Person;

alter table if exists Person
    add constraint FK5o8otu2be52jalkqsvm74qohx
    foreign key (car_registrationPlate, car_sequenceNumber)
    references Car;

alter table if exists Person_sportsClubs
    add constraint FK8xectdnlwrfkqd6qi8aohsbuk
    foreign key (sportsClubs_id)
    references SportsClub;

alter table if exists Person_sportsClubs
    add constraint FKbdylvxu03q5p0acf1mpxkt4y4
    foreign key (members_id)
    references Person;

alter table if exists Person_telephoneNumbers
    add constraint FKij2vg4r8c9kt8mm5he2idgyva
    foreign key (Person_id)
    references Person;