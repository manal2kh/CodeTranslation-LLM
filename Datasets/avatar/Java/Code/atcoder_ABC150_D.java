import java.util.*;

public class atcoder_ABC150_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.next()) / 2;
        }
        long gcd;
        long lcd = 1;
        for (int i = 0; i < n; i++) {
            gcd = getGCD(lcd, a[i]);
            lcd = lcd * a[i] / gcd;
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

    public static long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }
}
