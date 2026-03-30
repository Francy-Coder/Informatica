CREATE DATABASE Azienda;

CREATE TABLE Azienda.Dipartimento(
    codice VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    sede VARCHAR(50) NOT NULL,
    direttore INT NULL -- NOT NULL ?
);

CREATE TABLE Azienda.Impiegato(
    matricola INT PRIMARY KEY,
    cognome VARCHAR(20) NOT NULL,
    stipendio INT NOT NULL,
    dipartimento VARCHAR(20) NOT NULL
);

CREATE TABLE Azienda.Progetto(
    sigla VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    bilancio INT NOT NULL,
    responsabile INT NOT NULL
);

CREATE TABLE Azienda.Partecipazione(
    impiegato INT,
    progetto VARCHAR(20),
    PRIMARY KEY (impiegato, progetto)
);

-- Vincoli di riferimento 
ALTER TABLE Azienda.Dipartimento ADD CONSTRAINT fk_direttore FOREIGN KEY (direttore) REFERENCES Azienda.Impiegato(matricola);

ALTER TABLE Azienda.Impiegato ADD CONSTRAINT fk_dipartimento FOREIGN KEY (dipartimento) REFERENCES Azienda.Dipartimento(codice);

ALTER TABLE Azienda.Progetto ADD CONSTRAINT fk_responsabile FOREIGN KEY (responsabile) REFERENCES Azienda.Impiegato(matricola);

ALTER TABLE Azienda.Partecipazione ADD CONSTRAINT fk_impiegato FOREIGN KEY (impiegato) REFERENCES Azienda.Impiegato(matricola);
ALTER TABLE Azienda.Partecipazione ADD CONSTRAINT fk_progetto FOREIGN KEY (progetto) REFERENCES Azienda.Progetto(sigla);

-- Inserimento Dati
INSERT INTO Azienda.Dipartimento (codice, nome, sede, direttore) VALUES
('NO', 'Nord', 'Milano', NULL),
('SU', 'Sud', 'Napoli', NULL),
('IS', 'Isole', 'Palermo', NULL);

INSERT INTO Azienda.Impiegato (matricola, cognome, stipendio, dipartimento) VALUES
(101, 'Sili', 60, 'NO'),
(102, 'Rossi', 40, 'NO'),
(103, 'Neri', 40, 'NO'),
(201, 'Neri', 40, 'SU'),
(202, 'Verdi', 50, 'SU'),
(301, 'Bisi', 70, 'IS');

UPDATE Azienda.Dipartimento SET direttore = 101 WHERE codice = 'NO';
UPDATE Azienda.Dipartimento SET direttore = 201 WHERE codice = 'SU';
UPDATE Azienda.Dipartimento SET direttore = 301 WHERE codice = 'IS';

INSERT INTO Azienda.Progetto (sigla, nome, bilancio, responsabile) VALUES
('Alpha', 'Vendite', 30, 202),
('Beta', 'Inventario', 50, 301),
('Gamma', 'Distribuzione', 18, 301);

INSERT INTO Azienda.Partecipazione (impiegato, progetto) VALUES
(101, 'Alpha'),
(101, 'Beta'),
(103, 'Alpha'),
(103, 'Beta'),
(201, 'Beta'),
(202, 'Beta');

-- Interrogazione SQL
/*
8. Trovare cognome dei direttori di dipartimento e dei responsabili di progetto.
9. Trovare nomi dei dipartimenti in cui lavorano impiegati che guadagnano pi`u di 60.
10. Trovare nomi dei dipartimenti in cui tutti gli impiegati guadagnano pi`u di 60.
11. Trovare cognome degli impiegati di stipendio massimo.
12. Trovare matricola e cognome degli impiegati che non lavorano a nessun progetto.
13. Trovare matricola e cognome degli impiegati che lavorano a pi`u di un progetto.
14. Trovare matricola e cognome degli impiegati che lavorano a un solo progetto.
15. Trovare per ciascun dipartimento lo stipendio medio degli impiegati che vi lavorano.
16. Trovare matricola e cognome degli impiegati che hanno lo stipendio superiore almeno del
10% rispetto allo stipendio medio del loro dipartimento.
*/

-- 1. Trovare matricola e cognome degli impiegati che guadagnano pi`u di 50.
SELECT matricola, cognome FROM Impiegato WHERE stipendio > 50;

-- 2. Trovare cognome e stipendio degli impiegati che lavorano a Roma.
SELECT Impiegato.cognome, Impiegato.stipendio FROM Azienda.Impiegato INNER JOIN Azienda.Dipartimento ON Impiegato.dipartimento = Dipartimento.codice WHERE Dipartimento.sede = 'Roma';
SELECT DISTINCT Cognome, Stipendio FROM IMPIEGATO, DIPARTIMENTO WHERE Dipartimento=Codice AND Sede='Roma';

-- 3. Trovare cognome degli impiegati e nome del dipartimento in cui lavorano.
SELECT Impiegato.cognome, Dipartimento.nome FROM Azienda.Impiegato INNER JOIN Azienda.Dipartimento ON Impiegato.dipartimento = Dipartimento.codice;
SELECT Cognome AS Impiegato, Nome AS Dipartimento FROM IMPIEGATO, DIPARTIMENTO WHERE Dipartimento = Codice;

-- 4. Trovare cognome degli impiegati che sono direttori di dipartimento.
SELECT Impiegato.cognome FROM Azienda.Impiegato INNER JOIN Azienda.Dipartimento ON Impiegato.dipartimento = Dipartimento.codice WHERE Impiegato.matricola = Dipartimento.direttore;
SELECT Cognome FROM IMPIEGATO, DIPARTIMENTO WHERE Matricola = Direttore;
SELECT Cognome FROM IMPIEGATO WHERE EXISTS (SELECT * FROM DIPARTIMENTO WHERE Direttore = Matricola);
SELECT Cognome FROM IMPIEGATO WHERE Matricola IN (SELECT Direttore FROM DIPARTIMENTO);

-- 5. Trovare i nomi dei progetti e i cognomi dei responsabili.
SELECT Progetto.nome, Impiegato.cognome AS cognomeResponsabili FROM Azienda.Progetto INNER JOIN Azienda.Impiegato ON Progetto.responsabile = Impiegato.matricola;
SELECT Nome AS Progetto, Cognome AS Responsabile FROM IMPIEGATO, PROGETTO WHERE Matricola = Responsabile;
SELECT Nome AS Progetto, Cognome AS Responsabile FROM IMPIEGATO JOIN PROGETTO ON Matricola = Responsabile;

-- 6. Trovare i nomi dei progetti con bilancio maggiore di 100 e i cognomi degli impiegati che lavorano su di essi.
SELECT Progetto.nome, Impiegato.cognome FROM Azienda.Progetto INNER JOIN Azienda.Partecipazione ON Progetto.sigla = Partecipazione.progetto INNER JOIN Azienda.Impiegato ON Partecipazione.impiegato = Impiegato.matricola WHERE Progetto.bilancio > 100;
SELECT Nome, Cognome FROM IMPIEGATO, PROGETTO, PARTECIPAZIONE WHERE Sigla = Progetto AND Matricola = Impiegato AND Bilancio > 100 ORDER BY Nome;

-- Da verificare
-- 7. Trovare cognome degli impiegati che guadagnano pi`u del loro direttore di dipartimento. <-- Da Rivedere
SELECT i.cognome
FROM Azienda.Impiegato i
JOIN Azienda.Dipartimento d ON i.dipartimento = d.codice
JOIN Azienda.Impiegato direttore ON d.direttore = direttore.matricola
WHERE i.stipendio > direttore.stipendio;

SELECT DISTINCT imp.Cognome FROM IMPIEGATO imp, IMPIEGATO dir, DIPARTIMENTO WHERE imp.DIPARTIMENTO = Codice AND dir.Matricola = Direttore AND imp.Stipendio > dir.Stipendio
