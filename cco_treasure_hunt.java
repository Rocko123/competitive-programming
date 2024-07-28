import java.util.*;
import java.io.*;
public class cco_treasure_hunt {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, max = (int) 1e9;
    static List<edge> adj[];
    static int[] bounty, ans;
    public static void main(String[] args) throws IOException{
        // only run 1 dijkstra
        // try to pass subtask 2 - how to check which nodes in the path
        // could accept some island in the path as their answer
        // only take paths less than 10^9
        n = readInt(); m = readInt();

        adj = new ArrayList[n+1]; bounty = new int[n+1]; ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            ans[i] = bounty[i] = readInt();
        }

        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt(); long c = readLong();
            adj[a].add(new edge(b, c)); adj[b].add(new edge(a, c));
        }
        dijkstra(1);
        for (int i = 1; i <= n; i++) System.out.println(ans[i]);
    }
    static void dijkstra (int start) {
        PriorityQueue<edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[n+1];
        vis[start] = true;
        pq.add(new edge(start, bounty[start])); // instead of pushing dist, push rem bounty val
        while (!pq.isEmpty()) {
            // new idea: whenever we get a better answer, we push it back into q to update the answer
            // of its neighbors, the hope is that it is the best answer so then its neighbor will also get the best answer
            // try to propagate the answer instead of looking at paths to the answer
            edge cur = pq.poll();
            if (ans[cur.u] > cur.w) continue;
            for (edge i: adj[cur.u]) {
                if (ans[i.u] < cur.w - i.w) {
                    ans[i.u] = (int) (cur.w - i.w);
                    pq.add(new edge(i.u, cur.w - i.w));
                } else if (!vis[i.u]) { // the current path is not good, we create a new start
                    pq.add(new edge(i.u, bounty[i.u]));
                    vis[i.u] = true;
                } 
            }
        }
    }
    static class edge implements Comparable<edge> {
        int u; long w;
        edge (int u0, long w0) {
            u = u0; w = w0;
        }
        public int compareTo(edge x) {
            return Long.compare(x.w, w); 
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
