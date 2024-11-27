import java.io.* ; import java.util.* ; public class codeforces_171_A { static class FastReader { BufferedReader br ; StringTokenizer st ; public FastReader ( ) { br = new BufferedReader ( new InputStreamReader ( System.in ) ) ; } String next ( ) { while ( st == null || ! st.hasMoreElements ( ) ) { try { st = new StringTokenizer ( br.readLine ( ) ) ; } catch ( IOException e ) { e.printStackTrace ( ) ; } } return st.nextToken ( ) ; } int nextInt ( ) { return Integer.parseInt ( next ( ) ) ; } long nextLong ( ) { return Long.parseLong ( next ( ) ) ; } double nextDouble ( ) { return Double.parseDouble ( next ( ) ) ; } String nextLine ( ) { String str = "" ; try { str = br.readLine ( ) ; } catch ( IOException e ) { e.printStackTrace ( ) ; } return str ; } } public static void main ( String [ ] args ) { FastReader sc = new FastReader ( ) ; int n = sc.nextInt ( ) ; int m = sc.nextInt ( ) ; int t = reverse ( m ) ; System.out.println ( t + n ) ; } public static int reverse ( int n ) { if ( n < 10 ) return n * 10 ; int t = n , r = 0 ; while ( t > 0 ) { r = ( r * 10 ) + t % 10 ; t = t / 10 ; } return r ; } }
