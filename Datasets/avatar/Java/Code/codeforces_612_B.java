import java.util.Scanner ; public class codeforces_612_B { public static void main ( String args [ ] ) { Scanner s = new Scanner ( System.in ) ; int n = s.nextInt ( ) ; int dp [ ] = new int [ 200001 ] ; for ( int i = 0 ; i < n ; i ++ ) { dp [ s.nextInt ( ) ] = i ; } long ans = 0 ; for ( int i = 2 ; i <= n ; i ++ ) { ans += Math.abs ( dp [ i ] - dp [ i - 1 ] ) ; } System.out.println ( ans ) ; } }
