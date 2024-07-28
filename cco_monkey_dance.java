import java.util.*;
import java.io.*;
public class cco_monkey_dance {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> adj[];
    static int[] vis, dist;
    static List<Integer> cycles;
    public static void main(String[] args) throws IOException{
    	// find LCM of cycles in multiple functional graphs
    	// similar to Swapity Swapity Swap
    	int n = readInt();
    	while (n != 0) {
    		// possible with 1d array like in Bob's Portal Travel
    		cycles = new ArrayList<>();
    		adj = new ArrayList[n+1];
    		for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
    		
    		vis = new int[n+1];
    		dist = new int[n+1];
    		for (int i = 0; i < n; i++) {
    			int u = readInt(), v = readInt();
    			adj[u].add(v); adj[v].add(u);
    		}
    		
    		for (int i = 1; i <= n; i++) {
    			if (vis[i] == 0) {
    				dfs(i);
    			}
    		}
    		
    		// for (int i: cycles) System.out.println("Cycle size: " + i);
    		System.out.println(listLcm());
    		n = readInt();
    	}
    }
    
    static void dfs (int start) {
    	vis[start] = 1;  
    	for (int i: adj[start]) {
    		if (vis[i] == 0) { 
    			dist[i] = dist[start] + 1;
    			dfs(i);
    		} else if (vis[i] == 1) {
    			cycles.add(dist[start] - dist[i] + 1);
    		}
    	}
    	vis[start] = 2;
    }
    
    static int gcd(int a, int b) {
    	// Euclid's algorithm
    	while (b > 0) {
    		int temp = b;
    		b = a % b;
    		a = temp;
    	}
    	return a;
    }
    
    static int lcm (int a, int b) {
    	return a * (b / gcd(a, b));
    }
    
    static int listLcm () {
    	int ans = cycles.get(0);
    	for (int i = 1; i < cycles.size(); i++) {
    		ans = lcm(ans, cycles.get(i));
    	}
    	return ans;
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