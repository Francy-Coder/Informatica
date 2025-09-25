# Creare un gioco di ruolo testuale base

- Scenario:
Il giocatore dovrà interagire con un mondo virtuale composto da diverse stanze, ognuna con caratteristiche uniche. In ogni stanza, il giocatore potrà compiere azioni come muoversi, combattere mostri ed esplorare.

- Una “Entità” rappresenta un elemento "vivente" nel gioco (Personaggio e Mostro). E’ caratterizzata dal nome, punti vita, forza, difesa (fisica e/o magica). Oltre alle funzionalità  getter/setter e toString, ci sono anche i metodi per attaccare e subireDanni, di cui non sappiamo ancora come saranno implementati.

- Un “Oggetto” rappresenta un elemento "non vivente" nel gioco (armi, armature e pozioni). E’ caratterizzata dal nome, la categoria e la descrizione. Offre le funzionalità Getter/Setter e toString.

- Una “Arma” è derivata da oggetto e aggiunge il tipoDanno (fisico o magico) e il danno. Offre i metodi Getter/Setter e toString.

- Una “Armatura” è derivata da oggetto e aggiunge il tipoDifesa (fisico o magico) e la difesa. Offre i metodi Getter/Setter e toString.

- Una “Pozione” è derivata da oggetto e aggiunge i punti ferita che guarisce. Offre i metodi Getter/Setter e toString.

- Un “Mostro” è derivato dalla classe Entità, ereditando gli attributi e i metodi. Aggiungerà caratteristiche specifiche come il tipo di attacco (fisico o magico) e la quantità di esperienza che il giocatore guadagna sconfiggendolo. Oltre alle funzionalità  getter/setter e toString implementi i metodi della classe Entità. Il calcolo del danno subito è dato dal danno ricevuto - la difesa. Inoltre il mostro una volta che muori potrebbe lasciare un bottino, la percentuale è data da il livello *10%. Ogni mostro ha un bottino fissato quando si crea il mostro che può essere un’arma, un’armatura o una pozione.

- Un “Personaggio” è derivato dalla classe Entità, ereditando gli attributi e i metodi. Aggiungerà caratteristiche specifiche come livello, armi, armature, zaino pozioni (max 5) e la quantità di esperienza che il giocatore deve guadagnare per passare di livello. Oltre alle funzionalità getter/setter e toString implementare i metodi della classe Entità. Il calcolo del danno subito è dato dal danno ricevuto - il livello di difesa. Il livello di difesa è dato dalla difesa base + la difesa dell’armatura. Attenzione che si distingue tra difesa fisica e magica. I danni totali sono dati dal danno base + il danno dell’arma utilizzata. Anche in questo caso cambia tra fisico e magico.
Ogni volta che il personaggio passa di livello il personaggio aggiunge da 1 a 10 punti ferita estratti a caso. Il giocatore può utilizzare una sola arma e armatura alla volta. Il personaggio può avere al massimo 2 armi e armature. Inoltre ha un metodo esamina, che restituisce la descrizione della stanza.

- Una “Stanza” è caratterizzata da uno o più mostri (opzionale per un massimo di 5) e la descrizione. Offre i metodi Getter/Setter e toString.

- Un’avventura è composta da una a N stanze e un giocatore e per vincere il giocatore deve superare tutte le stanze. Se ci sono dei mostri il giocare non può passare nella stanza superiore, ma può tornare nella stanza precedente.

- Il giocatore fa sempre e solo un’azione alla volta che può essere attaccare, cambiare arma, cambiare armatura o usare una pozione.  

- Combattimento: Quando il giocatore incontra un mostro, inizia una sequenza di combattimento in cui il giocatore e il mostro si alternano nell'attaccare. Il giocatore può rinunciare all’attacco per bere una pozione oppure per ritirarsi nella stanza precedente.

# Funzionamento del Gioco:
Il gioco inizia con la creazione del Personaggio, i cui parametri punti vita, forza, difesa  sono generati a caso. Inoltre iniziano al livello 1 e senza oggetti.

Il programma deve generare in automatico l’avventura, con alcune indicazione scelte dall’utente quali il numero massimo di stanze. 
Generazione delle stanze:
   La descrizione della stanza è opzione. Le stanze sono generate dalla prima fino all’ultima e 
   per ognuna vengono generati i mostri che sono contenuti.
Generazione dei mostri: 
I nomi dei mostri sono presi da una lista di nomi preimpostata, inoltre i mostri sono dello stesso livello massimo della stanza e il loro numero non può superare il numero della stanza (es. nella quinta stanza ci possono essere massimo 5 mostri con livello da 1 a 5). Tutti i mostri iniziano con i punti ferita basi, da 1 a 7. Per ogni livello si aggiunge da 1 a 10 punti.
Generato il Personaggio e l’Avventura il gioco inizia. Il giocatore può scegliere di entrare in una stanza, usare un oggetto in suo possesso o lasciare l’avventura. Entrato nella stanza il gioco si svolge con quanto descritto sopra. Nota: ogni volta che il Personaggio subisce un danno deve essere stampato a video i danni ricevuti e i punti vita rimasti, mentre tutte le volte che attacca deve essere stampato i danni e il tipo di danno che fa e quanti danni subisce il mostro.
Esempio:
Personaggio Dhort: attacca con un danno fisico di 14 e infligge 10 ferisci.
Mostro Serpir: attacca e con un danno magico di 60, Dhort rimane con 10 punti ferita.

Al progetto aggiungere:
Il personaggio ha uno zaino nel quale contenere gli oggetti
Il personaggio può impostare due set di equipaggimento composta da un arma e un'armatura.
