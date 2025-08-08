create table answers(
    id bigint not null auto_increment,
    message varchar(100) not null,
    topic_id bigint not null,
    last_change datetime not null,
    author varchar(20) not null,
    active tinyint not null default 1,

    primary key(id),
    constraint fk_answers_topic_id foreign key(topic_id) references topics(id)
);