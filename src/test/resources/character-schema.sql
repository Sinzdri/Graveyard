drop table if exists `player_character` CASCADE;
create table `player_character`
(
id integer AUTO_INCREMENT, 
causeofdeath varchar(255), 
characterclass varchar(255), 
characterlevel integer not null, 
charactername varchar(255), 
characterrace varchar(255), 
playername varchar(255), 
primary key (id)
);
