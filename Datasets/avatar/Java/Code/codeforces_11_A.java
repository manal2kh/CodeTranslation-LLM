import java.util.Scanner ; public class codeforces_11_A { public static void main ( String [ ] args ) { Scanner in = new Scanner ( System.in ) ; int n = in.nextInt ( ) ; int d = in.nextInt ( ) ; int [ ] nums = new int [ n ] ; for ( int i = 0 ; i < n ; i ++ ) { nums [ i ] = in.nextInt ( ) ; } int result = 0 ; int a = 0 ; for ( int i = 1 ; i < n ; i ++ ) { a = ( nums [ i - 1 ] - nums [ i ] ) ; if ( a >= 0 ) { result += a / d + 1 ; nums [ i ] += ( a / d + 1 ) * d ; } } System.out.println ( result ) ; } }
