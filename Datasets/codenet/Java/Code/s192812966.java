import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int w = scanner.nextInt(),h = scanner.nextInt(),n = scanner.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] a = new int[n];
		int xmax = w,xmin = 0;
		int ymax = h,ymin = 0;
		for(int i=0;i<n;i++){
			x[i] = scanner.nextInt();
			y[i] = scanner.nextInt();
			a[i] = scanner.nextInt();
			switch(a[i]){

			case 1:
				xmin = Math.max(xmin, x[i]);
				break;
			case 2:
				xmax = Math.min(xmax, x[i]);
				break;
			case 3:
				ymin = Math.max(ymin, y[i]);
				break;
			case 4:
				ymax = Math.min(ymax, y[i]);
				break;
			}
		}
		w = Math.max(xmax-xmin, 0);
		h = Math.max(ymax-ymin, 0);

		System.out.println(w*h);

	}

}
