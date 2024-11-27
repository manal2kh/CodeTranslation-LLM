import java.util.Scanner;

public class AtCoderABC150D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.next()) / 2;
        }
        
        long lcd = 1;
        for (int i = 0; i < n; i++) {
            lcd = lcm(lcd, a[i]);
            if (lcd > m) {
                System.out.println(0);
                return;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if ((lcd / a[i]) % 2 == 0) {
                System.out.println(0);
                return;
            }
        }
        
        System.out.println((m / lcd + 1) / 2);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b;
    }

    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }
}