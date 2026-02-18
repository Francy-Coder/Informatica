CREATE DATABASE Negozio;

CREATE TABLE Negozio.Prodotto(
	id int PRIMARY KEY,
    nome varchar(20),
    prezzo double
);

INSERT INTO Negozio.Prodotto (id, nome, prezzo) VALUES 
(1, 'Mouse', 19.99),
(2, 'Tastiera', 29.99),
(3, 'Monitor', 149.99),
(4, 'Stampante', 89.99),
(5, 'Webcam', 39.99),
(6, 'Cuffie', 24.99),
(7, 'Microfono', 59.99),
(8, 'Hard Disk', 79.99),
(9, 'SSD', 99.99),
(10, 'Chiavetta USB', 14.99),
(11, 'Router', 69.99),
(12, 'Notebook', 699.99);

SELECT * FROM Negozio.Prodotto;
SELECT nome, prezzo FROM Negozio.Prodotto;
SELECT * FROM Negozio.Prodotto WHERE nome = "Tastiera";
SELECT nome, prezzo * 0.85 AS ProdottoScontato FROM Negozio.Prodotto;
SELECT * FROM Negozio.Prodotto WHERE prezzo BETWEEN 19.99 AND 50;