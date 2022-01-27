CREATE SEQUENCE component_mapping START 1 INCREMENT 10;

CREATE TABLE employee (
    id int NOT NULL PRIMARY KEY DEFAULT nextval('component_mapping'::REGCLASS),
    name varchar(50),
    date_of_birth timestamp,
    street varchar(100),
    house_no varchar(20),
    city varchar(50),
    zip_code varchar(10),
    country varchar(50)
);