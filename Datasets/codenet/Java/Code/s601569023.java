import java.util.Scanner;
 
class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num<1200)
            System.out.println("ABC");
        else
            System.out.println("ARC");
    }
}