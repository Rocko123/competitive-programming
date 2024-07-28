import java.util.*;
import java.io.*;
public class mock_ccc_dominating_olympics {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();

        ArrayList<Integer> adj[] = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        int[] indeg = new int[n+1], time = new int[n+1], dp = new int[n+1], q = new int[n+1];
        // problem requires a q optimization for java

        for (int i = 1; i <= n; i++) {
            int t = readInt(), r = readInt();
            time[i] = t; indeg[i] = r;
            for (int j = 0; j < r; j++) adj[readInt()].add(i);
        }

        int f = 0, r = -1;
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q[++r] = i;
                dp[i] = time[i];
            }
        }
        int ans = 0;
        while (f <= r) {
            int cur = q[f++];
            ans = Math.max(ans, dp[cur]);
            for (int i: adj[cur]) {
                dp[i] = Math.max(dp[cur], dp[i]);
                if (--indeg[i] == 0) {
                    q[++r] = i;
                    dp[i] += time[i]; 
                }
            }
        }
        System.out.println(ans);
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