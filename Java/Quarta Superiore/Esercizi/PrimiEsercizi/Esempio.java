import java.util.Scanner;

class Esempio{
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		System.out.print("Inserisci un numero intero:");
		double x;
		x = sc.nextDouble();
		if(x<0){
			System.out.print("negativo");
		}else{
			System.out.print("positivio");
		}
	}
}