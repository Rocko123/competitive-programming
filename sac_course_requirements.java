import java.util.*;
import java.io.*;
public class sac_course_requirements {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	// topo sort template
    	int n = readInt();
    	List<Integer> adj[] = new ArrayList[n+1];
    	for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
    	int[] inDeg = new int[n+1];
    	
    	for (int i = 1; i <= n; i++) {
    		int c = readInt();
    		inDeg[i] = c;
    		for (int j = 0; j < c; j++) {
    			int pre = readInt();
    			adj[pre].add(i);
    		}
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	for (int i = 1; i <= n; i++) {
    		if (inDeg[i] == 0) {
    			q.add(i);
    		}
    	}

    	ArrayList<Integer> ans = new ArrayList<>();
    	while (!q.isEmpty()) {
    		int cur = q.poll();
    		ans.add(cur);
    		for (int i: adj[cur]) {
    			if (--inDeg[i] == 0) {
    				q.add(i);
    			}
    		}
    	}
    	
    	for (int i: ans) {
    		System.out.print(i + " ");
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