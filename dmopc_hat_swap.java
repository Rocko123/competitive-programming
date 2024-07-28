import java.util.*;
import java.io.*;
public class dmopc_hat_swap {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, students[];
    static List<Integer> adj[];
    public static void main(String[] args) throws IOException{
    	n = readInt(); m = readInt();
    	List<int[]> dist1[] = new ArrayList[n+1], dist2[] = new ArrayList[n+1];
    	// a list of n arraylists, where there are two elements of type int[], each int array
    	// stores the person and distance of the closest and second closest person with hat color ci
    	
    	students = new int[n+1];
    	adj = new ArrayList[n+1];
    	for (int i = 1; i <= n; i++) {
    		students[i] = readInt();
    		adj[i] = new ArrayList<>();
    		dist1[i] = new ArrayList<>(); dist2[i] = new ArrayList<>(); 
    	}
    	
    	for (int i = 0; i < m; i++) {
    		int u = readInt(), v = readInt();
    		adj[u].add(v); adj[v].add(u);
    	}
    	
    	bfs(1, dist1); bfs(n, dist2);
    	
    	int ans = Integer.MAX_VALUE;
    	for (int i = 1; i <= n; i++) { // loop through each color
    		for (int[] j: dist1[i]) { // loop through up to two students
    			for (int[] k: dist2[i]) {
    				if (j[1] != k[1]) { // if they are not the same person
    					ans = Math.min(ans, j[0] + k[0]);
    				}
    			}
    		}
    	}
    	
    	System.out.println(ans == Integer.MAX_VALUE ? -1: ans);
    }
    
    static void bfs(int start, List<int[]> d[]) {
    	boolean[] vis = new boolean[n+1];
	    int[] dist = new int[n+1];
	    Queue<Integer> q = new LinkedList<>();
	    
	    vis[start] = true;
	    q.add(start);
	    
	    while (!q.isEmpty()) {
	    	int cur = q.poll();
	    	if (d[students[cur]].size() < 2) { // if there is less than two choices for ci
	    		d[students[cur]].add(new int[] {dist[cur], cur}); // add the distance and student
	    	}
	    	for (int i: adj[cur]) {
	    		if (!vis[i]) {
	    			q.add(i);
	    			vis[i] = true;
	    			dist[i] = dist[cur] + 1;
	    		}
	    	}
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