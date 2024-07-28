import java.util.*;
import java.io.*;
public class educational_dp_longest_path {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;
    static int n, m, ans = 0;
    static List<Integer> adj[];
    public static void main(String[] args) throws IOException{
        n = readInt(); m = readInt();

        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (; m > 0; m--) {
            int x = readInt(), y = readInt();
            adj[x].add(y);
        }

        // dp state: longest dist starting at i
        // dp transition: dp[start] + max (dp[neighbors])

        dp = new int[n+1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(dfs(i), ans);
        }
        System.out.println(ans-1);
    }
    static int dfs (int start) {
        if (dp[start] != 0) return dp[start];
        int d = 0;
        for (int i: adj[start]) {
            d = Math.max(d, dfs(i));
        }
        return dp[start] = d + 1;
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