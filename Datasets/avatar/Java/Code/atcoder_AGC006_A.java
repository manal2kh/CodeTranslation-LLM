import java.io.* ; import java.util.* ; public class atcoder_AGC006_A { static int N = 200 + 10 ; static int f [ ] = new int [ N ] ; static char b [ ] = new char [ N ] ; static void getFail ( char b [ ] , int m ) { int j = 0 ; f [ 0 ] = f [ 1 ] = 0 ; for ( int i = 2 ; i <= m ; i ++ ) { while ( j > 0 && b [ j + 1 ] != b [ i ] ) j = f [ j ] ; if ( b [ j + 1 ] == b [ i ] ) j ++ ; f [ i ] = j ; } } public static void main ( String [ ] args ) { InputReader in = new InputReader ( System.in ) ; PrintWriter out = new PrintWriter ( System.out ) ; int n = in.nextInt ( ) ; String s1 = in.next ( ) , str = in.next ( ) ; int cnt = 0 ; for ( int i = 0 ; i < n ; i ++ ) b [ ++ cnt ] = str.charAt ( i ) ; for ( int i = 0 ; i < n ; i ++ ) b [ ++ cnt ] = s1.charAt ( i ) ; getFail ( b , cnt ) ; int len = Math.min ( f [ cnt ] , Math.min ( n , n ) ) ; out.println ( 2 * n - len ) ; out.flush ( ) ; } static class InputReader { public BufferedReader reader ; public StringTokenizer tokenizer ; public InputReader ( InputStream stream ) { reader = new BufferedReader ( new InputStreamReader ( stream ) , 32768 ) ; tokenizer = null ; } public String next ( ) { while ( tokenizer == null || ! tokenizer.hasMoreTokens ( ) ) { try { tokenizer = new StringTokenizer ( reader.readLine ( ) ) ; } catch ( IOException e ) { throw new RuntimeException ( e ) ; } } return tokenizer.nextToken ( ) ; } public int nextInt ( ) { return Integer.parseInt ( next ( ) ) ; } } }