import java.util.*;
import java.io.*;
public class cco_fundraising_problem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long dp[][];
    static int hate[], val[];
    static boolean vis[];
    static List<Integer> radj[];
    static int root;
    static long ans;
    public static void main(String[] args) throws IOException{
        int n = readInt();

        // break the edge in the cycle make this node the root, results in a DAG
        // use the reversed graph and the root to run dfs with dp

        dp = new long[n+1][2];
        hate = new int[n+1]; val = new int[n+1];
        vis = new boolean[n+1];
        radj = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) radj[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int v = readInt(), h = readInt();
            hate[i] = h; val[i] = v;
            radj[h].add(i);
        }

        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            for (root = i; !vis[root]; root = hate[root]) {
                vis[root] = true;
            }
            ans += Math.max(dfs(root, 0), dfs(root, 1));
        }
        System.out.println(ans);
    }
    static long dfs (int cur, int take) { // current node, if we selected its hate
        if (cur == hate[root] && take > 0) { // broken edge can't take its hate
            dp[cur][0] = 0; dp[cur][1] = -Long.MAX_VALUE/2;
        } else {
            dp[cur][0] = 0; dp[cur][1] = val[cur];
        }
        vis[cur] = true;
        for (int i: radj[cur]) {
            if (i == root) continue;
            dfs(i, take);
            dp[cur][0] += Math.max(dp[i][0], dp[i][1]);
            dp[cur][1] += dp[i][0];
        }
        return dp[cur][take];
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