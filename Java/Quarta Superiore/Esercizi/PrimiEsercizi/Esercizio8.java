import java.util.Scanner;
/*letto in input un valore numerico, dica se è positivo, negativo o nullo*/ 

class Esercizio8{
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		System.out.print("inserisci un numero intero:");
		double x;
		x = sc.nextDouble();
		
		if (x>=1){
			System.out.print("è positivo");
		}else{
		if (x<=1 && x!=0){
			System.out.print("è negativo");
		}else{
		if (x == 0){
			System.out.print("è nullo");
				}
			}
		}
	}
}