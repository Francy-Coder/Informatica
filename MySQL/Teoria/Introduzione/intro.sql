/*Creo il database*/
CREATE DATABASE intro;

/*Creo la tabella Casa(id(pk), nome(opzionale), indirizzo)*/
CREATE TABLE intro.Casa(
	id int PRIMARY KEY,
    nome varchar(20),
    indirizzo varchar(100) NOT NULL
);

/*ES: Tabella persona & numeroCellulare & rubrica*/
CREATE TABLE intro.NumeroCellulare(
	cod int PRIMARY KEY,
    numero int NOT NULL,
    tipo varchar(20) DEFAULT "personale"
);

CREATE TABLE intro.Persona(
	cf varchar(16) PRIMARY KEY,
    nome varchar(20) NOT NULL, 
    cognome varchar(20) NOT NULL,
    email varchar(100) UNIQUE
);

CREATE TABLE intro.Rubrica(
	id int PRIMARY KEY,
	CONSTRAINT codPersona FOREIGN KEY (id) REFERENCES Persona(cf),
    CONSTRAINT codCell FOREIGN KEY (id) REFERENCES NumeroCellulare(cod)  
);
