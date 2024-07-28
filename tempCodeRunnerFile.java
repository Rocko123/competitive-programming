import java.util.*;
import java.io.*;
public class dwite_breadth_first_not_quite_tree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        for (int i = 0; i < 5; i++) {
            int n = readInt();
            int[] levels = new int[51], dist = new int[51];
            boolean[] vis = new boolean[101];
            List<Integer> adj[] = new ArrayList[101];
            for (int j = 1; j <= 100; j++) adj[j] = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int u = readInt(), v = readInt();
                adj[u].add(v); adj[v].add(u);
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(1); vis[1] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                int d = dist[cur] + 1;
                for (int j: adj[cur]) {
                    if (!vis[j]) {
                        q.add(j);
                        dist[j] = d;
                        levels[d]++;
                        vis[j] = true;
                    }
                }
            }
            int ans = 0;
            for (int j = 1; j <= 50; j++) {
                // System.out.println(levels[j]);
                if (j == levels[j]-1) ans+= j;
            }
            System.out.println(ans);
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