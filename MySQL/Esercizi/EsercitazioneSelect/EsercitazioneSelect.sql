CREATE DATABASE Biblioteca;

CREATE TABLE Biblioteca.Utenti(
	id_utente varchar(20) PRIMARY KEY,
    nome varchar(20) NOT NULL,
    cognome varchar(20) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
	eta int CHECK(eta >= 14)
);

INSERT INTO Biblioteca.Utenti VALUES ("ABA", "Anna", "Agostina", "anna.agostina@gmail.com", 18);
INSERT INTO Biblioteca.Utenti VALUES ("LBR", "Luca", "Bianchi", "luca.bianchi@gmail.com", 14);
INSERT INTO Biblioteca.Utenti VALUES ("MRS", "Maria", "Rossi", "maria.rossi@outlook.com", 30);
INSERT INTO Biblioteca.Utenti VALUES ("GVR", "Giovanni", "Verdi", "giovanni.verdi@yahoo.com", 45);
INSERT INTO Biblioteca.Utenti VALUES ("FNT", "Francesca", "Neri", "francesca.neri@gmail.com", 19);

CREATE TABLE Biblioteca.Libri(
	id_libro VARCHAR(20) PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    autore VARCHAR(20) NOT NULL,
    isbn VARCHAR(100) UNIQUE,
    anno_pubblicazione date CHECK(anno_pubblicazione >= "1500-12-31")
);

INSERT INTO Biblioteca.Libri VALUES ("LBL", "Elden Ring", "FromSoftware", "ISBN001", "2020-01-10");
INSERT INTO Biblioteca.Libri VALUES ("L01", "Il Signore degli Anelli", "Tolkien", "ISBN002", "1954-05-14");
INSERT INTO Biblioteca.Libri VALUES ("L02", "1984", "Orwell", "ISBN003", '1949-09-19');
INSERT INTO Biblioteca.Libri VALUES ("L03", "Il Piccolo Principe", "Saint-Exupery", "ISBN004", "1943-02-18");
INSERT INTO Biblioteca.Libri VALUES ("L04", "Harry Potter", "Rowling", "ISBN005", "1997-07-23");

CREATE TABLE Biblioteca.Prestiti (
    id_prestito VARCHAR(20) PRIMARY KEY,
    id_utente VARCHAR(20),
    id_libro VARCHAR(20),
    data_prestito date NOT NULL,
    data_restituzione date,
    CONSTRAINT fk_prestiti_utente FOREIGN KEY (id_utente) REFERENCES Utenti(id_utente),
    CONSTRAINT fk_prestiti_libro FOREIGN KEY (id_libro) REFERENCES Libri(id_libro)
);

/* --- DQL_SELECT --- */
INSERT INTO Biblioteca.Prestiti VALUES ("PR1", "ABA", "LBL", "2025-01-10", NULL);
INSERT INTO Biblioteca.Prestiti VALUES ("PR2", "LBR", "L01", "2026-01-11", "2025-01-25");
INSERT INTO Biblioteca.Prestiti VALUES ("PR3", "MRS", "L02", "2023-01-15", NULL);
INSERT INTO Biblioteca.Prestiti VALUES ("PR4", "GVR", "L03", "2026-01-18", "2025-01-30");
INSERT INTO Biblioteca.Prestiti VALUES ("PR5", "FNT", "L04", "2022-01-20", NULL);

SELECT * FROM Biblioteca.Utenti;
SELECT * FROM Biblioteca.Libri;
SELECT * FROM Biblioteca.Utenti WHERE eta < 18;
SELECT titolo, autore FROM Biblioteca.Libri WHERE anno_pubblicazione > "2010-12-31";
SELECT nome, cognome, eta FROM Biblioteca.Utenti WHERE email LIKE '%@gmail.com';

/* --- Prof --- */
SELECT DISTINCT nome, cognome FROM Biblioteca.Utenti;

/* --- Esercitazione Select --- */
SELECT  * FROM Biblioteca.Utenti WHERE cognome LIKE "B%";
SELECT DISTINCT Libri.titolo, Prestiti.data_prestito FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro WHERE data_prestito > "2025-12-31";
SELECT Libri.titolo, Libri.autore, Prestiti.data_prestito FROM Biblioteca.Utenti INNER JOIN Biblioteca.Prestiti ON Utenti.id_utente = Prestiti.id_utente INNER JOIN Biblioteca.Libri ON Prestiti.id_libro = Libri.id_libro WHERE Utenti.email =  'nicolo.rossi@gigi.com';
SELECT Libri.titolo, Libri.autore FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro WHERE Prestiti.data_prestito BETWEEN '2021-01-01' AND '2025-12-31';
SELECT DISTINCT Libri.titolo, Utenti.nome, Utenti.eta FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro INNER JOIN Biblioteca.Utenti ON Prestiti.id_utente = Utenti.id_utente WHERE Utenti.eta BETWEEN 18 AND 24;
SELECT Libri.titolo, Libri.autore, Utenti.nome, Utenti.cognome FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro INNER JOIN Biblioteca.Utenti ON Prestiti.id_utente = Utenti.id_utente WHERE Prestiti.data_prestito BETWEEN '2020-01-01' AND '2020-12-31';
