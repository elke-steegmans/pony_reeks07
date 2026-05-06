drop table if exists ponies;

create table owner(
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR
);

create table ponies(
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR,
    age int,
    owner_id BIGINT,
    foreign key (owner_id) references owner
);
