import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int X = scan.nextInt();
		int t = scan.nextInt();
		
		if(X>=t){
			System.out.println(X-t);
		} else if (X<t){
			System.out.print(0);
		}
		

	}
}