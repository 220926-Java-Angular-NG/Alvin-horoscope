create table "mini-project-zodiac".users(
userId serial primary key,
firstName varchar(20) not null,
lastName varchar(20) not null,
userName varchar(30) not null unique,
pass_word varchar (30) not null,
zodiac varchar(15) not null,
mood varchar(20) 
);

drop table users;