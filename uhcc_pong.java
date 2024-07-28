import java.io.*;
import java.util.*;
public class uhcc_pong {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int x = readInt(), y = readInt(), z = readInt(), l = readInt();
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 < p2) {
                p1 += x;
                if (p1 >= l) {
                    System.out.println(1);
                    System.exit(0);
                }
            } else {
                p2 += y;
                if (p2 >= l) {
                    System.out.println(2);
                    System.exit(0);
                }
                p1 += z;
                if (p1 >= l) {
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
