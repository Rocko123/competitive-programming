import java.util.*;
import java.io.*;
public class dwite_breadth_first_not_quite_tree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        for (int i = 0; i < 5; i++) {
            int n = readInt();
            
            int[] dist = new int[100];
            boolean[] vis = new boolean[100];
            List<Integer> adj[] = new ArrayList[100];
            for (int j = 1; j <= 99; j++) adj[j] = new ArrayList<>();

            List<int[]> input = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int u = readInt(), v = readInt();
                adj[u].add(v); adj[v].add(u);
                input.add(new int[] {u, v});
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
                        vis[j] = true;
                    }
                }
            }
            int ans = 0;
            for (int[] j: input) {
                if (dist[j[0]] == dist[j[1]]) ans++;
            }
            System.out.println(ans);
            // i cant read apparently
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