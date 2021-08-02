ALTER TABLE tb_user ADD CONSTRAINT user_email_ukey UNIQUE (email);


CREATE TABLE movie_rating (
	id serial NOT NULL,
	movie_id int NOT NULL,
	rating float NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT movie_rating_pkey PRIMARY KEY (id),
	CONSTRAINT movie_rating_movie_user_ukey UNIQUE (movie_id, user_id), 
	CONSTRAINT movie_rating_movie_fkey FOREIGN KEY(movie_id) REFERENCES movie(id),
	CONSTRAINT movie_rating_user_fkey FOREIGN KEY(user_id) REFERENCES tb_user(id)
);


