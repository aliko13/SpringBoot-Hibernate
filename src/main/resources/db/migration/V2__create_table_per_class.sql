CREATE SEQUENCE post_sequence START 1 INCREMENT 10;

create table Post (
    id int NOT NULL PRIMARY KEY DEFAULT nextval('post_sequence' :: REGCLASS),
    title text,
    description text
);

create table Twitter (
    id int NOT NULL PRIMARY KEY DEFAULT nextval('post_sequence' :: REGCLASS),
    title text,
    description text,
    account_name text,
    followers int
);

create table Facebook (
     id int NOT NULL PRIMARY KEY DEFAULT nextval('post_sequence' :: REGCLASS),
     title text,
     description text,
     likes int,
     number_of_comments int
);
