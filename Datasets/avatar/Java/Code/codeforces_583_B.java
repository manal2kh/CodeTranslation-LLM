import java.util.* ; public class codeforces_583_B { public static void main ( String [ ] args ) { Scanner in = new Scanner ( System.in ) ; while ( in.hasNext ( ) ) { int n = in.nextInt ( ) ; int [ ] a = new int [ n ] ; int [ ] b = new int [ n ] ; int s = - 1 ; for ( int i = 0 ; i < n ; i ++ ) { a [ i ] = in.nextInt ( ) ; b [ i ] = 0 ; } int tem = 1 ; int q = 0 ; while ( q != n ) { s ++ ; if ( tem == 1 ) { for ( int i = 0 ; i < n ; i ++ ) { if ( a [ i ] <= q && b [ i ] == 0 ) { b [ i ] = 1 ; q ++ ; } } tem = 0 ; } else { for ( int i = n - 1 ; i >= 0 ; i -- ) { if ( a [ i ] <= q && b [ i ] == 0 ) { b [ i ] = 1 ; q ++ ; } } tem = 1 ; } } System.out.println ( s ) ; } } }
