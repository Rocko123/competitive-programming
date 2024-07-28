import java.util.*;
import java.io.*;
public class mock_ccc_directed_graph {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dist;
    static boolean[] vis;
    static List<Integer> adj[];
    static int n, m;
    public static void main(String[] args) throws IOException{
    	// remove an edge and bfs from 1 to n to see if it's possible
    	n = readInt(); m = readInt();
    	adj = new ArrayList[n+1];
    	int[] s = new int[m]; int[] t = new int[m];
    	for (int i = 1; i <= n; i++) {
    		adj[i] = new ArrayList<>();
    	}
    	
    	for (int i = 0; i < m; i++) {
    		int u = readInt(), v = readInt();
    		adj[u].add(v);
    		s[i] = u; t[i] = v;
    	}

    	for (int i = 0; i < m; i++) {
    		vis = new boolean[n+1];
        	Queue<Integer> q = new LinkedList<>();
        	q.add(1);
        	
        	while(!q.isEmpty()) {
        		int cur = q.poll();
        		for (int j: adj[cur]) {
        			if (!vis[j] && !(cur == s[i] && j == t[i])) {
        				vis[j] = true;
        				q.add(j);
        			}
        		}
        	}
        	System.out.println(vis[n] ? "YES": "NO");
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