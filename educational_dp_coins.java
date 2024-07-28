import java.util.*;
import java.io.*;
public class educational_dp_coins {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // dp state: out of first i coins, j of them are heads
        // dp transition: dp[i][j] = dp[i-1][j-1] * prob if cur is heads + dp[i-1][j] * (1-prob) is cur is tails both total to j coins each
        // ans = sum dp[n][j] j > n/2

        int n = readInt();
        double[] prob = new double[n+1];
        double[][] dp = new double[n+1][n+1];

        dp[0][0] = 1; // 0 coins heads 100%

        for (int i = 1; i <= n; i++) {
            prob[i] = readDouble();
            dp[i][0] = dp[i-1][0] * (1-prob[i]); // i coins, 0 heads
            for (int j = 1; j <= i; j++) { 
                dp[i][j] = dp[i-1][j-1] * prob[i] + dp[i-1][j] * (1-prob[i]);
            }
        }
        double ans = 0;
        for (int i = n; i > n/2; i--) {
            ans += dp[n][i];
        }
        System.out.printf("%.16f", ans);
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