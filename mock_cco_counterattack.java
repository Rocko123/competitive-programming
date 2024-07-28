import java.util.*;
import java.io.*;
public class mock_cco_counterattack {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dist1, dist2;
    static List<edge> adj[];
    public static void main(String[] args) throws IOException{ // too slow on one batch
        int n = readInt(), m = readInt();

        dist1 = new int[n+1]; dist2 = new int[n+1];
        adj = new ArrayList[n+1]; 
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist1[i] = Integer.MAX_VALUE/2; dist2[i] = Integer.MAX_VALUE/2;
        }

        for (int i = 0; i < m; i++) {
            int a =  readInt(), b = readInt(), w = readInt();
            adj[a].add(new edge(b, w)); adj[b].add(new edge(a, w));
        }
        dist1 = dijkstra(1, dist1); dist2 = dijkstra(n, dist2);
        
        int shortest = dist1[n], min_dist = Integer.MAX_VALUE/2;
        for (int i = 1; i <= n; i++) {
            for (edge j: adj[i]) {
                int d = dist1[i] + j.w + dist2[j.node];
                if (d > shortest && d < min_dist) {
                    min_dist = d;
                }
            }
        }
        System.out.println(min_dist);
    }
    static int[] dijkstra (int start, int[] dist) {
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(start, 0)); dist[start] = 0;
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            int node = cur.node, dis = cur.w;
            if (dis > dist[node]) continue;
            for (edge i: adj[node]) {
                int next = i.node, d = dis + i.w;
                if (dist[next] > d) {
                    dist[next] = d;
                    pq.add(new edge(next, d));
                }
            }
        }
        return dist;
    }
    static class edge implements Comparable<edge> {
        int node, w;
        edge (int node0, int w0) {
            node = node0; w = w0;
        }
        public int compareTo (edge x) {
            return Integer.compare(w, x.w);
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