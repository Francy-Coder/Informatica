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

            //Casistiche per stampare in modi diversi, per ogni caso possibile
            if(primaVolta) {
                System.out.println("\nBenvenuto in ELDEN-LORD\n" + "Affronta labirinti infidi, sconfiggi creature terrificanti e scopri poteri perduti. Solo i più audaci osano entrare: ti unirai a loro?");
                System.out.println("\n === Cosa vuoi fare? === \n 1. Accetta la sfida\n 2. Ritirati");
                primaVolta = false;
                casoStampa = 1;
            }else{
                if (personaggio.getPuntiVita() <= 0) {
                    System.out.println("\Ti arrenderai o avrai il coraggio di sfidare nuovamente il destino?");
                    System.out.println("\n === Cosa vuoi fare? === \n 1. Ogni tentativo è un passo più vicino al successo\n 2. A volte fermarsi è necessario per andare avanti");
                    casoStampa = 1;
                }else{
                    System.out.println("\nHai vinto!");
                    System.out.println("\n === Cosa vuoi fare? === \n 1. La vittoria è solo l'inizio, c'è sempre altro da conquistare\n 2. La vittoria è il frutto di ogni sforzo, goditela");
                    casoStampa = 2;
                }
            }

            sceltaMenu = sc.nextInt();
            switch (sceltaMenu) {
                case 1:
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

                            //Controlla subito se il personaggio è morto
                            if (personaggio.getPuntiVita() <= 0) {
                                System.out.println("💀 " + "Sei morto. La tua avventura termina qui.");
                                break; //Esce dal ciclo dei mostri
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
