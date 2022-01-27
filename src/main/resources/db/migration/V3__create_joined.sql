create table Animal (
    id int NOT NULL PRIMARY KEY DEFAULT nextval('global_id_sequence' :: REGCLASS),
    species text,
    country varchar(50)
);

create table Pet (
     id int,
     name text,
     birthday timestamp,
     foreign key (id) references Animal(id)
);

create table Wild (
    id int,
    name text,
    birthday timestamp,
    foreign key (id) references Animal(id)
);
