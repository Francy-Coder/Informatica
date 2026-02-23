CREATE DATABASE Biblioteca;

CREATE TABLE Biblioteca.Utenti(
	id_utente INT PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    cognome VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    eta INT CHECK (eta >= 14)
);

INSERT INTO Biblioteca.Utenti VALUES (1, 'Mario', 'Rossi', 'mario.rossi@gmail.com', 20),
(2, 'Anna', 'Bianchi', 'anna.bianchi@gmail.com', 25),
(3, 'Luca', 'Verdi', 'luca.verdi@gmail.com', 30),
(4, 'Giulia', 'Neri', 'giulia.neri@gmail.com', 19),
(5, 'Marco', 'Gialli', 'marco.gialli@gmail.com', 40);

CREATE TABLE Biblioteca.Libri(
	id_libro INT PRIMARY KEY,
    titolo VARCHAR(50) NOT NULL,
    autore VARCHAR(50) NOT NULL,
    isbn VARCHAR(100) UNIQUE,
    anno_pubblicazione INT CHECK(anno_pubblicazione >= 1500)
);

INSERT INTO Biblioteca.Libri VALUES (1, 'Elden Ring', 'From Software', '0231-3213-4213', 2022),
(2, 'Il Signore degli Anelli', 'J.R.R. Tolkien', '978-88-452-9000-1', 1954),
(3, '1984', 'George Orwell', '978-0-452-28423-4', 1949),
(4, 'Divina Commedia', 'Dante Alighieri', "232-3231-434-343", 1500),
(5, 'Il Nome della Rosa', 'Umberto Eco', '978-88-06-13250-5', 1980);

CREATE TABLE Biblioteca.Prestiti(
	id_prestito INT PRIMARY KEY,
	id_utente INT,
    id_libro INT,
	data_prestito DATE NOT NULL,
    data_restituzione DATE,
    CONSTRAINT fk_prestiti_utente FOREIGN KEY (id_utente) REFERENCES Biblioteca.Utenti(id_utente),
    CONSTRAINT fk_prestiti_libro FOREIGN KEY (id_libro) REFERENCES Biblioteca.Libri(id_libro)
);

INSERT INTO Biblioteca.Prestiti VALUES (1, 1, 1, '2020-10-30', NULL),
(2, 2, 3, '2021-03-15', '2021-03-25'),
(3, 3, 2, '2022-07-01', NULL),
(4, 4, 5, '2023-01-10', '2023-01-20'),
(5, 5, 4, '2024-05-05', NULL);

SELECT * FROM Biblioteca.Utenti;
SELECT * FROM Biblioteca.Prestiti;
SELECT * FROM Biblioteca.Utenti WHERE eta < 18;
SELECT * FROM Biblioteca.Libri WHERE anno_pubblicazione > 2010;
SELECT nome, cognome, eta FROM Biblioteca.Utenti WHERE email LIKE "%@gmail%";

SELECT  * FROM Biblioteca.Utenti WHERE cognome LIKE "B%";
SELECT DISTINCT Libri.titolo, Prestiti.data_prestito FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro WHERE data_prestito > "2025-12-31";
SELECT Libri.titolo, Libri.autore, Prestiti.data_prestito FROM Biblioteca.Utenti INNER JOIN Biblioteca.Prestiti ON Utenti.id_utente = Prestiti.id_utente INNER JOIN Biblioteca.Libri ON Prestiti.id_libro = Libri.id_libro WHERE Utenti.email =  'nicolo.rossi@gigi.com';
SELECT Libri.titolo, Libri.autore FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro WHERE Prestiti.data_prestito BETWEEN '2021-01-01' AND '2025-12-31';
SELECT DISTINCT Libri.titolo, Utenti.nome, Utenti.eta FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro INNER JOIN Biblioteca.Utenti ON Prestiti.id_utente = Utenti.id_utente WHERE Utenti.eta BETWEEN 18 AND 24;
SELECT Libri.titolo, Libri.autore, Utenti.nome, Utenti.cognome FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro INNER JOIN Biblioteca.Utenti ON Prestiti.id_utente = Utenti.id_utente WHERE Prestiti.data_prestito BETWEEN '2020-01-01' AND '2020-12-31';

SELECT * FROM Biblioteca.Utenti WHERE eta > 25;
SELECT * FROM Biblioteca.Utenti WHERE nome LIKE "F%";
SELECT * FROM Biblioteca.Utenti WHERE email LIKE "%gmail%";
SELECT * FROM Biblioteca.Utenti WHERE cognome LIKE "%lli";
SELECT * FROM Biblioteca.Utenti WHERE eta BETWEEN 18 AND 30;
SELECT DISTINCT autore FROM Biblioteca.Libri;
SELECT * FROM Biblioteca.Libri WHERE titolo LIKE "%amore%";
SELECT * FROM Biblioteca.Libri WHERE anno_pubblicazione < 1900;
SELECT * FROM Biblioteca.Libri WHERE isbn IS NOT NULL;
SELECT * FROM Biblioteca.Prestiti WHERE data_restituzione IS NULL;
SELECT * FROM Biblioteca.Prestiti WHERE data_prestito BETWEEN '2024-01-01' AND '2024-12-31';
SELECT Utenti.nome, Utenti.cognome, Prestiti.data_prestito FROM Biblioteca.Utenti INNER JOIN Biblioteca.Prestiti ON Utenti.id_utente = Prestiti.id_utente;
SELECT Libri.titolo, Libri.autore FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro;
SELECT DISTINCT Libri.titolo FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro;
SELECT Utenti.nome, Libri.Titolo FROM Biblioteca.Utenti INNER JOIN Biblioteca.Prestiti ON Utenti.id_utente = Prestiti.id_utente INNER JOIN Biblioteca.Libri ON Prestiti.id_libro = Libri.id_libro;
SELECT Utenti.cognome, Prestiti.data_prestito FROM Biblioteca.Utenti INNER JOIN Biblioteca.Prestiti ON Utenti.id_utente = Prestiti.id_utente WHERE Utenti.cognome = "Galli";
SELECT Libri.titolo, Libri.autore, Libri.anno_pubblicazione FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro WHERE Libri.titolo LIKE "%storia%";
SELECT DISTINCT Utenti.email, Prestiti.data_prestito, Prestiti.data_restituzione FROM Biblioteca.Utenti INNER JOIN Biblioteca.Prestiti ON Utenti.id_utente = Prestiti.id_utente; 
SELECT Libri.titolo, Libri.anno_pubblicazione FROM Biblioteca.Libri INNER JOIN Biblioteca.Prestiti ON Libri.id_libro = Prestiti.id_libro WHERE Libri.anno_pubblicazione BETWEEN 1500 AND 1700;



