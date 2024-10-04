import java.util.*;
import java.io.*;
public class fibonacci_sequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long mod = (int) 1e9 + 7;
    public static void main(String[] args) throws IOException{
        // See: Pisano period
        // find pisano period for 1e9 + 7 (prime)
        // store n as a double and mod it by the pisano period get that value
        // find the n % pisano fib using fast doubling
        // See: https://math.stackexchange.com/questions/519039/calculating-pisano-periods-for-any-integer
        // https://codeforces.com/blog/entry/93570
        // https://cp-algorithms.com/algebra/fibonacci-numbers.html#toc-tgt-5
        double n = readDouble();
        // 1 000 000 007 % 5 = 2
        long pisano = 2 * mod + 2;
        long idx = (long) n % pisano;

        long[] pair = fib(idx); // Fn, Fn+1

        // F(2n+1) = F(n+1)^2 + F(n)^2
        // F(2n) = 2F(n+1) * F(n) - F(n)^2

        // System.out.println(pair[0] + " " + pair[1]);
        // for (int i = 1; i <= n; i++) System.out.println(Arrays.toString(fib(i)));
        System.out.println(pair[0]);
    }
    static long[] fib (long n) { // fast doubling
        if (n == 0) {
            return new long[] {0, 1};
        }
        long[] p = fib(n >> 1);
        long c = p[0] * (2 * p[1] - p[0]);
        long d = p[0] * p[0] + p[1] * p[1];
        c %= mod; d %= mod;
        if (n % 2 == 0) {
            return new long[] {c, d};
        } else {
            return new long[] {d, (c+d) % mod};
        }
        // overflow because forgot to mod
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