import java.util.* ; public class codeforces_596_B { public static void main ( String [ ] args ) { Scanner scan = new Scanner ( System.in ) ; int n = scan.nextInt ( ) ; long [ ] arr = new long [ n ] ; for ( int i = 0 ; i < n ; i ++ ) { arr [ i ] = scan.nextInt ( ) ; } long answer = Math.abs ( arr [ 0 ] ) ; for ( int i = 1 ; i < n ; i ++ ) { answer += Math.abs ( arr [ i ] - arr [ i - 1 ] ) ; } System.out.println ( answer ) ; } }