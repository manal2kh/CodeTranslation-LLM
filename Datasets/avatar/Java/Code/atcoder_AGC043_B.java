import java.io.* ; import java.util.* ; public class atcoder_AGC043_B { private int cal ( String s , char c ) { int n = s.length ( ) ; int m = n - 1 ; int ans = 0 ; for ( int i = 0 ; i < n ; i ++ ) { if ( s.charAt ( i ) == c && ( m & i ) == i ) { ans ^= 1 ; } } return ans ; } private void solve ( ) { int n = sc.nextInt ( ) ; String s = sc.next ( ) ; StringBuilder sb = new StringBuilder ( ) ; for ( int i = 1 ; i < n ; i ++ ) { sb.append ( Math.abs ( s.charAt ( i ) - s.charAt ( i - 1 ) ) ) ; } if ( n == 2 ) { out.println ( sb.charAt ( 0 ) ) ; return ; } s = sb.toString ( ) ; if ( s.contains ( "1" ) ) { out.println ( cal ( s , '1' ) ) ; } else { out.println ( cal ( s , '2' ) * 2 ) ; } } private static PrintWriter out ; private static MyScanner sc ; private static class MyScanner { BufferedReader br ; StringTokenizer st ; private MyScanner ( ) { br = new BufferedReader ( new InputStreamReader ( System.in ) ) ; } String next ( ) { while ( st == null || ! st.hasMoreElements ( ) ) { try { st = new StringTokenizer ( br.readLine ( ) ) ; } catch ( IOException e ) { e.printStackTrace ( ) ; } } return st.nextToken ( ) ; } int nextInt ( ) { return Integer.parseInt ( next ( ) ) ; } long nextLong ( ) { return Long.parseLong ( next ( ) ) ; } double nextDouble ( ) { return Double.parseDouble ( next ( ) ) ; } } public static void main ( String [ ] args ) { out = new PrintWriter ( new BufferedOutputStream ( System.out ) ) ; sc = new MyScanner ( ) ; new atcoder_AGC043_B ( ).solve ( ) ; out.close ( ) ; } }
