/*
Una “Arma” è derivata da oggetto e aggiunge il tipoDanno (fisico o magico) e il danno. Offre i metodi Getter/Setter e toString.

Arma extends Oggetto

- tipoDanno : String
- danno : int

+ arma(nome:String, categoria:String, descrizione:String, tipoDanno:String, danno:int)
+ getTipoDanno() : String
+ setTipoDanno(tipoDanno:String)
+ getDanno() : int
+ setDanno(danno:int)
*/

public class Arma extends Oggetto{
    private String tipoDanno;
    private int danno;

    public Arma(String nome, String categoria, String descrizione, String tipoDanno, int danno){
        super(nome, categoria, descrizione);
        this.tipoDanno = tipoDanno;
        this.danno = danno;
    }

    public String getTipoDanno(){
        return tipoDanno;
    }

    public void setTipoDanno(String tipoDanno){
        this.tipoDanno = tipoDanno;
    }

    public int getDanno(){
        return danno;
    }

    public void setDanno(int danno){
        this.danno = danno;
    }

    @Override
    public String stampa(){
        return super.stampa() + " - Tipo danno: " + getTipoDanno() + " - Danno: " + getDanno();
    }
}