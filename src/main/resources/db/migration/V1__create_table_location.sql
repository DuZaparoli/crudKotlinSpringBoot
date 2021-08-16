create table location_product(
    id bigint not null AUTO_INCREMENT,
    street varchar(50) not null,
    number int not null,
    apartment int not null,
    primary key(id)
);