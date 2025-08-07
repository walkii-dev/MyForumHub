create table topics(

    id bigint not null auto_increment,
    title varchar(100) not null unique,
    message varchar(100) not null unique,
    last_change DATETIME not null,
    topic_status varchar(20)not null,
    author varchar(20) not null,
    course varchar(100) not null,

    primary key(id)

);