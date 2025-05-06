package GiocoDiRuolo;

import java.util.Scanner;
import java.util.Random;
public class Main {

    //Da rivedere, usare il repo di TPSI per confermare..
    private static void stampaConDelay(String testo) {
        for (char c : testo.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        stampaConDelay("Ciao Avventuriero!\nInserisci il tuo nome:");
        String nomePersonaggio = sc.next();

        int puntiVita = 100;
        int forza = random.nextInt(10) + 1; // Numero casuale da 1 a 10
        int difesa = random.nextInt(10) + 1;
        Personaggio personaggio = new Personaggio(nomePersonaggio, puntiVita, forza, difesa, "fisica", 1);

        stampaConDelay("\nCiao " + nomePersonaggio + "!\nQuante stanze vorresti sfidare?");
        int maxStanze = sc.nextInt();
        Stanza[] stanza = new Stanza[maxStanze];
        Mostro[] mostro = new Mostro[5];

        stampaConDelay("\nEcco il tuo personaggio: " + personaggio.stampa() + "\n");

        stampaConDelay("---------------------------------------------------------" + "\n");

        boolean primaVolta = true;
        int casoStampa;

        int sceltaMenu = -1;
        while (sceltaMenu != 2) {
            if (primaVolta) {
                stampaConDelay("\nBenvenuto in ELDEN-LORD\n" +
                        "Affronta labirinti infidi, sconfiggi creature terrificanti e scopri poteri perduti. " +
                        "Solo i più audaci osano entrare: ti unirai a loro?");
                stampaConDelay("\n === Cosa vuoi fare? === \n 1. Accetta la sfida\n 2. Ritirati");
                sceltaMenu = sc.nextInt();
                primaVolta = false;
                casoStampa = 1;
            } else if (personaggio.getPuntiVita() <= 0) {
                stampaConDelay("\nTi arrenderai o avrai il coraggio di sfidare nuovamente il destino?");
                stampaConDelay("\n === Cosa vuoi fare? === \n 1. Ogni tentativo è un passo più vicino al successo\n 2. A volte fermarsi è necessario per andare avanti");
                sceltaMenu = sc.nextInt();
                casoStampa = 1;
            } else {
                stampaConDelay("\nHai vinto!");
                stampaConDelay("\n === Cosa vuoi fare? === \n 1. La vittoria è solo l'inizio, c'è sempre altro da conquistare\n 2. La vittoria è il frutto di ogni sforzo, goditela");
                sceltaMenu = sc.nextInt();
                casoStampa = 2;
            }

            switch (sceltaMenu) {
                case 1:
                    stampaConDelay("Per ora vuoto... Prova a inserire 3..");
                    break;

                case 2:
                    if (casoStampa == 1) {
                        stampaConDelay("\nNon possiamo vincere qui, ritirarsi è l'unica via");
                    } else {
                        stampaConDelay("\nOgni vittoria merita una pausa, ma la strada non finisce mai");
                    }
                    break;

                case 3: // Case per testare le varie funzioni
                    for (int i = 0; i < maxStanze; i++) {
                        int numeroCasualeDescrizione = random.nextInt(RisorseMain.descrizioneStanze.length);
                        String descrizione = RisorseMain.descrizioneStanze[numeroCasualeDescrizione];

                        int numeroMostri = random.nextInt(5) + 1;
                        stanza[i] = new Stanza(numeroMostri, descrizione);
                        stampaConDelay("\n>Stanza nr " + i + ": " + stanza[i].stampa());

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

                            mostro[j] = new Mostro(nomeMostro, puntiVitaMostro, forzaMostro, difesaMostro, "fisica", descrizioneMostro,
                                    "fisica", quantitaExpMostro, new Oggetto(bottinoMostroArmi, bottinoMostroCategoria, bottinoMostroDescrizione));
                            stampaConDelay(mostro[j].stampa());

                            stampaConDelay("\nAzione sul mostro " + mostro[j].getNome() + ":");
                            personaggio.attacare(mostro[j]);
                            personaggio.subireDanni(10); // Decrementa i punti vita del personaggio

                            // Controlla subito se il personaggio è morto
                            if (personaggio.getPuntiVita() <= 0) {
                                stampaConDelay("💀 " + "Sei morto. La tua avventura termina qui.");
                                break; // Esce dal ciclo dei mostri
                            }
                            stampaConDelay("");

                            int numeroCasualePozione = random.nextInt(RisorseMain.nomiPozioni.length);
                            String nomePozione = RisorseMain.nomiPozioni[numeroCasualePozione];
                            String categoriaPozione = RisorseMain.categoriaPozioni[numeroCasualePozione];
                            String descrizionePozione = RisorseMain.descrizionePozioni[numeroCasualePozione];
                            int puntiFeritaGuariscePozione = RisorseMain.curaPozione[numeroCasualePozione];

                            Pozione pozione = new Pozione(nomePozione, categoriaPozione, descrizionePozione, puntiFeritaGuariscePozione);
                            stampaConDelay(pozione.stampa());
                            puntiVita = puntiVita + puntiFeritaGuariscePozione;
                            stampaConDelay("❤️ " + "Ti sei guarito con la pozione " + pozione.getNome() + " di " + pozione.getPuntiFeritaGuarisce());
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
