# Negozio Online
Svilupatta in php e basata sul utilizzo di file JSON per la memorizzazione dei dati.

## Scelte Progettuali
### Classe prodotti.json
Attributi:
    - nome
    - categoria
    - descrizione
    - quantità disponibile

### Classe utenti.json
Attributi:
    - ID
    - Nome
    - Cognome
    - Login
    - Password [approfondimento personale: la password non siano mai salvate in chiaro, ma memorizzate come hash sicuri]

### Classe paginaLogin.php
Funzionalità per accedere al sitoWeb

### Classe funzionalitàCarello.php (Lato Server)
Funzionalità per:
    - Visuallizare un prodotto
    - Aggiungere un prodotto
    - Rimuovere un prodotto

### Classe sitoWeb.php
Contiene: 
- la lista di prodotti e il metodo per filtral
- un link per accedere al sitoWeb 
- la possibilita di visuallizare, aggiungere, rimuovere prodotti
    - aggiungere e rimuovere può essere contenuto all'interno di visuallizare ❓


## Funzionalità
- Tutti possono vedere i prodotti anche se non sono loggati
	- Possibilità di filtrare l'elenco di prodotti per categorie
- Solo gli utenti loggati possono visuallizare, aggiungere e rimuovere i prodotti al carello
	- presenza di una pagina login, l'utente inserisce le proprie credenziali
		- se correte, viene aperta una sessione PHP
			- la sessione contiene le informazioni relative all'utente e al suo carello


## Attenzioni da adottare
- Continuità tra le pagine
- Oltre alla protezione delle credenziali, occorre validare tutti gli input provenienti dall’utente.
