package GiocoDiRuolo;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ciao Avventuriero!\nInserisci il tuo nome:");
        String nomePersonaggio = sc.next();

        int puntiVita = 100;
        int forza = (int) (Math.random() * 10) + 1;
        int difesa = (int) (Math.random() * 10) + 1;
        Personaggio personaggio = new Personaggio(nomePersonaggio, puntiVita, forza, difesa, "fisica", 1);

        System.out.println("\nCiao " + nomePersonaggio + "!\nQuante stanze vorresti sfidare?");
        int maxStanze = sc.nextInt();
        Stanza[] stanza = new Stanza[maxStanze];
        Mostro[] mostro = new Mostro[5];

        System.out.println("\nEcco il tuo personaggio: " + personaggio.stampa() + "\n");

        System.out.println("---------------------------------------------------------" + "\n");

        int sceltaMenu = -1;
        while (sceltaMenu != 2) {
            //Fare che quando muore, il personaggio viene ricreato(opzionale) + cambia la stampa (rivincita)
            System.out.println("\nAffronta labirinti infidi, sconfiggi creature terrificanti e scopri poteri perduti. Solo i più audaci osano entrare: ti unirai a loro?");
            System.out.println("\n === Cosa vuoi fare? === \n 1. Accetta la sfida\n 2. Ritirati\n");
            sceltaMenu = sc.nextInt();
            switch (sceltaMenu) {
                case 1:
                    break;

                case 2:
                    System.out.println("Non possiamo vincere qui, ritirarsi è l'unica via");
                    break;

                case 3: //Case per testare le varie funzioni
                    for (int i = 0; i < maxStanze; i++) {
                        int numeroCasualeDescrizione = (int) (Math.random() * RisorseMain.descrizioneStanze.length);
                        String descrizione = RisorseMain.descrizioneStanze[numeroCasualeDescrizione];

                        int numeroMostri = (int) (Math.random() * 5) + 1;
                        stanza[i] = new Stanza(numeroMostri, descrizione);
                        System.out.println("\n>Stanza nr " + i + ": " + stanza[i].stampa());

                        for (int j = 0; j < numeroMostri; j++) {
                            int numeroCasualePerMostri = (int) (Math.random() * RisorseMain.nomiMostri.length);
                            String nomeMostro = RisorseMain.nomiMostri[numeroCasualePerMostri];
                            String descrizioneMostro = RisorseMain.descrizioneMostri[numeroCasualePerMostri];

                            int puntiVitaMostro = (int) (Math.random() * 10) + 1;
                            int forzaMostro = (int) (Math.random() * 10) + 1;
                            int difesaMostro = (int) (Math.random() * 10) + 1;
                            int quantitaExpMostro = (int) (Math.random() * 100) + 1;

                            int numeroCasualeBottinoMostro = (int) (Math.random() * RisorseMain.nomiArmi.length);
                            String bottinoMostroArmi = RisorseMain.nomiArmi[numeroCasualeBottinoMostro];
                            String bottinoMostroCategoria = RisorseMain.categoriaArmi[numeroCasualeBottinoMostro];
                            String bottinoMostroDescrizione = RisorseMain.descrizioneArmi[numeroCasualeBottinoMostro];

                            mostro[j] = new Mostro(nomeMostro, puntiVitaMostro, forzaMostro, difesaMostro, "fisica", descrizioneMostro, "fisica", quantitaExpMostro, new Oggetto(bottinoMostroArmi, bottinoMostroCategoria, bottinoMostroDescrizione));
                            System.out.println(mostro[j].stampa());

                            System.out.println("\nAzione sul mostro " + mostro[j].getNome() + ":");
                            personaggio.attacare(mostro[j]);
                            personaggio.subireDanni(10);// Decrementa i punti vita del personaggio

                            // Controlla subito se il personaggio è morto
                            if (personaggio.getPuntiVita() <= 0) {
                                System.out.println("Sei morto. La tua avventura termina qui.");
                                break; // Esce dal ciclo dei mostri
                            }
                            System.out.println();

                            int numeroCasualePozione = (int) (Math.random() * RisorseMain.nomiPozioni.length);
                            String nomePozione = RisorseMain.nomiPozioni[numeroCasualePozione];
                            String categoriaPozione = RisorseMain.categoriaPozioni[numeroCasualePozione];
                            String descrizionePozione = RisorseMain.descrizionePozioni[numeroCasualePozione];
                            int puntiFeritaGuariscePozione = RisorseMain.curaPozione[numeroCasualePozione];

                            Pozione pozione = new Pozione(nomePozione, categoriaPozione, descrizionePozione, puntiFeritaGuariscePozione);
                            System.out.println(pozione.stampa());
                            puntiVita = puntiVita + puntiFeritaGuariscePozione;
                            System.out.println("Ti sei guarito con la pozione " + pozione.getNome() + " di " + pozione.getPuntiFeritaGuarisce());
                        }

                        // Se il personaggio è morto, esce dal ciclo delle stanze
                        if (personaggio.getPuntiVita() <= 0) {
                            break;
                        }
                    }
                    break;
            }
        }
    }
}

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
    private Pozione[] zaino;
    private int esperienza;
    private int esperienzaPerProssimoLivello;

    public Personaggio(String nome, int puntiVita, int forza, int difesa, String tipoDifesa, int livello) {
        super(nome, puntiVita, forza, difesa, tipoDifesa);
        this.livello = livello;
        this.esperienza = 0;
        this.esperienzaPerProssimoLivello = 100;
        this.zaino = new Pozione[5];
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

    public Pozione[] getZaino() {
        return zaino;
    }

    public void aggiungiPozione(Pozione pozione) {
        for (int i = 0; i < zaino.length; i++) {
            if (zaino[i] == null) {
                zaino[i] = pozione;
                break;
            }
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
        System.out.println(this.getNome() + " attacca con un danno " + (armaEquipaggiata != null ? armaEquipaggiata.getTipoDanno() : "fisico") + " di " + danno); //Stampa il nome del personaggio non del mostro (errore)
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

        // Controlla se i punti vita sono scesi sotto 0
        if (this.getPuntiVita() <= 0) {
            System.out.println(this.getNome() + " è morto.");
        }
    }
}
