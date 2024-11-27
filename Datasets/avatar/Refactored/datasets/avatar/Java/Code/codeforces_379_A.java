import java.util.Scanner;

public class Codeforces379A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = a;

        while (a >= b) {
            result += (a / b);
            a = (a / b) + (a % b);
        }

        System.out.println(result);
    }
}