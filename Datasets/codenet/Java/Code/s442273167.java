import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] l = new int[n];		
		int[] r = new int[n];
		for (int i=0; i<n; i++){
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		int sum = 0;
		for (int i=0; i<n; i++){
			sum += r[i] - l[i] + 1;
		}
		System.out.println(sum);
	}
}