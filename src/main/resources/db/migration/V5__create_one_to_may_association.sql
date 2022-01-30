CREATE SEQUENCE association_sequence START 1 INCREMENT 10;

CREATE TABLE company (
    id int NOT NULL PRIMARY KEY DEFAULT nextval('association_sequence':: regclass),
    name varchar(150),
    email varchar(100)
);

CREATE TABLE phone_number (
    id int not null PRIMARY KEY DEFAULT nextval('association_sequence'::regclass),
    number varchar(50),
    phone_number_type varchar(20),
    company_id int not null,
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) references company(id)
);