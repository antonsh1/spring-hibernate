CREATE SCHEMA IF NOT EXISTS netology AUTHORIZATION postgres;
create table netology.customer
(
    id  bigserial primary key,
    city_of_living varchar(255),
    age            integer,
    name           varchar(255) not null,
    sure_name      varchar(255) not null,
    phone_number   varchar(255)
);

INSERT INTO netology.customer (name,sure_name,age,phone_number, city_of_living) VALUES ('Denis', 'Petrov', 10, '+79000000000','Moscow');
INSERT INTO netology.customer (name,sure_name,age,phone_number, city_of_living) VALUES ('Alexey', 'Ivanov', 15, '+79111111111','Ekaterinburg');
INSERT INTO netology.customer (name,sure_name,age,phone_number, city_of_living) VALUES ('Anna', 'Vasilyeva', 20, '+79222222222','Moscow');
INSERT INTO netology.customer (name,sure_name,age,phone_number, city_of_living) VALUES ('Olga', 'First', 25, '+79333333333','Ekaterinburg');
INSERT INTO netology.customer (name,sure_name,age,phone_number, city_of_living) VALUES ('Ivan', 'Second', 30, '+79444444444','Vologda');