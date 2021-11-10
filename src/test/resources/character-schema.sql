drop table if exists `player_character` CASCADE;
create table `player_character`
(
id integer AUTO_INCREMENT, 
causeofdeath integer, 
characterclass integer, 
characterlevel integer not null, 
charactername varchar(255), 
characterrace integer, 
playername varchar(255), 
primary key (id)
);
