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

-- Esercizitazione Sicurezza
ALTER TABLE  Biblioteca.Utenti ADD psw VARCHAR(20) NOT NULL CHECK (LENGTH(psw) >= 8);

UPDATE Biblioteca.Utenti SET psw = 'passwordABA' WHERE id_utente = "ABA";
UPDATE Biblioteca.Utenti SET psw = 'passwordLBR' WHERE id_utente = "LBR";
UPDATE Biblioteca.Utenti SET psw = 'passwordMRS' WHERE id_utente = "MRS";
UPDATE Biblioteca.Utenti SET psw = 'passwordGVR' WHERE id_utente = "GVR";
UPDATE Biblioteca.Utenti SET psw = 'passwordFNT' WHERE id_utente = "FNT";
