CREATE DATABASE Biblioteca;

CREATE TABLE Biblioteca.Utenti(
	id_utente varchar(20) PRIMARY KEY,
    nome varchar(20) NOT NULL,
    cognome varchar(20) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
	eta int CHECK(eta >= 14)
);

INSERT INTO Biblioteca.Utenti VALUES ("ABA", "Anna", "Agostina", "anna.agostina@gmail.com", 18);
INSERT INTO Biblioteca.Utenti VALUES ("LBR", "Luca", "Bianchi", "luca.bianchi@gmail.com", 22);
INSERT INTO Biblioteca.Utenti VALUES ("MRS", "Maria", "Rossi", "maria.rossi@gmail.com", 30);
INSERT INTO Biblioteca.Utenti VALUES ("GVR", "Giovanni", "Verdi", "giovanni.verdi@gmail.com", 45);
INSERT INTO Biblioteca.Utenti VALUES ("FNT", "Francesca", "Neri", "francesca.neri@gmail.com", 19);

CREATE TABLE Biblioteca.Libri(
	id_libro VARCHAR(20) PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    autore VARCHAR(20) NOT NULL,
    isbn VARCHAR(100) UNIQUE,
    anno_publicazione int CHECK(anno_publicazione >= 1500)
);

INSERT INTO Biblioteca.Libri VALUES ("LBL", "Elden Ring", "FromSoftware", "ISBN001", 2020);
INSERT INTO Biblioteca.Libri VALUES ("L01", "Il Signore degli Anelli", "Tolkien", "ISBN002", 1954);
INSERT INTO Biblioteca.Libri VALUES ("L02", "1984", "Orwell", "ISBN003", 1949);
INSERT INTO Biblioteca.Libri VALUES ("L03", "Il Piccolo Principe", "Saint-Exupery", "ISBN004", 1943);
INSERT INTO Biblioteca.Libri VALUES ("L04", "Harry Potter", "Rowling", "ISBN005", 1997);

CREATE TABLE Biblioteca.Prestiti (
    id_prestito VARCHAR(20) PRIMARY KEY,
    id_utente VARCHAR(20),
    id_libro VARCHAR(20),
    data_prestito DATE NOT NULL,
    data_restituzione DATE,
    CONSTRAINT fk_prestiti_utente FOREIGN KEY (id_utente) REFERENCES Utenti(id_utente),
    CONSTRAINT fk_prestiti_libro FOREIGN KEY (id_libro) REFERENCES Libri(id_libro)
);

INSERT INTO Biblioteca.Prestiti VALUES ("PR1", "ABA", "LBL", "2025-01-10", NULL);
INSERT INTO Biblioteca.Prestiti VALUES ("PR2", "LBR", "L01", "2025-01-11", "2025-01-25");
INSERT INTO Biblioteca.Prestiti VALUES ("PR3", "MRS", "L02", "2025-01-15", NULL);
INSERT INTO Biblioteca.Prestiti VALUES ("PR4", "GVR", "L03", "2025-01-18", "2025-01-30");
INSERT INTO Biblioteca.Prestiti VALUES ("PR5", "FNT", "L04", "2025-01-20", NULL);
