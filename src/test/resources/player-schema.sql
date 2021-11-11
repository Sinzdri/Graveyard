drop table if exists `player` CASCADE;
create table player (id integer not null auto_increment, emailaddress varchar(255), firstname varchar(255), lastname varchar(255), primary key (id))