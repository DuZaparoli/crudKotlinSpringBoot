create table product(
    id bigint not null AUTO_INCREMENT,
    description varchar(50) not null,
    quantity int not null,
    location_id bigint,
    create_at datetime not null,
    primary key(id),
    foreign key(location_id) references location_product(id)
);