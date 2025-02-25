/*
Una “Entità” rappresenta un elemento "vivente" nel gioco (Personaggio e Mostro). E’ caratterizzata dal nome, punti vita, forza, difesa (fisica e/o magica).
Oltre alle funzionalità  getter/setter e toString, ci sono anche i metodi per attaccare e subireDanni, di cui non sappiamo ancora come saranno implementati.

Entita

- nome : String
- puntiVita : int
- forza : int
- difesa : String

+ entita(nome:String, puntiVita:int, forza:int, difesa:String)
+ getNome() : String
+ setNome(nome:String)
+ getPuntiVita() : int
+ setPuntiVita(puntiVita:int)
+ getForza() : int
+ setForza(forza:int)
+ getDifesa() : String
+ setDifesa(difesa:String)

+ attacare() : abstract
+ subireDanni() : abstract
*/

public abstract class Entita {
    private String nome;
    private int puntiVita;
    private int forza;
    private int difesa;
    private String tipoDifesa;

    public Entita(String nome, int puntiVita, int forza, int difesa, String tipoDifesa) {
        this.nome = nome;
        this.puntiVita = puntiVita;
        this.forza = forza;
        this.difesa = difesa;
        this.tipoDifesa = tipoDifesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String puntiVita) {
        this.nome = nome;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public void setPuntiVita(int puntiVita) {
        this.puntiVita = puntiVita;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }

    public String getTipoDifesa() {
        return tipoDifesa;
    }

    public void setDifesa(String Difesa) {
        this.tipoDifesa = tipoDifesa;
    }

    public abstract void attacare(Entita target);

    public abstract void subireDanni(int danno);

    public String stampa() {
        return "Nome: " + getNome() + " - Punti vita: " + getPuntiVita() + " - Forza: " + getForza() + " - Difesa: " + getDifesa() + " - Tipo difesa: " + getTipoDifesa();
    }
}
