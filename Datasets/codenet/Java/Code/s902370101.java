import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		int max = 0;
		int min = 10000;
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
			if (max < array[i]) {
				max = array[i];
			}

			if (min > array[i]) {
				min = array[i];
			}
		}
		System.out.println(max - min);
		sc.close();
	}

}
