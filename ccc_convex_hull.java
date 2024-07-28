import java.util.*;
import java.io.*;
public class ccc_convex_hull {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // 2d dijkstra, i dont think duplicate edges matter
        int k = readInt(), n = readInt(), m = readInt();
        List<edge> adj[] = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt(), t = readInt(), h = readInt();
            adj[a].add(new edge(b, t, h)); adj[b].add(new edge(a, t, h));
        }
        int A = readInt(), B = readInt();

        int[][] dist = new int[n+1][k]; // stores best dist to a island, given at most j hull damage 
        for (int i = 1; i <= n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE/2);

        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(A, 0, 0));
        dist[A][0] = 0;

        while (!pq.isEmpty()) {
            edge e = pq.poll();
            int cur = e.u, time = e.t, damage = e.h;
            if (time > dist[cur][damage]) continue;
            for (edge i: adj[cur]) {
                int next = i.u, nTime = i.t, nDamage = i.h;
                // old way processed all ways less than k, bad
                // only process possible ways less than k
                // for (int j = 0; j < k-nDamage; j++) { // loops through all edges and update times less than k damage
                if (damage + nDamage < k) { // damage from current node to next is less than K
                    if (dist[next][damage + nDamage] > time + nTime) { 
                        // time from A to next at this much damage is greater
                        // than time from A to cur + time from cur to next
                        dist[next][damage + nDamage] = time + nTime;
                        pq.add(new edge(next, dist[next][damage + nDamage], damage + nDamage));
                        // keep passing along current distance from A and damage sustained from A
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE/2;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, dist[B][i]);
        }
        System.out.println(ans == Integer.MAX_VALUE/2 ? -1: ans);
    }
    static class edge implements Comparable<edge> {
        int u, t, h;
        edge (int u0,int t0, int h0) {
            u = u0; t = t0; h = h0;
        }
        public int compareTo(edge x) {
            return Integer.compare(t, x.t); // compare this weight with other weight
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
