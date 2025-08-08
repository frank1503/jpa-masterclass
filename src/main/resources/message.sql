drop table if exists message;

create table message
(
    id   bigint not null
        primary key,
    text varchar(255)
);

