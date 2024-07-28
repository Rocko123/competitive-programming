import java.util.*;
import java.io.*;
public class noisy_class {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Integer> adj[];
    static int[] vis, inDeg;
    static Queue<Integer> q = new LinkedList<>();
    static boolean silence = true;
    public static void main(String[] args) throws IOException{
    	// topo or dfs to see if its acyclic graph or not
    	n = readInt(); int m = readInt();
    	
    	adj = new ArrayList[n+1];
    	for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
    	inDeg = new int[n+1]; vis = new int[n+1];
    
    	for (int i = 0; i < m; i++) {
    		int u = readInt(), v = readInt();
    		adj[u].add(v);
    		inDeg[v]++;
    	}
    	
    	for (int i = 1; i <= n; i++) {
    		if (inDeg[i] == 0) {
    			q.add(i);
    		}
    	}
    	// topo(); 
    	// with topo sort, we can instantly detect a cycle when we cannot choose another vertex
    	// and the number of vertexes we've taken is not the total number of vertexes

    	for (int i = 1; i <= n; i++) { 
    		if (!silence) break;
        		dfs(i);
        	// with dfs we have to check that any student can start noise
        	// however once we realize there is any loop and where we stop
    	}
    	System.out.println(silence? "Y": "N");
    	// why didn't the matrix work 
    }
    
    static void topo() {
    	int count = 0;
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		count++;
    		for (int i: adj[cur]) {
    			if (--inDeg[i] == 0) q.add(i);
    		}
    	}
    	if (count != n) {
    		silence = false;
    	}
    }
    
    static void dfs(int start) {
    	vis[start] = 1;
    	for (int i: adj[start]) {
    		if (vis[i] == 0) {
    			dfs(i);
    		} else if (vis[i] == 1) {
    			silence = false;
    		}
    	}
    	vis[start] = 2;
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