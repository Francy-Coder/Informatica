package GiocoDiRuolo;

/*
Un “Oggetto” rappresenta un elemento "non vivente" nel gioco (armi, armature e pozioni).
E’ caratterizzata dal nome, la categoria e la descrizione. Offre le funzionalità Getter/Setter e toString.

Oggetto

- nome : String
- categoria : String
- descrizione : String

+ oggetto(nome:String, categoria:String, descrizione:String)
+ getNome() : String
+ setNome(nome:String)
+ getCategoria() : String
+ setCategoria(categoria:String)
+ getDescrizione() : String
+ setDescrizione(descrizione:String)
*/

public class Oggetto{
    private String nome;
    private String categoria;
    private String descrizione;

    public Oggetto(String nome, String categoria, String descrizione){
        this.nome = nome;
        this.categoria = categoria;
        this.descrizione = descrizione;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String puntiVita){
        this.nome = nome;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public void setDescrizione(String descrizione){
        this.descrizione = descrizione;
    }

    public String stampa(){
        return "🎒 " + "Nome: " + getNome() + " - Categoria: " + getCategoria() + " - Descrizione: " + getDescrizione();
    }
}
