package GiocoDiRuolo;

/*
Un “Personaggio” è derivato dalla classe Entità, ereditando gli attributi e i metodi.
Aggiungerà caratteristiche specifiche come livello, armi, armature, zaino pozioni (max 5) e la quantità di esperienza che il giocatore deve guadagnare per passare di livello.
Oltre alle funzionalità getter/setter e toString implementare i metodi della classe Entità. Il calcolo del danno subito è dato dal danno ricevuto - il livello di difesa.
Il livello di difesa è dato dalla difesa base + la difesa dell’armatura. Attenzione che si distingue tra difesa fisica e magica.
I danni totali sono dati dal danno base + il danno dell’arma utilizzata. Anche in questo caso cambia tra fisico e magico.
Ogni volta che il personaggio passa di livello il personaggio aggiunge da 1 a 10 punti ferita estratti a caso. Il giocatore può utilizzare una sola arma e armatura alla volta.
Il personaggio può avere al massimo 2 armi e armature. Inoltre ha un metodo esamina, che restituisce la descrizione della stanza.

Personaggio extends Entita

- livello : int
- esperienza : int
- quantitaExpNecessaria : int

+ personaggio(nome:String, puntiVita:int, forza:int, difesa:String, tipoDifesa:String, livello:int)
+ getLivello() : int
+ setLivello(livello:int)
+ getEsperienza() : int
+ setEsperienza(esperienza:int)
+ getQuantitaExpNecessaria() : int
+ setQuantitaExpNecessaria(quantitaExpNecessaria:int)

+ CalcoloDannoSubito() : int
+ LivelloDifesa() : int
*/

public class Personaggio extends Entita {
    private int livello;
    private Arma armaEquipaggiata;
    private Armatura armaturaEquipaggiata;
    private ArrayList<Oggetto> = zaino;
    private int esperienza;
    private int esperienzaPerProssimoLivello;

    public Personaggio(String nome, int puntiVita, int forza, int difesa, String tipoDifesa, int livello, Oggetto zaino) {
        super(nome, puntiVita, forza, difesa, tipoDifesa);
        this.livello = livello;
        this.esperienza = 0;
        this.esperienzaPerProssimoLivello = 100;
        this.zaino = new ArrayList<>;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public Arma getArmaEquipaggiata() {
        return armaEquipaggiata;
    }

    public void setArmaEquipaggiata(Arma armaEquipaggiata) {
        this.armaEquipaggiata = armaEquipaggiata;
    }

    public Armatura getArmaturaEquipaggiata() {
        return armaturaEquipaggiata;
    }

    public void setArmaturaEquipaggiata(Armatura armaturaEquipaggiata) {
        this.armaturaEquipaggiata = armaturaEquipaggiata;
    }

    public ArrayList<Oggetto> zaino() {
        return zaino;
    }

    public void aggiungiOggetto(Oggetto oggetto){
        zaino.add(oggetto);
        System.out.println("Hai aggiunto: " oggetto.getNome() + " nel tuo zaino");
    }

    public void rimuoviOggetto(posizioneOggetto){
        zaino.remove(posizioneOggetto);
        System.out.println("Hai rimosso: " + zaino.get(posizioneOggetto) + " dal tuo zaino");
    }

    public void mostraZaino(){
        for(Oggetto oggetto : zaino){
            System.out.println(oggetto);
        }
    }

    public int getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(int esperienza) {
        this.esperienza = esperienza;
    }

    public int getEsperienzaPerProssimoLivello() {
        return esperienzaPerProssimoLivello;
    }

    public void setEsperienzaPerProssimoLivello(int esperienzaPerProssimoLivello) {
        this.esperienzaPerProssimoLivello = esperienzaPerProssimoLivello;
    }

    public void esamina(Stanza stanza) {
        System.out.println(stanza.getDescrizione());
    }

    public void passaDiLivello() {
        this.livello++;
        int puntiVitaAggiuntivi = (int)(Math.random() * 10) + 1;
        this.setPuntiVita(this.getPuntiVita() + puntiVitaAggiuntivi);
        System.out.println(this.getNome() + " è passato al livello " + this.livello + " con " + this.getPuntiVita() + " punti vita.");
    }

    @Override
    public void attacare(Entita target) {
        int danno = this.getForza() + (armaEquipaggiata != null ? armaEquipaggiata.getDanno() : 0);
        target.subireDanni(danno);
        System.out.println("⚔️ " + this.getNome() + " attacca con un danno " + (armaEquipaggiata != null ? armaEquipaggiata.getTipoDanno() : "fisico") + " di " + danno); //Stampa il nome del personaggio non del mostro (errore)
    }

    public void subireDanni(int danno) {
        int difesaTotale = this.getDifesa() + (armaturaEquipaggiata != null ? armaturaEquipaggiata.getDifesa() : 0);
        int dannoEffettivo = danno - difesaTotale;
        if (dannoEffettivo > 0) {
            this.setPuntiVita(this.getPuntiVita() - dannoEffettivo);
        } else {
            dannoEffettivo = 0; // Per evitare numeri negativi nel log
        }

        System.out.println(this.getNome() + " subisce " + dannoEffettivo + " danni. Punti vita restanti: " + this.getPuntiVita());

        /*
        // Controlla se i punti vita sono scesi sotto 0
        if (this.getPuntiVita() <= 0) {
            System.out.println(this.getNome() + " è morto.");
        }
        */
    }
}
