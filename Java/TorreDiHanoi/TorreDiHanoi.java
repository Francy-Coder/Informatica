import java.util.Scanner;
import java.util.Stack;

class Pila extends Stack<Integer> {
    private String nome;
    
    public Pila(String nome) {
        super();
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    @Override
    public Integer push(Integer disco) {
        if (isEmpty() || disco < peek()) {
            return super.push(disco);
        }
        return null; 
    }
}

class Colonne {
    private Pila[] torri;
    private int numeroDischi;
    
    public Colonne(int numeroDischi) {
        this.numeroDischi = numeroDischi;
        torri = new Pila[3];
        torri[0] = new Pila("Colonna1");
        torri[1] = new Pila("Colonna2");
        torri[2] = new Pila("Colonna3");
        
        for (int i = numeroDischi; i >= 1; i--) {
            torri[0].push(i);
        }
    }
    
    public boolean spostaDisco(int da, int a) {
        if (da < 1 || da > 3 || a < 1 || a > 3 || torri[da-1].isEmpty()) {
            return false;
        }
        
        Integer disco = torri[da-1].peek();
        Integer risultato = torri[a-1].push(disco);
        
        if (risultato != null) {
            torri[da-1].pop();
            return true;
        }
        return false;
    }
    
    public void stampaTorri() {
        Stack<Integer>[] copie = new Stack[3];
        for (int i = 0; i < 3; i++) {
            copie[i] = (Stack<Integer>) torri[i].clone();
        }
        
        for (int livello = numeroDischi - 1; livello >= 0; livello--) {
            for (int i = 0; i < 3; i++) {
                if (copie[i].size() > livello) {
                    Stack<Integer> temp = new Stack<>();
                    while (copie[i].size() > livello + 1) {
                        temp.push(copie[i].pop());
                    }
                    System.out.print(copie[i].peek() + " ");
                    while (!temp.isEmpty()) {
                        copie[i].push(temp.pop());
                    }
                } else {
                    System.out.print("  ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        
        System.out.println("Colonna1 - Colonna2 - Colonna3");
        
        System.out.print("size: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(torri[i].size() + " ");
        }
        System.out.println();
    }
    
    public boolean giocoFinito() {
        return torri[0].isEmpty() && (torri[1].size() == numeroDischi || torri[2].size() == numeroDischi);
    }
    
    public Pila getTorre(int indice) {
        if (indice >= 0 && indice < 3) {
            return torri[indice];
        }
        return null;
    }
}

public class TorreDiHanoi {
    private static Scanner scanner = new Scanner(System.in);
    private static int mosse = 0;
    
    public static void main(String[] args) {
        System.out.println("=== TORRE DI HANOI ===");
        System.out.print("Inserisci il numero di dischi (minimo 3): ");
        int numeroDischi = scanner.nextInt();
        
        if (numeroDischi < 3) {
            System.out.println("Il numero minimo di dischi è 3. Imposto a 3.");
            numeroDischi = 3;
        }
        
        Colonne colonne = new Colonne(numeroDischi);
        
        boolean esci = false;
        while (!esci && !colonne.giocoFinito()) {
            System.out.println("\n=== Situazione Attuale ===");
            colonne.stampaTorri();
            System.out.println("Mosse effettuate: " + mosse);
            
            System.out.println("\nMenu:");
            System.out.println("1- Sposta disco");
            System.out.println("2- Esci");
            System.out.print("Cosa scegli di fare: ");
            
            int scelta = scanner.nextInt();
            
            switch (scelta) {
                case 1:
                    System.out.print("Scegli la colonna da cui togliere il disco (1-3): ");
                    int da = scanner.nextInt();
                    System.out.print("Scegli dove mettere il disco (1-3): ");
                    int a = scanner.nextInt();
                    
                    if (da == a) {
                        System.out.println("Errore: la colonna di partenza e destinazione sono uguali!");
                        break;
                    }
                    
                    // Controlla se la mossa è valida
                    Pila torreDa = colonne.getTorre(da-1);
                    Pila torreA = colonne.getTorre(a-1);
                    
                    if (torreDa == null || torreA == null) {
                        System.out.println("Errore: colonna non valida!");
                        break;
                    }
                    
                    System.out.println("Sposto il disco dalla colonna " + da + " alla colonna " + a);
                    
                    if (colonne.spostaDisco(da, a)) {
                        mosse++;
                        System.out.println("Mossa valida!");
                    } else {
                        if (torreDa.isEmpty()) {
                            System.out.println("Errore: la colonna " + da + " è vuota!");
                        } else {
                            System.out.println("Non puoi spostare un disco grande sopra uno piccolo!");
                        }
                    }
                    break;
                    
                case 2:
                    esci = true;
                    System.out.println("Grazie per aver giocato!");
                    break;
                    
                default:
                    System.out.println("Scelta non valida!");
            }
        }
        
        if (colonne.giocoFinito()) {
            System.out.println("\n=== COMPLIMENTI! ===");
            System.out.println("Hai completato la Torre di Hanoi con " + numeroDischi + " dischi!");
            System.out.println("Mosse totali: " + mosse);
            colonne.stampaTorri();
        }
        
        scanner.close();
    }
}
