--liquibase formatted sql

--changeset mukhomedyarov:1
create table netology.persons
(
    name varchar(255) not null ,
    surname varchar(255) not null ,
    age int check (age > 0 and age < 100 and age !=''),
    phone_number varchar(20) check (phone_number regexp '[+]?[0-9]{1,3} ?\\(?[0-9]{3}\\)? ?[0-9]{2}[0-9 -]+[0-9]{2}'),
    city_of_living varchar(255),
    primary key (name, surname, age)
)

--rollback drop table netology.persons;
