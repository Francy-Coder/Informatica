package GiocoDiRuolo;

/*
Un “Mostro” è derivato dalla classe Entità, ereditando gli attributi e i metodi.
Aggiungerà caratteristiche specifiche come il tipo di attacco (fisico o magico) e la quantità di esperienza che il giocatore guadagna sconfiggendolo.
Oltre alle funzionalità  getter/setter e toString implementi i metodi della classe Entità. Il calcolo del danno subito è dato dal danno ricevuto - la difesa.
Inoltre il mostro una volta che muori potrebbe lasciare un bottino, la percentuale è data da il livello *10%.
Ogni mostro ha un bottino fissato quando si crea il mostro che può essere un’arma, un’armatura o una pozione.

Mostro extends Entita

- tipoAttacco : String
- quantitaExp : int

+ entita(nome:String, pruntiVita:int, forza:int, difesa:String, tipoAttacco:String, quantitaExp:int)
+ getTipoAttacco() : String
+ setTipoAttacco(tipoAttacco:String)
+ getQuantitaExp() : int
+ setQuantitaExp(quantitaExp:int)
*/

public class Mostro extends Entita{
    private String descrizione; //Non sicuro
    private String tipoAttacco;
    private int quantitaExp;
    private Oggetto bottino;

    public Mostro(String nome, int puntiVita, int forza, int difesa, String tipoDifesa, String descrizione, String tipoAttacco, int quantitaExp, Oggetto bottino){
        super(nome, puntiVita, forza, difesa, tipoDifesa);
        this.descrizione = descrizione;
        this.tipoAttacco = tipoAttacco;
        this.quantitaExp = quantitaExp;
        this.bottino = bottino;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipoAttacco(){
        return tipoAttacco;
    }

    public void setTipoAttacco(String tipoAttacco){
        this.tipoAttacco = tipoAttacco;
    }

    public int getQuantitaExp(){
        return quantitaExp;
    }

    public void setQuantitaExp(int quantitaExp){
        this.quantitaExp = quantitaExp;
    }

    public Oggetto getBottino(){
        return bottino;
    }

    public void setBottino(Oggetto bottino){
        this.bottino = bottino;
    }

    @Override
    public void attaccare(Entita target){
        int danno = this.getForza();
        target.subireDanni(danno);
        System.out.println(this.getNome() + " attacca con un danno " + tipoAttacco + " di " + danno);
    }

    public void subireDanni(int danno){
        int dannoEffettivo = danno - this.getDifesa();
        if (dannoEffettivo > 0) {
            this.setPuntiVita(this.getPuntiVita() - dannoEffettivo);
        }
        System.out.println(this.getNome() + " subisce " + dannoEffettivo + " danni. Punti vita restanti: " + this.getPuntiVita()); // Forse non necesario
    }

    public String stampa(){
        return super.stampa() + " - Descrizione: " + getDescrizione() + " - Tipo attacco: " + getTipoAttacco() + " Quantita EXP: " + getQuantitaExp();
    }
}
