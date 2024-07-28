import java.util.*;
import java.io.*;
public class dmopc_sawmill_scheme {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();

        double dp[] = new double[n+1]; dp[1] = 1;
        int deg[] = new int[n+1], q[] = new int[n+1];
        List<Integer> adj[] = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt();
            adj[a].add(b);
            deg[b]++;
        }

        int f = 0, r = -1;
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) {
                q[++r] = i;
            }
        }

        while (f <= r) {
            int cur = q[f++];
            if (adj[cur].size() == 0) continue;
            double prob = (double) dp[cur]/adj[cur].size();
            for (int i: adj[cur]) {
                dp[i] += prob;
                if (--deg[i] == 0) {
                    q[++r] = i;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (adj[i].size() == 0) System.out.println(dp[i]);
        }
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