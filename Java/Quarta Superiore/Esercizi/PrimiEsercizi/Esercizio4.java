import java.util.Scanner;
/*dati due numeri calcoli la somma se sono entrambi positivi, altrimenti  il prodotto*/

class Esercizio4{
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		System.out.print("Inserisci due numeri interi:");
		double x;
		double y;
		x = sc.nextDouble();
		y = sc.nextDouble();
		double somma;
		double prodotto;
			if(y>0 && x>0) {
			somma=x+y;
			System.out.print(somma);
		}else{
			prodotto=x*y;
			System.out.print(prodotto);
		}
	}
}