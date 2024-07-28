import java.util.*;
import java.io.*;
public class dmopc_not_enough_time {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), t = readInt();
        // try solving knapsack way, each item is actually 3 items
        // use 1d array

        int[] dp = new int[t+1];
        int[] w = new int[3], val = new int[3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                w[j] = readInt(); val[j] = readInt();
            }
            for (int j = t; j >= 0; j--) {
                for (int k = 0; k < 3; k++) {
                    if (j >= w[k]) dp[j] = Math.max(dp[j], dp[j-w[k]] + val[k]); // test all 3 items
                }
            }
        }
        System.out.println(dp[t]);
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
