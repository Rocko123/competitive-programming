import java.util.*;
import java.io.*;
public class gfssoc_mostly_talking {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, base = (int) 1e6;
    public static void main(String[] args) throws IOException{
    	int n = readInt(), m = readInt();
    	// shortest path = dist_start[u] + <u, v>  + dist_end[v]
    	List<edge> adj[] = new ArrayList[n+1];
    	List<edge> radj[] = new ArrayList[n+1];
    	for (int i = 1; i <= n; i++) {
    		adj[i] = new ArrayList<>(); radj[i] = new ArrayList<>();
    	}
    	for (int i = 0; i < m; i++) {
    		int a = readInt(), b = readInt(), k = readInt();
    		adj[a].add(new edge(b, k));
    		radj[b].add(new edge(a, k));
    	}
    	
    	long[] dist1 = new long[n+1], dist2 = new long[n+1];
    	dijkstra(1, adj, dist1); dijkstra(n, radj, dist2);
    	long ans = dist1[n];
    	int d = readInt();
    	for (; d > 0; d--) {
    		int a = readInt(), b = readInt(), g = readInt();
    		ans = Math.min(ans, dist1[a] + g + dist2[b]);
    	}
    	System.out.println(ans >= Integer.MAX_VALUE ? -1: ans);
    }
    static void dijkstra(int start, List<edge> adj[], long dist[]) {
    	PriorityQueue<Long> pq = new PriorityQueue<>();
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	dist[start] = 0;
    	pq.add((long) start);
    	while(!pq.isEmpty()) {
    		// dis*base + vertex
    		long cur = pq.poll(), curDist = cur / base; int next = (int) (cur % base);
    		if (curDist > dist[next]) continue;
    		for (edge e: adj[next]) {
    			if (dist[e.v] > e.w + dist[next]) {
    				dist[e.v] = e.w + dist[next];
    				pq.add(dist[e.v] * base + e.v);
     			}
    		}
    	}
    }
    static class edge implements Comparable<edge> {
    	int v; long w;
    	edge (int v0, long w0) {
    		v = v0; w = w0;
    	}
    	public int compareTo(edge x) {
    		return Long.compare(w, x.w);
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
