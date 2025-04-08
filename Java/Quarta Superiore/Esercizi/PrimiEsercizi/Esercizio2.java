import java.util.Scanner;
/**
	Legge un numero intero e lo stampa a video 
*/
class Esercizio2{
	public static void main(String[] args){
		/* tipo Scanner
		   nome sc
		   System.in indica la tastiera
		*/ 
		Scanner sc = new Scanner(System.in);
		//leggere un numero intero
		int numero;
		
		System.out.print("Inserisci un numero intero:");
		numero = sc.nextInt();
		System.out.print(numero);
	}
}