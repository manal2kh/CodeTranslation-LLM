import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class atcoder_ABC043_B {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        LightScanner in = new LightScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BUnhappyHackingABCEdit solver = new BUnhappyHackingABCEdit();
        solver.solve(1, in, out);
        out.close();
    }

    static class BUnhappyHackingABCEdit {
        public void solve(int testNumber, LightScanner in, PrintWriter out) {
            String s = in.string();
            StringBuilder d = new StringBuilder();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '0':
                        d.append("0");
                        break;
                    case '1':
                        d.append("1");
                        break;
                    case 'B':
                        if (d.length() > 0) {
                            d.setLength(d.length() - 1);
                            d.trimToSize();
                        }
                        break;
                }
            }
            out.println(d);
        }
    }

    static class LightScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public LightScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public String string() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
            return tokenizer.nextToken();
        }
    }
}
