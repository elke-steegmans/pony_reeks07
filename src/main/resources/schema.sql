drop table if exists ponies;

create table owner(
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR
);

create table stable(
    id BIGINT primary key auto_increment
);

create table animal(
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR,
    age int,
    owner_id BIGINT,
    lays_eggs BOOLEAN,
    species VARCHAR,
    stable_id BIGINT,
    foreign key (owner_id) references owner,
    foreign key (stable_id) references stable
);


-- create table ponies(
--     id BIGINT PRIMARY KEY auto_increment,
--     name VARCHAR,
--     age int,
--     owner_id BIGINT,
--     foreign key (owner_id) references owner
-- );
