import java.util.*;
import java.io.*;
public class dmopc_save_nagato {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Integer> adj[];
    public static void main(String[] args) throws IOException{
        n = readInt();
        
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int u = readInt(), v = readInt();
            adj[u].add(v); adj[v].add(u);
        }

        int[] dist1 = new int[n+1], dist2 = new int[n+1];
        int start = bfs(1, dist1); 
        Arrays.fill(dist1, 0); 
        bfs(bfs(start, dist1), dist2);

        for (int i = 1; i <= n; i++) {
            System.out.println(Math.max(dist1[i], dist2[i])+ 1);
        }
    }
    static int bfs (int start, int[] dist) {
        int dep = 0, node = 1;
        boolean[] vis = new boolean[n+1];
        vis[start] = true; dist[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int d = dist[cur] + 1;
            for (int i: adj[cur]) {
                if (!vis[i]) {
                    vis[i] = true;
                    dist[i] = d;
                    q.add(i);
                    if (dist[i] > dep) {
                        dep = dist[i];
                        node = i;
                    }
                }
            }
        }
        return node;
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