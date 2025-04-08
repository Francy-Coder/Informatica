import java.util.Scanner;
/*dato il prezzo di un prodotto applichi uno sconto del 12% se il prezzo è inferiore a € 30 del 25% altrimenti*/

class Esercizio5{
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		double prezzo;
		double sconto1;
		double sconto2;
		double risultato1;
		double risultato2;
		prezzo = sc.nextDouble();

		sconto1 = 0.12;
		sconto2 = 0.25;
			if (prezzo<30){
			risultato1 = prezzo*sconto1; 
			System.out.print(risultato1);
		}else{
			risultato2 = prezzo*sconto2;
			System.out.print(risultato2);
		}
	}
}