import java.util.*;
import java.io.*;
public class vmss_frank_roads {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int t = readInt(), n = readInt(), m = readInt(), g = readInt();
    	
    	List<int[]> adj[] = new ArrayList[n+1];
    	for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
    	
    	int[] foodBasics = new int[g];
    	for (int i = 0; i < g; i++) foodBasics[i] = readInt();
    	
    	for (int i = 0; i < m; i++) {
    		int a = readInt(), b = readInt(), l = readInt();
    		adj[a].add(new int[] {b, l});
    	}
    	
    	int dist[] = new int[n+1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	boolean[] vis = new boolean[n+1];
    	dist[0] = 0;
    	
    	for (int i = 0 ; i <= n; i++) {
    		int next = -1;
    		int min = Integer.MAX_VALUE;
    		for (int j = 0; j <= n; j++) {
    			if (!vis[j] && dist[j] < min) {
    				min = dist[j];
    				next = j;
    			}
    		}
    		if (next == -1) break;
    		vis[next] = true;
    		for (int[] j: adj[next]) {
    			if (dist[j[0]] > dist[next] + j[1]) {
    				dist[j[0]] = dist[next] + j[1];
    			}
    		}
    	}
    	int ans = 0;
    	for (int i: foodBasics) {
    		if (dist[i] <= t) {
    			ans++;
    		}
    	}
    	System.out.println(ans);
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
