import java.util.Scanner;

class Main {
	public static void main(String[] args) {
	
	Scanner stdIn = new Scanner(System.in);
	
	short r = stdIn.nextShort();
	
	if (r < 1200) {
		System.out.println("ABC");
		return;
	}
	
	if (r < 2800) {
		System.out.println("ARC");
		return;
	}
	
	System.out.println("AGC");
	
	}

}