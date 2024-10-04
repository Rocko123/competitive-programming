import java.util.*;
import java.io.*;
public class bob_knapsack {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        // just why
        int n = readInt(), q = readInt();
        long[] a = new long[n+1];
        for (int i = 1; i <= n; i++) a[i] = readLong();
        Arrays.sort(a, 1, n+1);
        for (int i = 1; i <= n/2; i++) {
            long temp = a[i];
            a[i] = a[n-i+1]; a[n-i+1] = temp;
        }
        for (int i = 1; i <= n; i++) {
            a[i] = Math.max(a[i-1] + a[i], a[i-1]);
        }
        // System.out.println(Arrays.toString(a));
        for (; q > 0; q--) {
            System.out.println(a[readInt()]);
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