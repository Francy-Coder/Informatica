import java.util.Scanner;
/*dato un numero intero in input, visualizza il suo doppio se è pari, il triplo se è dispari*/

class Esercizio7{
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		System.out.print("inserisci un numero intero:");
		double x;
		double y;
		double risultato1;
		double risultato2;
		x = sc.nextDouble();
		
		y = 2;
		if ((x % y) == 0){
			risultato1 = x*2;
			System.out.print(risultato1);
		}else{
			risultato2 = x*3;
			System.out.print(risultato2);
		}
	}
}
		
		
		