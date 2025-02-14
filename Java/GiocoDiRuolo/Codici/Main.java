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

        System.out.println("Affronta labirinti infidi, sconfiggi creature terrificanti e scopri poteri perduti. Solo i più audaci osano entrare: ti unirai a loro?");

        System.out.println("\nCosa vuoi fare?\n 1. Accetta la sfida\n 2. Ritirati\n");
        int sceltaMenu = sc.nextInt();

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
                        personaggio.subireDanni(10);
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
                }
                break;
        }
    }
}
