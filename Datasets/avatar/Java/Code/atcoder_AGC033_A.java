import java.util.* ; public class atcoder_AGC033_A { public static void main ( String [ ] args ) { Scanner sc = new Scanner ( System.in ) ; int H = sc.nextInt ( ) ; int W = sc.nextInt ( ) ; char [ ] [ ] A = new char [ H ] [ W ] ; Queue < int [ ] > queue = new ArrayDeque < int [ ] > ( ) ; for ( int i = 0 ; i < H ; i ++ ) { String row = sc.next ( ) ; for ( int j = 0 ; j < W ; j ++ ) { A [ i ] [ j ] = row.charAt ( j ) ; if ( A [ i ] [ j ] == '#' ) { int [ ] start = { i , j , 0 } ; queue.add ( start ) ; } } } int [ ] [ ] flag = new int [ H ] [ W ] ; int ans = 0 ; int [ ] dx = { 1 , - 1 , 0 , 0 } ; int [ ] dy = { 0 , 0 , 1 , - 1 } ; loop : while ( ! queue.isEmpty ( ) ) { int [ ] temp = queue.remove ( ) ; int y = temp [ 0 ] ; int x = temp [ 1 ] ; int depth = temp [ 2 ] ; for ( int i = 0 ; i < 4 ; i ++ ) { if ( 0 <= y + dy [ i ] && y + dy [ i ] <= H - 1 && 0 <= x + dx [ i ] && x + dx [ i ] <= W - 1 ) { if ( flag [ y + dy [ i ] ] [ x + dx [ i ] ] == 0 && A [ y + dy [ i ] ] [ x + dx [ i ] ] == '.' ) { flag [ y + dy [ i ] ] [ x + dx [ i ] ] = 1 ; int [ ] queue_add = { y + dy [ i ] , x + dx [ i ] , depth + 1 } ; queue.add ( queue_add ) ; ans = depth + 1 ; } } } } System.out.println ( ans ) ; } }
