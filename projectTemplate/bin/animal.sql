create table animal_class (
        class_name varchar(100) primary key,
        warm_blooded char(1),
        has_hair char(1),
        has_vertebrae char(1)
        );
        
create table animal (
        name varchar(200) primary key,
        class_name varchar(100) not null,
        leg_count integer,
        sound varchar(50),
        life_expectancy integer,
        continent_name varchar(50)
        );
        
create table continent (
        name varchar(50) primary key,
        area BIGINT,
        human_population BIGINT
        );
        
insert into animal_class values ('mammal', 'Y', 'Y', 'Y');
insert into animal_class values ('reptile', 'N','N','Y');
insert into animal_class values ('amphibian', 'N','N','Y');
insert into animal_class values ('bird', 'Y','N','Y');
insert into animal_class values ('fish', 'N','N','Y');
insert into animal_class values ('invertebrates','N','N','N');

insert into animal values ('dog', 'mammal', 4, 'woof', 12, 'North America');
insert into animal values ('cat', 'mammal', 4, 'meow', 18, 'North America');
insert into animal values ('horse', 'mammal', 4, 'neigh', 8, 'North America');
insert into animal values ('hamster', 'mammal', 4, 'meep', 7, 'Asia');
insert into animal values ('rabbit', 'mammal', 4, 'eeeee', 22, 'North America');
insert into animal values ('bison', 'mammal', 4, 'meeeehhh', 15, 'North America');
insert into animal values ('snake', 'reptile', 0, 'hiss', 6, 'Africa');
insert into animal values ('lizard', 'reptile', 0, 'click squeek', 6, 'Africa');
insert into animal values ('alligator', 'reptile', 4, 'rawr', 60, 'North America');
insert into animal values ('crocodile', 'reptile', 4, 'rawr', 45, 'Africa');
insert into animal values ('frog', 'amphibian', 4, 'ribbit', 60, 'Africa');
insert into animal values ('salamander', 'amphibian', 4, 'meh', 25, 'North America');
insert into animal values ('ostrich', 'bird', 2, 'aarrrkk', 25, 'North America');
insert into animal values ('shark', 'fish', 0, 'bubble bubble', 30, 'North America');
insert into animal values ('eagle', 'bird', 2, 'caw caw', 12, 'North America');
insert into animal values ('raven', 'bird', 2, 'caw caw', 24, 'North America');
insert into animal values ('spider', 'invertebrates', 8, '...', 3, 'Europe');
insert into animal values ('octupus', 'invertebrates', 8, 'bubble bubble', 40, 'South America');
insert into animal values ('penguin', 'bird', 2, 'caw caw', 24, 'Antartica');
insert into animal values ('kangaroo', 'mammal', 2, 'bounce', 11, 'Australia');

insert into continent values ('North America', 24490000, 574777000);
insert into continent values ('South America', 17840000, 418447000);
insert into continent values ('Africa', 30370000, 1186178000);
insert into continent values ('Antartica', 13720000, 4490);
insert into continent values ('Asia', 43820000, 4393296000);
insert into continent values ('Europe', 10180000, 738442000);
insert into continent values ('Australia', 9008500, 39331000);