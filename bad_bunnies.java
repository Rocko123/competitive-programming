import java.util.*;
import java.io.*;
public class bad_bunnies {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
    	int n = readInt(), r = readInt();
    	List<Integer> adj[] = new ArrayList[n+1];
    	for (int i = 1; i<= n; i++) {
    		adj[i] = new ArrayList<>();
    	}
    	
    	for (int i = 1; i < n; i++) {
    		int a = readInt(), b = readInt();
    		adj[a].add(b); adj[b].add(a);
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	boolean[] visited = new boolean[n+1];
    	int[] dist = new int[n+1]; // distance of a bunny to a node, the bunny doesn't actually move
    	for (int i = 0; i < r; i++) {
    		int bunny = readInt();
    		q.add(bunny);
    		visited[bunny] = true;
    	}
    	// compute shortest distance for a bunny to get to any node
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		int d = dist[cur] + 1;
    		for (int i: adj[cur]) {
    			if (!visited[i]) {
    				q.add(i);
    				visited[i] = true;
    				dist[i] = d;
    			}
    		}
    	}
    	
    	int x = readInt(), y = readInt();
    	int[] prev = new int[n+1];
    	visited = new boolean[n+1];
    	q.add(x);
    	visited[x] = true;
    
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		for (int i: adj[cur]) {
    			if (!visited[i]) {
    				visited[i] = true;
    				q.add(i);
    				prev[i] = cur;
    			}
    		}
    	}
    	int closestBunny = Integer.MAX_VALUE;
    	for (int cur = y; cur != 0; cur = prev[cur]) {
    		// backtrack from y to x, check if the distance of a bunny to that particular node is less
    		closestBunny = Math.min(closestBunny, dist[cur]);
    	}
    	System.out.println(closestBunny);
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