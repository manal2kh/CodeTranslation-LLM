import java.util.Arrays ; import java.util.Scanner ; public class codeforces_108_B { public static void main ( String [ ] args ) { Scanner in = new Scanner ( System.in ) ; int n = in.nextInt ( ) ; int a [ ] = new int [ n ] ; for ( int i = 0 ; i < n ; i ++ ) { a [ i ] = in.nextInt ( ) ; } Arrays.sort ( a ) ; for ( int i = 0 ; i < a.length - 1 ; i ++ ) { if ( a [ i + 1 ] < a [ i ] * 2 && a [ i ] != a [ i + 1 ] ) { System.out.println ( "YES" ) ; return ; } } System.out.println ( "NO" ) ; } }
