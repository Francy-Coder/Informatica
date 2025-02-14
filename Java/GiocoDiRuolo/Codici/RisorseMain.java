public class RisorseMain {
    //nome, categoria, descrizione, tipoDanno, danno
    public static final String[] nomiArmi = {"Spada Lunga", "Spada Della Falce", "Spada Del Cavaliere Nero", "Ascia Da Battaglia", "Spada Incantata", "Frusta", "Martello Da Guerra", "Lancia Della Caccia", "Arco Lungo", "Spada Chiodata"};
    public static final String[] categoriaArmi = {"magico", "fisico", "magico", "fisico", "magico", "fisico", "fisico", "magico", "fisico", "magico"};
    public static final String[] descrizioneArmi = {"Lama equilibrata, versatile e robusta", "Lunga, curvata, letale a distanza", "Elegante, potente, simbolo di nobiltà", "Ampia, devastante, ideale per guerre", "Magica, incide poteri arcani", "Flessibile, acuminata, colpi rapidi", "Pesante, potente, schiaccia nemici", "Affilata, lunga, perfetta per cacciatori", "Lontano, preciso, per colpi rapidi", "Artigliata, spietata, causa gravi danni"};
    public static final String[] tipoDannoArmi = {"fisico", "magico", "fisico", "magico", "fisico", "magico", "fisico", "magico", "fisico", "magico"};
    public static final int[] dannoArmi = {4, 12, 1, 16, 9, 14, 6, 17, 10, 20};

    //nome, categoria, descrizione, tipoDifesa, difesa
    public static final String[] nomiArmature = {"Armatura del Cavaliere", "Armatura del Guerriero", "Armatura di Bull-Goat", "Cappa del Bandito", "Armatura di Blaidd", "Armatura del Cavaliere Senza Nome", "Armatura di Raging Wolf", "Armatura di Radagon", "Armatura del Re degli Elden", "Tunica di Faram"};
    public static final String[] categoriaArmature = {"fisico", "magico", "fisico", "magico", "fisico", "magico", "fisico", "magico", "fisico", "magico"};
    public static final String[] descrizioneArmature = {"Armatura pesante, difesa solida", "Resistente, stili combattimento variegati", "Alta resistenza, peso elevato", "Leggera, agilità e furtività", "Elegante, protezione bestiale", "Misteriosa, difesa leggera", "Agilità, protezione equilibrata", "Imponente, resistenza divina", "Potente, resistenza regale suprema", "Leggera, agilità suprema"};
    public static final String[] tipoDifesaArmature = {"magico", "fisico", "magico", "fisico", "magico", "fisico", "fisico", "magico", "fisico", "magico"};
    public static final int[] difesaArmature = {7, 13, 19, 3, 15, 11, 2, 18, 5, 8};

    //nome, categoria, descrizione, puntiFeritaGuarisce
    public static final String[] nomiPozioni = {"Cura Inferiore", "Cura Minore", "Cura Media", "Cura Maggiore", "Cura Superiore"};
    public static final String[] categoriaPozioni = {"cura", "cura", "cura", "cura", "cura", "cura", "cura", "cura", "cura", "cura"};
    public static final String[] descrizionePozioni = {"Ripristino limitato, debole", "Guarigione moderata, efficace", "Ripristino significativo, utile", "Guarigione potente, abbondante", "Ripristino massimo, completo"};
    public static final int[] curaPozione = {10, 25, 50, 75, 100};

    //nome, descrizioni mostri (opzionale)
    public static final String[] nomiMostri = {"Margit", "Radahn", "Rennala", "Malenia", "Godrick", "Mohg", "Fia", "Rykard", "Dracogruppo", "Enia"};
    public static final String[] descrizioneMostri = {"Il Re degli Scherni", "Il Cavaliere della Stella", "Regina della Luna", "Spada di Miquella", "Il Re del Tormento", "Signore del Sangue", "La Signora della Morte", "Signore del Serpente", "Del Bosco degli Alberi Infiammati", "Custode dei Segreti"};

    //descrizione stanze
    public static final String[] descrizioneStanze = {"Oscura sala con pareti scure e rovine", "Caverna ghiacciata illuminata da cristalli tremolanti", "Tempio antico con colonne spezzate e rovine", "Torre abbandonata, il vento ulula forte", "Caverna sotterranea con fiumi di lava ardente", "Giardino silenzioso, statue di pietra sbiadite", "Labirinto di roccia, corridoi stretti e bui", "Cattedrale decadente, candele consumate da tempo", "Sala regale, troni d'oro ormai arrugginiti", "Cimitero desolato, lapidi rotte e muschio", "Fortezza murata, porte di ferro sigillate", "Grotta cristallina, suoni misteriosi nell'oscurità", "Cortile in rovina, erba alta e selvaggia", "Stanza infestata, eco di passi lontani", "Stanza nascosta, antico tesoro sotto sabbia", "Sala di pietra, nebbia che inghiotte tutto", "Cunicoli sotterranei, luce fioca da torce", "Tana di bestie, odore di muschio pungente", "Sala di vetro, luci riflettono sulle superfici", "Antica biblioteca, polvere su vecchi tomi", "Chiesa sconsacrata, il silenzio è opprimente", "Sala di ferro, catene che tintinnano appena", "Caverna profonda, lamenti nell'oscurità senza fine", "Sotterraneo umido, stalattiti pendono come spade", "Antico ponte, nebbia che avvolge tutto", "Sala vuota, ombre che si muovono furtive", "Città distrutta, rovine di un antico regno", "Passaggio segreto, luce tremolante di lanterne", "Stanza sommersa, l'acqua scorre lenta e fredda", "Altare solitario, fiori appassiti su pietra"};
}
