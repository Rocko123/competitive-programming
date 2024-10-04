import java.util.*;
import java.io.*;
public class cco_fundraising_problem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long dp[][];
    static int hate[], val[], edge[], head[], nxt[];
    static boolean vis[];
    static int root;
    static long ans;
    public static void main(String[] args) throws IOException{
        int n = readInt();

        // break the edge in the cycle make this node the root, results in a DAG
        // use the reversed graph and the root to run dfs with dp

        dp = new long[2][n+1];
        hate = new int[n+1]; val = new int[n+1]; edge = new int[n+1]; head = new int[n+1]; nxt = new int[n+1];
        vis = new boolean[n+1];

        int idx = 0;
        Arrays.fill(head, -1);
        for (int i = 1; i <= n; i++) {
            int v = readInt(), h = readInt();
            hate[i] = h; val[i] = v;
            edge[idx] = i; nxt[idx] = head[h]; head[h] = idx++; 
        }

        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            for (root = i; !vis[root]; root = hate[root]) {
                vis[root] = true;
            }
            ans += Math.max(dfs(root, 0), dfs(root, 1));
        }
        System.out.println(ans);
        // try adj list optimization
    }
    static long dfs (int cur, int take) { // current node, if we selected its hate
        if (cur == hate[root] && take > 0) { // broken edge can't take its hate
            dp[0][cur] = 0; dp[1][cur] = -Long.MAX_VALUE/2;
        } else {
            dp[0][cur] = 0; dp[1][cur] = val[cur];
        }
        vis[cur] = true;
        for (int j = head[cur]; j != -1; j = nxt[j]) {
            int i = edge[j];
            if (i == root) continue;
            dfs(i, take);
            dp[0][cur] += Math.max(dp[0][i], dp[1][i]);
            dp[1][cur] += dp[0][i];
        }
        return dp[take][cur];
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