import java.util.ArrayList ; import java.util.Arrays ; import java.util.Scanner ; public class codeforces_456_A { static ArrayList md = new ArrayList ( ) ; public static void main ( String [ ] args ) { Scanner in = new Scanner ( System.in ) ; int n = in.nextInt ( ) ; int [ ] a = new int [ n ] ; int [ ] b = new int [ n ] ; int temp = 0 ; int q = 0 ; int w = 0 , e = 0 ; boolean f = false ; for ( int i = 0 ; i < n ; i ++ ) { a [ i ] = in.nextInt ( ) ; b [ i ] = in.nextInt ( ) ; if ( temp < a [ i ] ) { if ( q > b [ i ] ) { f = true ; } q = b [ i ] ; temp = a [ i ] ; } if ( temp > a [ i ] ) { if ( q < b [ i ] ) { f = true ; } q = b [ i ] ; temp = a [ i ] ; } if ( a [ i ] > w ) { w = a [ i ] ; if ( b [ i ] < e ) { f = true ; } e = b [ i ] ; } if ( a [ i ] < w ) { if ( b [ i ] > e ) { f = true ; } } } if ( f == true ) { System.out.println ( "Happy Alex" ) ; } else System.out.println ( "Poor Alex" ) ; } }
