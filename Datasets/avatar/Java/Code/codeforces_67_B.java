import java.io.* ; import java.util.* ; public class codeforces_67_B extends PrintWriter { codeforces_67_B ( ) { super ( System.out , true ) ; } Scanner sc = new Scanner ( System.in ) ; public static void main ( String [ ] $ ) { codeforces_67_B o = new codeforces_67_B ( ) ; o.main ( ) ; o.flush ( ) ; } void main ( ) { int n = sc.nextInt ( ) ; int k = sc.nextInt ( ) ; int [ ] bb = new int [ n ] ; for ( int i = 0 ; i < n ; i ++ ) bb [ i ] = sc.nextInt ( ) ; int [ ] aa = new int [ n ] ; int m = 0 ; for ( int a = n - 1 ; a >= 0 ; a -- ) { int j = 0 ; while ( bb [ a ] > 0 ) { if ( aa [ j ] >= a + k ) bb [ a ] -- ; j ++ ; } for ( int j_ = m ++ ; j_ > j ; j_ -- ) aa [ j_ ] = aa [ j_ - 1 ] ; aa [ j ] = a ; } for ( int i = 0 ; i < n ; i ++ ) print ( aa [ i ] + 1 + " " ) ; println ( ) ; } }