import java.util.*;
import java.io.*;
public class dmopc_hitchhiking_fun {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // dijkstra with pq, danger roads is the weight
        int n = readInt(), m = readInt();
        List<pair> adj[] = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (; m > 0; m--) {
            int a = readInt(), b = readInt(), t = readInt();
            adj[a].add(new pair(b, t)); adj[b].add(new pair(a, t));
        }
        pair dist[] = new pair[n+1]; // stores the number of danger roads and total roads
        for (int i = 1; i <= n; i++) dist[i] = new pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        boolean[] vis = new boolean[n+1];
        dist[1] = new pair(0, 0);
        
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(dist[1], 1)); // danger roads, total roads, node
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            if (vis[cur.node]) continue;
            vis[cur.node] = true;
            int danger = cur.road.danger, count = cur.road.count;
            for (pair i: adj[cur.node]) {
                int next = i.danger, weight = i.count;
                pair temp = new pair(danger + weight, count + 1);
                if (dist[next].compareTo(temp) > 0) {
                    dist[next] = temp;
                    pq.add(new edge(dist[next], next));
                }
            }
        }
        if (vis[n]) {
            System.out.println(dist[n].danger + " " + dist[n].count);
        } else {
            System.out.println(-1);
        }
    }
    // the array list and dist array had to store pairs and idk why
    static class pair implements Comparable<pair> {
        // learn comparator
        int danger, count;
        pair (int d, int c) {danger = d; count = c;}
        public int compareTo(pair x) {
            if (danger != x.danger) return Integer.compare(danger, x.danger);
            return Integer.compare(count, x.count);
        }
    }
    static class edge implements Comparable<edge> {
        pair road; int  node;
        edge (pair x, int y) {road = x; node = y;}
        public int compareTo(edge x) {return road.compareTo(x.road);}
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
