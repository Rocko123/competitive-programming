import java.io.*;
import java.util.*;
public class ccc_pi_day {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k, ans = 0;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        n = readInt(); k = readInt();
        if (n == k || k == 1) {
            System.out.println(1);
        } else {
            dp = new int[n+1][k+1][n+1];
            System.out.println(dfs(n, k, 1));
        }  
    }
    static int dfs (int pie, int people, int last) {
        if (dp[pie][people][last] != 0) return dp[pie][people][last];
        if (people == 1) return dp[pie][people][last] = 1;
        int ways = 0;
        for (int cur = last; cur <= pie/people; cur++) {
            ways += dfs(pie - cur, people -1, cur);
        }
        return dp[pie][people][last] = ways;
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}