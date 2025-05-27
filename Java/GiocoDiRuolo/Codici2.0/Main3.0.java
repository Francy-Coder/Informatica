package GiocoDiRuolo;

import java.util.Scanner;
import java.util.Random;
public class Main {

    //Da rivedere usando il repo di TPSI per confermare...
    private static void stampaConDelay(String testo) {
        for (char c : testo.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(0); //Ritardo di 30 millisecondi tra ogni carattere | In alcuni SOUT non è stato messo, perchè ci vorrebbero ore per finire di stampare tutte le stanze con mostri e i vari metodi...
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        stampaConDelay("Ciao Avventuriero!\nInserisci il tuo nome:");
        String nomePersonaggio = sc.next();

        int puntiVita = 100;
        int forza = random.nextInt(10) + 1; //Numero casuale da 1 a 10
        int difesa = random.nextInt(10) + 1;
        Personaggio personaggio = new Personaggio(nomePersonaggio, puntiVita, forza, difesa, "fisica", 1);

        stampaConDelay("\nCiao " + nomePersonaggio + "!\nQuante stanze vorresti sfidare?");
        int maxStanze = sc.nextInt();

        Stanza[] stanza = new Stanza[maxStanze];

        Mostro[] mostro = new Mostro[5]; //Mostri totali nelle stanze

        Arma[] arma = new Arma[5]; //Armi totali che il personaggio può avere nel invetario < Però può usare solo 1 sola 📌
        int slotArmi = 0;

        Armatura[] armatura = new Armatura[5]; //Armature totali che il personaggio può avere nel invetario < Però può usare solo 1 sola 📌
        int slotArmature = 0;

        Pozione[] pozione = new Pozione[10]; //Pozione totali che il personaggio può avere nel invetario < Però può usare solo 1 sola 📌
        int slotPozioni = 0;

        stampaConDelay("\nEcco il tuo personaggio: " + personaggio.stampa() + "\n");
        System.out.println("---------------------------------------------------------" + "\n");

        boolean primaVolta = true;
        int casoStampa;

        int sceltaMenu = -1;
        while (sceltaMenu != 2) {
            //Fare: (Controllare anche CosaManca2.0)
            //(Opzionale) Quando muore, il personaggio viene ricreato | Idea: Creare un altra classe, dove viene richiamato un metodo al suo interno per creare il personaggio
                //In caso di sconfitta (ma anche vittoria) cosa si può fare con il personaggio? | ✅ Per ora il problema morte / vittoria è stato risolto con il secondo metodo
                    //Eliminare il personaggio in caso di morte (forse anche vittoria) ❓
                    //Tenere il personaggio in entrambi i casi e continuare l'avventura ❓ 🔎
                //In caso di vittoria o morte, possibita di creare un nuovo personaggio e quello vecchio si salva in uno slot ❓
            //(Opzionale) Fare diversi classi per il personaggio (es: stregone, guerriero, necromante, assassino, samurai)
                //In caso di vittoria si può far decidere se creare un nuovo personaggio o continuare con quello che si ha
                    //Oppure per entrambi i casi si mantiene il personaggio e si possono implementare degli slot, così che si possono avere piu personaggi

            //(Opzionale) Thread per stampare il testo come in un video gioco ✅

            //(Opzionale) Thread per vedere il tempo impiegato durante la run ✅

            //(Opzionale) Aggiungere / Modificare le parti nuovi fatte
                //Si potrebbe aggiungere un Arraylist
                //Si potrebbero aggiungere delle Eccezioni ✅
                    //Exception
                //Si potrebbe aggiungere una cartella log e al interno inserire un file.txt tramite lo Stream
                //Si potrebbe aggiungere la classe Random ✅
                //Si potrebbe implementare List

            //Correzzioni Importanti:
                //Metodo attaca e subisci danno, non cambia mai il valore d'attacco o subisci danno ❌
                    //Danno si basa sulla forza del personaggio, idem per subire danni 📌

            //Casistiche per stampare in modi diversi, per ogni caso possibile
            if (primaVolta) {
                stampaConDelay("\nBenvenuto in ELDEN-LORD \nAffronta labirinti infidi, sconfiggi creature terrificanti e scopri poteri perduti. Solo i più audaci osano entrare: ti unirai a loro?");
                stampaConDelay("\n === Cosa vuoi fare? === \n 1. Accetta la sfida\n 2. Ritirati");
                sceltaMenu = sc.nextInt();
                primaVolta = false;
                casoStampa = 1;
            } else if (personaggio.getPuntiVita() <= 0) {
                stampaConDelay("\nTi arrenderai o avrai il coraggio di sfidare nuovamente il destino?");
                stampaConDelay("\n === Cosa vuoi fare? === \n 1. Ogni tentativo è un passo più vicino al successo\n 2. A volte fermarsi è necessario per andare avanti");
                sceltaMenu = sc.nextInt();
                casoStampa = 1;

                //Casistica se l'utente sceglie di continuare con la storia
                if(sceltaMenu == 3){ //Per ora il valore è 3, ma dovrebbe essere 1
                    personaggio.setPuntiVita(100);
                    stampaConDelay("\nVedo che ci riproverai.. Mentre eri svenuto i tuoi punti vita sono stati ripristinati \nQuante stanze vorresti sfidare ora? (stanze affrontate prima: " + maxStanze + ")");
                    maxStanze = sc.nextInt();
                    stanza = new Stanza[maxStanze];
                }

            } else {
                stampaConDelay("\nHai vinto!");
                stampaConDelay("\n === Cosa vuoi fare? === \n 1. La vittoria è solo l'inizio, c'è sempre altro da conquistare\n 2. La vittoria è il frutto di ogni sforzo, goditela");
                sceltaMenu = sc.nextInt();
                casoStampa = 2;

                //Casistica se l'utente sceglie di continuare con la storia
                if(sceltaMenu == 3){ //Per ora il valore è 3, ma dovrebbe essere 1
                    personaggio.setPuntiVita(100);
                    stampaConDelay("\nVedo che una vittoria non basta.. Mentre stavi festaggiando i tuoi punti vita sono stati ripristinati \nQuante stanze vorresti sfidare ora? (stanze affrontate prima: " + maxStanze + ")");
                    maxStanze = sc.nextInt();
                    stanza = new Stanza[maxStanze];
                }
            }

            switch (sceltaMenu) {
                case 1:
                    System.out.println("Per ora vuoto... Prova a inserire 3..");

                    //Iniziare a fare tutte le casistiche con switch e if (es: se vuoi andare avanti o indietro di stanza, o se attaccare o usare una pozione o se scappare) dopo aver fatto:
                        //Zaino 🔎
                        //Metodi Attacca e Subisci Danno 🔎
                        //Equipaggiamento 🔎
                        //Livello Personaggio
                        //BottinoMostro
                    break;

                case 2:
                    if (casoStampa == 1) {
                        stampaConDelay("\nNon possiamo vincere qui, ritirarsi è l'unica via");
                    } else {
                        stampaConDelay("\nOgni vittoria merita una pausa, ma la strada non finisce mai");
                    }
                    break;

                case 3: // Case per testare le varie funzioni

                    long tempoInizio = System.nanoTime();

                    for (int i = 0; i < maxStanze; i++) {
                        int numeroCasualeDescrizione = random.nextInt(RisorseMain.descrizioneStanze.length);
                        String descrizione = RisorseMain.descrizioneStanze[numeroCasualeDescrizione];

                        int numeroMostri = random.nextInt(5) + 1;
                        stanza[i] = new Stanza(numeroMostri, descrizione);
                        System.out.println("\n>Stanza nr " + i + ": " + stanza[i].stampa());

                        for (int j = 0; j < numeroMostri; j++) {
                            int numeroCasualePerMostri = random.nextInt(RisorseMain.nomiMostri.length);
                            String nomeMostro = RisorseMain.nomiMostri[numeroCasualePerMostri];
                            String descrizioneMostro = RisorseMain.descrizioneMostri[numeroCasualePerMostri];

                            int puntiVitaMostro = random.nextInt(10) + 1;
                            int forzaMostro = random.nextInt(10) + 1;
                            int difesaMostro = random.nextInt(10) + 1;
                            int quantitaExpMostro = random.nextInt(100) + 1;


                            //Il bottino per ora è un arma, ma dovrebbe variare tra arma e armtura ❌ < Ricordarsi che il bottino è fisso per ogni mostro, questo è variabile ❌
                            int numeroCasualeBottinoMostro = random.nextInt(RisorseMain.nomiArmi.length);
                            String bottinoMostroArma = RisorseMain.nomiArmi[numeroCasualeBottinoMostro];
                            String bottinoMostroCategoriaArma = RisorseMain.categoriaArmi[numeroCasualeBottinoMostro];
                            String bottinoMostroDescrizioneArma = RisorseMain.descrizioneArmi[numeroCasualeBottinoMostro];
                            String bottinoMostroTipoDannoArma = RisorseMain.tipoDannoArmi[numeroCasualeBottinoMostro];
                            int bottinoMostroDannoArma = RisorseMain.dannoArmi[numeroCasualeBottinoMostro];

                            mostro[j] = new Mostro (nomeMostro, puntiVitaMostro, forzaMostro, difesaMostro, "fisica", descrizioneMostro, "fisica", quantitaExpMostro, new Arma(bottinoMostroArma, bottinoMostroCategoriaArma, bottinoMostroDescrizioneArma, bottinoMostroTipoDannoArma, bottinoMostroDannoArma));
                            System.out.println(mostro[j].stampa());

                            if(slotArmi < arma.length) {
                                int numeroCasualePerArmi = random.nextInt(RisorseMain.nomiArmi.length);
                                String nomeArma = RisorseMain.nomiArmi[numeroCasualePerArmi];
                                String categoriaArma = RisorseMain.categoriaArmi[numeroCasualePerArmi];
                                String descrizioneArma = RisorseMain.descrizioneArmi[numeroCasualePerArmi];
                                String tipoDannoArma = RisorseMain.tipoDannoArmi[numeroCasualePerArmi];
                                int dannoArma = RisorseMain.dannoArmi[numeroCasualePerArmi];

                                arma[slotArmi] = new Arma(nomeArma, categoriaArma, descrizioneArma, tipoDannoArma, dannoArma);
                                System.out.println("🗡️ " + arma[slotArmi].stampa());
                                slotArmi++;
                            }else{
                                System.out.println("❌ " + "Slot Armi Esauriti");
                            }

                            if(slotArmature < armatura.length) {
                                int numeroCasualePerArmature = random.nextInt(RisorseMain.nomiArmature  .length);
                                String nomeArmatura = RisorseMain.nomiArmature[numeroCasualePerArmature];
                                String categoriaArmatura = RisorseMain.categoriaArmature[numeroCasualePerArmature];
                                String descrizioneArmatura = RisorseMain.descrizioneArmature[numeroCasualePerArmature];
                                String tipoDifesaArmatura = RisorseMain.tipoDifesaArmature[numeroCasualePerArmature];
                                int difesaArmatura = RisorseMain.difesaArmature[numeroCasualePerArmature];

                                armatura[slotArmature] = new Armatura(nomeArmatura, categoriaArmatura, descrizioneArmatura, tipoDifesaArmatura, difesaArmatura);
                                System.out.println("🛡️ " + armatura[slotArmature].stampa());
                                slotArmature++;
                            }else{
                                System.out.println("❌ " + "Slot Armature Esauriti");
                            }

                            System.out.println("\nAzione sul mostro " + mostro[j].getNome() + ":");
                            personaggio.attaccare(mostro[j]);
                            personaggio.subireDanni(10); // Decrementa i punti vita del personaggio

                            // Controlla subito se il personaggio è morto
                            if (personaggio.getPuntiVita() <= 0) {
                                System.out.println("💀 " + "Sei morto. La tua avventura termina qui.");
                                break; // Esce dal ciclo dei mostri
                            }

                            if(slotPozioni < pozione.length) {
                                int numeroCasualePozione = random.nextInt(RisorseMain.nomiPozioni.length);
                                String nomePozione = RisorseMain.nomiPozioni[numeroCasualePozione];
                                String categoriaPozione = RisorseMain.categoriaPozioni[numeroCasualePozione];
                                String descrizionePozione = RisorseMain.descrizionePozioni[numeroCasualePozione];
                                int puntiFeritaGuariscePozione = RisorseMain.curaPozione[numeroCasualePozione];

                                pozione[slotPozioni]= new Pozione(nomePozione, categoriaPozione, descrizionePozione, puntiFeritaGuariscePozione);
                                System.out.println("🧪 " + pozione[slotPozioni].stampa());

                                puntiVita = puntiVita + puntiFeritaGuariscePozione;
                                System.out.println("🧪 " + "Ti sei guarito con la pozione " + pozione[slotPozioni].getNome() + " di " + pozione[slotPozioni].getPuntiFeritaGuarisce());
                                slotPozioni++;
                            }else{
                                System.out.println("❌ " + "Slot Pozioni Esauriti");
                            }

                            long tempoFine = System.nanoTime();
                            long tempoTotaleSecondi = (tempoFine - tempoInizio) / 1_000_000_000; // Convertire in secondi
                            System.out.println("\nTempo di Gioco: " + tempoTotaleSecondi + " secondi");

                        }

                        // Se il personaggio è morto, esce dal ciclo delle stanze
                        if (personaggio.getPuntiVita() <= 0) {
                            break;
                        }
                    }
                    break;
            }
        }
            } catch (Exception e) {
            System.err.println("Si è verificato un errore: " + e +  "\nChiusura del programma");
            }
    }
}
