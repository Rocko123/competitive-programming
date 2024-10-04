import java.util.*;
import java.io.*;
public class bob_currency_exchange {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // greedy always want the most coins in country i-1
        int n = readInt();
        long[] a = new long[n+1];
        for (int i = 1; i <= n; i++) a[i] = readLong();
        for (int i = 1; i < n; i++) {
            long x = readLong(), y = readLong();
            a[i+1] += (a[i]/x) * y; 
        }
        System.out.println(a[n]);
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