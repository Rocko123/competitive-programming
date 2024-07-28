import java.util.*;
import java.io.*;
public class ccc_painting_roads {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] vis;
    static char[] output; 
    // static char[][] colors; <- 4e10 bytes, very bad
    static List<int[]> adj[];
    static int n, m;
    public static void main(String[] args) throws IOException{
        // use dfs to alternate the colors and detect a cycle
        // once we have an edge that creates a cycle ommit it
        // all initially grey, at least have all intersections
        // in a component connect so they alternate, rest are grey
        n = readInt(); m = readInt();
        
        vis = new int[n+1];
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        output = new char[m];
        for (int i = 0; i < m; i++) {
            int u = readInt(), v = readInt();
            adj[u].add(new int[] {v, i}); adj[v].add(new int[] {u, i});
            output[i] = 'G';
        }

        
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                dfs(i, true);
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(output[i]);
        }
    }
    static void dfs(int cur, boolean red) {
        vis[cur] = 1;
        for (int i[]: adj[cur]) {
            if (vis[i[0]] == 0) {
                dfs(i[0], !red);
                output[i[1]] = red ? 'R': 'B';
            }
        }
        vis[cur] = 2;
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