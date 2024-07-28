import java.util.*;
import java.io.*;
public class dmopc_terrible_trains {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static List<Integer> adj[];
    public static void main(String[] args) throws IOException{
        // S to T in X time
        // U to V in Y time
        // if ST <= X || UV <= Y good bc we can just build a direct path to the other pair
        // ST + UV = X + Y
        // try every node != S,T,U,V prob slow

        n = readInt(); m = readInt();

        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt();
            adj[a].add(b); adj[b].add(a);
        }

        int q = readInt();
        for (; q > 0; q--) {
            int s = readInt(), t = readInt(), x = readInt(), u = readInt(), v = readInt(), y = readInt();

            int[] dist = bfs(s); int dist1 = dist[t];
            dist = bfs(u); int dist2 = dist[v];

            if (dist1 <= x || dist2 <= y) {
                System.out.println("YES");
                continue;
            }

            outerloop:
            for (int i = 1; i <= n; i++) {
                if (i == s || i == t || i == u || i == v) {
                    continue;
                } else {
                    dist = bfs(i);
                    if (dist[s] + dist[t] + dist[u] + dist[v] <= x + y) {
                        System.out.println("YES");
                        break outerloop;         
                    }
                }
            }
            System.out.println("NO");
        }


    }
    static int[] bfs (int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
        int[] dist = new int[n+1];

        vis[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i: adj[cur]) {
                if (!vis[i]) {
                    vis[i] = true;
                    dist[i] = dist[cur] + 1;
                    q.add(i);
                }
            }
        }
        return dist;
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