CREATE DATABASE Biblioteca;

CREATE TABLE Biblioteca.Utenti(
	id_utente varchar(20) PRIMARY KEY,
    nome varchar(20) NOT NULL,
    cognome varchar(20) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
	eta int CHECK(eta >= 14)
);

INSERT INTO Biblioteca.Utenti VALUES ("ABA", "Anna", "Agostina", "anna.agostina@gmail.com", 18),
("LBR", "Luca", "Bianchi", "luca.bianchi@gmail.com", 14),
("MRS", "Maria", "Rossi", "maria.rossi@outlook.com", 30),
("GVR", "Giovanni", "Verdi", "giovanni.verdi@yahoo.com", 45),
("FNT", "Francesca", "Neri", "francesca.neri@gmail.com", 22);

CREATE TABLE Biblioteca.Libri(
	id_libro VARCHAR(20) PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    autore VARCHAR(50) NOT NULL,
    isbn VARCHAR(100) UNIQUE,
    anno_pubblicazione INT CHECK(anno_pubblicazione >= 1500)
);

INSERT INTO Biblioteca.Libri VALUES ("L01", "Elden Ring", "FromSoftware", "ISBN001", 2020),
("L02", "Il Signore degli Anelli", "Tolkien", "ISBN002", 1954),
("L03", "1984", "Orwell", "ISBN003", 1949),
("L04", "Le città invisibili", "Italo Calvino", "ISBN004", 1972),
("L05", "Harry Potter", "Rowling", "ISBN005", 1997);

CREATE TABLE Biblioteca.Prestiti (
    id_prestito VARCHAR(20) PRIMARY KEY,
    id_utente VARCHAR(20),
    id_libro VARCHAR(20),
    data_prestito date NOT NULL,
    data_restituzione date,
    CONSTRAINT fk_prestiti_utente FOREIGN KEY (id_utente) REFERENCES Utenti(id_utente),
    CONSTRAINT fk_prestiti_libro FOREIGN KEY (id_libro) REFERENCES Libri(id_libro)
);

INSERT INTO Biblioteca.Prestiti VALUES ('PR1', 'ABA', 'L01', '2025-01-10', NULL),
('PR2', 'LBR', 'L01', '2026-01-11', '2026-01-25'),
('PR3', 'MRS', 'L02', '2023-01-15', NULL),
('PR4', 'GVR', 'L03', '2026-01-18', '2026-01-30'),
('PR5', 'FNT', 'L04', '2022-01-20', NULL);

/* --- Esercitazione IN & IS + Esempi EQUI JOIN --- */
SELECT * FROM Biblioteca.Utenti WHERE eta IN (10, 15, 22, 50);
SELECT Utenti.nome, Utenti.cognome, Libri.titolo, Libri.autore, Prestiti.data_prestito FROM Biblioteca.Utenti, Biblioteca.Prestiti, Biblioteca.Libri WHERE Utenti.id_utente = Prestiti.id_utente AND Prestiti.id_libro = Libri.id_libro AND Libri.autore IN ("Italo Calvino", "Umberto Eco", "Elena Ferrante");
SELECT Libri.titolo, Libri.anno_pubblicazione, Prestiti.data_prestito FROM Biblioteca.Libri, Biblioteca.Prestiti WHERE Libri.id_libro = Prestiti.id_libro AND Libri.anno_pubblicazione IN (2020, 2022, 2026);
SELECT Utenti.nome, Utenti.cognome, Libri.titolo, Libri.isbn, Prestiti.data_prestito FROM Biblioteca.Utenti, Biblioteca.Libri, Biblioteca.Prestiti WHERE Utenti.id_utente = Prestiti.id_utente AND Libri.id_libro = Prestiti.id_libro AND Libri.isbn IS NOT NULL;
SELECT * FROM Biblioteca.Prestiti WHERE data_restituzione IS NULL;
SELECT * FROM Biblioteca.Prestiti WHERE data_restituzione IS NOT NULL;
SELECT Libri.titolo, Libri.autore, Prestiti.data_prestito FROM Biblioteca.Libri, Biblioteca.Prestiti WHERE Libri.id_libro = Prestiti.id_libro AND data_prestito IS NULL;

/* --- Esercitazione SQL GROUP BY & Aggregazioni --- */
SELECT Utenti.nome, Utenti.cognome, COUNT(*) AS numero_prestiti_utenti FROM Biblioteca.Utenti INNER JOIN Biblioteca.Prestiti ON Utenti.id_utente = Prestiti.id_utente GROUP BY Utenti.nome, Utenti.cognome;
SELECT Libri.titolo, Libri.autore, COUNT(*) AS numero_prestiti_libri FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro GROUP BY Libri.titolo, Libri.autore;
SELECT AVG(eta) AS eta_media FROM Biblioteca.Utenti;
SELECT Utenti.eta, COUNT(*) AS numero_utenti FROM Biblioteca.Utenti GROUP BY Utenti.eta;
SELECT Libri.autore, COUNT(*) AS numero_prestiti FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro GROUP BY Libri.autore;

-- eta minima, massima e media degli utenti che hanno effettuato alemeno un prestito
SELECT MIN(Utenti.eta) AS eta_minima, AVG(Utenti.eta) AS eta_media, MAX(Utenti.eta) AS eta_massima FROM Biblioteca.Utenti INNER JOIN Biblioteca.Prestiti ON Utenti.id_utente = Prestiti.id_utente;
