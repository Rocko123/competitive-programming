import java.util.*;
import java.io.*;
public class tsoc_joey_biology {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] dp = new int[1003][1003];
    static String s, t;
    public static void main(String[] args) throws IOException{
    	// lcs + edit distance
        n = readInt(); m = readInt();
        s = next(); t = next();

        for (int i = 1; i <= n; i++) dp[i][0] = (i + 2) / 3;
        for (int j = 1; j <= m; j++) dp[0][j] = (j+2) / 3;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    for (int k = 1; k <= 3; k++) {
                        if (i >= k) {
                            dp[i][j] = Math.min(dp[i][j], dp[i-k][j] + 1);
                        }
                        if (j >= k) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][j-k] + 1);
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
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