ALTER TABLE movie ADD CONSTRAINT movie_director FOREIGN KEY (director_id) REFERENCES director(id);
ALTER TABLE movie ADD CONSTRAINT movie_genre FOREIGN KEY (genre_id) REFERENCES genre(id);



