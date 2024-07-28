import java.util.*;
import java.io.*;
public class egoi_zeros {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long a, b;
    public static void main(String[] args) throws IOException{
        // find the LCM from a - b
        // trailing zeros is the smallest exponent with base 2 or 5

        a = readLong(); b = readLong();
        a--;
        System.out.println(Math.min(pow(2), pow(5)));
    }
    static int pow (int x) { // ?
        long power = x; int exponent = 1;
        while (true) {
            if (b / power == a / power) {
                return --exponent;
            } else {
                power *= x;
                exponent++;
            }
        }
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }  
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}