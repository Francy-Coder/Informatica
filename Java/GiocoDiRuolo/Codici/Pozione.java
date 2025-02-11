/*
Una “Pozione” è derivata da oggetto e aggiunge i punti ferita che guarisce. Offre i metodi Getter/Setter e toString.

Pozione extends Oggetto

- puntiFeritaGuarisce : int

+ pozione(nome:String, categoria:String, descrizione:String, puntiFeritaGuarisce:int)
+ getPuntiFeritaGuarisce() : int
+ setPuntiFeritaGuarisce(puntiFeritaGuarisce:int)
*/

public class Pozione extends Oggetto{
    private int puntiFeritaGuarisce;

    public Pozione(String nome, String categoria, String descrizione, int puntiFeritaGuarisce){
        super(nome, categoria, descrizione);
        this.puntiFeritaGuarisce = puntiFeritaGuarisce;
    }

    public int getPuntiFeritaGuarisce(){
        return puntiFeritaGuarisce;
    }

    public void puntiFeritaGuarisce(int puntiFeritaGuarisce){
        this.puntiFeritaGuarisce = puntiFeritaGuarisce;
    }

    @Override
    public String stampa(){
        return super.stampa() + " - Punti ferita che guarisce: " + getPuntiFeritaGuarisce();
    }
}