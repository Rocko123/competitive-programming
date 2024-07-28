import java.util.*;
import java.io.*;
public class ccc_phonomenal_reviews {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, root;
    static int far, dia, pho_shops;
    static boolean pho[];
    static List<Integer> adj[];
    public static void main(String[] args) throws IOException{
    	// remove all the nodes not required to visit (a node that doesn't connect
    	// a pho restaurant)
    	
    	// remaining is all restaurants needed to visit. Min dist is 2E-diameter
    	
    	n = readInt();
    	m = readInt();
    	
    	pho = new boolean[n];
    	adj = new ArrayList[n];
    	for (int i = 0; i < n; i++) {
    		adj[i] = new ArrayList<>();
    	}
    	
    	for (int i = 0; i < m; i++) {
    		pho[root = readInt()] = true;
    	}
    	for (int i = 1; i < n; i++) {
    		int u = readInt(), v = readInt();
    		adj[u].add(v); adj[v].add(u);
    	}
    	dfs_pho(root, -1);
    	dfs_dia(root, -1, 0);
    	dfs_dia(far, -1, 0);
    	System.out.println(2*(pho_shops-1)-dia);
    	
    }
    // mark all the pho restaurants 
    static void dfs_pho(int cur, int pre) {
    	for (int i: adj[cur]) {
    		if (i != pre) {
    			dfs_pho(i, cur);
    			if (pho[i]) {
    				pho[cur] = true; // this is a restaurant that must be visited
    				// because it has a child that is a pho restaurant
    			}
    		}
    	}
    	if (pho[cur]) {
    		pho_shops++; // num pho shops
    	}
    }
    
    // find the furthest node from root, then use the that furthest node 
    // to find the other furthest node to get the diameter
    static void dfs_dia(int cur, int pre, int dis) {
    	if (dis > dia) {
    		dia = dis;
    		far = cur;
    	}
    	for (int i: adj[cur]) {
    		if (i != pre && pho[i]) {
    			dfs_dia(i, cur, dis+1);
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