create database dictionary;
use dictionary;
create table vocabulary (
id int primary key auto_increment,
word varchar(50) unique not null);
create table meaning (
id int primary key auto_increment,
mean varchar(200) not null unique);
create table vocabulary_meaning (
word_id int,
meaning_id int);

alter table vocabulary_meaning
add constraint fk_vocabulary_id foreign key (word_id) references vocabulary (id) on delete cascade,
add constraint fk_meaning_id foreign key (meaning_id) references meaning (id) on delete cascade;

alter table vocabulary_meaning
add primary key(word_id, meaning_id);

insert into vocabulary_meaning values (1,1), (2,2), (3,3), (4,4); 
update vocabulary_meaning set meaning_id = 4 where word_id = 3;
update vocabulary_meaning set meaning_id = 3 where word_id = 4;

select word , mean from vocabulary 
join vocabulary_meaning on vocabulary.id = vocabulary_meaning.word_id
join meaning on vocabulary_meaning.meaning_id = meaning.id;

select word , mean from vocabulary 
join vocabulary_meaning on vocabulary.id = vocabulary_meaning.word_id
join meaning on vocabulary_meaning.meaning_id = meaning.id
where word = 'table';

insert into vocabulary (word) values ('fan');
insert into meaning (mean) values ('quạt');
delimiter //
create procedure add_word (in a_word varchar(50),a_meaning varchar(100))
begin
declare word_id int default 0;
declare mean_id int default 0;
insert into vocabulary (word) values (a_word);
insert into meaning (mean) values (a_meaning);
select vocabulary.id into word_id from vocabulary where word = a_word limit 1;
select meaning.id into mean_id from meaning where mean = a_meaning limit 1;
insert into vocabulary_meaning values (word_id,mean_id);
end //
delimiter ;

delimiter //
create procedure look_up (in a_word varchar(50))
begin
select vocabulary.id , vocabulary.word , meaning.mean from vocabulary 
join vocabulary_meaning on vocabulary.id = vocabulary_meaning.word_id
join meaning on vocabulary_meaning.meaning_id = meaning.id
where vocabulary.word like a_word;
end //
delimiter ;

delimiter //
create procedure add_meaning_to_exist_word (in a_word varchar(50),a_meaning varchar(100))
begin
declare word_id int default 0;
declare mean_id int default 0;
insert into meaning (mean) values (a_meaning);
select vocabulary.id into word_id from vocabulary where word = a_word limit 1;
select meaning.id into mean_id from meaning where mean = a_meaning limit 1;
insert into vocabulary_meaning values (word_id,mean_id);
end //
delimiter ;

delimiter //
create procedure add_word_to_exist_meaning (in a_word varchar(50),a_meaning varchar(100))
begin
declare word_id int default 0;
declare mean_id int default 0;
insert into vocabulary (word) values (a_word);
select vocabulary.id into word_id from vocabulary where word = a_word limit 1;
select meaning.id into mean_id from meaning where mean = a_meaning limit 1;
insert into vocabulary_meaning values (word_id,mean_id);
end //
delimiter ;

delimiter //
create procedure list_all_word_meaning ()
begin
select vocabulary.id , vocabulary.word , meaning.mean from vocabulary 
join vocabulary_meaning on vocabulary.id = vocabulary_meaning.word_id
join meaning on vocabulary_meaning.meaning_id = meaning.id;
end //
delimiter ;
