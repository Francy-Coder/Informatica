package GiocoDiRuolo;

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
      
        System.out.println("Ciao Avventuriero!\nInserisci il tuo nome:");
        String nomePersonaggio = sc.next();

        int puntiVita = 100;
        int forza = random.nextInt(10) + 1; //Numero casuale da 1 a 10
        int difesa = random.nextInt(10) + 1;
        Personaggio personaggio = new Personaggio(nomePersonaggio, puntiVita, forza, difesa, "fisica", 1);

        System.out.println("\nCiao " + nomePersonaggio + "!\nQuante stanze vorresti sfidare?");
        int maxStanze = sc.nextInt();
        Stanza[] stanza = new Stanza[maxStanze];
        Mostro[] mostro = new Mostro[5];

        System.out.println("\nEcco il tuo personaggio: " + personaggio.stampa() + "\n");

        System.out.println("---------------------------------------------------------" + "\n");

        boolean primaVolta = true;
        int casoStampa;

        int sceltaMenu = -1;
        while (sceltaMenu != 2) {
            //Fare: (Controllare anche CosaManca2.0)
            //(Opzionale) Quando muore, il personaggio viene ricreato | Idea: Creare un altra classe, dove viene richiamato un metodo al suo interno per creare il personaggio
                //In caso di sconfitta si può ricreare il personaggio
            
            //In caso di vittoria si può far decidere se creare un nuovo personaggio o continuare con quello che si ha
                //Oppure per entrambi i casi si mantiene il personaggio e si possono implementare degli slot, così che si possono avere piu personaggi
            
            //(Opzionale) Thread per stampare il testo come in un video gioco
            
            //(Opzionale) Thread per vedere il tempo impiegato durante la run
            
            //(Opzionale) Aggiungere / Modificare le parti nuovi fatte
                //Si potrebbe aggiungere un Arraylist
                //Si potrebbero aggiungere delle Eccezioni
                //Si potrebbe aggiungere una cartella log e al interno inserire un file.txt tramite lo Stream
                //Si potrebbe aggiungere la classe Random

            //Casistiche per stampare in modi diversi, per ogni caso possibile
            if(primaVolta) {
                System.out.println("\nBenvenuto in ELDEN-LORD\n" + "Affronta labirinti infidi, sconfiggi creature terrificanti e scopri poteri perduti. Solo i più audaci osano entrare: ti unirai a loro?");
                System.out.println("\n === Cosa vuoi fare? === \n 1. Accetta la sfida\n 2. Ritirati");
                sceltaMenu = sc.nextInt();
                primaVolta = false;
                casoStampa = 1;
            } else if (personaggio.getPuntiVita() <= 0) {
                    System.out.println("\nTi arrenderai o avrai il coraggio di sfidare nuovamente il destino?");
                    System.out.println("\n === Cosa vuoi fare? === \n 1. Ogni tentativo è un passo più vicino al successo\n 2. A volte fermarsi è necessario per andare avanti");
                    sceltaMenu = sc.nextInt();
                    casoStampa = 1;
                }else{
                    System.out.println("\nHai vinto!");
                    System.out.println("\n === Cosa vuoi fare? === \n 1. La vittoria è solo l'inizio, c'è sempre altro da conquistare\n 2. La vittoria è il frutto di ogni sforzo, goditela");
                    sceltaMenu = sc.nextInt();
                    casoStampa = 2;
                }
            }
            
            switch (sceltaMenu) {
                case 1:
                    System.out.println("Per ora vuoto... Prova a inserire 3..")
                    break;

                case 2:
                    if(casoStampa == 1){
                        System.out.println("\nNon possiamo vincere qui, ritirarsi è l'unica via");
                    }else{
                        System.out.println("\nOgni vittoria merita una pausa, ma la strada non finisce mai");
                    }
                    break;

                case 3: //Case per testare le varie funzioni
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
                            
                            int numeroCasualeBottinoMostro = random.nextInt(RisorseMain.nomiArmi.length);
                            String bottinoMostroArmi = RisorseMain.nomiArmi[numeroCasualeBottinoMostro];
                            String bottinoMostroCategoria = RisorseMain.categoriaArmi[numeroCasualeBottinoMostro];
                            String bottinoMostroDescrizione = RisorseMain.descrizioneArmi[numeroCasualeBottinoMostro];

                            mostro[j] = new Mostro(nomeMostro, puntiVitaMostro, forzaMostro, difesaMostro, "fisica", descrizioneMostro, "fisica", quantitaExpMostro, new Oggetto(bottinoMostroArmi, bottinoMostroCategoria, bottinoMostroDescrizione));
                            System.out.println(mostro[j].stampa());

                            System.out.println("\nAzione sul mostro " + mostro[j].getNome() + ":");
                            personaggio.attacare(mostro[j]);
                            personaggio.subireDanni(10);// Decrementa i punti vita del personaggio

                            //Controlla subito se il personaggio è morto
                            if (personaggio.getPuntiVita() <= 0) {
                                System.out.println("💀 " + "Sei morto. La tua avventura termina qui.");
                                break; //Esce dal ciclo dei mostri
                            }
                            System.out.println();

                            int numeroCasualePozione = random.nextInt(RisorseMain.nomiPozioni.length);
                            String nomePozione = RisorseMain.nomiPozioni[numeroCasualePozione];
                            String categoriaPozione = RisorseMain.categoriaPozioni[numeroCasualePozione];
                            String descrizionePozione = RisorseMain.descrizionePozioni[numeroCasualePozione];
                            int puntiFeritaGuariscePozione = RisorseMain.curaPozione[numeroCasualePozione];

                            Pozione pozione = new Pozione(nomePozione, categoriaPozione, descrizionePozione, puntiFeritaGuariscePozione);
                            System.out.println(pozione.stampa());
                            puntiVita = puntiVita + puntiFeritaGuariscePozione;
                            System.out.println("❤️ " + "Ti sei guarito con la pozione " + pozione.getNome() + " di " + pozione.getPuntiFeritaGuarisce());
                        }

                        //Se il personaggio è morto, esce dal ciclo delle stanze
                        if (personaggio.getPuntiVita() <= 0) {
                            break;
                        }
                    }
                    break;
            }
        }

    }
}
