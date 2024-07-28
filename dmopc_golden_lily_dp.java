import java.util.*;
import java.io.*;
public class dmopc_golden_lily_dp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int l = readInt(), d = readInt();

        int[][] g = new int[d+1][l+1];
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= l; j++) {
                g[i][j] = readInt();
            }
        }
        int endx = readInt()+1, endy = readInt()+1;

        int[][] dp = new int[d+2][l+2];
        for (int i = 0; i <= d; i++) Arrays.fill(dp[i], Integer.MAX_VALUE/2); // overflowed when checking dp[i][j+1] + a[i][j]

        dp[1][0] = 0;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= l; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + g[i][j];
                // find the best answer between the space above or from the left to the current (moving down/right)
            }
            for (int j = l; j >= 1; j--) {
                dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + g[i][j]); 
                // find the best answer between the space above or from the right to the current (moving down/left)
                // since we already got moving down from prev, don't need to do again
            }
        }

        System.out.println(dp[endy][endx]);
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