/*
Una “Armatura” è derivata da oggetto e aggiunge il tipoDifesa (fisico o magico) e la difesa. Offre i metodi Getter/Setter e toString.

Armatura extends Oggetto

- tipoDifesa : String
- difesa : int

+ armatura(nome:String, categoria:String, descrizione:String, tipoDifesa:String, difesa:int)
+ getTipoDifesa() : String
+ setTipoDifesa(tipoDifesa:String)
+ getDifesa() : int
+ setDifesa(difesa:int)
*/

public class Armatura extends Oggetto{
    private String tipoDifesa;
    private int difesa;

    public Armatura(String nome, String categoria, String descrizione, String tipoDifesa, int difesa){
        super(nome, categoria, descrizione);
        this.tipoDifesa = tipoDifesa;
        this.difesa = difesa;
    }

    public String getTipoDifesa(){
        return tipoDifesa;
    }

    public void setTipoDifesa(String tipoDifesa){
        this.tipoDifesa = tipoDifesa;
    }

    public int getDifesa(){
        return difesa;
    }

    public void setDifesa(int difesa){
        this.difesa = difesa;
    }

    @Override
    public String stampa(){
        return super.stampa() + " - Tipo difesa: " + getTipoDifesa() + " - Difesa: " + getDifesa();
    }
}