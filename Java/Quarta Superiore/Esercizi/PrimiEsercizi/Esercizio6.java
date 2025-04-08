import java.util.Scanner;
/*letti in input due numeri interi, verifichi se il primo è multiplo del secondo*/

class Esercizio6{
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		System.out.println("inserisci due numeri interi:");
		double x;
		double y;
		x = sc.nextDouble();
		y = sc.nextDouble();
		
		if ((x % y) == 0){
			System.out.print("é un multiplo");	
		}else{ 
			System.out.print("non é un multiplo");
		}
	}	
}
	
	