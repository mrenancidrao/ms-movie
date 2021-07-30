CREATE TABLE genre (
	id serial NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT genre_pkey PRIMARY KEY (id)
);

CREATE TABLE director (
	id serial NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT director_pkey PRIMARY KEY (id)
);

CREATE TABLE actor (
	id serial NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT actor_pkey PRIMARY KEY (id)
);

CREATE TABLE movie (
	id serial NOT NULL,
	name varchar(255) NOT NULL,
	genre_id int NOT NULL,
	director_id int NOT NULL,
	CONSTRAINT movie_pkey PRIMARY KEY (id)
);

CREATE TABLE movie_actor (
	id serial NOT NULL,
	movie_id int NOT NULL,
	actor_id int NOT NULL,
	CONSTRAINT movie_actor_pkey PRIMARY KEY (id)
);

insert into genre(id, name) values (1,'Ação');
insert into genre(id, name) values (2,'Aventura');
insert into genre(id, name) values (3,'Comédia');
insert into genre(id, name) values (4,'Drama');
insert into genre(id, name) values (5,'Ficção científica');
insert into genre(id, name) values (6,'Romance');
insert into genre(id, name) values (7,'Suspense');
insert into genre(id, name) values (8,'Terror');

insert into director(id, name) values (1,'Frank Darabonto');
insert into director(id, name) values (2,'Steven Spielberg');
insert into director(id, name) values (3,'George Lucas');
insert into director(id, name) values (4,'Quentin Tarantino');
insert into director(id, name) values (5,'Alfred Hitchcock');
insert into director(id, name) values (6,'Tim Burton');
insert into director(id, name) values (7,'Woody Allen');
insert into director(id, name) values (8,'James Cameron');
insert into director(id, name) values (9,'Francis Ford Coppola');
insert into director(id, name) values (10,'David Fincher');
insert into director(id, name) values (11,'Cristopher Nolan');

insert into actor(id, name) values (1,'Morgan Freeman');
insert into actor(id, name) values (2,'Tim Robbins');
insert into actor(id, name) values (3,'Bob Gunton');
insert into actor(id, name) values (4,'Brad Pitt');
insert into actor(id, name) values (5,'Edward Norton');
insert into actor(id, name) values (6,'Meat Loaf');
insert into actor(id, name) values (7,'Marlon Brandon');
insert into actor(id, name) values (8,'Al Pacino');
insert into actor(id, name) values (9,'James Caan');
insert into actor(id, name) values (10,'Matthew McConaughey');
insert into actor(id, name) values (11,'Ellen Burstyn');
insert into actor(id, name) values (12,'Mackenzie Foy');
insert into actor(id, name) values (13,'Anthony Perkins');
insert into actor(id, name) values (14,'Vera Miles');
insert into actor(id, name) values (15,'John Gavin');
insert into actor(id, name) values (16,'Janet Leigh');

insert into movie(id, name, genre_id, director_id) values (1, 'Um Sonho de Liberdade', 4, 1);
insert into movie(id, name, genre_id, director_id) values (2, 'O Poderoso Chefão', 4, 9);
insert into movie(id, name, genre_id, director_id) values (3, 'Clube da Luta', 4, 10);
insert into movie(id, name, genre_id, director_id) values (4, 'Interestelas', 5, 11);
insert into movie(id, name, genre_id, director_id) values (5, 'Psicose', 8, 5);

insert into movie_actor(movie_id, actor_id) values (1,1);
insert into movie_actor(movie_id, actor_id) values (1,2);
insert into movie_actor(movie_id, actor_id) values (1,3);
insert into movie_actor(movie_id, actor_id) values (2,7);
insert into movie_actor(movie_id, actor_id) values (2,8);
insert into movie_actor(movie_id, actor_id) values (2,9);
insert into movie_actor(movie_id, actor_id) values (3,4);
insert into movie_actor(movie_id, actor_id) values (3,5);
insert into movie_actor(movie_id, actor_id) values (3,6);
insert into movie_actor(movie_id, actor_id) values (4,10);
insert into movie_actor(movie_id, actor_id) values (4,11);
insert into movie_actor(movie_id, actor_id) values (4,12);
insert into movie_actor(movie_id, actor_id) values (5,13);
insert into movie_actor(movie_id, actor_id) values (5,14);
insert into movie_actor(movie_id, actor_id) values (5,15);
insert into movie_actor(movie_id, actor_id) values (5,16);

