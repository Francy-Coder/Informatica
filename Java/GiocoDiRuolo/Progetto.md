Il progetto non è aggiornato, fa riferimento ai codici 1.0
# Entità
- Una “Entità” rappresenta un elemento "vivente" nel gioco (Personaggio e Mostro). E’ caratterizzata dal nome, punti vita, forza, difesa (fisica e/o magica).
Oltre alle funzionalità  getter/setter e toString, ci sono anche i metodi per attaccare e subireDanni, di cui non sappiamo ancora come saranno implementati.
```
Entità

- nome : String
- puntiVita : int
- forza : int
- difesa : String

+ entita(nome:String, puntiVita:int, forza:int, difesa:String)
+ getNome() : String
+ setNome(nome:String)
+ getPuntiVita() : int
+ setPuntiVita(puntiVita:int)
+ getForza() : int
+ setForza(forza:int)
+ getDifesa() : String
+ setDifesa(difesa:String)

+ attacare() : abstract
+ subireDanni() : abstract
```
-------------------------------------------------------------------------------------------------------------------
# Oggetto
- Un “Oggetto” rappresenta un elemento "non vivente" nel gioco (armi, armature e pozioni).
E’ caratterizzata dal nome, la categoria e la descrizione. Offre le funzionalità Getter/Setter e toString.
```
Oggetto

- nome : String
- categoria : String
- descrizione : String

+ oggetto(nome:String, categoria:String, descrizione:String)
+ getNome() : String
+ setNome(nome:String)
+ getCategoria() : String
+ setCategoria(categoria:String)
+ getDescrizione() : String
+ setDescrizione(descrizione:String)
```
-------------------------------------------------------------------------------------------------------------------
# Arma
- Una “Arma” è derivata da oggetto e aggiunge il tipoDanno (fisico o magico) e il danno. Offre i metodi Getter/Setter e toString.
```
Arma extends Oggetto

- tipoDanno : String
- danno : int

+ arma(nome:String, categoria:String, descrizione:String, tipoDanno:String, danno:int)
+ getTipoDanno() : String
+ setTipoDanno(tipoDanno:String)
+ getDanno() : int
+ setDanno(danno:int)
```
-------------------------------------------------------------------------------------------------------------------
# Armatura
- Una “Armatura” è derivata da oggetto e aggiunge il tipoDifesa (fisico o magico) e la difesa. Offre i metodi Getter/Setter e toString.
```
Armatura extends Oggetto

- tipoDifesa : String
- difesa : int

+ armatura(nome:String, categoria:String, descrizione:String, tipoDifesa:String, difesa:int)
+ getTipoDifesa() : String
+ setTipoDifesa(tipoDifesa:String)
+ getDifesa() : int
+ setDifesa(difesa:int)
```
-------------------------------------------------------------------------------------------------------------------
# Pozione
- Una “Pozione” è derivata da oggetto e aggiunge i punti ferita che guarisce. Offre i metodi Getter/Setter e toString.
```
Pozione extends Oggetto

- puntiFeritaGuarisce : int

+ pozione(nome:String, categoria:String, descrizione:String, puntiFeritaGuarisce:int)
+ getPuntiFeritaGuarisce() : int
+ setPuntiFeritaGuarisce(puntiferita:int)
```
-------------------------------------------------------------------------------------------------------------------
# Mostro 
- Un “Mostro” è derivato dalla classe Entità, ereditando gli attributi e i metodi.
Aggiungerà caratteristiche specifiche come il tipo di attacco (fisico o magico) e la quantità di esperienza che il giocatore guadagna sconfiggendolo.
Oltre alle funzionalità  getter/setter e toString implementi i metodi della classe Entità. Il calcolo del danno subito è dato dal danno ricevuto - la difesa.
Inoltre il mostro una volta che muori potrebbe lasciare un bottino, la percentuale è data da il livello *10%.
Ogni mostro ha un bottino fissato quando si crea il mostro che può essere un’arma, un’armatura o una pozione.
```
Mostro extends Entita

- tipoAttacco : String
- quantitaExp : int

+ entita(nome:String, pruntiVita:int, forza:int, difesa:String, tipoAttacco:String, quantitaExp:int)
+ getTipoAttacco() : String
+ setTipoAttacco(tipoAttacco:String)
+ getQuantitaExp() : int
+ setQuantitaExp(quantitaExp:int)
```
-------------------------------------------------------------------------------------------------------------------
# Personaggio
- Un “Personaggio” è derivato dalla classe Entità, ereditando gli attributi e i metodi.
Aggiungerà caratteristiche specifiche come livello, armi, armature, zaino pozioni (max 5) e la quantità di esperienza che il giocatore deve guadagnare per passare di livello.
Oltre alle funzionalità getter/setter e toString implementare i metodi della classe Entità. Il calcolo del danno subito è dato dal danno ricevuto - il livello di difesa.
Il livello di difesa è dato dalla difesa base + la difesa dell’armatura. Attenzione che si distingue tra difesa fisica e magica.
I danni totali sono dati dal danno base + il danno dell’arma utilizzata. Anche in questo caso cambia tra fisico e magico.
Ogni volta che il personaggio passa di livello il personaggio aggiunge da 1 a 10 punti ferita estratti a caso. Il giocatore può utilizzare una sola arma e armatura alla volta.
Il personaggio può avere al massimo 2 armi e armature. Inoltre ha un metodo esamina, che restituisce la descrizione della stanza.
```
Personaggio extends Entita

- livello : int
- quantitaExpAumentoLivello : int

+ personaggio(livello:int, armi:String[], armature:String[], zainoPozioni:int, quantitaExpAumentoLivello:int)
+ getLivello() : int
+ setLivello(livello:int)
+ getQuantitaExpAumentoLivello() : int
+ setQuantitaExpAumentoLivello(quantitaExpAumentoLivello:int)

+ CalcoloDannoSubito() : int
+ LivelloDifesa() : int
```
-------------------------------------------------------------------------------------------------------------------
# Stanza
- Una “Stanza” è caratterizzata da uno o più mostri (opzionale per un massimo di 5) e la descrizione. Offre i metodi Getter/Setter e toString.
```
Stanza

- numeroMostri : int
- descrizione : String

+ stanza(numeroMostri:int, descrizione:String)
+ getNumeroMostri() : int
+ setNumeroMostri(numeroMostri:String)
+ getDescrizione() : String
+ setDescrizione(descrizione:String)
```




