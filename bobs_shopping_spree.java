import java.util.*;
import java.io.*;
public class bobs_shopping_spree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int n = readInt(), m = readInt(), k = readInt();

        long[] dp = new long[k+1];
 
        int[] S = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int p = readInt(), s = readInt();
            S[i] = s;
            // run unlimited knapsack on each regular priced item
            for (int j = p; j <= k; j++) {
                dp[j] = Math.max(dp[j], dp[j-p] + s);
            }
        }
        for (int i = 1; i <= m; i++) {
            int q = readInt(), t = readInt(), d = readInt(), a = readInt();
            int p = 1;
            // q items of type t for d $/item, limit of a such deals
            for (; p <= a; p *= 2) { // binary packaging
                int size = p * d; long val = (long) p * q * S[t]; // needs an explicit case bruh
                for (int j = k; j >= size; j--) { // limited knapsack (knapsack on each package)
                    dp[j] = Math.max(dp[j], dp[j-size] + val);
                }
                a -= p;
            }
            if (a > 0) {
                // remaining package
                int size = a * d; long val = (long) a * q * S[t];
                for (int j = k; j >= size; j--) {
                    dp[j] = Math.max(dp[j], dp[j-size] + val);
                }
            }
        }
        System.out.println(dp[k]);
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