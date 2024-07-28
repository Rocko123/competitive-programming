import java.util.*;
import java.io.*;
public class ccc_escape_room {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int size = (int) 1e6 + 1;
    	boolean[] vis = new boolean[size];
    	List<Integer> adj[] = new ArrayList[size];
    	for (int i = 1; i < size; i++) adj[i] = new ArrayList<>();
    	
    	int m = readInt(), n = readInt();
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j <= n; j++) {
    			adj[i*j].add(readInt());
    			// any element who has an coordinate product equal to i * j will be stored here
    			// because we can only access elements who have a coordinate product equal 
    			// to the current element, we can access any of these elements in this list
    		}
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.add(1); vis[1] = true;
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		for (int i: adj[cur]) {
    			// for all elements who have a 
    			// coordinate product of cur we vis
    			if (!vis[i]) {
    				q.add(i); vis[i] = true;
    			}
    		}
    	}
    	System.out.println(vis[m * n] ? "yes": "no");
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
