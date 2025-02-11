import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //nome, categoria, descrizione, tipoDanno, danno
        String[] nomiArmi = {"Spada Lunga", "Spada Della Falce", "Spada Del Cavaliere Nero", "Ascia Da Battaglia", "Spada Incantata", "Frusta", "Martello Da Guerra", "Lancia Della Caccia", "Arco Lungo", "Spada Chiodata"};
        String[] categoriaArmi = {"magico", "fisico", "magico", "fisico", "magico", "fisico", "fisico", "magico", "fisico", "magico"};
        String[] descrizioneArmi = {"Lama equilibrata, versatile e robusta", "Lunga, curvata, letale a distanza", "Elegante, potente, simbolo di nobiltà", "Ampia, devastante, ideale per guerre", "Magica, incide poteri arcani", "Flessibile, acuminata, colpi rapidi", "Pesante, potente, schiaccia nemici", "Affilata, lunga, perfetta per cacciatori", "Lontano, preciso, per colpi rapidi", "Artigliata, spietata, causa gravi danni"};
        String[] tipoDannoArmi = {"fisico", "magico", "fisico", "magico", "fisico", "magico", "fisico", "magico", "fisico", "magico"};
        int[] dannoArmi = {4, 12, 1, 16, 9, 14, 6, 17, 10, 20};

        //nome, categoria, descrizione, tipoDifesa, difesa
        String[] nomiArmature = {"Armatura del Cavaliere", "Armatura del Guerriero", "Armatura di Bull-Goat", "Cappa del Bandito", "Armatura di Blaidd", "Armatura del Cavaliere Senza Nome", "Armatura di Raging Wolf", "Armatura di Radagon", "Armatura del Re degli Elden", "Tunica di Faram"};
        String[] categoriaArmature = {"fisico", "magico", "fisico", "magico", "fisico", "magico", "fisico", "magico", "fisico", "magico"};
        String[] descrizioneArmature = {"Armatura pesante, difesa solida", "Resistente, stili combattimento variegati", "Alta resistenza, peso elevato", "Leggera, agilità e furtività", "Elegante, protezione bestiale", "Misteriosa, difesa leggera", "Agilità, protezione equilibrata", "Imponente, resistenza divina", "Potente, resistenza regale suprema", "Leggera, agilità suprema"};
        String[] tipoDifesaArmature = {"magico", "fisico", "magico", "fisico", "magico", "fisico", "fisico", "magico", "fisico", "magico"};
        int[] difesaArmature = {7, 13, 19, 3, 15, 11, 2, 18, 5, 8};

        //nome, categoria, descrizione, puntiFeritaGuarisce
        String[] nomiPozioni = {"Cura Inferiore", "Cura Minore", "Cura Media", "Cura Maggiore", "Cura Superiore"};
        String[] categoriaPozioni = {"cura", "cura", "cura", "cura", "cura", "cura", "cura", "cura", "cura", "cura"};
        String[] descrizionePozioni = {"Ripristino limitato, debole", "Guarigione moderata, efficace", "Ripristino significativo, utile", "Guarigione potente, abbondante", "Ripristino massimo, completo"};
        int[] curaPozione = {10, 25, 50, 75, 100};

        //nome, descrizioni mostri (opzionale)
        String[] nomiMostri = {"Margit", "Radahn", "Rennala", "Malenia", "Godrick", "Mohg", "Fia", "Rykard", "Dracogruppo", "Enia"};
        String[] descrizioneMostri = {"Il Re degli Scherni", "Il Cavaliere della Stella", "Regina della Luna", "Spada di Miquella", "Il Re del Tormento", "Signore del Sangue", "La Signora della Morte", "Signore del Serpente", "Del Bosco degli Alberi Infiammati", "Custode dei Segreti"};

        //descrizione stanze
        String[] descrizioneStanze = {"Oscura sala con pareti scure e rovine", "Caverna ghiacciata illuminata da cristalli tremolanti", "Tempio antico con colonne spezzate e rovine", "Torre abbandonata, il vento ulula forte", "Caverna sotterranea con fiumi di lava ardente", "Giardino silenzioso, statue di pietra sbiadite", "Labirinto di roccia, corridoi stretti e bui", "Cattedrale decadente, candele consumate da tempo", "Sala regale, troni d'oro ormai arrugginiti", "Cimitero desolato, lapidi rotte e muschio", "Fortezza murata, porte di ferro sigillate", "Grotta cristallina, suoni misteriosi nell'oscurità", "Cortile in rovina, erba alta e selvaggia", "Stanza infestata, eco di passi lontani", "Stanza nascosta, antico tesoro sotto sabbia", "Sala di pietra, nebbia che inghiotte tutto", "Cunicoli sotterranei, luce fioca da torce", "Tana di bestie, odore di muschio pungente", "Sala di vetro, luci riflettono sulle superfici", "Antica biblioteca, polvere su vecchi tomi", "Chiesa sconsacrata, il silenzio è opprimente", "Sala di ferro, catene che tintinnano appena", "Caverna profonda, lamenti nell'oscurità senza fine", "Sotterraneo umido, stalattiti pendono come spade", "Antico ponte, nebbia che avvolge tutto", "Sala vuota, ombre che si muovono furtive", "Città distrutta, rovine di un antico regno", "Passaggio segreto, luce tremolante di lanterne", "Stanza sommersa, l'acqua scorre lenta e fredda", "Altare solitario, fiori appassiti su pietra"};

        System.out.println("Ciao Avventuriero!\nInserisci il tuo nome:");
        String nomePersonaggio = sc.next();

        int puntiVita = 100;
        int forza = (int)(Math.random() * 10) + 1;
        int difesa = (int)(Math.random() * 10) + 1;
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
                    int numeroCasualeDescrizione = (int) (Math.random() * 30);
                    String descrizione = descrizioneStanze[numeroCasualeDescrizione];

                    int numeroMostri = (int) (Math.random() * 5) + 1;
                    stanza[i] = new Stanza(numeroMostri, descrizione);
                    System.out.println("\n>Stanza nr " + i + ": " + stanza[i].stampa());

                    for (int j = 0; j < numeroMostri; j++) {
                        int numeroCasualePerMostri = (int) (Math.random() * 5);
                        String nomeMostro = nomiMostri[numeroCasualePerMostri];
                        String descrizioneMostro = descrizioneMostri[numeroCasualePerMostri];

                        int puntiVitaMostro = (int) (Math.random() * 10) + 1;
                        int forzaMostro = (int) (Math.random() * 10) + 1;
                        int difesaMostro = (int) (Math.random() * 10) + 1;
                        int quantitaExpMostro = (int) (Math.random() * 100) + 1;

                        int numeroCasualeBottinoMostro = (int) (Math.random() * 10);
                        String bottinoMostroArmi = nomiArmi[numeroCasualeBottinoMostro];
                        String bottinoMostroCategoria = categoriaArmi[numeroCasualeBottinoMostro];
                        String bottinoMostroDescrizione = descrizioneArmi[numeroCasualeBottinoMostro];

                        mostro[j] = new Mostro(nomeMostro, puntiVitaMostro, forzaMostro, difesaMostro, "fisica", descrizioneMostro, "fisica", quantitaExpMostro, new Oggetto(bottinoMostroArmi, bottinoMostroCategoria, bottinoMostroDescrizione));
                        System.out.println(mostro[j].stampa());

                        System.out.println("\nAzione sul mostro " + mostro[j].getNome() + ":");
                        personaggio.attacare(mostro[j]);
                        personaggio.subireDanni(10);
                        System.out.println();

                        int numeroCasualePozione = (int) (Math.random() * 5);
                        String nomePozione = nomiPozioni[numeroCasualePozione];
                        String categoriaPozione = categoriaPozioni[numeroCasualePozione];
                        String descrizionePozione = descrizionePozioni[numeroCasualePozione];
                        int puntiFeritaGuariscePozione = curaPozione[numeroCasualePozione];

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
