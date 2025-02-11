/*
Una “Stanza” è caratterizzata da uno o più mostri (opzionale per un massimo di 5) e la descrizione. Offre i metodi Getter/Setter e toString.

Stanza

- numeroMostri : int
- descrizione : String

+ stanza(numeroMostri:int, descrizione:String)
+ getNumeroMostri() : int
+ setNumeroMostri(numeroMostri:String)
+ getDescrizione() : String
+ setDescrizione(descrizione:String)
*/

public class Stanza{
    private int numeroMostri;
    private String descrizione;

    public Stanza(int numeroMostri, String descrizione){
        this.numeroMostri = numeroMostri;
        this.descrizione = descrizione;
    }

    public int getNumeroMostri(){
       /*
       int numeroCasualeNumeroMostri = (int)(Math.random() * 5) + 1;
       return numeroMostri = numeroCasualeNumeroMostri;
       */
        return numeroMostri;
    }

    public void setNumeroMostri(int numeroMostri){
        this.numeroMostri = numeroMostri;
    }

    public String getDescrizione(){
       /*
       String[] descrizioneStanze = {"Oscura sala con pareti scure e rovine", "Caverna ghiacciata illuminata da cristalli tremolanti", "Tempio antico con colonne spezzate e rovine", "Torre abbandonata, il vento ulula forte", "Caverna sotterranea con fiumi di lava ardente", "Giardino silenzioso, statue di pietra sbiadite", "Labirinto di roccia, corridoi stretti e bui", "Cattedrale decadente, candele consumate da tempo", "Sala regale, troni d'oro ormai arrugginiti", "Cimitero desolato, lapidi rotte e muschio", "Fortezza murata, porte di ferro sigillate", "Grotta cristallina, suoni misteriosi nell'oscurità", "Cortile in rovina, erba alta e selvaggia", "Stanza infestata, eco di passi lontani", "Stanza nascosta, antico tesoro sotto sabbia", "Sala di pietra, nebbia che inghiotte tutto", "Cunicoli sotterranei, luce fioca da torce", "Tana di bestie, odore di muschio pungente", "Sala di vetro, luci riflettono sulle superfici", "Antica biblioteca, polvere su vecchi tomi"};
       int numeroCasualeDescrizione = (int)(Math.random() * 20) + 1;
       return descrizione = descrizioneStanze[numeroCasualeDescrizione];
       */
        return descrizione;
    }

    public void setDescrizione(String descrizione){
        this.descrizione = descrizione;
    }

    public String stampa(){
        return "Numero mostri: " + getNumeroMostri() + " - Descrizione stanza: " + getDescrizione();
    }
}