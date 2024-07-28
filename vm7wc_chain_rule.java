import java.util.*;
import java.io.*;
public class vm7wc_chain_rule {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<edge> adj[];
    public static void main(String[] args) throws IOException{
    	// implement PQ
    	n = readInt(); 
    	int m = readInt();
    	// 2 way dijkstra, once from Phillips Exeter and once from Washington D.C to any city i
    	adj = new ArrayList[n];
    	for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    	
    	for (int i = 0; i < m; i++) {
    		int a = readInt(), b = readInt(), t = readInt();
    		adj[a].add(new edge(b, t)); adj[b].add(new edge(a, t));
    	}
    	
    	int[] dist1 = new int[n];
    	Arrays.fill(dist1, Integer.MAX_VALUE);
    	int[] dist2 = new int[n];
    	Arrays.fill(dist2, Integer.MAX_VALUE);
    	dijkstra(0, dist1); dijkstra(n-1, dist2);
    	
    	long ans = 0;
    	for (int i = 0; i < n; i++) {
    		ans = Math.max(ans, dist1[i] + dist2[i]);
    	}
    	System.out.println(ans);
    }
    static void dijkstra(int start, int[] dist) {
    	PriorityQueue<edge> pq = new PriorityQueue<>();
    	pq.add(new edge (start, 0)); dist[start] = 0;
    	while (!pq.isEmpty()) {
    		edge e = pq.poll();
    		int next = e.b;
    		int weight = e.c;
    		if (weight > dist[next]) continue;
    		for (edge i: adj[next]) {
    			if (dist[i.b] > dist[next] + i.c) {
    				dist[i.b] = dist[next] + i.c;
    				pq.add(new edge (i.b, dist[i.b]));
    			}
    		}
    	}
    }
    
    public static class edge implements Comparable<edge> {
    	int b, c;
    	edge(int end, int weight) {
    		b = end; c = weight;
    	}
    	@Override
    	public int compareTo(edge e) {
    		return Integer.compare(c, e.c);
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
