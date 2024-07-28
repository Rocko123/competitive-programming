import java.util.*;
import java.io.*;
public class aac_squirrel_structures {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Integer> adj[], adj2[];
    static List<int[]> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException{
    	// link to grandchild, since edge uv in a and we cannot use that edge
    	// I have no idea what else is going on
    	boolean solved = false
    	n = readInt();
    	adj = new ArrayList[n+1]; adj2 = new ArrayList[n+1];
    	
    	for (int i = 0; i <= n; i++) {
    		adj[i] = new ArrayList<>();
    		adj2[i] = new ArrayList<>();
    	}
    	
    	for (int i = 1; i < n; i++) {
    		int u = readInt(), v = readInt();
    		adj[u].add(v); adj[v].add(u);
    	}
    	System.out.println(1 + adj[1].size());
    	dfs(1, 0); dfs2(1, 0);
    	for (int u: adj[1]) {
    		dfs2(u, 0);
    		printer();
    	}
    	
    }
    static void dfs (int cur, int pre) {
    	// don't go back in tree
    	for (int i: adj[cur]) {
    		if (i != cur) {
    			adj2[pre].add(i);
    			dfs(i, cur);
    		}
    	}
    }
    
    static void dfs2(int cur, int pre) {
    	for (int i: adj2[cur]) {
    		if (i != pre) {
    			ans.add(new int[] {cur, i});
    			dfs2(i, cur);
    		}
    	}
    }
    
    static void printer() {
    	System.out.println(ans.size()+1);
    	for (int[] i: ans) {
    		System.out.println(i[0] + " " + i[1]);
    	}
    	ans.clear();
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