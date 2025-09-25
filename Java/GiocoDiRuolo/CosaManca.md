# Parti Mancanti:
Da fare con polimorfismo
- Il personaggio ha uno zaino nel quale contenere gli oggetti
- Il personaggio può impostare due set di equipaggimento composta da un arma e un'armatura.

Inoltre il mostro una volta che muori potrebbe lasciare un bottino,
la percentuale è data da il livello *10%. Ogni mostro ha un bottino fissato quando si crea il mostro che può essere un’arma, un’armatura o una pozione.

Ogni volta che il personaggio passa di livello il personaggio aggiunge da 1 a 10 punti ferita estratti a caso.

Il giocatore può utilizzare una sola arma e armatura alla volta.

Un’avventura è composta da una a N stanze e un giocatore e per vincere il giocatore deve superare tutte le stanze.
Se ci sono dei mostri il giocare non può passare nella stanza superiore, ma può tornare nella stanza precedente.

Il giocatore fa sempre e solo un’azione alla volta che può essere attaccare, cambiare arma, cambiare armatura o usare una pozione

Combattimento: Quando il giocatore incontra un mostro, inizia una sequenza di combattimento in cui il giocatore e il mostro si alternano nell'attaccare.
Il giocatore può rinunciare all’attacco per bere una pozione oppure per ritirarsi nella stanza precedente.

I nomi dei mostri sono presi da una lista di nomi preimpostata, inoltre i mostri sono dello stesso livello massimo della stanza e il loro numero non può superare il numero della stanza
(es. nella quinta stanza ci possono essere massimo 5 mostri con livello da 1 a 5). Tutti i mostri iniziano con i punti ferita basi, da 1 a 7. Per ogni livello si aggiunge da 1 a 10 punti.

ogni volta che il Personaggio subisce un danno deve essere stampato a video i danni ricevuti e i punti vita rimasti,
mentre tutte le volte che attacca deve essere stampato i danni e il tipo di danno che fa e quanti danni subisce il mostro.

# Codici Insicuri:
Personaggio
- Muoversi / Esplorare

Entita
- Elemento "Vivente"

Oggetto
- Elemento "Non vivente"

Personaggio
- Il calcolo del danno subito è dato dal danno ricevuto - il livello di difesa.
  Il livello di difesa è dato dalla difesa base + la difesa dell’armatura. Attenzione che si distingue tra difesa fisica e magica.
  I danni totali sono dati dal danno base + il danno dell’arma utilizzata. Anche in questo caso cambia tra fisico e magico.

Personaggio / Mostro

- Metodo attaco (o subisci danni (non sicuro)) che stampa il nome sbaggliato

# Situazioni delle Classi:
Classi Finite:
Oggetto (?)
Arma
Armatura
Entita (?)

Classi Non Finite:
Personaggio
Mostro
Stanza
Main

# Cosa Sistemare?
Cura nel main, morte del personaggio quando gli hp scendono sotto lo 0
