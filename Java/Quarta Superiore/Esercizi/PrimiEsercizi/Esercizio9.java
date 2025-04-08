import java.util.Scanner;
/*presi in input 3 numeri, visualizzi il valore maggiore*/

class Esercizio9{
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		System.out.print("inserisci tre numeri interi:");
		double x;
		double y;
		double z;
		double risultato1;
		double risultato2;
		double risultato3;
		x = sc.nextDouble();
		y = sc.nextDouble();
		z = sc.nextDouble();
		
		if (x>y && x>z){
			System.out.print("x maggiore");	
		}else{
		if (y>x && y>z){
			System.out.print("y maggiore");
		}else{
		if (z>x && z>y){ 
			System.out.print("z maggiore");	
				}
			}
		}
	}
}