import java.util.*;
import java.io.*;
public class educational_dp_knapsack1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), w = readInt();
        // we don't really need to store the items
        long[][] dp = new long[n+1][w+1];

        for (int i = 1; i <= n; i++) {
            int wi = readInt(), vi = readInt();
            for (int j = 1; j <= w; j++) {
                if (j - wi < 0) {
                    dp[i][j] = dp[i-1][j]; // object is too big for a knapsack of size j, cant take
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wi] + vi);
                    // take the best between not taking the item and
                    // the best from a knapsack with size j-wi plus the value of the cur
                }
            }
        }
        System.out.println(dp[n][w]);
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