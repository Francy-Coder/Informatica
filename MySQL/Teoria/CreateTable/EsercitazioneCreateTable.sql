CREATE DATABASE Biblioteca;

CREATE TABLE Biblioteca.Utenti(
	id_utente varchar(20) PRIMARY KEY,
    nome varchar(20) NOT NULL,
    cognome varchar(20) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
	eta int CHECK(eta >= 14)
);

CREATE TABLE Biblioteca.Libri(
	id_libro VARCHAR(20) PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    autore VARCHAR(20) NOT NULL,
    isbn VARCHAR(100) UNIQUE,
    anno_publicazione int CHECK(anno_publicazione>= 1500)
);

CREATE TABLE Biblioteca.Prestiti (
    id_prestito VARCHAR(20) PRIMARY KEY,
    id_utente VARCHAR(20),
    id_libro VARCHAR(20),
    data_prestito DATE NOT NULL,
    data_restituzione DATE,
    CONSTRAINT fk_prestiti_utente FOREIGN KEY (id_utente) REFERENCES Utenti(id_utente),
    CONSTRAINT fk_prestiti_libro FOREIGN KEY (id_libro) REFERENCES Libri(id_libro)
);

