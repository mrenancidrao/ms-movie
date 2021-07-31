CREATE TABLE tb_user (
	id serial NOT NULL,
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	active boolean NOT NULL,
	CONSTRAINT tb_user_pkey PRIMARY KEY (id)
);

CREATE TABLE tb_role (
	id serial NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT tb_role_pkey PRIMARY KEY (id)
);

CREATE TABLE tb_user_role (
	id serial NOT NULL,
	user_id int NOT NULL,
	role_id int NOT NULL,
	CONSTRAINT tb_user_role_pkey PRIMARY KEY (id)
);

INSERT INTO tb_user (name, email, password, active) VALUES ('Renan Cidrão', 'mrenancidrao@gmail.com', '$2y$12$g6V03al6xIMCCmXhXXKtCOck7DkzOj2431B24pH7sttzRQtT8D0I2', true);
INSERT INTO tb_user (name, email, password, active) VALUES ('Cecília Cidrão', 'ceciliacidrao@gmail.com', '$2y$12$g6V03al6xIMCCmXhXXKtCOck7DkzOj2431B24pH7sttzRQtT8D0I2', true);

INSERT INTO tb_role (name) VALUES ('ADMIN');
INSERT INTO tb_role (name) VALUES ('USER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

