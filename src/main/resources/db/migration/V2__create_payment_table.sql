CREATE SEQUENCE global_id_sequence START 1 INCREMENT 10;

create table payment (
    id int NOT NULL PRIMARY KEY DEFAULT nextval('global_id_sequence' :: REGCLASS),
    payment_mode varchar(2),
    amount decimal(8,3),
    card_number varchar(20),
    check_number varchar(20)
);